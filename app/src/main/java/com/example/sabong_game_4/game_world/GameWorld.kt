package com.example.sabong_game_4.game_world

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.config.Scaler
import com.example.sabong_game_4.controls.MovementControl
import com.example.sabong_game_4.game_world.playables.GameCharacter
import java.lang.ref.WeakReference

@RequiresApi(Build.VERSION_CODES.R)
class GameWorld(
    private val worldLayout: WeakReference<ViewGroup>,
    private val worldContext: WeakReference<Context>,
) : IGameWorld {
    private val gameCharacters: MutableList<GameCharacter> = mutableListOf()

    override fun addGameCharacter(character: GameCharacter) {
        gameCharacters.add(character)
    }

    override fun attachMoveControllers(moveControllers: List<MovementControl>) {
        worldLayout.get()?.apply {
            moveControllers.forEach { controller ->
                addView(controller)
            }
        }
    }

    override fun initGame() {
        worldContext.get()?.let {
            worldLayout.get()?.apply {
                for (gameCharacter in gameCharacters) {
                    addView(gameCharacter)
                }
            }
        }
    }

    /**
     * Let the game loop loop on even if the application is switched to another application, the game should still continue even when no one is around to play, we'll look at pausing the game later
     * */
    override fun runGameLoop() {
        Thread {
            while (true) {
                updateWorld()
            }
        }.start()
    }

    /**
     * Updates the game world and is running on a separate thread
     * */
    override fun updateWorld() {
        val realPhoneScreenHeight =
            (worldContext.get() as Activity).windowManager.maximumWindowMetrics.bounds.height()
        Thread.sleep(1)

        for (gameCharacter in gameCharacters) {
            val gravityAcceleration = Scaler.scaleFloatOnHeight(gameCharacter.resources, 0.01f)
            val groundLevel = realPhoneScreenHeight - GlobalConstants.FULL_SCREEN_PADDING - gameCharacter.height
            val jumpAcceleration = Scaler.scaleFloatOnHeight(gameCharacter.resources, .08f)

            if (gameCharacter.jumpWasPressed) {
                doJumpEffect(gameCharacter, jumpAcceleration)
                continue
            }

            doGravityEffect(gameCharacter, gravityAcceleration, groundLevel)
        }
    }

    override fun doJumpEffect(gameCharacter: GameCharacter, acceleration: Float) {
        if (gameCharacter.jumpAmmo > 0) {
            gameCharacter.velocityY -= acceleration
            gameCharacter.y += gameCharacter.velocityY
            gameCharacter.jumpAmmo -= 1
        } else {
            gameCharacter.jumpWasPressed = false
            gameCharacter.jumpAmmo = gameCharacter.originalJumpAmmo
        }
    }

    override fun doGravityEffect(gameCharacter: GameCharacter, acceleration: Float, groundLevel: Int) {
        if (gameCharacter.y + gameCharacter.velocityY < groundLevel) {
            gameCharacter.y += gameCharacter.velocityY
            gameCharacter.velocityY += acceleration
        } else {
            gameCharacter.velocityY = 0f
            gameCharacter.y = groundLevel.toFloat()
        }
    }
}