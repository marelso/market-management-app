package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    query: String,
    placeholder: String,
    enabled: Boolean = true,
    containerColor: Color = MaterialTheme.colorScheme.background,
    interactionSource: InteractionSource = MutableInteractionSource(),
    onSearch: (String) -> Unit,
    onClearClicked: () -> Unit
) = BasicTextField(
    modifier = modifier
        .fillMaxWidth()
        .border(
            width = 1.dp,
            color = Color.Black.copy(alpha = .20f),
            shape = RoundedCornerShape(4.dp)
        ),
    value = query,
    textStyle = TextStyle(fontSize = 14.sp),
    onValueChange = onSearch,
    enabled = enabled,
    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
) { innerTextField ->
    TextFieldDefaults.DecorationBox(
        value = query,
        innerTextField = innerTextField,
        placeholder = { Text(text = placeholder, style = MaterialTheme.typography.bodyMedium) },
        enabled = enabled,
        singleLine = false,
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSource,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            if (query.isNotBlank()) {
                IconButton(
                    onClick = onClearClicked,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear search"
                        )
                    }
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                )
            }
        }
    )
}