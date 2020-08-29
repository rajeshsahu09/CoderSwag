package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.R
import com.example.coderswag.utilities.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val category_type = intent.getStringExtra(EXTRA_CATEGORY)
    }
}