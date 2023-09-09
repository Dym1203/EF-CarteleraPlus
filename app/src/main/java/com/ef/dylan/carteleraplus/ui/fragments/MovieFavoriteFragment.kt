package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.FragmentMovieFavoriteBinding
import com.ef.dylan.carteleraplus.ui.adapter.RVMovieListAdapter
import com.ef.dylan.carteleraplus.ui.viewmodels.MovieFavoriteViewModel

class MovieFavoriteFragment : Fragment() {

    private lateinit var binding : FragmentMovieFavoriteBinding
    private lateinit var viewModel : MovieFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MovieFavoriteViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVMovieListAdapter(listOf()) { movie ->
            val destination = MovieFavoriteFragmentDirections.actionMovieFavoriteFragmentToMovieDetailFragment(movie)
            findNavController().navigate(destination)
        }
        binding.rvMoviesfavorite.layoutManager = GridLayoutManager(binding.root.context, 2)
        binding.rvMoviesfavorite.adapter = adapter
        viewModel.moviesfavorite.observe(requireActivity()) { movies ->
            adapter.movies = movies
            adapter.notifyDataSetChanged()
        }
        viewModel.getMoviesFavorite()
    }

}