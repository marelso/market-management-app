package io.marelso.marketmanagement.ui.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.marelso.marketmanagement.R

@Composable
fun SignInScreenHoisting(viewModel: SignInViewModel) {
    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val canSubmit by viewModel.canSubmit.collectAsStateWithLifecycle()

    SignInScreen(
        holder = SignInParameterHolder(
            email = email,
            password = password,
            canSubmit = canSubmit,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onSignInClick = viewModel::onSubmit,
            onForgotPasswordClick = {

            },
            onLoginOptionClick = viewModel::onSubmit
        )
    )
}

@Composable
private fun SignInScreen(
    modifier: Modifier = Modifier,
    holder: SignInParameterHolder
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
                    text = "Bem vindo de volta, Entre com sua conta",
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                )

                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    value = holder.email,
                    onValueChange = holder.onEmailChange,
                    label = { Text("Email") },
                    placeholder = { Text("Insira seu email") },
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = modifier.fillMaxWidth(),
                    value = holder.password,
                    onValueChange = holder.onPasswordChange,
                    label = { Text("Senha") },
                    placeholder = { Text("Insira sua senha") },
                    singleLine = true
                )

                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable { holder.onForgotPasswordClick() },
                    text = "Esqueceu a senha?",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                )

                Button(
                    modifier = modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp),
                    enabled = holder.canSubmit,
                    onClick = holder.onSignInClick
                ) {
                    Text(
                        text = "Entrar",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    )
                }


                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Divider()
                    Text(
                        modifier = modifier
                            .background(Color.White)
                            .padding(horizontal = 8.dp),
                        text = "Ou continue com",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp
                        )
                    )
                }

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = modifier
                            .border(
                                width = 1.dp,
                                color = Color.Black.copy(alpha = .15f),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .width(80.dp),
                        onClick = holder.onLoginOptionClick
                    ) {
                        Icon(
                            modifier = modifier.size(32.dp),
                            imageVector = ImageVector.vectorResource(R.drawable.ic_google),
                            contentDescription = "Sign In with Google",
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}