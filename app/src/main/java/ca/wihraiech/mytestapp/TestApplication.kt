package ca.wihraiech.mytestapp

import android.app.Application
import ca.wihraiech.mytestapp.di.testModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication :Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@TestApplication)
            modules(testModule)
        }
    }

}