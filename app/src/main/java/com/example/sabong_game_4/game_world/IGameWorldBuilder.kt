package com.example.sabong_game_4.game_world

import android.content.Context
import android.view.ViewGroup

interface IGameWorldBuilder {
    fun setWorld(worldLayout: ViewGroup?, worldContext: Context): GameWorldBuilder

    fun buildWorld(): IGameWorld?

    fun setWorldBackground(backgroundColor: Int, borderColor: Int, lineWidth: Int, padding: Int): GameWorldBuilder
}