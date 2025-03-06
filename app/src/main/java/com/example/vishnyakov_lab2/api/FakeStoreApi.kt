package com.example.vishnyakov_lab2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FakeStoreApi {
    private const val BASE_URL = "https://fakestoreapi.com/"

    val fakeStoreController: FakeStoreController by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreController::class.java)
    }
}