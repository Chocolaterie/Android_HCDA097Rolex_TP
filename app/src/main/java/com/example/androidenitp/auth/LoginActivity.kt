package com.example.androidenitp.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.androidenitp.article.ArticleListActivity
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KClass

class LoginActivity : ComponentActivity() {

    lateinit var viewModel : AuthViewModel;

    // Va condition l'affichage de la boite de chargement
    val showProgressDialog = MutableStateFlow<Boolean>(false)

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
                password,
                showProgressDialog
            )
        }
    }

    fun onClickLogin() {
        /*
        val intent = Intent(this, ArticleListActivity::class.java);
        startActivity(intent);
        */
        // Afficher la popup
        showProgressDialog.value = true;
        // Appel api
        viewModel.callApi(email.value, password.value, {
            showProgressDialog.value = false;
        })
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
    showProgressDialog: MutableStateFlow<Boolean>
) {
    val emailState by email.collectAsState();
    val passwordState by password.collectAsState();
    // Ecouter les changements du boolean
    val showProgressDialogState by showProgressDialog.collectAsState();

    EniTemplatePage({
        Box {
            Column(modifier = Modifier.padding(40.dp)) {
                EniTitleTextPage("Login")
                EniTextField("Email", value = emailState, onValueChange = { email.value = it })
                EniTextField(
                    "Mot de passe",
                    value = passwordState,
                    onValueChange = { password.value = it })
                EniGradientButton("Connexion", onClickLoginBtn)
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                    EniGradientButton("Reset Password", onClickResetBtn)
                    EniGradientButton("Je veux m'inscrire", onClickSignUpBtn)
                }
            }
            if (showProgressDialogState) {
                Dialog(onDismissRequest = {
                    showProgressDialog.value = false;
                }) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.background(
                            Color.White,
                            shape = RoundedCornerShape((10.dp))
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator()
                            Text("Chargement en cours..")
                        }
                    }
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun LoginComposePagePreview() {

    val showProgressDialog = MutableStateFlow<Boolean>(false)

    LoginComposePage(showProgressDialog = showProgressDialog)
}
