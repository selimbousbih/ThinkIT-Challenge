package com.thinkit.smartyhome.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.stringFormat(pattern: String = "MMMM dd, yyy"): String {
    val format = SimpleDateFormat(pattern, Locale.getDefault())
    return format.format(this)
}