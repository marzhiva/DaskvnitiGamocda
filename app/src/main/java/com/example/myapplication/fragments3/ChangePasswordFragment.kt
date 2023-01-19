package com.example.myapplication.fragments3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordFragment: Fragment(R.layout.fragment_change_password) {

    private lateinit var newPassword: EditText
    private lateinit var newPassword2: EditText
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newPassword = view.findViewById(R.id.newPassword)
        newPassword2 = view.findViewById(R.id.newPassword2)
        button = view.findViewById(R.id.button4)

        button.setOnClickListener {

            val userNewPassword = newPassword.text.toString()
            val userNewPassword2 = newPassword2.text.toString()

            if (userNewPassword.isEmpty() || userNewPassword2.isEmpty() || userNewPassword != userNewPassword2){
                Toast.makeText(context, "Check your passwords!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .currentUser?.updatePassword(userNewPassword)
                ?.addOnCompleteListener {  task ->
                    if (task.isSuccessful){
                        Toast.makeText(context, "It's changed", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show()
                    } }

        }

    }
}