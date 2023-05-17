package com.example.nineandtenpractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nineandtenpractice.R
import com.example.nineandtenpractice.adapters.PetAdapter
import com.example.nineandtenpractice.databinding.FragmentComplexListBinding
import com.example.nineandtenpractice.models.Pet
import com.example.nineandtenpractice.repo.PetRepo


class ComplexListFragment : Fragment() {

    private lateinit var binding: FragmentComplexListBinding
    private lateinit var pets: ArrayList<Pet>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentComplexListBinding.inflate(inflater, container, false)
        pets = PetRepo.data
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PetAdapter(requireContext(), R.layout.pet_item, pets)
        binding.listView.adapter = adapter
        val itemListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            val pet = parent.getItemAtPosition(position) as Pet
            Toast.makeText(requireContext(), pet.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.listView.onItemClickListener = itemListener
    }

}