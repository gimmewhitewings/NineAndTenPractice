package com.example.nineandtenpractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nineandtenpractice.R
import com.example.nineandtenpractice.adapters.ProductAdapter
import com.example.nineandtenpractice.databinding.FragmentButtonListBinding
import com.example.nineandtenpractice.models.Product
import com.example.nineandtenpractice.repo.ProductRepo


class ButtonListFragment : Fragment() {

    private lateinit var binding: FragmentButtonListBinding
    private lateinit var products: ArrayList<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentButtonListBinding.inflate(inflater, container, false)
        products = ProductRepo.data
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(requireContext(), R.layout.product_item, products)
        binding.listView.adapter = adapter
    }

}