package ru.eugenypets.itprogerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val linkToAuth: TextView = findViewById(R.id.tvAuthLink)

        // слушатели событий элементов
        btnSubmit.setOnClickListener {
            // собираем данные полей ввода
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || email == "" || password == "")
            // всплывающее уведомление
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)  // экземпляр класса для передачи его в БД
                val db = DbHelper(this, null)
                db.addUser(user)  // запись введенных данных в БД

                Toast.makeText(
                    this,
                    "Пользователь $login добавлен",
                    Toast.LENGTH_LONG
                ).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }
        }

        // переход на AuthActivity
        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

    }
}