package com.example.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//import kotlinx.coroutines.internal.synchronized => não import essa linha, tem que remover.

/*A anotação vamos informar quais entidades vamos usar no projeto.*/
/*Room executa o método migrate() de uma ou mais subclasses Migration para migrar o banco de dados
para a versão mais recente no tempo de execução:*/
@Database(entities = [BusinessCard::class], version = 1)
//@AutoMigration

abstract class AppDatabase : RoomDatabase() {

    abstract fun businessDao() : BusinessCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //@InternalCoroutinesApi => o synchronizes esta com erro ao colocar essa anotação o erro foi sanado, porém no GitHub informa para remover essa anotação
        // pois ele é executada uma vez, na segunda vez da um erro no banco.
        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                instance

            }

        }
        /*GetDatabase gerencia nossas entidades e nosso Room.*/
    }


}
/*nA UTIL vamos estanciar esse metodos, pois ao iniciar o aplicativo o App será chamado e com isso os metdos do banco.*/