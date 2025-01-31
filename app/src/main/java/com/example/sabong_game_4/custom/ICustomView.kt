package com.example.sabong_game_4.custom

interface ICustomView {
    fun setViewDimensions(width: Int, height: Int, toScale: Boolean)

    fun setBorderLine(backgroundColor: Int, borderColor: Int, lineWidth: Int)
}