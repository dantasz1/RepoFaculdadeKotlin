package br.edu.fatecpg.livraria

// Classe simples para representar o Livro
data class Livro(
    val titulo: String,
    val autor: String
)

// Objeto para guardar a lista na memória enquanto o app estiver aberto
object LivroDao {
    val livros = mutableListOf<Livro>()
}