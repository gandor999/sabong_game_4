package com.example.sabong_game_4.game_world

import com.example.sabong_game_4.game_world.playables.GameCharacter

interface IGameWorld {
    fun addPlayableCharacter(character: GameCharacter)

    fun initGame()

    fun updateWorld()
}