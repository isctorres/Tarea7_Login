package com.example.registro

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
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

        btnIniciarSesion2.setOnClickListener{
            val intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }

    }
}
