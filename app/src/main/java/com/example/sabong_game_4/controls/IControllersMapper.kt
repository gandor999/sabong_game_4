package com.example.sabong_game_4.controls

import android.content.Context
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

interface IControllersMapper {
    fun getMovementControl(context: Context, character: PlayableCharacter): List<MovementControl>
}