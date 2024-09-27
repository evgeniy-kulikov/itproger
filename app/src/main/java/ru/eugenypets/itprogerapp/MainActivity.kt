package ru.eugenypets.itprogerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим элементы
        val userLogin: EditText = findViewById(R.id.etxtLogin)
        val userEmail: EditText = findViewById(R.id.etxtEmail)
        val userPassword: EditText = findViewById(R.id.etxtPassword)
        val btnSubmit: Button = findViewById(R.id.btnRegistration)

        // слушатели событий элементов
        btnSubmit.setOnClickListener {
            // собираем данные полей ввода
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if (login == "" || email == "" || pass == "")
                // всплывающее уведомление
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                println(pass)
            }

        }

    }
}