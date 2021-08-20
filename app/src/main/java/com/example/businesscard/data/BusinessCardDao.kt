package com.example.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/*Dao Classe que vamos fazer nossas persistencias e chamadas ao banco, no Room essa classe é uma interface*/
/*No Data Object Access (DAO), configuramos os SQLs.*/
@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCard") /*Para Buscar os dados no banco de dados.*/
    fun getAll(): LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)


}
/*Para fazer a chamado do DAO vamos criar um repositorio em Data.*/