package com.example.androidenitp.api

/*
 * Genericité :
 * Quand T => List<Movie> du coup data devient => data : List<Movie>
 * Quand T => String du coup data devient => data : String
 * Quand T => User du coup data devient => data : User
 * Quand T => Boolean du coup data devient => data : Boolean
 * Etc...
 */
class ApiResponse<T>(var code : String, var message : String, var data : T?) {
}