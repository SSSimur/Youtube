package com.example.models

data class User(
    val id: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: Int,
    val password: String,
)