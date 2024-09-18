package com.example.androidenitp.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidenitp.helper.AlertDialogHelper
import com.example.androidenitp.helper.ProgressDialogHelper
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage
import kotlinx.coroutines.flow.MutableStateFlow

fun callApi(email: String, viewModel : AuthViewModel){
    // Afficher la boite de chargement
    ProgressDialogHelper.Singleton.progressDialogHelper.showProgressDialog()

    viewModel.callApiResetPassword(email, {

        // Fermer la boite de chargement
        ProgressDialogHelper.Singleton.progressDialogHelper.closeProgressDialog()

        // Afficher la popup avec le new password dedans
        AlertDialogHelper.Singleton.alertDialogHelper.showAlert("${it.message} + ${it.data}")
    })
}

@Composable
fun ResetPasswordComponent(viewModel: AuthViewModel) {

    var email : MutableStateFlow<String> = MutableStateFlow("isaac@gmail.com");

    val emailState by email.collectAsState()

    Box() {
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Récupération de mot de passe")
            EniTextField("Email", value = emailState, onValueChange = { email.value = it })
            EniGradientButton("Envoyer le lien de récupération", onClick = { callApi(email.value, viewModel) })
        }
        ProgressDialogHelper.Singleton.progressDialogHelper.renderProgress()
        AlertDialogHelper.Singleton.alertDialogHelper.render()
    }
}