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
    var isPressingLeft = false
    open val terminalVelocityX = Scaler.scaleFloatOnWidth(resources, 15f)
    open val originalJumpAmmo = 20
    open val accelerationX = 2f
    abstract var jumpAmmo: Int

    override fun jump() {
        jumpWasPressed = true
        currentState = States.Jumping
    }

    override fun attack() {
        TODO("Not yet implemented")
    }

    override fun moveRight() {
        currentState = States.RunningRight
        x += velocityX
        if (velocityX < terminalVelocityX) velocityX += Scaler.scaleFloatOnWidth(resources, accelerationX)
    }

    override fun moveLeft() {
        currentState = States.RunningLeft
        x -= velocityX
        if (velocityX < terminalVelocityX) velocityX += Scaler.scaleFloatOnWidth(resources, accelerationX)
    }
}