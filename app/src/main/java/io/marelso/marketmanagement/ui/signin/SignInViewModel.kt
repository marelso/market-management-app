package io.marelso.marketmanagement.ui.signin

import androidx.lifecycle.ViewModel
import io.marelso.marketmanagement.data.network.account.AccountRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInViewModel(private val repository: AccountRepository): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onEmailChange(value: String) = _email.tryEmit(value)
    fun onPasswordChange(value: String) = _password.tryEmit(value)
}