package com.example.vishnyakov_lab2.api

import com.example.vishnyakov_lab2.types.FakeStoreProduct
import retrofit2.Call
import retrofit2.http.GET

interface FakeStoreController {
    @GET("products")
    fun getProducts(): Call<List<FakeStoreProduct>>
}