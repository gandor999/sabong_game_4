package com.example.sabong_game_4.controls

import android.content.Context
import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.custom.GandorView
import com.example.sabong_game_4.game_world.playables.Movement
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

open class MovementControl(context: Context, private var playableCharacter: PlayableCharacter) : IMovementControl, GandorView(context) {
    override fun moveToDirection(direction: Movement) {
        playableCharacter.move(direction, GlobalConstants.HORIZONTAL_ACCELERATION)
    }
}