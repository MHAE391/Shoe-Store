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
import kotlinx.coroutines.processNextEventInCurrentThread

class ShoesListingFragment : Fragment() {
    lateinit var binding: FragmentShoesListingBinding
    lateinit var viewModel: ShoesListingViewModel
    lateinit var shoes: MutableList<Shoe>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.show()
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoes_listing,container,false)
        viewModel = ViewModelProvider(requireActivity())[ShoesListingViewModel::class.java]
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            for(ix in it){
                addNewView(ix)
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
    private fun addNewView(shoe: Shoe) {
        // this method inflates the single item layout
        // inside the parent linear layout
        val inflater = LayoutInflater.from(requireContext()).inflate(R.layout.shoe_details, null)
        val name = inflater?.findViewById<TextView>(R.id.shoe_name)
        val size = inflater?.findViewById<TextView>(R.id.shoe_size)
        val company = inflater?.findViewById<TextView>(R.id.shoe_company)
        val description = inflater?.findViewById<TextView>(R.id.shoe_description)
        name?.text = shoe.name
        size?.text=shoe.size.toString()
        company?.text = shoe.company
        description?.text = shoe.description
        binding.parentLinearLayout.addView(inflater, binding.parentLinearLayout.childCount)
    }


}