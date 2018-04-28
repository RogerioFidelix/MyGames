package br.com.eu.mygames

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.my_game_item.view.*

/**
 * Created by logonrm on 27/04/2018.
 */
class JogosAdapter(private val jogos: List<Jogo>,
                   private val context: Context,
                   val listener: (Jogo) -> Unit)
    :RecyclerView.Adapter<JogosAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.my_game_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val jogo = jogos[position]
        holder?.let {
            it.bindView(jogo, listener)
        }
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(jogo: Jogo,
                     listener: (Jogo) -> Unit) = with(itemView) {
            ivJogo.setImageDrawable(ContextCompat.getDrawable(context, jogo.resourceID))
            tvNome.text = jogo.nome
            tvAnoLancamento.text = jogo.anoLançamento.toString()
            tvDescricao.text = jogo.descricao

            setOnClickListener { listener(jogo) }
        }
    }

}