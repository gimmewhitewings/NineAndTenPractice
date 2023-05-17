package com.example.nineandtenpractice.repo

import com.example.nineandtenpractice.models.Pet

object PetRepo {
    val data = arrayListOf<Pet>(
        Pet("Fido", 3, "Dog"),
        Pet("Fluffy", 2, "Cat"),
        Pet("Goldie", 1, "Fish"),
        Pet("Spot", 4, "Dog")
    )
}