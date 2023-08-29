package com.ef.dylan.carteleraplus.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.FragmentTvSerieDetailBinding
import com.ef.dylan.carteleraplus.model.TVSerie

class TVSerieDetailFragment : Fragment() {

    private lateinit var binding : FragmentTvSerieDetailBinding
    private val args : TVSerieDetailFragmentArgs by navArgs()
    private lateinit var tvserie: TVSerie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvserie = args.tvserie
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvSerieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDetalleTVSerieName.text = tvserie.titulo
        binding.tvDetalleTVSerieOverview.text = "Sinopsis: ${tvserie.sinopsis}"
        binding.tvDetalleTVSerieOriginCountry.text = "País de Origen: ${tvserie.pais}"
        binding.tvDetalleTVSerieOriginalLanguage.text = "Idioma: ${tvserie.idioma}"
        binding.tvDetalleTVSeriePopularity.text = "Popularidad: ${tvserie.popularidad}"
        binding.tvDetalleTVSerieVoteAverage.text = "Puntuación: ${tvserie.puntuacion}"
        /*Glide*/
        Glide.with(binding.root)
            .load(tvserie.poster)
            .override(200, 250)
            .error(R.drawable.mistake)
            .into(binding.imgDetalleTVSeriePosterPath)
    }

}