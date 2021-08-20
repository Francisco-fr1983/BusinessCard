package com.example.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.data.BusinessCardRepository


/*Vamos criar o nosso ViewModel onde podemos trafegas os dados entre no repository e a nossa tela*/
class MainViewModel (private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }
    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }
}
/*Como agente não está usando injeção de dependencias, vamos injetar a ViewModel manual*/
class MainViewModelFactory(private val repository: BusinessCardRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
/*Agora vamos fazer uma forma da nossa ViewModel conectar com a nossa Activity principal*/