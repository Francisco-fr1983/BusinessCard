package com.example.businesscard


import android.app.Application
import com.example.businesscard.data.AppDatabase
import com.example.businesscard.data.BusinessCardRepository

/*CLASSE PARA GERENCIAMENTO FUTUROS DOS REPOSITORIOS*/
/*A classe app rodar antes de abrir a mainactivity ->a nossa tela*/

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}