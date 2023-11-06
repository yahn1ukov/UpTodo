package ua.yahniukov.uptodo.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ua.yahniukov.uptodo.presentation.MainViewModel
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.AddEditViewModel
import ua.yahniukov.uptodo.presentation.screens.home.calendar.CalendarViewModel
import ua.yahniukov.uptodo.presentation.screens.home.settings.SettingsViewModel
import ua.yahniukov.uptodo.presentation.screens.home.task.TaskViewModel
import ua.yahniukov.uptodo.presentation.screens.home.tasks.TasksViewModel
import ua.yahniukov.uptodo.presentation.screens.onboarding.OnboardingViewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { OnboardingViewModel(get()) }
    viewModel { TasksViewModel(get()) }
    viewModel { CalendarViewModel(get()) }
    viewModel { SettingsViewModel(get(), get()) }
    viewModel { AddEditViewModel(get()) }
    viewModel { TaskViewModel(get()) }
}