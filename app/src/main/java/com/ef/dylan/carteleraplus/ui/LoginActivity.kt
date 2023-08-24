package com.ef.dylan.carteleraplus.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import cn.pedant.SweetAlert.SweetAlertDialog
import com.ef.dylan.carteleraplus.R
import com.ef.dylan.carteleraplus.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**/
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val visibilityIcon = resources.getDrawable(R.drawable.baseline_visibility_off_24)
        visibilityIcon.setTint(resources.getColor(R.color.black))
        edtPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
            edtPassword.compoundDrawablesRelative[0],
            null,
            visibilityIcon,
            null
        )
        edtPassword.setOnClickListener {
            val drawable = edtPassword.compoundDrawablesRelative[2]
            val iconWidth = drawable?.bounds?.width() ?: 0
            // Verificar si el clic se realizó en el área del ícono
            if (edtPassword.width - iconWidth <= it.x + it.width) {
                togglePasswordVisibility(edtPassword)
            }
        }
        /**/
        firebaseAuth = FirebaseAuth.getInstance()
        googleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    authenticateWithFirebase(account.idToken!!)
                }
                catch (e : Exception) {

                }
            }
        }
        /*Shared Preferences*/
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userLoggedIn = sharedPreferences.getBoolean("user_logged_in", false)

        if (userLoggedIn) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val emailText = s.toString()
                val passwordText = binding.edtPassword.text.toString()
                binding.btnLogin.isEnabled = validateEmailPassword(emailText, passwordText)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val emailText = binding.edtEmail.text.toString()
                val passwordText = s.toString()
                binding.btnLogin.isEnabled = validateEmailPassword(emailText, passwordText)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.btnLogin.setOnClickListener {
            val password = binding.edtPassword.editableText.toString()
            val email = binding.edtEmail.editableText.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginWithEmailAndPassword(email, password)
            }
            else {
                SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("¡Error!")
                    .setContentText("Por favor, completa todos los campos.")
                    .setConfirmText("Cerrar")
                    .show()
            }
        }

        binding.btnGoogle.setOnClickListener {
            loginWithGoogle()
        }

        binding.btnSignUp.setOnClickListener {
            val password = binding.edtPassword.editableText.toString()
            val email = binding.edtEmail.editableText.toString()
            signUpWithEmailAndPassword(email, password)
        }
    }

    private fun saveUserLoggedInState() {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("user_logged_in", true)
        editor.apply()
    }

    private fun loginWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    saveUserLoggedInState()
                }
                else {
                    SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("¡Error!")
                        .setContentText("El usuario no se encuentra registrado.")
                        .setConfirmText("Cerrar")
                        .show()
                }
            }
    }

    private fun loginWithGoogle() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()
        val googleClient = GoogleSignIn.getClient(this, googleSignInOptions)
        val intent = googleClient.signInIntent
        googleLauncher.launch(intent)
    }

    private fun signUpWithEmailAndPassword(email: String, password: String) {
        if (validateEmailPassword(email, password)) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = firebaseAuth.currentUser
                        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("¡Éxito!")
                            .setContentText("El usuario fue registrado correctamente.")
                            .setConfirmText("Cerrar")
                            .show()
                    } else {
                        val exception = task.exception
                        if (exception is FirebaseAuthUserCollisionException) {
                            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("¡Error!")
                                .setContentText("El usuario ya está registrado.")
                                .setConfirmText("Cerrar")
                                .show()
                        } else {
                            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("¡Error!")
                                .setContentText("No es posible registrar al usuario.")
                                .setConfirmText("Cerrar")
                                .show()
                        }
                    }
                }
        } else {
            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("¡Error!")
                .setContentText("No son credenciales válidas.")
                .setConfirmText("Cerrar")
                .show()
        }
    }

    private fun authenticateWithFirebase(idToken: String) {
        val authCredentials = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(authCredentials)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    saveUserLoggedInState()
                }
            }
    }

    private fun validateEmailPassword(emailText: String, passwordText: String): Boolean {
        val isEmailValid = emailText.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
        val isPasswordValid = passwordText.length >= 6
        return isEmailValid && isPasswordValid
    }

    private fun togglePasswordVisibility(editText: EditText) {
        if (editText.transformationMethod == PasswordTransformationMethod.getInstance()) {
            // Mostrar el texto plano
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            // Ocultar el texto plano
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        editText.setSelection(editText.text.length)
    }

    override fun onBackPressed() {
        SweetAlertDialog(
            this, SweetAlertDialog.WARNING_TYPE
        ).setTitleText("¡Has oprimido el botón atrás!")
            .setContentText("¿Quieres cerrar la aplicación?")
            .setCancelText("Cancelar").setConfirmText("Cerrar")
            .showCancelButton(true).setCancelClickListener { sDialog: SweetAlertDialog ->
                sDialog.dismissWithAnimation()
                SweetAlertDialog(
                    this,
                    SweetAlertDialog.ERROR_TYPE
                ).setTitleText("¡Operación Cancelada!")
                    .setContentText("¡No saliste de la aplicación!")
                    .setConfirmText("Aceptar")
                    .show()
            }.setConfirmClickListener { sweetAlertDialog: SweetAlertDialog ->
                sweetAlertDialog.dismissWithAnimation()
                System.exit(0)
            }.show()
    }

}