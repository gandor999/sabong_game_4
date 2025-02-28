package com.example.sabong_game_4.game_world

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.config.Scaler
import com.example.sabong_game_4.controls.MovementControl
import com.example.sabong_game_4.game_world.playables.GameCharacter
import com.example.sabong_game_4.states.States
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        Thread.sleep(10L)

        for (gameCharacter in gameCharacters) {
            val gravityAcceleration = Scaler.scaleFloatOnHeight(gameCharacter.resources, 0.4f)
            val groundLevel =
                realPhoneScreenHeight - GlobalConstants.FULL_SCREEN_PADDING - gameCharacter.height
            val jumpAcceleration = Scaler.scaleFloatOnHeight(gameCharacter.resources, 14f)

            EffectsManager.doDecellerationEffect(gameCharacter)

            if (gameCharacter.jumpWasPressed) {
                EffectsManager.doJumpEffect(gameCharacter, jumpAcceleration)
            } else {
                EffectsManager.doGravityEffect(gameCharacter, gravityAcceleration, groundLevel)
            }
        }
    }
}