package com.example.coderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Product

class ProductAdapter(private val myProducts : List<Product>, var itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    class MyViewHolder(var productView: View, var context : Context, var itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(productView) {
        val productTitle: TextView = productView.findViewById(R.id.productname)
        val productPrice: TextView = productView.findViewById(R.id.productprice)
        val productImage: ImageView = productView.findViewById(R.id.productimg)

        fun bindProduct(myProduct: Product) {
            productTitle.text =  myProduct.title
            productPrice.text = "Price: "+myProduct.price

            val resourceId = context.resources.getIdentifier(myProduct.image, "drawable", context.packageName)
            productImage.setImageResource(resourceId)

            productView.setOnClickListener { itemClick(myProduct) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var viewProdcut = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)

        return MyViewHolder(viewProdcut, parent.context, itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindProduct(myProducts[position])
    }

    override fun getItemCount(): Int {
        return myProducts.count()
    }
}