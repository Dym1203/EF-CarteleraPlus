package com.ef.dylan.carteleraplus.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class TVSerieListViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()
    fun getTVSerieList() = firestore.collection("tvserie").get()

}