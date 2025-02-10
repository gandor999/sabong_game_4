package com.example.sabong_game_4.game_world.playables

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
class PlayerOne(context: Context) : PlayableCharacter(
    context,
) {
    private val width = 150
    private val height = 150

    override val originalJumpAmmo: Int
        get() = 20

    // this must be initialized
    override var jumpAmmo: Int = originalJumpAmmo

    init {
        setViewDimensions(width, height, true)
        setBorderLine(Color.TRANSPARENT, Color.BLUE, 10)
        initState()
    }
}