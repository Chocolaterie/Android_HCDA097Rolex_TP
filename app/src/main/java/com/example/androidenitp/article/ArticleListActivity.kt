package com.example.androidenitp.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTitleTextPage

class ArticleListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Liste des articles mock
        val articles = listOf(
            Article(
                "Pinte de nutella",
                "olpqsdppsqpoqssd",
                "https://www.bridor.com/medias/sys_master/images/images/h07/hdc/8897595441182/Croissant-Courb-EDT-SourceHD-515Wx515H.png"
            ),
            Article(
                "Crevete Nutella",
                "Que des dingueries",
                "https://dogtime.com/wp-content/uploads/sites/12/2011/01/GettyImages-653001154-e1691965000531.jpg"
            ),
        )

        setContent {
            ArticleListComposePage(articles)
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Box(modifier = Modifier.height(164.dp)) {
            AsyncImage(
                model = article.imgPath,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0x55000000))
                ) {
                    Text(
                        article.title,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        article.desc,
                        modifier = Modifier.padding(10.dp),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleListComposePage(articles: List<Article>) {
    EniTemplatePage({
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("La liste des articles", paddingTitle = 20.dp)
            LazyColumn {
                items(articles) { article ->
                    ArticleCard(article)
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun ArticleListComposePagePreview() {

    // Liste des articles mock
    val articles = listOf(
        Article("Pinte de nutella", "olpqsdppsqpoqssd", ""),
        Article("Crevete Nutella", "Que des dingueries", ""),
    )

    ArticleListComposePage(articles)
}
