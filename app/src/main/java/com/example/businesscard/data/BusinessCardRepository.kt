package com.example.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*Como construtor vamos enjetar o nosso DAO*/

class BusinessCardRepository (private val dao: BusinessCardDao) {

    /*Usamos a corrotina runBlocking*/

    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(businessCard)
        }

    }
    fun getAll() = dao.getAll()

}
/*Depois de criar o BusinessCardRepository, temos que criar uma classe que o Room tem que enchegar,
seria o AppDatabase é uma classe que gerencia o nosso banco de dados*/