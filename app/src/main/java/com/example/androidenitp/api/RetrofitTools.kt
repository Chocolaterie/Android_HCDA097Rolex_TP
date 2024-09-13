package com.example.androidenitp.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitTools {

    // Kotlin :  companion object = tout ce qui est dedans est statics
    companion object{
        // La racine de l'api
        // val BASE_URL = "http://localhost:3000/"

        // La racine de l'api
        val BASE_URL = "http://161.35.39.34:3000/"

        // Pour les personnes emulateurs :
        //val BASE_URL = "http://10.0.2.2:3000/"

        // L'utilitaire conversion JSON <=> Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();

        // Retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build();
    }
}