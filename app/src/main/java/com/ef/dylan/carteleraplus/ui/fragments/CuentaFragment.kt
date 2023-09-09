package com.ef.dylan.carteleraplus.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.FragmentCuentaBinding
import com.ef.dylan.carteleraplus.ui.LoginActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class CuentaFragment : Fragment() {

    private lateinit var binding : FragmentCuentaBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCuentaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.tvEditInfo.setOnClickListener {
            SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Éxito")
                .setContentText("¡Se ha cambiado sus datos correctamente!")
                .setCustomImage(R.drawable.jake)
                .setConfirmText("Cerrar")
                .show()
        }
        binding.tvChangePassword.setOnClickListener {
            SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Éxito")
                .setContentText("¡Se ha restablecido su contraseña correctamente!")
                .setCustomImage(R.drawable.jimmyneutron)
                .setConfirmText("Cerrar")
                .show()
        }
        binding.tvAppInfo.setOnClickListener {
            showAppInfo()
        }
        binding.tvSignOut.setOnClickListener {
            signOut()
        }
        binding.btnInformacion.setOnClickListener {
            SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Muchas gracias")
                .setContentText("¡Por revisar mi aplicación!")
                .setCustomImage(R.drawable.ironman)
                .setConfirmText("Cerrar")
                .show()
        }
        binding.switchNotifications.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                toastCorrecto("¡Notificaciones habilitadas!")
            }
            else {
                toastError("¡Notificaciones deshabilitadas!")
            }
        }
        binding.switchEmailMessages.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                toastCorrecto("¡Mensajes por email habilitados!")
            }
            else {
                toastError("¡Mensajes por email deshabilitados!")
            }
        }
    }

    private fun showAppInfo() {
        val versionName = requireContext().packageManager?.getPackageInfo(requireContext().packageName, 0)?.versionName

        val infoMessage = "Versión: $versionName"
        val creationMessage = "Fecha de Creación: 18/08/2023"
        val fullInfoMessage = "$creationMessage\n$infoMessage"

        SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
            .setTitleText("Información de la Aplicación")
            .setContentText(fullInfoMessage)
            .setCustomImage(R.drawable.totoro)
            .setConfirmText("Cerrar")
            .show()
    }

    private fun toastCorrecto(mensaje: String) {
        val layoutInflater = LayoutInflater.from(requireContext())
        val view = layoutInflater.inflate(R.layout.custom_toast_success, requireView().findViewById(R.id.toast_success))
        val tvMensaje = view.findViewById<TextView>(R.id.tvMensajeToast1)
        tvMensaje.text = mensaje

        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 200)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = view
        toast.show()
    }

    private fun toastError(mensaje: String) {
        val layoutInflater = LayoutInflater.from(requireContext())
        val view = layoutInflater.inflate(R.layout.custom_toast_error, requireView().findViewById(R.id.toast_error))
        val tvMensaje = view.findViewById<TextView>(R.id.tvMensajeToast2)
        tvMensaje.text = mensaje

        val toast = Toast(requireContext())
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 200)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = view
        toast.show()
    }

    private fun signOut() {
        firebaseAuth.signOut()
        // Si se usó Google SignIn, también desconectar de Google
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        val googleClient = GoogleSignIn.getClient(requireContext(), googleSignInOptions)
        googleClient.signOut()

        /*Shared Preferences*/
        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("user_logged_in", false)
        editor.apply()

        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

}