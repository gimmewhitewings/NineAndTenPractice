package com.example.nineandtenpractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nineandtenpractice.databinding.FragmentGridBinding


class GridFragment : Fragment() {

    private lateinit var binding: FragmentGridBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            "Russia",
            "Canada",
            "USA",
            "China",
            "Japan",
            "Korea",
            "India",
            "Brazil",
            "Argentina",
            "Mexico"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, data)
        binding.gridView.adapter = adapter
        binding.gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), data[position], Toast.LENGTH_SHORT).show()
        }
    }
}