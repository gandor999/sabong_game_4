package com.example.sabong_game_4.controls

import com.example.sabong_game_4.game_world.playables.Movement
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

interface IMovementControl {
    fun setPlayableCharacter(playableCharacter: PlayableCharacter)
    fun getPlayableCharacter(): PlayableCharacter?

    fun moveToDirection(direction: Movement)
}