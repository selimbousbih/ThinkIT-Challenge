package com.thinkit.smartyhome.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData

abstract class MvvmActivity : AppCompatActivity() {
    protected fun <T> LiveData<T>.observe(consumer: (T) -> Unit) {
        observe(this@MvvmActivity, { consumer(it) })
    }
}