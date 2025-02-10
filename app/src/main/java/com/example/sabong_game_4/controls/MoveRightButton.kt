package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.R)
class MoveRightButton(context: Context, playableCharacter: PlayableCharacter) :
    LeftSideController(context, playableCharacter) {

    private val runnable = object : Runnable {
        override fun run() {
            if (isPressed) {
                excecute()
                handler.postDelayed(this, 10L) // this could just as easily be post instead, but I don't know... the game kind of lags if no delay is introduced
            }
        }
    }

    override fun excecute() {
        super.excecute()
        playableCharacter.moveRight()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                isPressed = true
                handler.post(runnable) // Start repeating action
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                isPressed = false
                handler.removeCallbacks(runnable) // Stop repeating
                return true
            }
            else -> super.onTouchEvent(event)
        }

        return super.onTouchEvent(event)
    }
}