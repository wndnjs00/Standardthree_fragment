package com.example.standardthree_fragment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlowerViewModel : ViewModel() {

    val flowerData = MutableLiveData<String>()

    fun sendFlowerData(name : String, description : String){
        flowerData.value = name
        flowerData.value = description
    }

}