package com.example.sabong_game_4.game_world

import android.content.Context
import android.view.ViewGroup

interface IGameWorld {
    fun setWorld(worldLayout: ViewGroup?, worldContext: Context)

    fun buildWorld()

    fun updateWorld()

    fun setWorldBackground(backgroundColor: Int, borderColor: Int, lineWidth: Int, padding: Int)
}