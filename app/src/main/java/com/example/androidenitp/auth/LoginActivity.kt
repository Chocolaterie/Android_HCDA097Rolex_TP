package com.example.androidenitp.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidenitp.article.ArticleListActivity
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KClass

class LoginActivity : ComponentActivity() {

    lateinit var viewModel : AuthViewModel;

    //
    var email = MutableStateFlow<String>("isaac@gmail.com");
    var password = MutableStateFlow<String>("password");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // instancier le view model
        viewModel = AuthViewModel();

        // Version 1
        setContent {
            LoginComposePage(
                onClickLoginBtn = { onClickLogin() },
                onClickResetBtn = { onClickResetPassword() },
                onClickSignUpBtn = { onClickSignUp() },
                email,
                password
            )
        }
    }

    fun onClickLogin() {
        /*
        val intent = Intent(this, ArticleListActivity::class.java);
        startActivity(intent);
        */
        viewModel.callApi(email.value, password.value)
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
    onClickLoginBtn: () -> Unit = {},
    onClickResetBtn: () -> Unit = {},
    onClickSignUpBtn: () -> Unit = {},
    email: MutableStateFlow<String> = MutableStateFlow<String>(""),
    password: MutableStateFlow<String> = MutableStateFlow<String>(""),
) {
    val emailState by email.collectAsState();
    val passwordState by password.collectAsState();

    EniTemplatePage({
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Login")
            EniTextField("Email", value = emailState, onValueChange = { email.value = it })
            EniTextField("Mot de passe", value = passwordState, onValueChange = { password.value = it })
            EniGradientButton("Connexion", onClickLoginBtn)
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                EniGradientButton("Reset Password", onClickResetBtn)
                EniGradientButton("Je veux m'inscrire", onClickSignUpBtn)
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun LoginComposePagePreview() {
    LoginComposePage()
}
