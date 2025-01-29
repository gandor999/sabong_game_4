package com.example.sabong_game_4.game_world

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.sabong_game_4.GlobalConstants
import com.example.sabong_game_4.MainActivity
import com.example.sabong_game_4.custom.GandorView
import com.example.sabong_game_4.game_world.playables.GameCharacter
import kotlinx.coroutines.runInterruptible
import java.lang.ref.WeakReference

@RequiresApi(Build.VERSION_CODES.R)
class GameWorld(
    private val worldLayout: WeakReference<ViewGroup>,
    private val worldContext: WeakReference<Context>,
) : IGameWorld {
    private val playableCharacters: MutableList<GameCharacter> = mutableListOf()

    override fun addPlayableCharacter(character: GameCharacter) {
        playableCharacters.add(character)
    }

    override fun initGame() {
        worldContext.get()?.let {
            worldLayout.get()?.apply {
                for (playableCharacter in playableCharacters) {
                    if (playableCharacter.isPlayableCharacter) addView(playableCharacter)
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
        doGravityEffect(playableCharacters)
    }

    override fun doGravityEffect(gandorViews: List<GandorView>) {
        val realPhoneScreenHeight =
            (worldContext.get() as Activity).windowManager.maximumWindowMetrics.bounds.height()
        val acceleration = 0.0000009f

        for (gandorView in gandorViews) {
            if (gandorView.y + gandorView.velocity <= (realPhoneScreenHeight - GlobalConstants.FULL_SCREEN_PADDING - gandorView.height)) {
                gandorView.y += gandorView.velocity
                gandorView.velocity += acceleration
            } else {
                gandorView.velocity = 0f
                gandorView.y += (realPhoneScreenHeight - GlobalConstants.FULL_SCREEN_PADDING - gandorView.height) - gandorView.y
            }
        }
    }
}