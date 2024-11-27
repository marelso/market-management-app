package io.marelso.marketmanagement.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.marelso.marketmanagement.data.network.account.AccountRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class SignInViewModel(private val repository: AccountRepository): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    val canSubmit = combine(_email, _password) { email, password ->
        password.isNotEmpty() && email.isNotEmpty()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue =  false
    )

    fun onEmailChange(value: String) = _email.tryEmit(value)
    fun onPasswordChange(value: String) = _password.tryEmit(value)
}