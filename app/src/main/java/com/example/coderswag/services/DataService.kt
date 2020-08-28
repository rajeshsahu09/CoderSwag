package com.example.coderswag.services

import com.example.coderswag.model.Category
import com.example.coderswag.model.Product

/**
 * Create singleton object
 * which store the information for category and its products
 * Like a small database
 */
object DataService {
    /**
     * In the resource/drawable folder we can see
     * 4 categories: Hat, Hoodie, Shirts, Digital
     * Each category has 4-5 products
     */
    val categories = listOf<Category>(
        Category("Shirts", "shirtimage"),
        Category("Hoodies", "hoodieimage"),
        Category("Hats", "hatimage"),
        Category("Digitals", "digitalgoodsimage"),

        Category("Shirts", "shirtimage"),
        Category("Hoodies", "hoodieimage"),
        Category("Hats", "hatimage"),
        Category("Digitals", "digitalgoodsimage")
    )

    val hats = listOf<Product>(
        Product("Devslopes Graphic Beanie", "₹699", "hat1"),
        Product("Devslopes Hat Black", "₹599", "hat2"),
        Product("Devslopes Hat White", "₹499", "hat3"),
        Product("Devslopes Hat Snapback", "₹435", "hat4"),
    )

    val hoodies = listOf<Product>(
        Product("Devslopes Hoodie Grey", "₹899", "hoodie1"),
        Product("Devslopes Hoodie Black", "₹799", "hoodie2"),
        Product("Devslopes Hoodie White", "₹699", "hoodie3"),
        Product("Devslopes Hoodie Blue", "₹535", "hoodie4"),
    )
    val shirts = listOf<Product>(
        Product("Devslopes Badge Shirt Grey", "₹899", "shirt1"),
        Product("Devslopes Shirt Black", "₹599", "shirt"),
        Product("Devslopes Logo Shirt Red", "₹699", "shirt3"),
        Product("Devslopes Hustle", "₹999", "shirt4"),
        Product("Kickflip Studios", "₹535", "shirt5"),
    )
}