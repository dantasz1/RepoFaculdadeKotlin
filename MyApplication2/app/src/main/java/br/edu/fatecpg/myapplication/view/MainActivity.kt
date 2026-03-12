package br.edu.fatecpg.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.myapplication.R
import br.edu.fatecpg.myapplication.model.Filme
import br.edu.fatecpg.myapplication.model.FilmeDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val dao = FilmeDaoImpl()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            val edtNome = findViewById<EditText>(R.id.edt_nome)
            val edtGenero = findViewById<EditText>(R.id.edt_genero)
            val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

            val fabMain = findViewById<FloatingActionButton>(R.id.fab_main)

        btnCadastrar.setOnClickListener {
            val nomeFilme = edtNome.text.toString()
            val generoFilme = edtGenero.text.toString()

            dao.postFilme(Filme(nomeFilme, generoFilme, assistido = false, nota = 0.0))

            Toast.makeText(this, "Cadastro Ok", Toast.LENGTH_SHORT).show()
            edtNome.text.clear()
            edtGenero.text.clear()
        }
        fabMain.setOnClickListener() {
        val intent = Intent(this,ListaActivity::class.java)
            startActivity(intent)
        }


    }
}