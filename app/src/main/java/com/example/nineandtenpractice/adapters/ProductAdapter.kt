package com.example.nineandtenpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.nineandtenpractice.R
import com.example.nineandtenpractice.models.Product

class ProductAdapter(
    private val context: Context,
    private val layout: Int,
    private val products: ArrayList<Product>
) : ArrayAdapter<Product>(context, layout, products) {

    // getView is called for each item in the list
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView // the view that will be returned
        val holder: ViewHolder // a class that holds references to the views in the layout

        // if the view is null, inflate the layout and create a new ViewHolder
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(layout, parent, false)
            holder = ViewHolder()
            holder.productNameTextView = itemView.findViewById(R.id.nameText)
            holder.productCountTextView = itemView.findViewById(R.id.countText)
            holder.productUnitTextView = itemView.findViewById(R.id.unitText)
            holder.addButton = itemView.findViewById(R.id.plusButton)
            holder.removeButton = itemView.findViewById(R.id.minusButton)
            itemView.tag = holder
        } else {
            holder = itemView.tag as ViewHolder
        }

        // get the current product and set the text of the views
        val product = products[position]
        holder.productNameTextView.text = product.name
        holder.productCountTextView.text = product.count.toString()
        holder.productUnitTextView.text = product.unit

        // set the onClickListener for the add button
        holder.addButton.setOnClickListener {
            product.count++
            holder.productCountTextView.text = product.count.toString()
        }

        // set the onClickListener for the remove button
        holder.removeButton.setOnClickListener {
            if (product.count > 0) {
                product.count--
                holder.productCountTextView.text = product.count.toString()
            }
        }

        return itemView!!
    }

    // ViewHolder is a class that holds references to the views in the layout
    private class ViewHolder {
        lateinit var productNameTextView: TextView
        lateinit var productCountTextView: TextView
        lateinit var productUnitTextView: TextView
        lateinit var addButton: Button
        lateinit var removeButton: Button
    }
}
