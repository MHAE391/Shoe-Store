package com.m391.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesListingViewModel: ViewModel() {
    val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val Done: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    init {
        Done.value = false
    }
}
