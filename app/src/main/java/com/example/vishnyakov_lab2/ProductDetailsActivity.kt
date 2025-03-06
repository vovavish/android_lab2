package com.example.vishnyakov_lab2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.vishnyakov_lab2.databinding.ActivityProductDetailsBinding
import com.example.vishnyakov_lab2.types.FakeStoreProduct

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("PRODUCT") as FakeStoreProduct

        binding.detailTitle.text = product.title
        binding.detailPrice.text = getString(R.string.price_format, product.price)
        binding.detailDescription.text = product.description
        Glide.with(this).load(product.image).into(binding.detailImage)

        binding.shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Продукт: ${product.title}\n${product.image}")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Поделиться через"))
        }
    }
}