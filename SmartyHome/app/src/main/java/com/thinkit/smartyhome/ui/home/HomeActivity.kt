package com.thinkit.smartyhome.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thinkit.smartyhome.R
import com.thinkit.smartyhome.ui.base.MvvmActivity
import com.thinkit.smartyhome.ui.base.viewModel
import com.thinkit.smartyhome.utils.stringFormat
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : MvvmActivity() {
    private val vm by viewModel { homeViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupUI()
        observeOutput()

        vm.getRooms()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        textDate.text = Date().stringFormat()
    }

    private fun observeOutput() {
        vm.run {
            personName.observe { textWelcome.text = getString(R.string.welcome_person, it) }
            rooms.observe { recyclerView.adapter = RoomAdapter(this@HomeActivity, it) }
        }
    }
}