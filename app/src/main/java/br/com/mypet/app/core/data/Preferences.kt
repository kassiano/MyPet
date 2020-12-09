package br.com.mypet.app.core.data

import android.content.Context

class Preferences(context: Context) {

    private val preferences = context.getSharedPreferences("mypetref", Context.MODE_PRIVATE)

    fun getInstance() = preferences

    fun getString(key: String) : String {
        return preferences.getString(key, "").orEmpty()
    }

    fun setString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    companion object{
        const val CURRENT_USER  = "CURRENT_USER"
    }

}