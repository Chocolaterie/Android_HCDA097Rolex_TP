package com.example.androidenitp.movie

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidenitp.R
import com.example.androidenitp.ui.theme.AndroidEniTPTheme
import com.example.androidenitp.ui.theme.EniBackgroundPage

class MovieDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MovieDetailPage()
        }
    }
}

@Composable
fun MovieDetailPage(
) {
    AndroidEniTPTheme {
        Scaffold { innerPadding ->
            Box(modifier = Modifier
                .padding(innerPadding)
                .background(Color.Black)) {
                MovieBackgroundComponent()
                Column {
                    Spacer(Modifier.weight(1.5f))
                    Column(Modifier.padding(20.dp)) {
                        Text("The Black phone", fontSize = 28.sp, color = Color.White)
                        Row(Modifier.padding(vertical = 7.dp)) {
                            MovieTag("Horror")
                            MovieTag("Thriller")
                            MovieTag("Supernatural")
                        }
                        Text(movieLoremDesc, color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailPagePreview() {
    MovieDetailPage()
}
