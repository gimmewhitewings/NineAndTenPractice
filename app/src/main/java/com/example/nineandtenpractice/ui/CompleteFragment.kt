package com.example.nineandtenpractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.nineandtenpractice.databinding.FragmentCompleteBinding


class CompleteFragment : Fragment() {

    private lateinit var binding: FragmentCompleteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCompleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // list of products
        val data = arrayListOf(
            "Milk", "Eggs", "Bread", "Butter", "Cheese", "Yogurt"
        )

        // set the adapter
        val adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_dropdown_item_1line, data
        )

        binding.materialAutoCompleteTextView.setAdapter(adapter)

        binding.appCompatMultiAutoCompleteTextView.setAdapter(adapter)
        binding.appCompatMultiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }

}