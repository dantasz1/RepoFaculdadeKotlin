package br.edu.fatecpg.myapplication.model

import java.net.FileNameMap

interface FilmeDao {

    fun postFilme(filme: Filme)
    fun getFilme():List<Filme>

}