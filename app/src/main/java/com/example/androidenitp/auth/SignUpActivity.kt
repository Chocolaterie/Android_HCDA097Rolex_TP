package com.example.androidenitp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidenitp.ui.theme.EniTemplatePage
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpActivity : ComponentActivity() {

    lateinit var viewModel: AuthViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val signUpRequest = MutableStateFlow(SignUpRequest());

        // Instancier le view model
        viewModel = AuthViewModel();

        setContent {
            SignUpComposePage(signUpRequest, viewModel)
        }
    }

}

@Composable
fun SignUpComposePage(signUpRequest : MutableStateFlow<SignUpRequest>, viewModel: AuthViewModel) {

    EniTemplatePage({
        SignUpComponent(signUpRequest, viewModel)
    })
}

@Preview(showBackground = true)
@Composable
fun SignUpComposePagePreview() {

    // Instancier le view model
    val viewModel = AuthViewModel();

    val signUpRequest = MutableStateFlow(SignUpRequest());

    SignUpComposePage(signUpRequest, viewModel)
}
