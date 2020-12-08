package br.com.mypet.app.core.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user")
data class User(
        @PrimaryKey(autoGenerate = true)
        val id:Int? = null,
        val name:String,
        val cellphone:String,
        val email:String,
        val password:String

): Parcelable