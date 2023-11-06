package ua.yahniukov.uptodo.presentation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ua.yahniukov.uptodo.R

sealed class Onboarding(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
) {
    object FirstPage : Onboarding(
        image = R.drawable.onboarding1,
        title = R.string.first_onboarding_title,
        description = R.string.first_onboarding_description,
    )

    object SecondPage : Onboarding(
        image = R.drawable.onboarding2,
        title = R.string.second_onboarding_title,
        description = R.string.second_onboarding_description,
    )

    object ThirdPage : Onboarding(
        image = R.drawable.onboarding3,
        title = R.string.third_onboarding_title,
        description = R.string.third_onboarding_description,
    )
}