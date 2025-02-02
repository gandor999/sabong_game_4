package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter
import com.example.sabong_game_4.states.States

@RequiresApi(Build.VERSION_CODES.R)
class JumpButton(context: Context, playableCharacter: PlayableCharacter) :
    RightSideController(context, playableCharacter) {

    override fun excecute() {
        super.excecute()
        playableCharacter.jump()
        Log.d(
            "Gandor",
            "execute jump | currentState: ${playableCharacter.currentState} | playableCharacter.velocityY: ${playableCharacter.velocityY} | playableCharacter.y: ${playableCharacter.y}"
        )

        val experimentLimitForY = 300
        val groundY = playableCharacter.y
        val limit = groundY - experimentLimitForY
//        while (playableCharacter.y <= limit) {
//            Log.d("Gandor", "execute jump")
//            playableCharacter.y -= 10
////                playableCharacter.velocityY -= 10
////                playableCharacter.y -= 10
//        }

//        synchronized(playableCharacter.velocityY) {
//            Thread {
                while (playableCharacter.y >= limit) {
//                    playableCharacter.y -= playableCharacter.velocityY
//                    playableCharacter.velocityY -= 0.00000009f
//
                    playableCharacter.y -= 1
                }
//            }.start()
//        }



//            playableCharacter.y -= playableCharacter.velocityY
//            playableCharacter.velocityY -= 0.0001f

//            while (true) {
//
//            }


//        playableCharacter.y -= 10
    }
}