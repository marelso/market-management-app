package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProductSheet(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    name: String,
    price: Double,
    onNameChange: (String) -> Unit,
    onPriceChange: (String) -> Unit,
    onSheetVisibilityChange: (Boolean) -> Unit,
    onSubmit: () -> Unit
) = ModalBottomSheet(
    modifier = modifier.padding(bottom = padding.calculateBottomPadding() + 12.dp),
    onDismissRequest = { onSheetVisibilityChange(false) }
) {
    Column(modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            text = "Preencha os campos abaixo:",
            style = MaterialTheme.typography.labelLarge
        )

        Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Box(
                modifier
                    .size(132.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
        }

        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nome do produto") },
            placeholder = { Text("Insira o nome do produto") },
            singleLine = true
        )

        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = price.toString(),
            onValueChange = onPriceChange,
            label = { Text("Preço") },
            placeholder = { Text("Valor de venda por unidade") },
            singleLine = true
        )

        Button(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            onClick = onSubmit
        ) {
            Text(text = "Cadastrar", style = MaterialTheme.typography.labelLarge)
        }
    }
}