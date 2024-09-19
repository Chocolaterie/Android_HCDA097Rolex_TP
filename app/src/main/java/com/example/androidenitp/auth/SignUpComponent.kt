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


fun onClickSignUp(signUpRequest: SignUpRequest, viewModel: AuthViewModel) {
    // Afficher la boite de chargement
    ProgressDialogHelper.Singleton.progressDialogHelper.showProgressDialog()

    // Appel api
    viewModel.callApiSignUp(signUpRequest, {
        ProgressDialogHelper.Singleton.progressDialogHelper.closeProgressDialog()
        AlertDialogHelper.Singleton.alertDialogHelper.showAlert(it.message)
    })
}

@Composable
fun SignUpComponent(signUpRequest : MutableStateFlow<SignUpRequest> = MutableStateFlow(SignUpRequest()), viewModel: AuthViewModel) {

    val signUpRequestState by signUpRequest.collectAsState();

    Box(){
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Sign Up", paddingTitle = 10.dp)
            EniTextField(
                "Pseudo",
                value = signUpRequestState.pseudo,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(pseudo = it) })
            EniTextField(
                "Email",
                value = signUpRequestState.email,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(email = it) })
            EniTextField(
                "Mot de passe",
                value = signUpRequestState.password,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(password = it) })
            EniTextField(
                "Confirmation Mot de passe",
                value = signUpRequestState.passwordConfirm,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(passwordConfirm = it) })
            EniTextField(
                "Code Postal",
                value = signUpRequestState.cityCode,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(cityCode = it) })
            EniTextField(
                "Ville",
                value = signUpRequestState.city,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(city = it) })
            EniTextField(
                "N° Tel",
                value = signUpRequestState.phone,
                onValueChange = { signUpRequest.value = signUpRequest.value.copy(phone = it) })
            EniGradientButton("Sign Up", onClick = {  onClickSignUp(signUpRequest.value, viewModel) })
        }

        ProgressDialogHelper.Singleton.progressDialogHelper.renderProgress()
        AlertDialogHelper.Singleton.alertDialogHelper.render()
    }
}