package com.example.vishnyakov_lab2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vishnyakov_lab2.adapter.ProductAdapter
import com.example.vishnyakov_lab2.api.FakeStoreApi
import com.example.vishnyakov_lab2.databinding.ActivityMainBinding
import com.example.vishnyakov_lab2.types.FakeStoreProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productList.layoutManager = LinearLayoutManager(this)

        fetchProducts()
    }

    private fun fetchProducts() {
        FakeStoreApi.fakeStoreController.getProducts().enqueue(object : Callback<List<FakeStoreProduct>> {
            override fun onResponse(call: Call<List<FakeStoreProduct>>, response: Response<List<FakeStoreProduct>>) {
                if (response.isSuccessful) {
                    val products = response.body() ?: emptyList()
                    binding.productList.adapter = ProductAdapter(products) { product ->
                        val intent = Intent(this@MainActivity, ProductDetailsActivity::class.java)
                        intent.putExtra("PRODUCT", product)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<List<FakeStoreProduct>>, t: Throwable) {
                // Обработки ошибки пока нет
            }
        })
    }
}