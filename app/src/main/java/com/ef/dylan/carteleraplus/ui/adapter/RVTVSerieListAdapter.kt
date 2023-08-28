package com.ef.dylan.carteleraplus.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.ItemTvserieBinding
import com.ef.dylan.carteleraplus.model.TVSerie
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class RVTVSerieListAdapter(var series : List<TVSerie>) : RecyclerView.Adapter<TVSerieViewHolder>() {

    fun setData(newSeries : List<TVSerie>) {
        series = newSeries
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVSerieViewHolder {
        val binding = ItemTvserieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVSerieViewHolder(binding)
    }

    override fun getItemCount() : Int = series.size

    override fun onBindViewHolder(holder: TVSerieViewHolder, position: Int) {
        holder.bind(series[position])
    }

}

class TVSerieViewHolder(private val binding : ItemTvserieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind (tvserie : TVSerie) {
        binding.txtserietitle.text = tvserie.titulo
        binding.txtserieoriginallanguage.text = "Idioma: ${tvserie.idioma}"
        binding.txtseriepopularity.text = "Popularidad: ${tvserie.popularidad}"
        binding.cpiPuntuacionSerie.maxProgress = 10.0
        binding.cpiPuntuacionSerie.setCurrentProgress(tvserie.puntuacion)
        binding.txtserieorigincountry.text = "País: ${tvserie.pais}"
        /*Glide*/
        Glide.with(binding.root)
            .load(tvserie.poster)
            .override(200, 250)
            .error(R.drawable.mistake)
            .into(binding.imgserieposter)
    }
}