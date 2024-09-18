package com.example.androidenitp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidenitp.helper.AlertDialogHelper
import com.example.androidenitp.helper.ProgressDialogHelper
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage
import kotlinx.coroutines.flow.MutableStateFlow

class ResetPasswordActivity : ComponentActivity() {

    var email = MutableStateFlow("isaac@gmail.com")
    var viewModel = AuthViewModel();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ResetPasswordComposePage(email, onClickSubmit = {
                callApi()
            })
        }
    }

    fun callApi(){
        // Afficher la boite de chargement
        ProgressDialogHelper.Singleton.progressDialogHelper.showProgressDialog()

        viewModel.callApiResetPassword(email.value, {

            // Fermer la boite de chargement
            ProgressDialogHelper.Singleton.progressDialogHelper.closeProgressDialog()

            // Afficher la popup avec le new password dedans
            AlertDialogHelper.Singleton.alertDialogHelper.showAlert("${it.message} + ${it.data}")
        })
    }

}

@Composable
fun ResetPasswordComposePage(email : MutableStateFlow<String> = MutableStateFlow(""),
                             onClickSubmit : () -> Unit = {}) {
    val emailState by email.collectAsState()

    EniTemplatePage({
        Box() {
            Column(modifier = Modifier.padding(40.dp)) {
                EniTitleTextPage("Récupération de mot de passe")
                EniTextField("Email", value = emailState, onValueChange = { email.value = it })
                EniGradientButton("Envoyer le lien de récupération", onClick = onClickSubmit)
            }
            ProgressDialogHelper.Singleton.progressDialogHelper.renderProgress()
            AlertDialogHelper.Singleton.alertDialogHelper.render()
        }

    })
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordComposePagePreview() {
    ResetPasswordComposePage()
}
