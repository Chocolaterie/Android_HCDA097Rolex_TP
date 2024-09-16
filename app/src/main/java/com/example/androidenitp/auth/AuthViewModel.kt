package com.example.androidenitp.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidenitp.article.ArticleService
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    fun callApi(email: String, password : String) {
        // Coroutine (tâche async)
        viewModelScope.launch {
            // Appel API
            val loginRequest = LoginRequest(email, password);
            val apiResponse = AuthService.AuthApi.authService.login(loginRequest);

            println(apiResponse.code);
            println(apiResponse.message);

            // Si le code metier est 200 donc succès alors récupérer les articles dans data
            if (apiResponse.code.equals("200")){
                // articles.value = apiResponse.data;
                println("L'api à fonctionnée avec le code 200")
            }

        }
    }
}