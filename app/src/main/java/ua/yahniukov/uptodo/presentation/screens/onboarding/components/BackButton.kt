package ua.yahniukov.uptodo.presentation.screens.onboarding.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ua.yahniukov.uptodo.R

@Composable
fun BackButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(text = stringResource(R.string.back_btn))
    }
}