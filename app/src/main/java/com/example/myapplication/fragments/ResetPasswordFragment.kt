package com.example.myapplication.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordFragment: Fragment(R.layout.fragment_reset_password) {
    private lateinit var email: EditText
    private lateinit var resetPassword: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.editTextEmail3)
        resetPassword = view.findViewById(R.id.resetPasswordButton2)

        resetPassword.setOnClickListener {
            val userEmail = email.text.toString()

            if (userEmail.isEmpty()) {
                Toast.makeText(context, "It's empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(userEmail)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val action = ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                        findNavController().navigate(action)
                    } else {
                        Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
}