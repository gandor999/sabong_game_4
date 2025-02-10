package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter
@RequiresApi(Build.VERSION_CODES.R)
class AttackButton(context: Context, playableCharacter: PlayableCharacter) :
    RightSideController(context, playableCharacter) {

    override fun execute() {
        super.execute()
        Log.d("Gandor", "execute attack")
    }
}