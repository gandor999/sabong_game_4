package com.example.sabong_game_4.game_world.playables

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.config.Scaler
import com.example.sabong_game_4.custom.GandorView
import com.example.sabong_game_4.states.CharacterState

@RequiresApi(Build.VERSION_CODES.R)
abstract class GameCharacter(context: Context): GandorView(context), IGameCharacter {
    var velocityY = 0f
    var velocityX = 0f;
    var characterState = CharacterState()
    var jumpWasPressed = false
    open val terminalVelocityX = Scaler.scaleFloatOnWidth(resources, 20f)
    open val originalJumpAmmo = 20
    open val accelerationX = 7f
    open val deccelerationX = 5f
    abstract var jumpAmmo: Int

    override fun jump() {
        jumpWasPressed = true
        characterState.toJumping()
    }

    override fun attack() {
        TODO("Not yet implemented")
    }

    override fun moveRight() {
        characterState.toRunningRight()
        x += velocityX
        if (velocityX < terminalVelocityX) velocityX += Scaler.scaleFloatOnWidth(resources, accelerationX)
    }

    override fun moveLeft() {
        characterState.toRunningLeft()
        x -= velocityX
        if (velocityX < terminalVelocityX) velocityX += Scaler.scaleFloatOnWidth(resources, accelerationX)
    }
}