package br.com.mypet.app.core.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mypet.app.core.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao() : UserDao

    companion object {
        private var INSTANCE : AppDataBase? = null

        @Synchronized
        fun getInstance(context : Context) : AppDataBase {

            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "mypet.db").build()
            }
            return INSTANCE as AppDataBase
        }
    }


}