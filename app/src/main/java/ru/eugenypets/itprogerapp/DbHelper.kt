package ru.eugenypets.itprogerapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// описание подключения БД. Методы БД

class DbHelper(
    val context: Context,
    val factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, "anyDB", factory, 1) {

    // создание БД  (обязательная функция)
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    // удаление и последующее пересоздание БД  (обязательная функция)
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    // Внесение данных пользователя в БД
    // ContentValues. Данный объект представляет словарь, который содержит набор пар "ключ-значение".
    // Для добавления в этот словарь нового объекта применяется метод put.
    // Первый параметр метода - это ключ, а второй - значение,
    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.password)

        // запись строки с данными нового пользователя в таблицу "users" в БД
        val db = this.writableDatabase
        db.insert("users", null, values)
        db.close()

    }


}