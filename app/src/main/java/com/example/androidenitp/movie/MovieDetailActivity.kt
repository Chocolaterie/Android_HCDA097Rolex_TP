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
            Box(modifier = Modifier.padding(innerPadding).background(Color.Black)) {
                Column {
                    Box(modifier = Modifier.weight(1.5f)) {
                        Image(
                            painter = painterResource(id = R.drawable.movie_background),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0x00000000),
                                            Color(0x00000000),
                                            Color(0xFF000000)
                                        )
                                    )
                                )
                        ) {

                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))
                }
                Column { Text("TODO") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailPagePreview() {
    MovieDetailPage()
}
