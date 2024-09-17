package com.example.androidenitp.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidenitp.R

class MovieTheme {
}

val movieLoremDesc =
    "The Black Phone is a 2021 American supernatural horror film[3] directed by Scott Derrickson from a screenplay coauthored with longtime collaborator C. Robert Cargill. It stars Mason Thames as Finney, a teenage boy abducted by a serial child killer known colloquially as The Grabber (Ethan Hawke). When Finney encounters a mystical black rotary phone in captivity, he uses it to plot his escape by communicating with the ghosts of The Grabber's slain victims";

@Composable
fun MovieReviewComponent(review: Float) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 10.dp)) {
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(text = "${review}", modifier = Modifier.padding(horizontal = 10.dp), color = Color(0xFFfdd10e), fontSize = 18.sp)
        Text(text = "(159k reviews)", color = Color.White)
    }
}

@Composable
fun MovieIMDBTag(review: Float) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .background(color = Color(0xFFfdd10e), shape = RoundedCornerShape(30.dp))
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(text = "IMDB ${review}", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MovieTag(label: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .background(color = Color(0x77FFFFFF), shape = RoundedCornerShape(30.dp))
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(text = label, color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun MovieBackgroundComponent() {
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
}