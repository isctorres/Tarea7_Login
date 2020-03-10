package com.example.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnCrearCuenta.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        val intSingUp = Intent(this@Login, SignUp::class.java)
        startActivity(intSingUp)
    }
}
