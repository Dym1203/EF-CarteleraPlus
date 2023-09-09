package com.ef.dylan.carteleraplus.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ef.dylan.carteleraplus.databinding.FragmentFirebaseMovieBinding
import com.ef.dylan.carteleraplus.model.TVSerie
import com.ef.dylan.carteleraplus.ui.AddTVSerieActivity
import com.ef.dylan.carteleraplus.ui.adapter.RVTVSerieListAdapter
import com.ef.dylan.carteleraplus.ui.viewmodels.TVSerieListViewModel

class FirebaseMovieFragment : Fragment() {

    private lateinit var binding : FragmentFirebaseMovieBinding
    private lateinit var viewModel : TVSerieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[TVSerieListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirebaseMovieBinding.inflate(inflater, container, false)
        binding.fabAddTvserie.setOnClickListener {
            val intent = Intent(requireContext(), AddTVSerieActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVTVSerieListAdapter(listOf()) { tvserie ->
            val destination = FirebaseMovieFragmentDirections.actionFirebaseMovieFragmentToTVSerieDetailFragment(tvserie)
            findNavController().navigate(destination)
        }
        binding.rvTvserieList.layoutManager = GridLayoutManager(binding.root.context, 2)
        binding.rvTvserieList.adapter = adapter
        viewModel.getTVSerieList().addOnSuccessListener { querySnapshot ->
            val serieList = mutableListOf<TVSerie>()
            for (document in querySnapshot.documents) {
                val name = document.getString("name") ?: ""
                val origincountry = document.getString("origin_country") ?: ""
                val originallanguage = document.getString("original_language") ?: ""
                val overview = document.getString("overview") ?: ""
                val popularity = document.getDouble("popularity") ?: ""
                val voteaverage = document.getDouble("vote_average") ?: ""
                val posterpath = document.getString("poster_path") ?: ""
                serieList.add(
                    TVSerie(name, origincountry, originallanguage, overview,
                        popularity as Double, voteaverage as Double, posterpath)
                )
            }
            adapter.setData(serieList)
        }
    }

}