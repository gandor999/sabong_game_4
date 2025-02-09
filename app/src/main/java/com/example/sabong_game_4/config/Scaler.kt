package com.example.sabong_game_4.config

import android.content.res.Resources

object Scaler {
    fun scaleInt(resources: Resources, numberToScale: Int): Int {
        val phoneWidth = resources.displayMetrics.widthPixels
        return (numberToScale * phoneWidth) / 2160
    }

    fun scaleFloatOnWidth(resources: Resources, numberToScale: Float): Float {
        val phoneWidth = resources.displayMetrics.widthPixels
        return (numberToScale * phoneWidth) / 2160
    }

    fun scaleFloatOnHeight(resources: Resources, numberToScale: Float): Float {
        val phoneHeight = resources.displayMetrics.heightPixels
        return (numberToScale * phoneHeight) / 1020
    }
}