package com.example.retrofit

import com.example.models.AllWalletData
import com.example.models.ExpenseData
import com.example.models.LoginRequest
import com.example.models.LoginResponse
import com.example.models.OnlyMessage
import com.example.models.RegistrationRequest
import com.example.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("/auth/login/with-email")
    suspend fun login(@Body request: LoginRequest):retrofit2.Response<LoginResponse>

    @GET("/users")
    suspend fun getUsers():retrofit2.Response<User>


    //Registration
    @POST ("/auth/register")
    suspend fun registration(@Body request: RegistrationRequest):retrofit2.Response<OnlyMessage>

    //Test
    @GET ("/auth")
    suspend fun test(): retrofit2.Response<String>

    @GET("/wallets")
    suspend fun getWallets(
        @Header("Authorization") token: String
    ): retrofit2.Response<AllWalletData>


    @GET("/users/{userId}/expenses")
    suspend fun getExpensesOfUser(
        @Header("Authorization") token: String,
        @Path("userId") userId: Int
    ): retrofit2.Response<List<ExpenseData>>

    @POST("/users/{userId}/wallets/{walletId}/expenses")
    suspend fun addExpenses(
        @Header("Authorization") token: String,
        @Path("userId") userId: Int,
        @Path("walletId") walletId: Int,
        @Body expenses: ExpenseData
    ): retrofit2.Response<ExpenseData>





}