package com.example.androidenitp.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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

class LoginActivity : ComponentActivity() {

    lateinit var viewModel: AuthViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // instancier le view model
        viewModel = AuthViewModel();

        // Version 1
        setContent {
            LoginComposePage(
                viewModel,
                onClickResetBtn = { onClickResetPassword() },
                onClickSignUpBtn = { onClickSignUp() },
            )
        }
    }

    fun onClickResetPassword() {
        val intent = Intent(this, ResetPasswordActivity::class.java);
        startActivity(intent);
    }

    fun onClickSignUp() {
        val intent = Intent(this, SignUpActivity::class.java);
        startActivity(intent);
    }
}

@Composable
fun LoginComposePage(
    viewModel: AuthViewModel,
    onClickResetBtn: () -> Unit = {},
    onClickSignUpBtn: () -> Unit = {},
) {

    EniTemplatePage({
        LoginComponent(viewModel, onClickResetBtn, onClickSignUpBtn)
    })
}

@Preview(showBackground = true)
@Composable
fun LoginComposePagePreview() {
    val viewModel = AuthViewModel()

    LoginComposePage(viewModel)
}
