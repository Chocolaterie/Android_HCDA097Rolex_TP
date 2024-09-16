package com.example.androidenitp.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel : ViewModel() {

    var articles = MutableStateFlow(listOf<Article>())

    fun callApi(){
        // Coroutine (tâche async)
        viewModelScope.launch {
            // Appel API
            val apiResponse = ArticleService.ArticleApi.articleService.getArticles();

            // Si le code metier est 200 donc succès alors récupérer les articles dans data
            if (apiResponse.code.equals("200")){
                articles.value = apiResponse.data!!;
            }

        }
    }
}