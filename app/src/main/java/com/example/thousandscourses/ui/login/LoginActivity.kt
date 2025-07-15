package com.example.thousandscourses.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.net.toUri
import androidx.core.widget.addTextChangedListener
import com.example.thousandscourses.databinding.ActivityLoginBinding
import com.example.thousandscourses.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupInputValidation()

        binding.loginButton.setOnClickListener {
            if (binding.loginButton.isEnabled) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("navigate_to_home", true)
                }
                startActivity(intent)
                finish()
            }
        }

        binding.registerTextView.isEnabled = false
        binding.forgotPasswordTextView.isEnabled = false

        binding.vkButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, "https://vk.com/".toUri()))
        }

        binding.okButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, "https://ok.ru/".toUri()))
        }
    }

    private fun setupInputValidation() {
        binding.emailEditText.addTextChangedListener { validateInputs() }
        binding.passwordEditText.addTextChangedListener { validateInputs() }

        viewModel.isLoginButtonEnabled.observe(this) { isEnabled ->
            binding.loginButton.isEnabled = isEnabled
        }

        binding.emailEditText.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            if (source != null && source.matches(Regex("[^a-zA-Z0-9@.]"))) {
                ""
            } else {
                source
            }
        })
    }

    private fun validateInputs() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        viewModel.validateInputs(email, password)
    }
}