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
fun DescriptionTextField(
    modifier: Modifier = Modifier,
    description: String,
    onDescriptionChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = description,
        onValueChange = onDescriptionChange,
        label = { Text(text = stringResource(R.string.description)) },
        placeholder = { Text(text = stringResource(R.string.description_hint)) },
        shape = RoundedCornerShape(4.dp),
        minLines = 7,
        maxLines = 7,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        )
    )
}