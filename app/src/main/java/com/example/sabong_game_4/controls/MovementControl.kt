package com.example.sabong_game_4.controls

import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.game_world.playables.Movement
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

object MovementControl : IMovementControl {
    private var playableCharacter: PlayableCharacter? = null

    override fun setPlayableCharacter(playableCharacter: PlayableCharacter) {
        this.playableCharacter = playableCharacter
    }

    override fun getPlayableCharacter(): PlayableCharacter? {
        return playableCharacter
    }

    override fun moveToDirection(direction: Movement) {
        playableCharacter?.move(direction, GlobalConstants.HORIZONTAL_ACCELERATION)
    }
}