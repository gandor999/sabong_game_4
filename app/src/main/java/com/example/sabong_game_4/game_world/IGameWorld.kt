package com.example.sabong_game_4.game_world

import com.example.sabong_game_4.controls.MovementControl
import com.example.sabong_game_4.game_world.playables.GameCharacter

interface IGameWorld {
    fun addGameCharacter(character: GameCharacter)

    fun attachMoveControllers(moveControllers: List<MovementControl>)

    fun initGame()

    fun runGameLoop()

    fun updateWorld()

    fun doJumpEffect(gameCharacter: GameCharacter, acceleration: Float)

    fun doGravityEffect(gameCharacter: GameCharacter, acceleration: Float, groundLevel: Int)
}