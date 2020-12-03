package br.com.mypet.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.features.login.LoginViewModel
import br.com.mypet.app.features.register.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyPetApp: Application() {

    private val myPetModule = module {

        single {
            provideDatabase(get())
        }

        viewModel { RegisterViewModel(get()) }
        viewModel { LoginViewModel(get()) }

    }

    private fun provideDatabase(context: Context)  : AppDataBase {
        return  Room.databaseBuilder(context, AppDataBase::class.java, "mypet.db").build()
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyPetApp)
            modules(myPetModule)
        }

    }

}