package com.example.androidenitp.auth.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidenitp.auth.AuthViewModel
import com.example.androidenitp.auth.LoginComponent
import com.example.androidenitp.auth.ResetPasswordComponent
import com.example.androidenitp.ui.theme.AndroidEniTPTheme
import com.example.androidenitp.ui.theme.FragmentTemplatePage

class AppNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavActivityPage()
        }
    }
}

@Composable
fun NavActivityPage() {
    var viewModel = AuthViewModel();

    // NavController ecoutable
    val navController = rememberNavController()

    AndroidEniTPTheme {
        Scaffold { innerPadding ->
            NavHost(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                navController = navController,
                startDestination = "login"
            ) {
                composable("reset-password") {
                    FragmentTemplatePage({
                        ResetPasswordComponent(viewModel)
                    })
                }
                composable("login") {
                    FragmentTemplatePage({
                        LoginComponent(viewModel)
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoActivityNavPagePreview() {

    NavActivityPage()
}