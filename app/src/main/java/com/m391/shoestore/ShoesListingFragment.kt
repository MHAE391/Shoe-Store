package com.m391.shoestore
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBindings
import com.m391.shoestore.databinding.FragmentShoesListingBinding
import com.m391.shoestore.databinding.ShoeDetailsBinding
import kotlinx.coroutines.processNextEventInCurrentThread

class ShoesListingFragment : Fragment() {
    lateinit var binding: FragmentShoesListingBinding
    lateinit var viewModel: ShoesListingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.show()
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoes_listing,container,false)
        viewModel = ViewModelProvider(requireActivity())[ShoesListingViewModel::class.java]
         viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for(shoe in it){
               addView(shoe)
            }
        })
        binding.addShoe.setOnClickListener{
            it.findNavController().navigate(R.id.action_shoesListingFragment_to_fragment_add_shoe)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.logout -> Navigation.findNavController(requireView()).navigate(R.id.action_shoesListingFragment_to_loginFragment)

        }
        return super.onOptionsItemSelected(item)
    }
    fun addView(shoe: Shoe) {
        val itemBinding = ShoeDetailsBinding.inflate(LayoutInflater.from(context))
        itemBinding.apply {
            shoeName.text = shoe.name
            shoeSize.text = shoe.size.toString()
            shoeCompany.text = shoe.company
            shoeDescription.text = shoe.description
        }
        binding.parentLinearLayout.addView(itemBinding.root)
    }

}