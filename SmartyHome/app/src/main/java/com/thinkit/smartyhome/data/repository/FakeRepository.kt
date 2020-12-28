package com.thinkit.smartyhome.data.repository

import com.thinkit.smartyhome.R
import com.thinkit.smartyhome.data.models.Room

class FakeRepository {
    fun getRooms(): ArrayList<Room> {
        return arrayListOf(
            Room("Living Room", R.drawable.livingroom, 4),
            Room("Media Room", R.drawable.mediaroom, 6),
            Room("Bathroom", R.drawable.bathroom, 1),
            Room("Bedroom", R.drawable.bedroom, 3)
        )
    }
}