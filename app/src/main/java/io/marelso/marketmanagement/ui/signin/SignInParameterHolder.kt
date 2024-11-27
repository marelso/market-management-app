package io.marelso.marketmanagement.ui.signin

data class SignInParameterHolder(
    val email: String,
    val password: String,
    val canSubmit: Boolean,
    val onEmailChange: (String) -> Unit,
    val onPasswordChange: (String) -> Unit,
    val onSignInClick: () -> Unit,
    val onForgotPasswordClick: () -> Unit,
    val onLoginOptionClick: () -> Unit
)