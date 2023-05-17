package com.example.nineandtenpractice.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nineandtenpractice.adapters.PetRecyclerAdapter
import com.example.nineandtenpractice.databinding.FragmentRecyclerBinding
import com.example.nineandtenpractice.repo.PetRepo

class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding


    private val TAG = "RecyclerFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = PetRepo.data
        val adapter = PetRecyclerAdapter(data)
        binding.petRecyclerView.adapter = adapter
        binding.petRecyclerView.layoutManager = LinearLayoutManager(context)
    }
}