package com.example.nineandtenpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.nineandtenpractice.R
import com.example.nineandtenpractice.models.Pet

class PetAdapter(
    private val context: Context, private val layout: Int, private val pets: ArrayList<Pet>
) : ArrayAdapter<Pet>(context, layout, pets) {

    // getView is called for each item in the list
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView // the view that will be returned
        val holder: ViewHolder // a class that holds references to the views in the layout

        // if the view is null, inflate the layout and create a new ViewHolder
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(layout, parent, false)
            holder = ViewHolder()
            holder.petNameTextView = itemView.findViewById(R.id.nameText)
            holder.petAgeTextView = itemView.findViewById(R.id.ageText)
            holder.petTypeTextView = itemView.findViewById(R.id.typeText)
            itemView.tag = holder
        } else {
            holder = itemView.tag as ViewHolder
        }

        // get the current pet and set the text of the views
        val pet = pets[position]
        holder.petNameTextView.text = pet.name
        holder.petAgeTextView.text = pet.age.toString()
        holder.petTypeTextView.text = pet.type

        return itemView!!
    }

    // ViewHolder is a class that holds references to the views in the layout
    private class ViewHolder {
        lateinit var petNameTextView: TextView
        lateinit var petAgeTextView: TextView
        lateinit var petTypeTextView: TextView
    }
}