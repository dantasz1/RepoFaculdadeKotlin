package br.edu.fatecpg.myapplication.model

class FilmeDaoImpl : FilmeDao {

    private val filmes = mutableListOf<Filme>()


    override fun postFilme(filme: Filme){
        filmes.add(filme)
    }

    override fun getFilme(): List<Filme> {
        return filmes
    }

}