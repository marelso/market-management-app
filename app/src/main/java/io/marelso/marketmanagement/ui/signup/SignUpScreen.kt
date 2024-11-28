package io.marelso.marketmanagement.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SignUpScreenHoisting(viewModel: SignUpViewModel) {
    val name by viewModel.name.collectAsStateWithLifecycle()
    val lastName by viewModel.lastName.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val canSubmit by viewModel.canSubmit.collectAsStateWithLifecycle()

    SignUpScreen(
        holder = SignUpParameterHolder(
            name = name,
            lastName = lastName,
            email = email,
            password = password,
            canSubmit = canSubmit,
            onNameChanged = viewModel::onNameChanged,
            onLastNameChanged = viewModel::onLastNameChanged,
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChanged = viewModel::onPasswordChanged,
            onSubmit = viewModel::onSubmit,
        )
    )
}

@Composable
private fun SignUpScreen(
    modifier: Modifier = Modifier,
    holder: SignUpParameterHolder
) {
    Scaffold {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Bem vindo, Crie sua conta conosco",
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                )

                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    value = holder.name,
                    onValueChange = holder.onNameChanged,
                    label = { Text("Nome") },
                    placeholder = { Text("Insira seu nome") },
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    value = holder.lastName,
                    onValueChange = holder.onLastNameChanged,
                    label = { Text("Sobrenome") },
                    placeholder = { Text("Insira seu sobrenome") },
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    value = holder.email,
                    onValueChange = holder.onEmailChanged,
                    label = { Text("Email") },
                    placeholder = { Text("Insira seu email") },
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    value = holder.password,
                    onValueChange = holder.onPasswordChanged,
                    label = { Text("Senha") },
                    placeholder = { Text("Insira sua senha") },
                    singleLine = true
                )

                Button(
                    modifier = modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp),
                    enabled = holder.canSubmit,
                    onClick = holder.onSubmit
                ) {
                    Text(
                        text = "Cadastrar",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
    }
}