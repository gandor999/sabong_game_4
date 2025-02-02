package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

@RequiresApi(Build.VERSION_CODES.R)
open class RightSideController(context: Context, playableCharacter: PlayableCharacter) :
    MovementControl(context, playableCharacter) {
}