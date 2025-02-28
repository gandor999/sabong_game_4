package com.example.sabong_game_4.states

interface ICharacterState {
    fun toJumping()

    fun isJumping(): Boolean

    fun toFalling()

    fun isFalling(): Boolean

    fun toRunningRight()

    fun toRunningLeft()

    fun toStoppingLeft()

    fun toStoppingRight()

    fun isMovingHorizontally(): Boolean

    fun toIdle()

    fun isIdle(): Boolean

    fun isMovingRight(): Boolean

    fun isMovingLeft(): Boolean

    fun getCurrentState(): Set<States>
}