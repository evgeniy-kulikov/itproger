package ru.eugenypets.itprogerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Находим элементы
        val userLogin: EditText = findViewById(R.id.etxtLoginAuth)
        val userPassword: EditText = findViewById(R.id.etxtPasswordAuth)
        val btnAuth: Button = findViewById(R.id.btnAuth)
        val linkToReg: TextView = findViewById(R.id.tvRegLink)


        // Слушатели событий

        // Кнопка
        btnAuth.setOnClickListener {
            // собираем данные полей ввода
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || password == "")
            // всплывающее уведомление
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, password)  // Сверка введенных данных с БД

                if (isAuth) {
                    Toast.makeText(
                        this,
                        "Пользователь $login успешно авторизован",
                        Toast.LENGTH_LONG
                    ).show()
                    userLogin.text.clear()
                    userPassword.text.clear()

                    // Переход на ItemsActivity
                    val Intent = Intent(this, ItemsActivity::class.java)
                    startActivity(Intent)

                } else {
                    Toast.makeText(
                        this,
                        "Пользователь $login не сушествует",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        // Переход на MainActivity
        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}