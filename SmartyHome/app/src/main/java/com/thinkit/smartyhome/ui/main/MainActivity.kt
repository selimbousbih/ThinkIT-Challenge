package com.thinkit.smartyhome.ui.main

import android.os.Bundle
import com.thinkit.smartyhome.R
import com.thinkit.smartyhome.ui.base.MvvmActivity
import com.thinkit.smartyhome.ui.base.ValidationState
import com.thinkit.smartyhome.ui.base.viewModel
import com.thinkit.smartyhome.ui.home.HomeActivity
import com.thinkit.smartyhome.utils.launchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvvmActivity() {
    private val vm by viewModel { mainViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (vm.loggedIn()) {
            launchActivity<HomeActivity>()
            finish()
        }

        setContentView(R.layout.activity_main)
        setupUI()
        observeOutput()
    }

    private fun setupUI() {
        continueButton.setOnClickListener { vm.validateName(editTextName.text.toString()) }
    }

    private fun observeOutput() {
        vm.nameValidation.observe {
            when (it) {
                is ValidationState.Pending -> {
                }

                is ValidationState.Success -> {
                    vm.setName(it.value)
                    launchActivity<HomeActivity>()
                    finish()
                }

                is ValidationState.Error -> {
                    editTextName.error = it.error.message
                }
            }
        }
    }
}