package com.example.androidenitp.auth

data class SignUpRequest(
    var email: String = "",
    var pseudo: String = "",
    var password: String = "",
    var passwordConfirm: String = "",
    var cityCode: String = "",
    var city: String = "",
    var phone: String = ""
) {
}