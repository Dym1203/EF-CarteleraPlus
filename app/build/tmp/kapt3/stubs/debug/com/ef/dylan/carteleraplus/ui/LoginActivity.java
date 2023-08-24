package com.ef.dylan.carteleraplus.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/ef/dylan/carteleraplus/ui/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ef/dylan/carteleraplus/databinding/ActivityLoginBinding;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "googleLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "authenticateWithFirebase", "", "idToken", "", "loginWithEmailAndPassword", "email", "password", "loginWithGoogle", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveUserLoggedInState", "signUpWithEmailAndPassword", "togglePasswordVisibility", "editText", "Landroid/widget/EditText;", "validateEmailPassword", "", "emailText", "passwordText", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ef.dylan.carteleraplus.databinding.ActivityLoginBinding binding;
    private com.google.firebase.auth.FirebaseAuth firebaseAuth;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleLauncher;
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void saveUserLoggedInState() {
    }
    
    private final void loginWithEmailAndPassword(java.lang.String email, java.lang.String password) {
    }
    
    private final void loginWithGoogle() {
    }
    
    private final void signUpWithEmailAndPassword(java.lang.String email, java.lang.String password) {
    }
    
    private final void authenticateWithFirebase(java.lang.String idToken) {
    }
    
    private final boolean validateEmailPassword(java.lang.String emailText, java.lang.String passwordText) {
        return false;
    }
    
    private final void togglePasswordVisibility(android.widget.EditText editText) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}