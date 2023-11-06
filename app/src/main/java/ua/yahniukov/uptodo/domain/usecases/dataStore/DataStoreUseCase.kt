package ua.yahniukov.uptodo.domain.usecases.dataStore

data class DataStoreUseCase(
    val getOnboardingCompletedUseCase: GetOnboardingCompletedUseCase,
    val getThemeModeUseCase: GetThemeModeUseCase,
    val setOnboardingCompletedUseCase: SetOnboardingCompletedUseCase,
    val setThemeModeUseCase: SetThemeModeUseCase,
)