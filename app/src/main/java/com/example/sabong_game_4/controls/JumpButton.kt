package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

@RequiresApi(Build.VERSION_CODES.R)
//@SuppressLint("NewApi")
class JumpButton(context: Context, playableCharacter: PlayableCharacter) :
    RightSideController(context, playableCharacter) {

    override fun execute() {
        super.execute()
        Log.d("Gandor", "!playableCharacter.characterState.isJumping() && !playableCharacter.characterState.isFalling(): ${!playableCharacter.characterState.isJumping() && !playableCharacter.characterState.isFalling()} | playableCharacter.characterState.isJumping(): ${playableCharacter.characterState.isJumping()} | playableCharacter.characterState.isFalling(): ${playableCharacter.characterState.isFalling()}")
        if (!playableCharacter.characterState.isJumping() && !playableCharacter.characterState.isFalling()) {
            Log.d("Gandor", "Jumped!")
            playableCharacter.jump()
        }
    }
}