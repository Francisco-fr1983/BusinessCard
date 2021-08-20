package com.example.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/*Essa class Data, vai passar para o meu banco de dados quais as informações que queremos gravar*/

@Entity /*Com essa anotação os dados da class ficaram persistentes, a entity é uma entidade, uma tabela, no banco de dados local Room*/
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, /*AutoGenerate vai criar os itens de forma automatizadas*/
    val nome: String,
    val telefone: String,
    val email: String,
    val empresa: String,
    val personalizado: String

    /*Como é uma tabela de dados precisamos colocar uma chave primary*/



)