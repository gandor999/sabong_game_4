package com.example.sabong_game_4.game_world

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import com.example.sabong_game_4.custom.GandorView
import java.lang.ref.WeakReference

class GameWorld(
    private val worldLayout: WeakReference<ViewGroup>,
    private val worldContext: WeakReference<Context>
) : IGameWorld {
    override fun initGame() {
        worldContext.get()?.let {
            worldLayout.get()?.apply {
                addView(GandorView(worldContext.get()!!).apply {
                    setViewDimensions(150, 150)
                    setBorderLine(Color.TRANSPARENT, Color.BLUE, 10)
                })
            }
        }
    }

    override fun updateWorld() {
        TODO("Not yet implemented")
    }
}