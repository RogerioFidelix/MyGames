package br.com.eu.mygames

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista_jogos.*

class ListaJogosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jogos)
        rvMygames.adapter = JogosAdapter(jogos(), this, {
            //Log.i("TAG", "MEU ITEM")
            Toast.makeText(this, it.nome, Toast.LENGTH_LONG).show()
        })
        val layoutManager = LinearLayoutManager(this)
        rvMygames.layoutManager = layoutManager
    }

    private fun jogos():List<Jogo>{
        return listOf(
                Jogo(R.drawable.godofwar,
                        "God of War",
                        "2018",
                        "O God mais God de Todos agora na Sibéria")
                )
    }
}
