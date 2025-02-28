package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

@RequiresApi(Build.VERSION_CODES.R)
open class LeftSideController(context: Context, playableCharacter: PlayableCharacter) :
    MovementControl(context, playableCharacter) {
    private val runnable = object : Runnable {
        var moveDirection = Directions.Nuetral;

        override fun run() {
            when (moveDirection) {
                Directions.Left -> playableCharacter.moveLeft()
                Directions.Right -> playableCharacter.moveRight()
                else -> {}
            }
            handler.post(this)
        }
    }

    private fun changeDirection(event: MotionEvent?) {
        if (event != null) {
            if (event.x < this.width / 2) runnable.moveDirection =
                Directions.Left else runnable.moveDirection = Directions.Right
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                synchronized(runnable) {
                    changeDirection(event)
                }
                return true
            }

            MotionEvent.ACTION_DOWN -> {
                isPressed = true
                synchronized(runnable) {
                    changeDirection(event)
                    handler.post(runnable) // Start repeating action
                }
                return true
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                isPressed = false
                synchronized(runnable) {
                    handler.removeCallbacks(runnable) // Stop repeating
                    if (runnable.moveDirection == Directions.Left) playableCharacter.characterState.toStoppingLeft() else playableCharacter.characterState.toStoppingRight()
                }
                return true
            }

            else -> super.onTouchEvent(event)
        }

        return super.onTouchEvent(event)
    }
}