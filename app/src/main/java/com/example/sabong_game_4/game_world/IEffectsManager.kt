package com.example.sabong_game_4.game_world

import com.example.sabong_game_4.game_world.playables.GameCharacter

interface IEffectsManager {
    fun doDecellerationEffect(gameCharacter: GameCharacter)

    fun doJumpEffect(gameCharacter: GameCharacter, acceleration: Float)

    fun doGravityEffect(gameCharacter: GameCharacter, acceleration: Float, groundLevel: Int)
}