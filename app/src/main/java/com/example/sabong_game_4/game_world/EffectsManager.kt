package com.example.sabong_game_4.game_world

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.GameCharacter
import com.example.sabong_game_4.states.States

@RequiresApi(Build.VERSION_CODES.R)
object EffectsManager : IEffectsManager {
    override fun doDecellerationEffect(gameCharacter: GameCharacter) {
//        val isJumpingOrFalling =
//            gameCharacter.currentState.getCurrentState()
//                .contains(States.Jumping) || gameCharacter.currentState.getCurrentState()
//                .contains(States.Falling)
        val newVelocity = maxOf(0f, gameCharacter.velocityX - gameCharacter.accelerationX)

        if (gameCharacter.characterState.getCurrentState()
                .contains(States.StoppingRunningRight) || gameCharacter.characterState.getCurrentState()
                .contains(States.StoppingRunningLeft)
        ) {
            Thread.sleep(10L)
            if (gameCharacter.velocityX > 0f) {
                gameCharacter.velocityX = newVelocity
                if (gameCharacter.characterState.getCurrentState()
                        .contains(States.StoppingRunningRight)
                ) {
                    gameCharacter.x += gameCharacter.velocityX
                } else {
                    gameCharacter.x -= gameCharacter.velocityX
                }
            } else {
                    gameCharacter.characterState.toIdle()
            }
        }
    }

    override fun doJumpEffect(gameCharacter: GameCharacter, acceleration: Float) {
        if (gameCharacter.jumpAmmo > 0 && gameCharacter.jumpWasPressed) {
            gameCharacter.velocityY -= acceleration
            gameCharacter.y += gameCharacter.velocityY
            gameCharacter.jumpAmmo -= 1
        } else {
            gameCharacter.jumpWasPressed = false
            gameCharacter.jumpAmmo = gameCharacter.originalJumpAmmo
        }
    }

    override fun doGravityEffect(
        gameCharacter: GameCharacter,
        acceleration: Float,
        groundLevel: Int
    ) {
        if (gameCharacter.y + gameCharacter.velocityY < groundLevel) {
            gameCharacter.y += gameCharacter.velocityY
            gameCharacter.velocityY += acceleration
            gameCharacter.characterState.toFalling()
        } else {
            gameCharacter.velocityY = 0f
            gameCharacter.y = groundLevel.toFloat()

            if (!gameCharacter.characterState.isMovingHorizontally()) gameCharacter.characterState.toIdle()
        }
    }
}