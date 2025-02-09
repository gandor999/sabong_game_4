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
    }
}