package io.marelso.marketmanagement.ui.signup

data class SignUpParameterHolder(
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val canSubmit: Boolean,
    val onNameChanged: (String) -> Unit,
    val onLastNameChanged: (String) -> Unit,
    val onEmailChanged: (String) -> Unit,
    val onPasswordChanged: (String) -> Unit,
    val onSubmit: () -> Unit,
)
