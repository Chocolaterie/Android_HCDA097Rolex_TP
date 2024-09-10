package com.example.androidenitp.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidenitp.ui.theme.EniGradientButton
import com.example.androidenitp.ui.theme.EniTemplatePage
import com.example.androidenitp.ui.theme.EniTextField
import com.example.androidenitp.ui.theme.EniTitleTextPage

class ArticleListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Liste des articles mock
        val articles = listOf(
            Article("Pinte de nutella", "olpqsdppsqpoqssd", ""),
            Article("Crevete Nutella", "Que des dingueries", ""),
        )

        setContent {
            ArticleListComposePage(articles)
        }
    }
}

@Composable
fun ArticleCard(article: Article){
    Text("Le titre est : ${article.title}")
}

@Composable
fun ArticleListComposePage(articles : List<Article>) {
    EniTemplatePage({
        Column(modifier = Modifier.padding(40.dp)) {
            EniTitleTextPage("La liste des articles")
            LazyColumn {
                items(articles) {
                    article -> ArticleCard(article)
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
