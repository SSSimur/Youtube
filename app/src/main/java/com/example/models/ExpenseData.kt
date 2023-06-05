package com.example.models

data class ExpenseData(
    val id: Long,
    val title: String,
    val description: String,
    val type: String,
    val amount: Double,
    val date: String,
    val walletId: Long,
    val userId: Long
)
