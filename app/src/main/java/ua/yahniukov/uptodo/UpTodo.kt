package ua.yahniukov.uptodo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ua.yahniukov.uptodo.di.appModules

class UpTodo : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UpTodo)
            modules(appModules)
        }
    }
}