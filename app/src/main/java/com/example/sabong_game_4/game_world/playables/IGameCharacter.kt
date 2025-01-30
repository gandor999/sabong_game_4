package com.example.sabong_game_4.game_world.playables

interface IGameCharacter {
    fun jump()

    fun attack()

    fun move(move: Movement, acceleration: Float)
}

enum class Movement {
    Right,
    Left,
    Up,
    Down
}