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

class RVTVSerieListAdapter(var series : List<TVSerie>, val onTVSerieClick: (TVSerie) -> Unit) : RecyclerView.Adapter<TVSerieViewHolder>() {

    fun setData(newSeries : List<TVSerie>) {
        series = newSeries
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVSerieViewHolder {
        val binding = ItemTvserieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVSerieViewHolder(binding, onTVSerieClick)
    }

    override fun getItemCount() : Int = series.size

    override fun onBindViewHolder(holder: TVSerieViewHolder, position: Int) {
        holder.bind(series[position])
    }

}

class TVSerieViewHolder(private val binding : ItemTvserieBinding, val onTVSerieClick: (TVSerie) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    fun bind (tvserie : TVSerie) {
        binding.cpiPuntuacionSerie.maxProgress = 10.0
        binding.cpiPuntuacionSerie.setCurrentProgress(tvserie.puntuacion)
        /*Glide*/
        Glide.with(binding.root)
            .load(tvserie.poster)
            .error(R.drawable.mistake)
            .into(binding.imgserieposter)
        binding.root.setOnClickListener {
            // Pasar a la siguiente pantalla
            onTVSerieClick(tvserie)
        }
    }
}