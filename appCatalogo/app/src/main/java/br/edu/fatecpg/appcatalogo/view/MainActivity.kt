package br.edu.fatecpg.appcatalogo.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.appcatalogo.R
import br.edu.fatecpg.appcatalogo.adapter.ProdutoAdapter
import br.edu.fatecpg.appcatalogo.model.Produto
import br.edu.fatecpg.appcatalogo.model.ProdutoDaoImpl
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = ProdutoDaoImpl()
    private var produtos = dao.getProdutos()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // para evitar duplicar entradas ao trocar entre modo escuro/claro
        if (savedInstanceState == null) {
            dao.postProduto(Produto("Iphone 15 pro", "R$ 6400", "eletrônicos"))
            dao.postProduto(Produto("Mouse", "R$ 249.90", "eletrônicos"))
            dao.postProduto(Produto("Camiseta", "R$2.00", "roupas"))
            dao.postProduto(Produto("Peter Pan", "R$ 64.90", "livros"))
        }

        val rvProdutos: RecyclerView = findViewById(R.id.rv_produtos)
        val bnvNav: BottomNavigationView = findViewById(R.id.bnv_nav)

        rvProdutos.layoutManager = LinearLayoutManager(this)
        rvProdutos.adapter = ProdutoAdapter(produtos)

        updateList("eletrônicos")

        bnvNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_eletronicos -> updateList("eletrônicos")
                R.id.nav_roupas -> updateList("roupas")
                R.id.nav_livros -> updateList("livros")
            }
            true
        }
    }
    private fun updateList(categoria: String) {
        val produtos = produtos.filter { it.categoria == categoria }
        val recyclerView: RecyclerView = findViewById(R.id.rv_produtos)
        recyclerView.adapter = ProdutoAdapter(produtos)
    }
}