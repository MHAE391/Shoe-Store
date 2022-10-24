package com.m391.shoestore

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesListingViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val listOfShoes = mutableListOf<Shoe>()
    lateinit var  shoe:Shoe
    var name : String = ""
    var size : String = ""
    var company : String = ""
    var description : String = ""

    val Done: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    init {
        Done.value = false
        shoe = Shoe("",0.0,"","")
    }
    fun addingShoeToTheList() :Boolean{
        if (verifiesIfTheFieldsAreEmpty()){
            shoe = Shoe(name,size.toDouble(),company,description)
            listOfShoes.add(shoe)
            _shoeList.value = listOfShoes
            return true
        }
        return false
    }

    private fun verifiesIfTheFieldsAreEmpty():Boolean{
        return !(name.isBlank() || size.isBlank() || company.isBlank() || description.isBlank())
    }

    fun cleaningFields(){
        name = ""
        size = ""
        description = ""
        company = ""
    }


}
