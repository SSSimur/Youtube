package com.example.models

data class RegistrationRequest(
    val email: String,
    val password: String,
    val firstname: String,
    val lastname: String,
    val phone: String
)
