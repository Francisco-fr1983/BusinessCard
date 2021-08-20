package com.example.businesscard.ui


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.databinding.ItemBusinessCardBinding

/*Vamos ter que chamar o Adapter na MainActiviry*/
/*O Adapter é responsável por fazer uma exibição para cada item no conjunto de dados(Listas)*/
/*O adapter implementa os membros onCreateViewHolder e o onBindViewHolder*/
class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallBack()) {

    var listenerShare: (View) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.personalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
        /*O app quebrou aqui binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.personalizado)),
        quando o usuário colocar a cor tipo #e54f6e em letra minúscula o app quebrava e ao colocar em maiúscula ele funcionava,
        e após quebrado somente voltou a funcionar desinstalando e instalando novamente.*/
    }
}
/*“DiffUtil é uma classe de utilitário que pode calcular a diferença entre duas listas e gerar uma lista de operações de atualização que converte a primeira lista na segunda.” - Desenvolvedor Android

A implementação diffcallbacknão é obrigatória, mas aumentará o desempenho se você estiver trabalhando com grandes conjuntos de dados*/
class DiffCallBack: DiffUtil.ItemCallback<BusinessCard> () {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id

}
/* Os dois pontos : => Extented*/
/*Ainda temos que criar o ViewHolder->  O ViewHolder é um wrapper em torno da View que contém o layout de um item individual na lista.
O Adapter cria objetos ViewHolder conforme necessário e também define os dados para essas visualizações*/
