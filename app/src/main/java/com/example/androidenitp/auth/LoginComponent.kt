package com.example.androidenitp.auth

import androidx.compose.foundation.layout.Arrangement
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

fun onClickLogin(email: String, password: String, viewModel: AuthViewModel) {
    /*
    val intent = Intent(this, ArticleListActivity::class.java);
    startActivity(intent);
    */
    // Afficher la popup
    ProgressDialogHelper.Singleton.progressDialogHelper.showProgressDialog()
    // Appel api
    viewModel.callApi(email, password, {
        ProgressDialogHelper.Singleton.progressDialogHelper.closeProgressDialog()
        AlertDialogHelper.Singleton.alertDialogHelper.showAlert(it.message)
    })
}

@Composable
fun LoginComponent(viewModel: AuthViewModel, onClickResetBtn: () -> Unit = {}, onClickSignUpBtn: () -> Unit = {} ) {
    var email = MutableStateFlow<String>("isaac@gmail.com");
    var password = MutableStateFlow<String>("password");

    val emailState by email.collectAsState();
    val passwordState by password.collectAsState();

    Box {
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Login")
            EniTextField("Email", value = emailState, onValueChange = { email.value = it })
            EniTextField(
                "Mot de passe",
                value = passwordState,
                onValueChange = { password.value = it })
            EniGradientButton("Connexion", onClick = { onClickLogin(emailState, passwordState, viewModel) })
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                EniGradientButton("Reset Password", onClickResetBtn)
                EniGradientButton("Je veux m'inscrire", onClickSignUpBtn)
            }
        }
        ProgressDialogHelper.Singleton.progressDialogHelper.renderProgress()
        AlertDialogHelper.Singleton.alertDialogHelper.render()
    }
}