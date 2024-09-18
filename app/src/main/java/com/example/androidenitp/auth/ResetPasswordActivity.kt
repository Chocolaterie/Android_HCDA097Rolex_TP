package com.example.androidenitp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidenitp.ui.theme.EniTemplatePage

class ResetPasswordActivity : ComponentActivity() {

    var viewModel = AuthViewModel();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ResetPasswordComposePage(viewModel)
        }
    }

}

@Composable
fun ResetPasswordComposePage(viewModel: AuthViewModel) {
    EniTemplatePage({
        ResetPasswordComponent(viewModel)
    })
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordComposePagePreview() {

    var viewModel = AuthViewModel();

    ResetPasswordComposePage(viewModel)
}
