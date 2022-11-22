package com.example.newpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonn : Button = findViewById(R.id.button)


        auth = FirebaseAuth.getInstance()

        buttonn.setOnClickListener{
            login()
        }
    }
    private fun login() {

        var emale : EditText = findViewById(R.id.emaill)
        var passwrd : EditText = findViewById(R.id.Password)

        val em = emale.text.toString()
        val pass = passwrd.text.toString()

        auth.signInWithEmailAndPassword(em,pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "UnSuccessfully LogIn", Toast.LENGTH_SHORT).show()

        }
    }







}