package com.mateodevs.crudroom.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mateodevs.crudroom.data.LaptopRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: LaptopRepository): ViewModel() {

    var state by mutableStateOf(LaptopMainState())
    private set

     init {
        viewModelScope.launch {
            state=state.copy(
                names = repository.getLaptops()
            )
        }
    }
    fun onNameChange(name: String){
        state=state.copy(
            name=name
        )

    }
    fun onDescriptionChange(description: String){
        state=state.copy(
            description = description
        )

    }

    fun onStorageChange(storage: String){
        state=state.copy(
            storage=storage.toInt()
        )
    }

    fun onProcessorChange(processor: String){
        state=state.copy(
            processor = processor
        )

    }

//como hago que storage sea opcional en esta funcion ?

    fun saveLaptop(){
        val laptop= Laptop(
            name=state.name,
            description = state.description,
            storage = state.storage,
            processor = state.processor
        )



        viewModelScope.launch {
            repository.insertLaptop(laptop)
        }
    }

}