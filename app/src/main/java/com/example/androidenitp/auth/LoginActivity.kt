package com.example.androidenitp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LoginComposePage()
        }
    }
}

@Composable
fun LoginComposePage() {
    EniTemplatePage({
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Login")
            EniTextField("Email")
            EniTextField("Mot de passe")
            EniGradientButton("Connexion")
        }
    })
}

@Preview(showBackground = true)
@Composable
fun LoginComposePagePreview() {
    LoginComposePage()
}
