package com.example.sabong_game_4.game_world.playables

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.Choreographer
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.config.Scaler
import com.example.sabong_game_4.custom.GandorView
import com.example.sabong_game_4.states.States

@RequiresApi(Build.VERSION_CODES.R)
abstract class GameCharacter(context: Context): GandorView(context), IGameCharacter {
    var velocityY = 0f
    var velocityX = 0f;
    var currentState = States.Idle
    var jumpWasPressed = false
    var isStoppingRightMove = false
    var isStoppingLeftMove = false
    open val terminalVelocityX = 30
    open val originalJumpAmmo = 20
    open val accelerationX = 2
    abstract var jumpAmmo: Int

    override fun jump() {
        jumpWasPressed = true
    }

    override fun attack() {
        TODO("Not yet implemented")
    }

    override fun moveRight() {
        Log.d("Gandor", "GameCharacter | moveRight | velocityX: $velocityX")
        x += Scaler.scaleFloatOnWidth(resources, velocityX)
//        if (velocityX < terminalVelocityX) velocityX += Scaler.scaleInt(resources, accelerationX)
        if (velocityX < terminalVelocityX) velocityX += accelerationX
    }

    override fun moveLeft() {
        x -= Scaler.scaleFloatOnWidth(resources, velocityX)
//        if (velocityX < terminalVelocityX) velocityX += Scaler.scaleInt(resources, accelerationX)
        if (velocityX < terminalVelocityX) velocityX += accelerationX
    }

    override fun initState() { // revisit this, this isn't very consistent, especially for running and idle
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
                    lastX < this@GameCharacter.x -> {
                        States.RunningRight
                    }
                    lastX > this@GameCharacter.x -> {
                        States.RunningLeft
                    }
                    else -> {
                        States.Idle
                    }
                }

                lastX = this@GameCharacter.x
                lastY = this@GameCharacter.y

                choreographer.postFrameCallback(this)
            }
        }

        choreographer.postFrameCallback(frameCallback)
    }
}