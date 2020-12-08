package br.com.mypet.app.core.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pet", foreignKeys =
        [ForeignKey(entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id"),
        onDelete = CASCADE)])
data class Pet(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val user_id: Int,
    val name:String,
    val race:String,
    val gender: String,
    val castrated:String,
//    val photo:String
//    val date:Date

):Parcelable