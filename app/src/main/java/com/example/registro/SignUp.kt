package com.example.registro

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.Toast
import com.example.registro.database.User
import com.example.registro.database.UserDatabase
import com.example.registro.helper.doAsync
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btnFecha.setOnClickListener{
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener{
                    view: DatePicker, mYear: Int, mMonth: Int, mDay: Int -> txtFecha.setText("" + mDay + "/" + (mMonth+1) + "/" + mYear)
                },
                year,
                month,
                day
            )

            dpd.show()
        }

        // Insertamos el usuario a la base de datos
        btnCrearCuenta.setOnClickListener{
            val userName = edtNombre.text.toString()
            val phoneUser = edtTelefono.text.toString()
            val emailUser = edtCorreo.text.toString()
            val passUser = edtContrasena.text.toString()
            val objUser = User(nameUser = userName,phoneUser = phoneUser, emailUser = emailUser, passUser = passUser,updateAt = Date())
            doAsync{
                UserDatabase.getInstance(this)!!.userDao().insertUser(objUser)
                //finish()
            }.execute()
            Toast.makeText(this,"Se registró el usuario",Toast.LENGTH_LONG).show()
        }

        btnIniciarSesion2.setOnClickListener{
            val intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sign_up,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itmUsuarios -> {
                val intUsuarios = Intent(this,ListUsers::class.java)
                startActivity(intUsuarios)
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
}
