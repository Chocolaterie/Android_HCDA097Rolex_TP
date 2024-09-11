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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidenitp.article.ArticleListActivity
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage
import kotlin.reflect.KClass

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Version 1
        setContent {
            LoginComposePage(
                onClickLoginBtn = { onClickLogin() },
                onClickResetBtn = { onClickResetPassword() },
                onClickSignUpBtn = { onClickSignUp() }
            )
        }

        // Version Generique
        /*
        setContent {
            LoginComposePage(onClickLoginBtn = { startActivityGeneric(ArticleListActivity::class) },
                onClickResetBtn = { startActivityGeneric(LoginActivity::class) },
                onClickSignUpBtn = { startActivityGeneric(ResetPasswordActivity::class) }
            )
        }
        */
    }

    // Version Generique
    /*
    fun <T : Any> startActivityGeneric(classe : KClass<T>){
        val intent = Intent(this, classe.java);
        startActivity(intent);
    }
    */
    fun onClickLogin() {
        val intent = Intent(this, ArticleListActivity::class.java);
        startActivity(intent);
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
    onClickSignUpBtn: () -> Unit = {}
) {
    EniTemplatePage({
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Login")
            EniTextField("Email")
            EniTextField("Mot de passe")
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
