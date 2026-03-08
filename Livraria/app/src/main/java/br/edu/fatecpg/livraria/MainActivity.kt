package br.edu.fatecpg.livraria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastrar = findViewById<Button>(R.id.btn_cadastroLivro)
        val editTitulo = findViewById<EditText>(R.id.editTitulo)
        val editAutor = findViewById<EditText>(R.id.editAutor)

        btnCadastrar.setOnClickListener {

            val intent = Intent(this, listaLivros::class.java)

            intent.putExtra("TITULO", editTitulo.text.toString())
            intent.putExtra("AUTOR", editAutor.text.toString())

            startActivity(intent)

            // --- A MÁGICA PARA LIMPAR OS CAMPOS ---
            editTitulo.text.clear() // Limpa o texto do título
            editAutor.text.clear()  // Limpa o texto do autor
            editTitulo.requestFocus() // Coloca o cursor de volta no primeiro campo
        }
    }
}