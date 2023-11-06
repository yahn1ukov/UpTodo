package ua.yahniukov.uptodo.di.modules

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ua.yahniukov.uptodo.utils.CalendarUtil
import ua.yahniukov.uptodo.utils.DataStoreUtil

val utilModule = module {
    single { DataStoreUtil(androidContext()) }
    single { CalendarUtil() }
}