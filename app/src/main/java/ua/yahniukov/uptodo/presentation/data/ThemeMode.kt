package ua.yahniukov.uptodo.presentation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatDelegate
import ua.yahniukov.uptodo.R

sealed class ThemeMode(
    @DrawableRes val icon: Int,
    @StringRes val name: Int,
    val mode: Int,
) {
    object System : ThemeMode(
        icon = R.drawable.ic_phone,
        name = R.string.system,
        mode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM,
    )

    object Light : ThemeMode(
        icon = R.drawable.ic_sun,
        name = R.string.light,
        mode = AppCompatDelegate.MODE_NIGHT_NO,
    )

    object Dark : ThemeMode(
        icon = R.drawable.ic_moon,
        name = R.string.dark,
        mode = AppCompatDelegate.MODE_NIGHT_YES,
    )
}