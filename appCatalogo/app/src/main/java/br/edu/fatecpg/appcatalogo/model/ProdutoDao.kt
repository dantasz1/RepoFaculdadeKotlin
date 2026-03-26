package br.edu.fatecpg.appcatalogo.model

interface ProdutoDao {
    fun postProduto(produto: Produto);
    fun getProdutos():List<Produto>;
}