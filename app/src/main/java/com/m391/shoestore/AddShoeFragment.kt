package com.m391.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.m391.shoestore.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {
  lateinit var binding: FragmentAddShoeBinding
  lateinit var viewModel: ShoesListingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.hide()
        viewModel = ViewModelProvider(requireActivity())[ShoesListingViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_shoe,container,false)
        binding.viewModel = viewModel
        binding.addShoe.setOnClickListener {
            if(!viewModel.addingShoeToTheList()){
                Toast.makeText(requireContext(),"All Fields Must Be Complete!!",Toast.LENGTH_SHORT).show()
            }
            it.findNavController().navigate(R.id.action_fragment_add_shoe_to_shoesListingFragment)
        }
        binding.cancelAdding.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_add_shoe_to_shoesListingFragment)
        }
        viewModel.cleaningFields()
        return binding.root
    }

}