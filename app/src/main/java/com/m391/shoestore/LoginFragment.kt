package com.m391.shoestore

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.m391.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding:FragmentLoginBinding
    lateinit var viewModel: ShoesListingViewModel
     var done:Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.hide()
        viewModel = ViewModelProvider(requireActivity())[ShoesListingViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        viewModel.Done.observe(viewLifecycleOwner, Observer { it -> done = it })
        binding.signIn.setOnClickListener {
            if(done == false) it.findNavController().navigate(R.id.action_loginFragment_to_welcomeScreenFragment)
            else it.findNavController().navigate(R.id.action_loginFragment_to_shoesListingFragment)
        }
        binding.signUp.setOnClickListener {
            if(done == false) it.findNavController().navigate(R.id.action_loginFragment_to_welcomeScreenFragment)
            else it.findNavController().navigate(R.id.action_loginFragment_to_shoesListingFragment)
        }
        return binding.root
    }

}