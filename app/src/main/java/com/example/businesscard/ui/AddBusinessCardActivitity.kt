package com.example.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.App
import com.example.businesscard.R
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.databinding.ActivityAddBusinessCardActivitityBinding


class AddBusinessCardActivitity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardActivitityBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    /*Vamos criar o insertListeners() para o botão Confirmar, criar a ação dele quando usuário clicar*/
    private fun insertListeners() {

        /*Criar a funcionalidade do botão confirmar, foi criar a entidade, dos valores que o usuário digita na tela.*/
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                personalizado = binding.tilPersonalizado.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString()

            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }


}