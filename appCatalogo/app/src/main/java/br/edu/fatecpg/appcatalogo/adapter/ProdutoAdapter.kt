package br.edu.fatecpg.appcatalogo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appcatalogo.R
import br.edu.fatecpg.appcatalogo.model.Produto

class ProdutoAdapter(private val produtos: List<Produto>):
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txvNomeProduto: TextView = itemView.findViewById(R.id.txv_nome_produto)
        val txvPrecoProduto: TextView = itemView.findViewById(R.id.txv_preco_produto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.txvNomeProduto.text = produto.nome
        holder.txvPrecoProduto.text = produto.preco
    }

    override fun getItemCount(): Int {
        return produtos.size
    }
}