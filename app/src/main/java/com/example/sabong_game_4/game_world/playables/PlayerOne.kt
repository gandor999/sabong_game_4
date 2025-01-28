package com.example.sabong_game_4.game_world.playables

import android.content.Context
import android.graphics.Color

class PlayerOne(context: Context): GameCharacter(context) {
    private val width = 150
    private val height = 150

    init {
        setViewDimensions(width, height)
        setBorderLine(Color.TRANSPARENT, Color.BLUE, 10)
        isPlayableCharacter = true
    }
}