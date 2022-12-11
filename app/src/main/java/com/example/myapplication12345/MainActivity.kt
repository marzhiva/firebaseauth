package com.example.myapplication12345

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val email = emailText.text.toString()
            val password = passwordText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "მონაცემები სწორად შეიყვანეთ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_SHORT).show()
                        emailText.text.clear()
                        passwordText.text.clear()
                    } else {
                        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}