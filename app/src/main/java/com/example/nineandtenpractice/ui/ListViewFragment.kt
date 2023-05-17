package com.example.nineandtenpractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.nineandtenpractice.R
import com.example.nineandtenpractice.databinding.FragmentListViewBinding


class ListViewFragment : Fragment() {

    private lateinit var binding: FragmentListViewBinding

    private val list = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val initialList = resources.getStringArray(R.array.countries)
        list.addAll(initialList)
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, list)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, _, _, _ ->
            val selected = binding.listView.checkedItemPositions
            val selectedItems = mutableListOf<String>()
            for (i in 0 until selected.size()) {
                if (selected.valueAt(i)) {
                    selectedItems.add(parent.getItemAtPosition(selected.keyAt(i)) as String)
                }
            }
            binding.choiceTextView.text = selectedItems.joinToString()
        }

        binding.addButton.setOnClickListener {
            add(it)
        }

        binding.removeButton.setOnClickListener {
            remove(it)
        }
    }

    private fun add(View: View) {
        val country = binding.countryEditText.text.toString()
        if (country.isNotEmpty()) {
            list.add(country) // Add the new country to the list
            val adapter = binding.listView.adapter as ArrayAdapter<String>
            adapter.notifyDataSetChanged()
            binding.countryEditText.text.clear()
        }
    }

    private fun remove(View: View) {
        val selected = binding.listView.checkedItemPositions
        val adapter = binding.listView.adapter as ArrayAdapter<String>
        for (i in 0 until selected.size()) {
            adapter.remove(binding.listView.getItemAtPosition(selected.keyAt(i)) as String)
        }
        binding.listView.clearChoices()
        binding.choiceTextView.text = ""
        adapter.notifyDataSetChanged()
    }

}
