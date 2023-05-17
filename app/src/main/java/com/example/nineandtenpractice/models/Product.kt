package com.example.nineandtenpractice.models

class Product(val name: String, var count: Int, val unit: String) {
    override fun toString(): String {
        return "$name: $count $unit"
    }
}