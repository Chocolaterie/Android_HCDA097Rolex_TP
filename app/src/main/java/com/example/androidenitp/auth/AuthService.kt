package com.example.androidenitp.auth

import com.example.androidenitp.api.ApiResponse
import com.example.androidenitp.api.RetrofitTools.Companion.retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    /**
     * loginRequest : ce qu'on envoie dans le body donc (email, password)
     * ApiResponse : code, message, data
     */
    @POST("login")
    suspend fun login(@Body loginRequest : LoginRequest) : ApiResponse<String>

    @POST("signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest) : ApiResponse<User>

    @POST("reset-password")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest) : ApiResponse<String>

    object AuthApi {
        val authService : AuthService by lazy { retrofit.create(AuthService::class.java) }
    }
}