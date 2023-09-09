package com.ef.dylan.carteleraplus.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.ItemMovieBinding
import com.ef.dylan.carteleraplus.model.Movie

class RVMovieListAdapter(var movies : List<Movie>, val onMovieClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieVH(binding, onMovieClick)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(movies[position])
    }

}

class MovieVH(private val binding : ItemMovieBinding, val onMovieClick: (Movie) -> Unit) : ViewHolder(binding.root) {
    fun bind(movie : Movie) {
        val baseImageUrl = "https://image.tmdb.org/t/p/"
        val posterSize = "w300"
        val posterPath = movie.poster
        val imageUrl = "$baseImageUrl$posterSize$posterPath"
        /*Glide*/
        Glide.with(binding.root)
            .load(imageUrl)
            .error(R.drawable.mistake)
            .into(binding.imgmovieposter)
        binding.cpiPuntuacion.maxProgress = 10.0
        binding.cpiPuntuacion.setCurrentProgress(movie.puntuacion)
        /**/
        binding.root.setOnClickListener {
            // Pasar a la siguiente pantalla de detalles
            onMovieClick(movie)
        }
    }

}