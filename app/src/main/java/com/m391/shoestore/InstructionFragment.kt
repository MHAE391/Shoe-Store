package com.m391.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.m391.shoestore.databinding.FragmentInstructionBinding
import com.m391.shoestore.databinding.FragmentWelcomeScreenBinding

class InstructionFragment : Fragment() {
    lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction,container,false)
        binding.navToItemsListButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_instructionFragment_to_shoesListingFragment)
        }
        return binding.root
    }
}