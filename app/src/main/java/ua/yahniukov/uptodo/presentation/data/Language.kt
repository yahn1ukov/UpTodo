package ua.yahniukov.uptodo.presentation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ua.yahniukov.uptodo.R

sealed class Language(
    @DrawableRes val icon: Int,
    @StringRes val name: Int,
    val code: String,
) {
    object English : Language(
        icon = R.drawable.ic_language,
        name = R.string.english,
        code = "en",
    )

    object Ukrainian : Language(
        icon = R.drawable.ic_language,
        name = R.string.ukrainian,
        code = "uk",
    )
}