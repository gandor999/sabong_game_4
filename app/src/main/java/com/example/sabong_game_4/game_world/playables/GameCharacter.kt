package com.example.sabong_game_4.game_world.playables

import android.content.Context
import android.os.Build
import android.view.Choreographer
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.custom.GandorView
import com.example.sabong_game_4.states.States

@RequiresApi(Build.VERSION_CODES.R)
open class GameCharacter(context: Context): GandorView(context), IGameCharacter {
    var velocityY = 0f
    var maxHorizontalVelocity = 10;
    var currentState = States.Idle
    var jumpWasPressed = false

    override fun jump() {
        jumpWasPressed = true
    }

    override fun attack() {
        TODO("Not yet implemented")
    }

    override fun initState() {
        val choreographer = Choreographer.getInstance()
        val frameCallback = object : Choreographer.FrameCallback {
            private var lastX = this@GameCharacter.x
            private var lastY = this@GameCharacter.y

            override fun doFrame(frameTimeNanos: Long) {
                currentState = when {
                    lastY > this@GameCharacter.y -> {
                        States.Jumping
                    }
                    lastY < this@GameCharacter.y -> {
                        States.Falling
                    }
                    lastX != this@GameCharacter.x -> {
                        States.Running
                    }
                    else -> States.Idle
                }

                lastX = this@GameCharacter.x
                lastY = this@GameCharacter.y

                choreographer.postFrameCallback(this)
            }
        }

        choreographer.postFrameCallback(frameCallback)
    }
}