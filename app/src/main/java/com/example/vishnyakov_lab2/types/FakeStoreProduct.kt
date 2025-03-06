package com.example.vishnyakov_lab2.types

import java.io.Serializable

// https://fakestoreapi.com/products/1
//{
//    "id": 1,
//    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//    "price": 109.95,
//    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//    "category": "men's clothing",
//    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//    "rating": {
//    "rate": 3.9,
//    "count": 120
//}

data class FakeStoreProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
) : Serializable
