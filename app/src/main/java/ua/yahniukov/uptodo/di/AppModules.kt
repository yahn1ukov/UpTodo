package ua.yahniukov.uptodo.di

import org.koin.dsl.module
import ua.yahniukov.uptodo.di.modules.databaseModule
import ua.yahniukov.uptodo.di.modules.repositoryModule
import ua.yahniukov.uptodo.di.modules.useCaseModule
import ua.yahniukov.uptodo.di.modules.utilModule
import ua.yahniukov.uptodo.di.modules.viewModelModule

val appModules = module {
    includes(
        databaseModule,
        utilModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
    )
}