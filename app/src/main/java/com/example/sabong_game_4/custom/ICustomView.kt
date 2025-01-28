package com.example.sabong_game_4.custom

import android.graphics.Color

interface ICustomView {
    fun setViewDimensions(width: Int, height: Int)

    fun setBorderLine(backgroundColor: Int, borderColor: Int, lineWidth: Int)
}