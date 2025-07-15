package com.example.thousandscourses.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _isLoginButtonEnabled = MutableLiveData<Boolean>(false)
    val isLoginButtonEnabled: LiveData<Boolean> get() = _isLoginButtonEnabled

    fun validateInputs(email: String, password: String) {
        val isEmailValid = email.matches(Regex("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$"))
                && !email.contains(Regex("[а-яА-Я]"))
        val isPasswordValid = password.isNotEmpty()

        _isLoginButtonEnabled.value = isEmailValid && isPasswordValid
    }
}