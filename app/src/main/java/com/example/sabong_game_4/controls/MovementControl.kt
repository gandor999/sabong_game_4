package com.example.sabong_game_4.controls

import android.content.Context
import android.os.Build
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.custom.GandorView
import com.example.sabong_game_4.game_world.playables.PlayableCharacter

@RequiresApi(Build.VERSION_CODES.R)
open class MovementControl(context: Context, var playableCharacter: PlayableCharacter) : IMovementControl, GandorView(context) {
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        execute()
        return super.onTouchEvent(event)
    }

    override fun execute() {
    }
}