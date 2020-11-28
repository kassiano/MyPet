package br.com.mypet.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.features.login.LoginActivity

class MainActivity : AppCompatActivity() {

    lateinit var database : AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDatabase()

        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun setupDatabase() {
        database = AppDataBase.getInstance(this)
    }
}