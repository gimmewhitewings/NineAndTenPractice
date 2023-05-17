package com.example.nineandtenpractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nineandtenpractice.R
import com.example.nineandtenpractice.models.Pet

class PetRecyclerAdapter(private val pets: List<Pet>) :
    RecyclerView.Adapter<PetRecyclerAdapter.PetViewHolder>() {

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val petNameTextView: TextView = itemView.findViewById(R.id.nameText)
        val petAgeTextView: TextView = itemView.findViewById(R.id.ageText)
        val petTypeTextView: TextView = itemView.findViewById(R.id.typeText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)
        return PetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = pets[position]
        holder.petNameTextView.text = pet.name
        holder.petAgeTextView.text = pet.age.toString()
        holder.petTypeTextView.text = pet.type
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "You clicked ${pet.name}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount(): Int {
        return pets.size
    }
}