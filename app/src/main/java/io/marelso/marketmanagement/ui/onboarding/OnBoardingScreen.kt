package io.marelso.marketmanagement.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.marelso.marketmanagement.R
import io.marelso.marketmanagement.ui.components.AppLocalImage

@Composable
fun OnBoardingScreenHoisting(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    OnBoardingScreen(
        onSignInClick = onSignInClick,
        onSignUpClick = onSignUpClick
    )
}

@Composable
private fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            Column(
                modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Precisa controlar seu estoque?",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                )
                Text(
                    text = "Cadastre sua loja!",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Button(
                    modifier = modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(4.dp),
                    onClick = onSignInClick
                ) {
                    Text(
                        text = "Entrar",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    )
                }
                Text(
                    modifier = modifier.clickable { onSignUpClick() },
                    text = "Criar cadastro",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                )
            }
        }
    ) {
        Box(modifier.padding(it), contentAlignment = Alignment.Center) {
            AppLocalImage(
                modifier = modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.onboarding)
            )
        }
    }
}