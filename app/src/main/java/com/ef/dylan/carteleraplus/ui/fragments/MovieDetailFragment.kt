package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import cn.pedant.SweetAlert.SweetAlertDialog
import com.bumptech.glide.Glide
import com.ef.dylan.carteleraplus.databinding.FragmentMovieDetailBinding
import com.ef.dylan.carteleraplus.model.Movie
import com.ef.dylan.carteleraplus.ui.viewmodels.MovieDetailViewModel
import com.google.android.material.snackbar.Snackbar

class MovieDetailFragment : Fragment() {

    private lateinit var binding : FragmentMovieDetailBinding
    private val args : MovieDetailFragmentArgs by navArgs()
    private lateinit var movie : Movie
    private lateinit var viewModel : MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = args.movie
        viewModel = ViewModelProvider(requireActivity())[MovieDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDetalleMovieTitle.text = movie.titulo
        binding.tvDetalleMovieReleaseDate.text = "Fecha de Estreno: ${movie.fechaLanzamiento}"
        binding.tvDetalleMovieVoteAverage.text = "Puntuación: ${movie.puntuacion}"
        val baseImageUrl = "https://image.tmdb.org/t/p/"
        val posterSize = "w300"
        val posterPath = movie.poster
        val imageUrl = "$baseImageUrl$posterSize$posterPath"
        /*Glide*/
        Glide.with(binding.root)
            .load(imageUrl)
            .into(binding.imgDetalleMoviePosterPath)

        /*Favoritos*/
        if (!movie.isFavorite) {
            binding.btnRemoveFavorite.visibility = View.GONE
            binding.btnAddFavorite.visibility = View.VISIBLE
        }
        else {
            binding.btnAddFavorite.visibility = View.GONE
            binding.btnRemoveFavorite.visibility = View.VISIBLE
        }

        binding.btnAddFavorite.setOnClickListener {
            if (!movie.isFavorite) {
                movie.isFavorite = true
                viewModel.addMoviesFavorites(movie)
                Snackbar.make(binding.root, "¡Película agregada a Favoritos!", Snackbar.LENGTH_SHORT).show()
            } else {
                SweetAlertDialog(requireContext(), SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Error")
                    .setContentText("¡Esta película ya está en tus favoritos!")
                    .setConfirmText("Cerrar")
                    .show()
            }
        }

        binding.btnRemoveFavorite.setOnClickListener {
            viewModel.removeMovieFromFavorites(movie)
            Snackbar.make(binding.root, "¡Película eliminada de Favoritos!", Snackbar.LENGTH_SHORT).show()
        }
    }

}