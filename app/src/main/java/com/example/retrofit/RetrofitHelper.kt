package com.example.retrofit

import com.google.gson.GsonBuilder
import com.util.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

public object RetrofitHelper {
    fun getInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}