package com.example.sabong_game_4.game_world.playables

import android.content.Context

abstract class PlayableCharacter(context: Context) : GameCharacter(context) {
    var maxHorizontalVelocity = 10;
}