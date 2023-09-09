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
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.FragmentMovieDetailBinding
import com.ef.dylan.carteleraplus.model.Movie
import com.ef.dylan.carteleraplus.ui.viewmodels.MovieDetailViewModel

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
        binding.tvDetalleMovieOverview.text = "Overview: ${movie.sinopsis}"
        binding.tvDetalleMovieOriginalLanguage.text = "Original Language: ${movie.idioma}"
        binding.tvDetalleMovieReleaseDate.text = "Release Date: ${movie.fechaLanzamiento}"
        binding.tvDetalleMovieVoteAverage.text = "Vote Average: ${movie.puntuacion}"
        val baseImageUrl = "https://image.tmdb.org/t/p/"
        val posterSize = "w300"
        val posterPath = movie.poster
        val imageUrl = "$baseImageUrl$posterSize$posterPath"
        /*Glide*/
        Glide.with(binding.root)
            .load(imageUrl)
            .error(R.drawable.mistake)
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
                SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("Éxito")
                    .setContentText("¡Película agregada a favoritos!")
                    .setCustomImage(R.drawable.homersimpson)
                    .setConfirmText("Cerrar")
                    .show()
            } else {
                SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("Error")
                    .setContentText("¡Esta película ya está en tus favoritos!")
                    .setCustomImage(R.drawable.snowball)
                    .setConfirmText("Cerrar")
                    .show()
            }
        }

        binding.btnRemoveFavorite.setOnClickListener {
            viewModel.removeMovieFromFavorites(movie)
            SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Éxito")
                .setContentText("¡Película eliminada de favoritos!")
                .setCustomImage(R.drawable.supermario)
                .setConfirmText("Cerrar")
                .show()
        }
    }

}