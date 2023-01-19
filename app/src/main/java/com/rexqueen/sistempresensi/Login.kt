package com.rexqueen.sistempresensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class Login : AppCompatActivity() {
    var nips = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun login(view: View) {
        nips = findViewById<EditText>(R.id.nisp).text.toString()
        password = findViewById<EditText>(R.id.password).text.toString()

        var db = DBHelper(applicationContext)

        var data = db.getLogin(nips.toInt())

        if(data.login == 1){
            if(data.password == password){
                Toast.makeText(this, "Selamat Datang Anying!", LENGTH_SHORT).show()
                startActivity(Intent(this, Home::class.java))
            } else {
                Toast.makeText(this, "Sandi Salah Anying!", LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "ID Salah Anying!", LENGTH_SHORT).show()
        }
    }
}