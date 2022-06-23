package com.rezasetiawan_18102205.praktikum11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.rezasetiawan_18102205.praktikum11.databinding.ActivityMSignUpBinding


class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCreateAccount.setOnClickListener(this)
        auth = FirebaseAuth.getInstance()
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreateAccount -> {
                createAccount(binding.inputEmail.text.toString(),
                    binding.inputPassword.text.toString())
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        if (!validateForm()) {
            return
        }
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Create User Success.",
                        Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun validateForm(): Boolean {
        var valid = true
        val email = binding.inputEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.inputEmail.error = "Required."
            valid = false
        } else {
            binding.inputEmail.error = null
        }
        val password = binding.inputPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.inputPassword.error = "Required."
            valid = false
        } else {
            binding.inputPassword.error = null
        }
        return valid
    }
}