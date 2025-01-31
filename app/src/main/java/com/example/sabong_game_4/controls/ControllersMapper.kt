package com.example.sabong_game_4.controls

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.view.doOnAttach
import androidx.core.view.doOnLayout
import androidx.core.view.doOnNextLayout
import androidx.core.view.doOnPreDraw
import com.example.sabong_game_4.MainActivity
import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.game_world.playables.PlayableCharacter
import com.example.sabong_game_4.game_world.playables.PlayerOne

@RequiresApi(Build.VERSION_CODES.R)
object ControllersMapper : IControllersMapper {
    override fun getMovementControl(
        context: Context,
        character: PlayableCharacter
    ): List<MovementControl> {
        return when (character) {
            is PlayerOne -> {
                val phoneWidth = context.resources.displayMetrics.widthPixels
                val phoneHeight =
                    if (context is Activity) context.windowManager.maximumWindowMetrics.bounds.height() - (2 * GlobalConstants.FULL_SCREEN_PADDING) else context.resources.displayMetrics.heightPixels

                // remember, the view may not draw the dimensions right away here, use the phoneWidth and phoneHeight dimensions for the calculations
                val leftButton = MoveLeftButton(context, character).apply {
                    setViewDimensions(
                        width = phoneWidth / 4,
                        height = phoneHeight,
                        false
                    )

                    setBorderLine(
                        borderColor = Color.BLUE,
                        backgroundColor = Color.TRANSPARENT,
                        lineWidth = 10
                    )
                }

                val rightButton = MoveRightButton(context, character).apply {
                    setViewDimensions(
                        width = phoneWidth / 4,
                        height = phoneHeight,
                        false
                    )

                    setBorderLine(
                        borderColor = Color.RED,
                        backgroundColor = Color.TRANSPARENT,
                        lineWidth = 10
                    )

                    x = (phoneWidth / 4).toFloat()
                }

                val jumpButton = JumpButton(context, character).apply {
                    setViewDimensions(
                        width = 150,
                        height = 150,
                        true
                    )

                    setBorderLine(
                        borderColor = Color.BLUE,
                        backgroundColor = Color.TRANSPARENT,
                        lineWidth = 10
                    )

//                    translationX = phoneWidth.toFloat() - scaledWidth?.toFloat()!! + (GlobalConstants.FULL_SCREEN_PADDING)

                    x = phoneWidth.toFloat() - scaledWidth?.toFloat()!! - (2 * GlobalConstants.FULL_SCREEN_PADDING)
//                    y = phoneHeight.toFloat() - 150 + (2 * GlobalConstants.FULL_SCREEN_PADDING)
                }

                leftButton.post {
                    Log.d(
                        "Gandor",
                        "phoneHeight: $phoneHeight | phoneWidth: $phoneWidth | leftButton.width: ${leftButton.width} | leftButton.height: ${leftButton.height} | jumpButton.x: ${jumpButton.x} | jumpButton.scaledWidth: ${jumpButton.scaledWidth} | jumpButton.width: ${jumpButton.width}"
                    )
                }

                return listOf(
                    leftButton,
                    rightButton,
                    jumpButton
                )
            }

            else -> listOf(MovementControl(context, character))
        }
    }
}