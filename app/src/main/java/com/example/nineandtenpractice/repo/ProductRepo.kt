package com.example.nineandtenpractice.repo

import com.example.nineandtenpractice.models.Product

object ProductRepo {
    // init product data with count 0
    val data = arrayListOf(
        Product("Milk", 0, "gallons"),
        Product("Eggs", 0, "dozen"),
        Product("Bread", 0, "loaves"),
        Product("Butter", 0, "sticks"),
        Product("Cheese", 0, "slices"),
        Product("Apples", 0, "pounds"),
        Product("Oranges", 0, "pounds"),
        Product("Bananas", 0, "pounds"),
        Product("Peaches", 0, "pounds"),
        Product("Grapes", 0, "pounds")
    )
}