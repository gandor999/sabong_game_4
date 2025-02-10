package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter
import com.example.sabong_game_4.states.States

@RequiresApi(Build.VERSION_CODES.R)
class MoveRightButton(context: Context, playableCharacter: PlayableCharacter) :
    LeftSideController(context, playableCharacter) {

//    var isCurrentlyPressing = false
    private val runnable = object : Runnable {
        override fun run() {
            if (isPressed) {
                execute()
                handler.post(this)
            }
        }
    }

    override fun execute() {
        super.execute()
//        Log.d("Gandor", "MoveRightButton | execute | playableCharacter.currentState: ${playableCharacter.currentState}")
        playableCharacter.moveRight()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                return true
            }
            MotionEvent.ACTION_DOWN -> {
                if (!isPressed) {
                    isPressed = true
                    handler.post(runnable) // Start repeating action
                }
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                isPressed = false
                handler.removeCallbacks(runnable) // Stop repeating
                playableCharacter.isStoppingRightMove = true
                return true
            }
            else -> super.onTouchEvent(event)
        }

        return super.onTouchEvent(event)
    }
}