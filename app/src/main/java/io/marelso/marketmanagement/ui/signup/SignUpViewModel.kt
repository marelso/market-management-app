package io.marelso.marketmanagement.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.marelso.marketmanagement.data.AccountCreate
import io.marelso.marketmanagement.data.network.account.AccountRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val repository: AccountRepository,
    val onSignUpSuccess: () -> Unit
) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _lastName = MutableStateFlow("")
    val lastName: StateFlow<String> = _lastName

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    val canSubmit = combine(
        _name,
        _lastName,
        _email,
        _password
    ) { name, lastname, email, password ->
        password.isNotEmpty() && email.isNotEmpty() && name.isNotEmpty() && lastname.isNotEmpty()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    fun onNameChanged(value: String) = _name.tryEmit(value)
    fun onLastNameChanged(value: String) = _lastName.tryEmit(value)
    fun onEmailChanged(value: String) = _email.tryEmit(value)
    fun onPasswordChanged(value: String) = _password.tryEmit(value)
    fun onSubmit() = viewModelScope.launch {
        val result = repository.create(
            AccountCreate(
                firstName = _name.value,
                lastName = _lastName.value,
                email = _email.value,
                password = _password.value,
            )
        )

        if(result.isSuccessful) {
            result.body()?.let {
                onSignUpSuccess()
            }
        }
    }
}