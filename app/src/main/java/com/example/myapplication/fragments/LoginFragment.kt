package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth



class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var resetPassword: Button
    private lateinit var registration: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (FirebaseAuth.getInstance().currentUser != null){
            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        super.onViewCreated(view, savedInstanceState)


        email = view.findViewById(R.id.editTextEmail)
        password = view.findViewById(R.id.editTextPassword)
        login = view.findViewById(R.id.loginButton)
        resetPassword = view.findViewById(R.id.resetPasswordButton)
        registration = view.findViewById(R.id.registrationButton)

        login.setOnClickListener {
            val userEmail = email.text.toString()
            val userPassword = password.text.toString()


            if (userEmail.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(context, "It's empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                        findNavController().navigate(action)
                    }else {
                        Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show()
                    }
                }



        }

       registration.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            findNavController().navigate(action)
        }

        resetPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment()
            findNavController().navigate(action)
        }


    }
}