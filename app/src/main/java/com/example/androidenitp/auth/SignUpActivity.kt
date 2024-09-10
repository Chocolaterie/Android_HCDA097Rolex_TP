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

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SignUpComposePage()
        }
    }
}

@Composable
fun SignUpComposePage() {
    EniTemplatePage({
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("Sign Up", paddingTitle = 40.dp)
            EniTextField("Pseudo")
            EniTextField("Email")
            EniTextField("Mot de passe")
            EniTextField("Confirmation Mot de passe")
            EniTextField("Code Postal")
            EniTextField("Ville")
            EniTextField("N° Tel")
            EniGradientButton("Sign Up")
        }
    });
}

@Preview(showBackground = true)
@Composable
fun SignUpComposePagePreview() {
    SignUpComposePage()
}
