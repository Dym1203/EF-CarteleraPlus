package com.ef.dylan.carteleraplus.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.ActivityAddTvserieBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.math.RoundingMode
import java.util.UUID

class AddTVSerieActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddTvserieBinding
    private lateinit var firestore: FirebaseFirestore
    companion object {
        private const val IMAGE_PICKER_REQUEST_CODE = 1
        private const val PERMISSION_REQUEST_CODE = 100
    }
    private var selectedImageUri: Uri? = null
    private val paisesOrigen = arrayOf("USA", "UK", "CAN", "MEX", "AUS", "GER", "FRA", "ITA", "ESP", "JPN")
    private val idiomasOriginales = arrayOf("Español", "Inglés", "Francés", "Alemán", "Japonés", "Italiano")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTvserieBinding.inflate(layoutInflater)
        firestore = Firebase.firestore
        setContentView(binding.root)
        /*Adaptadores para los Spinner*/
        val paisOrigenAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, paisesOrigen)
        val idiomaOriginalAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, idiomasOriginales)
        paisOrigenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        idiomaOriginalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPaisOrigen.adapter = paisOrigenAdapter
        binding.spinnerIdiomaOriginal.adapter = idiomaOriginalAdapter

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
        val origin_country = binding.spinnerPaisOrigen.selectedItem.toString()
        val original_language = binding.spinnerIdiomaOriginal.selectedItem.toString()
        val overview = binding.edtSinopsis.editableText.toString()
        val popularityStr = binding.edtPopularidad.editableText.toString()
        val vote_averageStr = binding.edtPuntuacion.editableText.toString()
        if (name.isNotEmpty() && origin_country.isNotEmpty() && original_language.isNotEmpty() && overview.isNotEmpty()
            && popularityStr.isNotEmpty() && vote_averageStr.isNotEmpty()) {

            val popularity = popularityStr.toDouble()
            val vote_average = vote_averageStr.toDouble()

            val popularityRounded = popularity.toBigDecimal().setScale(3, RoundingMode.HALF_EVEN)
            val vote_averageRounded = vote_average.toBigDecimal().setScale(1, RoundingMode.HALF_EVEN)

            val popularityFormatted = popularityRounded.toString()
            val vote_averageFormatted = vote_averageRounded.toString()

            // Subir la imagen a Firebase Storage
            selectedImageUri?.let { uri ->
                val storageRef = FirebaseStorage.getInstance().reference.child("tvserie_images/${System.currentTimeMillis()}_${UUID.randomUUID()}")
                val uploadTask = storageRef.putFile(uri)

                uploadTask.continueWithTask { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let {
                            throw it
                        }
                    }
                    storageRef.downloadUrl
                }.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val downloadUri = task.result
                        // Agregar la serie a Firestore con la referencia de la imagen
                        val newTvserie = hashMapOf<String, Any>(
                            "name" to name,
                            "origin_country" to origin_country,
                            "original_language" to original_language,
                            "overview" to overview,
                            "popularity" to popularityFormatted.toDouble(),
                            "vote_average" to vote_averageFormatted.toDouble(),
                            "poster_path" to downloadUri.toString()
                        )
                        firestore.collection("tvserie").add(newTvserie)
                            .addOnSuccessListener { documentReference ->
                                toastCorrecto("¡Serie de TV agregada con el id: ${documentReference.id}!")
                                limpiarCampos()
                            }
                            .addOnFailureListener {
                                toastError("¡Ocurrió un error al registrar la serie de TV!")
                            }
                    }
                }
            }
        } else {
            toastError("¡Por favor, completa todos los campos!")
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
                toastError("¡Se requiere permiso de lectura para acceder a las imágenes!")
            }
        }
    }

    private fun toastCorrecto(mensaje: String) {
        val layoutInflater = LayoutInflater.from(this)
        val view = layoutInflater.inflate(R.layout.custom_toast_success, this.findViewById(R.id.toast_success))
        val tvMensaje = view.findViewById<TextView>(R.id.tvMensajeToast1)
        tvMensaje.text = mensaje

        val toast = Toast(this)
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 200)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = view
        toast.show()
    }

    private fun toastError(mensaje: String) {
        val layoutInflater = LayoutInflater.from(this)
        val view = layoutInflater.inflate(R.layout.custom_toast_error, this.findViewById(R.id.toast_error))
        val tvMensaje = view.findViewById<TextView>(R.id.tvMensajeToast2)
        tvMensaje.text = mensaje

        val toast = Toast(this)
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 200)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = view
        toast.show()
    }

    private fun limpiarCampos() {
        binding.edtTitulo.editableText.clear()
        binding.spinnerPaisOrigen.setSelection(0)
        binding.spinnerIdiomaOriginal.setSelection(0)
        binding.edtSinopsis.editableText.clear()
        binding.edtPopularidad.editableText.clear()
        binding.edtPuntuacion.editableText.clear()
        binding.imgImagenSeleccionada.setImageDrawable(null)
        binding.edtTitulo.requestFocus()
    }

}