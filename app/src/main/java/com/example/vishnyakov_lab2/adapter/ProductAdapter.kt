package com.example.vishnyakov_lab2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vishnyakov_lab2.R
import com.example.vishnyakov_lab2.types.FakeStoreProduct

class ProductAdapter(
    private val products: List<FakeStoreProduct>,
    private val onItemClick: (FakeStoreProduct) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.setOnClickListener { onItemClick(product) }
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.productTitle)
        private val price: TextView = itemView.findViewById(R.id.productPrice)
        private val image: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: FakeStoreProduct) {
            title.text = product.title
            price.text = "$${product.price}"
            Glide.with(itemView.context).load(product.image).into(image)
            image.contentDescription = "Картинка: ${product.title}"
        }
    }
}