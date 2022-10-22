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
import androidx.navigation.fragment.findNavController
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
        binding.addShoe.setOnClickListener {
            val name = binding.shoeName.text.toString()
            val size = binding.shoeSize.text.toString().fullTrim().toDouble()
            val company = binding.shoeCompany.text.toString()
            val description = binding.shoeDescription.text.toString()
            val shoe:Shoe = Shoe(name,size,company,description)
            viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes->
                shoes.add(shoe)
            })
            it.findNavController().navigate(R.id.action_fragment_add_shoe_to_shoesListingFragment)
        }

        binding.cancelAdding.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_add_shoe_to_shoesListingFragment)
        }
        return binding.root
    }
    fun String.fullTrim() = trim().replace("\uFEFF", "")
}