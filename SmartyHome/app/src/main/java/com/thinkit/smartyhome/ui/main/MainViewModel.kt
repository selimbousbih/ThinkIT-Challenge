package com.thinkit.smartyhome.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thinkit.smartyhome.R
import com.thinkit.smartyhome.data.local.Preferences
import com.thinkit.smartyhome.ui.base.ValidationState
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val context: Context, private val preferences: Preferences) : ViewModel() {
    val nameValidation = MutableLiveData<ValidationState<String, Exception>>(ValidationState.Pending())

    fun loggedIn() = !preferences.name.isNullOrEmpty()

    fun setName(name: String?){
        preferences.name = name
    }

    fun validateName(name: String) {
        if (name.isBlank()) {
            nameValidation.postValue(ValidationState.Error(Exception(context.getString(R.string.error_name))))
            return
        }

        nameValidation.postValue(ValidationState.Success(name))
    }
}