package com.ef.dylan.carteleraplus.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.tvAppInfo.setOnClickListener {
            showAppInfo()
        }
        binding.tvSignOut.setOnClickListener {
            signOut()
        }
        binding.btnInformacion.setOnClickListener {
            SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("¡Muchas gracias!")
                .setContentText(("Por revisar mi aplicación."))
                .setCustomImage(R.drawable.ic_star)
                .setConfirmText("Cerrar")
                .show()
        }
        binding.switchNotifications.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "¡Notificaciones Activadas!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "¡Notificaciones Desactivadas!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.switchEmailMessages.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "¡Mensajes por Email Activados!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "¡Mensajes por Email Desactivados!", Toast.LENGTH_SHORT).show()
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
            .setCustomImage(R.drawable.ic_app_info)
            .setConfirmText("Cerrar")
            .show()
    }

    private fun signOut() {
        firebaseAuth.signOut()
        // Si se usó Google SignIn, también desconectar de Google
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        val googleClient = GoogleSignIn.getClient(requireContext(), googleSignInOptions)
        googleClient.signOut()

        // Redirigir a la pantalla de inicio de sesión
        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

        /**/
        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("user_logged_in", false)
        editor.apply()

        val intentLogin = Intent(requireContext(), LoginActivity::class.java)
        intentLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intentLogin)
    }

}