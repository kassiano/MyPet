package br.com.mypet.app.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mypet.app.R
import br.com.mypet.app.core.data.Preferences
import br.com.mypet.app.core.data.Preferences.Companion.CURRENT_USER
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {

    private val preferences by inject<Preferences>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        titleHomeUser.text = preferences.getString(CURRENT_USER)
    }
}