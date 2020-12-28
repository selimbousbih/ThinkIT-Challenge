package com.thinkit.smartyhome.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Launches an Activity
 * @param extras a bundle initializer
 */
inline fun <reified T : Activity> Context.launchActivity(extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, T::class.java).apply {
        putExtras(Bundle().apply(extras))
    }
    startActivity(intent)
}

/**
 * Launches an Activity, expecting a result
 * @param requestCode the request code
 */
inline fun <reified T : Activity> Activity.launchActivityForResult(requestCode: Int) {
    val intent = Intent(this, T::class.java)
    startActivityForResult(intent, requestCode)
}