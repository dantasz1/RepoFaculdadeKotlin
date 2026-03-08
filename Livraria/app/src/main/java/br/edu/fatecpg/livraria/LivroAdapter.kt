package br.edu.fatecpg.livraria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroAdapter(private val lista: List<Livro>) : RecyclerView.Adapter<LivroAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtTitulo: TextView = view.findViewById(R.id.txtTituloItem)
        val txtAutor: TextView = view.findViewById(R.id.txtAutorItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_livro, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val livro = lista[position]
        holder.txtTitulo.text = livro.titulo
        holder.txtAutor.text = livro.autor
    }

    override fun getItemCount(): Int = lista.size
}