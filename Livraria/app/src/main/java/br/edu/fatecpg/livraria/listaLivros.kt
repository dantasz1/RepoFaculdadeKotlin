package br.edu.fatecpg.livraria

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class listaLivros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_livros)

        val mainView = findViewById<android.view.View>(R.id.main) // Garanta que o ID no XML seja "main"
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Pega os dados que vieram da MainActivity
        val titulo = intent.getStringExtra("TITULO")
        val autor = intent.getStringExtra("AUTOR")

        // 2. Adiciona o novo livro na lista global
        if (titulo != null && autor != null) {
            LivroDao.livros.add(Livro(titulo, autor))
        }

        // 3. Configura o RecyclerView
        val rvLivros = findViewById<RecyclerView>(R.id.rvLivros)
        rvLivros.layoutManager = LinearLayoutManager(this)
        rvLivros.adapter = LivroAdapter(LivroDao.livros)

        // 4. Botão para voltar e cadastrar outro
        val btnNovoCad = findViewById<Button>(R.id.btn_novo_cadastro)
        btnNovoCad?.setOnClickListener {
            finish()
        }
    }
}