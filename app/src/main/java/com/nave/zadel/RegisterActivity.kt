package com.nave.zadel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_account_btn.setOnClickListener {
            val name = name_input.text.toString()
            val email = email_input.text.toString()
            val password = password_input.text.toString()

            if(name.isEmpty() || email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "Please, fill in the blanks!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("Register", "Email: $email && Password: $password")

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener

                    Log.d("Register", "Sucessfully created user with uid: ${it.result!!.user.uid}")
                }
        }

        already_have_account_text.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
