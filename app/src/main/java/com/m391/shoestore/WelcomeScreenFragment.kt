package com.m391.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.m391.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {
    lateinit var binding : FragmentWelcomeScreenBinding
    lateinit var viewModel: ShoesListingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        (activity as AppCompatActivity).supportActionBar?.hide()
        viewModel = ViewModelProvider(requireActivity())[ShoesListingViewModel::class.java]
        viewModel.Done.postValue(true)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_screen,container,false)
        binding.instructionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeScreenFragment_to_instructionFragment)
        }
        return binding.root
    }
}