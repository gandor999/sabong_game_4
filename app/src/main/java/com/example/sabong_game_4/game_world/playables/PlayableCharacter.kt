package com.example.sabong_game_4.game_world.playables

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
abstract class PlayableCharacter(context: Context) : GameCharacter(context) {
}