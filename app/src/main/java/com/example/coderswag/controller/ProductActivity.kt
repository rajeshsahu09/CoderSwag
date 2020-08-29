package com.example.coderswag.controller

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.adapter.ProductAdapter
import com.example.coderswag.model.Product
import com.example.coderswag.services.DataService
import com.example.coderswag.utilities.EXTRA_CATEGORY
import kotlin.math.max

class ProductActivity : AppCompatActivity() {

    private lateinit var viewManager : RecyclerView.LayoutManager
    private lateinit var viewAdapter : ProductAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val category_type = intent.getStringExtra(EXTRA_CATEGORY).toString()

        val orientation = resources.configuration.orientation
        var orien = if(Configuration.ORIENTATION_PORTRAIT == orientation) 2 else 3

        val screenSize = resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK // finds if XLarge device or not (4)
        val screen = if(screenSize > Configuration.SCREENLAYOUT_SIZE_LARGE) 3 else 2

        val spanCount = max(orien, screen)
        viewManager = GridLayoutManager(this, spanCount)
        viewAdapter = ProductAdapter(DataService.getProducts(category_type)) { product: Product ->
            fun getEmoji(product: String): String {
                return when(product) {
                    "Shirts" -> "\uD83D\uDC55"
                    "Hats" -> "\uD83E\uDDE2"
                    "Hoodies" -> "\uD83E\uDDE5"
                    else -> "\uD83D\uDCBB"
                }
            }
            var info = "Category ${getEmoji(category_type)}: Product: ${product.title}"
            Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
        }

        recyclerView = findViewById<RecyclerView>(R.id.productlistrecyclerview).apply {
            setHasFixedSize(true) // set only if cell size does not change
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}