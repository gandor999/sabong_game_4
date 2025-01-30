package com.example.sabong_game_4.game_world.playables

import android.content.Context
import com.example.sabong_game_4.custom.GandorView

open class GameCharacter(context: Context): GandorView(context), IGameCharacter {
    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun attack() {
        TODO("Not yet implemented")
    }

    override fun move(move: Movement, acceleration: Float) {
        TODO("Not yet implemented")
    }
}