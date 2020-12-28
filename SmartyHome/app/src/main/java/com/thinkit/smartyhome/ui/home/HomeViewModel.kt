package com.thinkit.smartyhome.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thinkit.smartyhome.data.local.Preferences
import com.thinkit.smartyhome.data.models.Room
import com.thinkit.smartyhome.data.repository.FakeRepository
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class HomeViewModel @Inject constructor(private val preferences: Preferences, private val repository: FakeRepository) : ViewModel() {
    val personName = MutableLiveData(preferences.name)
    val rooms = MutableLiveData(ArrayList<Room>())

    fun getRooms(){
        rooms.postValue(repository.getRooms())
    }
}