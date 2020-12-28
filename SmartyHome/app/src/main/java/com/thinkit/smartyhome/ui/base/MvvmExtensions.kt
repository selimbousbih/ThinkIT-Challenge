package com.thinkit.smartyhome.ui.base

import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thinkit.smartyhome.App
import com.thinkit.smartyhome.ui.KnownViewModels
import javax.inject.Provider

inline fun <reified T : ViewModel> FragmentActivity.viewModel(
        crossinline provider: KnownViewModels.() -> Provider<T>
) = viewModels<T> {
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>) =
                provider((application as App).mKnownViewModels).get() as T
    }
}