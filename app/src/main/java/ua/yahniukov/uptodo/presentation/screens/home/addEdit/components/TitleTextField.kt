package ua.yahniukov.uptodo.presentation.screens.home.addEdit.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ua.yahniukov.uptodo.R

@Composable
fun TitleTextField(
    modifier: Modifier = Modifier,
    title: String,
    onTitleChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = title,
        onValueChange = onTitleChange,
        label = { Text(text = stringResource(R.string.title)) },
        placeholder = { Text(text = stringResource(R.string.title_hint)) },
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
    )
}