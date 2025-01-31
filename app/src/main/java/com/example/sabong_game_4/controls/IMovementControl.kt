package com.example.sabong_game_4.controls

import com.example.sabong_game_4.game_world.playables.Movement
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

interface IMovementControl {
    fun moveToDirection(direction: Movement)
}