package com.thinkit.smartyhome.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class Preferences @Inject constructor(private val sharedPreferences: SharedPreferences){
    var name: String?
        get() = sharedPreferences.getString(KEY_PERSON_NAME, "")
        set(value) = sharedPreferences.edit()
                .putString(KEY_PERSON_NAME, value)
                .apply()

    companion object{
        private const val KEY_PERSON_NAME = "personName"
    }
}