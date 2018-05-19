package com.brunoeleodoro.org.firstkotlinapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brunoeleodoro.org.firstkotlinapp.R
import com.brunoeleodoro.org.firstkotlinapp.domain.Show
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.linha_show.view.*

class ShowsAdapter() : RecyclerView.Adapter<ShowsAdapter.ShowsHolder>() {

    var context : Context? = null
    var shows : List<Show> = ArrayList<Show>()

    constructor(context: Context,shows: List<Show> ) : this() {
        this.shows = shows
        this.context = context
        Log.i("script","shows size="+shows.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsHolder {
        val holder = ShowsHolder(LayoutInflater.from(context).inflate(R.layout.linha_show,null))
        return holder
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    override fun onBindViewHolder(holder: ShowsHolder, position: Int) {
        val show:Show = shows.get(position)
        holder.bindView(show)
    }

    class ShowsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(show: Show)
        {
            val txt_nome = itemView.txt_nome
            val txt_img = itemView.txt_img

            Picasso.get().load(show.image).into(txt_img)
            txt_nome.text = show.name
        }

    }
}