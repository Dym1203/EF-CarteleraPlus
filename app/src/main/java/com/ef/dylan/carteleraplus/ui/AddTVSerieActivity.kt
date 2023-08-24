package com.ef.dylan.carteleraplus.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.bumptech.glide.Glide
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.ActivityAddTvserieBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.math.RoundingMode

class AddTVSerieActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddTvserieBinding
    private lateinit var firestore: FirebaseFirestore
    companion object {
        private const val IMAGE_PICKER_REQUEST_CODE = 1
        private const val PERMISSION_REQUEST_CODE = 100
    }
    private var selectedImageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTvserieBinding.inflate(layoutInflater)
        firestore = Firebase.firestore
        setContentView(binding.root)

        binding.btnAgregarPoster.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
            } else {
                val imagePickerIntent = Intent(Intent.ACTION_PICK)
                imagePickerIntent.type = "image/*"
                startActivityForResult(imagePickerIntent, IMAGE_PICKER_REQUEST_CODE)
            }
        }

        binding.btnRegistrarSerie.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
            } else {
                registrarSerieEnFirestore()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICKER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            selectedImageUri  = data?.data
            // Mostrar la imagen seleccionada en el ImageView
            selectedImageUri?.let { uri ->
                Glide.with(this)
                    .load(uri)
                    .error(R.drawable.mistake)
                    .into(binding.imgImagenSeleccionada)
            }
        }
    }

    private fun registrarSerieEnFirestore() {
        val name = binding.edtTitulo.editableText.toString()
        val origin_country = binding.edtPaisOrigen.editableText.toString()
        val original_language = binding.edtIdiomaOriginal.editableText.toString()
        val overview = binding.edtSinopsis.editableText.toString()
        val popularityStr = binding.edtPopularidad.editableText.toString()
        val vote_averageStr = binding.edtPuntuacion.editableText.toString()
        if (name.isNotEmpty() && origin_country.isNotEmpty() && original_language.isNotEmpty() && overview.isNotEmpty()
            && popularityStr.isNotEmpty() && vote_averageStr.isNotEmpty()) {

            val popularity = popularityStr.toDouble()
            val vote_average = vote_averageStr.toDouble()

            val popularityRounded = popularity.toBigDecimal().setScale(3, RoundingMode.HALF_EVEN)
            val vote_averageRounded =
                vote_average.toBigDecimal().setScale(1, RoundingMode.HALF_EVEN)

            val popularityFormatted = popularityRounded.toString()
            val vote_averageFormatted = vote_averageRounded.toString()

            // Agregar la serie a Firestore con la referencia de la imagen
            val newTvserie = hashMapOf<String, Any>(
                "name" to name,
                "origin_country" to origin_country,
                "original_language" to original_language,
                "overview" to overview,
                "popularity" to popularityFormatted.toDouble(),
                "vote_average" to vote_averageFormatted.toDouble(),
                "poster_path" to selectedImageUri.toString()
            )
            firestore.collection("tvserie").add(newTvserie)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(
                        this,
                        "¡Serie de TV agregada con el id: ${documentReference.id}",
                        Toast.LENGTH_SHORT
                    ).show()
                    limpiarCampos()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "¡Ocurrió un error al registrar la serie de TV!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        } else {
            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("¡Error!")
                .setContentText("Por favor, completa todos los campos.")
                .setConfirmText("Cerrar")
                .show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val imagePickerIntent = Intent(Intent.ACTION_PICK)
                imagePickerIntent.type = "image/*"
                startActivityForResult(imagePickerIntent, IMAGE_PICKER_REQUEST_CODE)
            } else {
                Toast.makeText(this, "¡Se requiere permiso de lectura para acceder a imágenes!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun limpiarCampos() {
        binding.edtTitulo.editableText.clear()
        binding.edtPaisOrigen.editableText.clear()
        binding.edtIdiomaOriginal.editableText.clear()
        binding.edtSinopsis.editableText.clear()
        binding.edtPopularidad.editableText.clear()
        binding.edtPuntuacion.editableText.clear()
        binding.edtTitulo.requestFocus()
    }

}