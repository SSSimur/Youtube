package com.example.retrofit

import com.example.models.AllWalletData
import com.example.models.LoginRequest
import com.example.models.LoginResponse
import com.example.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("/auth/login/with-email")
    suspend fun login(@Body request: LoginRequest):retrofit2.Response<LoginResponse>

    @GET("/users")
    suspend fun getUsers():retrofit2.Response<User>


    //Registration
    @POST ("/auth/register")
    suspend fun registration(
        @Query("email") regemail:String,
        @Query("password") regpassword:String,
        @Query("firstname") firstname:String,
        @Query("lastname") lastname:String,
        @Query("phone") regphone:String
    ):retrofit2.Response<User>

    //Test
    @GET ("/auth")
    suspend fun test(): retrofit2.Response<String>

    @GET("/wallets")
    suspend fun getWallets(
        @Query("title") title:String,
        @Query("balance") balance:String
    ): retrofit2.Response<AllWalletData>





}