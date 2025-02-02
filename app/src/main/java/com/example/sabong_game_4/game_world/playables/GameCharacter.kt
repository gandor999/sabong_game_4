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

    override fun jump() {
//        val experimentLimitForY = 300
//        val groundY = y
//        val limit = groundY - experimentLimitForY
//        while (y >= limit) {
//            y -= 1
//            velocityY -= 0f
//        }
    }

    override fun attack() {
        TODO("Not yet implemented")
    }

    // This is pretty bad design I think, there's gotta be something better?
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