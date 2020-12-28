package com.thinkit.smartyhome.ui

import com.thinkit.smartyhome.ui.home.HomeViewModel
import com.thinkit.smartyhome.ui.main.MainViewModel
import javax.inject.Inject
import javax.inject.Provider

class KnownViewModels @Inject constructor(
    val mainViewModel: Provider<MainViewModel>,
    val homeViewModel: Provider<HomeViewModel>
)