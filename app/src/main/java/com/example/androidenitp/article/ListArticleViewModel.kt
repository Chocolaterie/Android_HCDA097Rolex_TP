package com.example.androidenitp.article

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ListArticleViewModel : ViewModel() {

    var articles = MutableStateFlow(listOf(
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
    ))

    fun addArticleTest(){
        articles.value += Article("Orchidée Noir", "Quelqu'un", "https://www.lafoliedessenteurs.com/670-superlarge_default/orchidee-noire.jpg")
    }
}