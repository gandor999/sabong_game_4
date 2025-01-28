package com.example.sabong_game_4

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sabong_game_4.config.PhoneConfigurator
import com.example.sabong_game_4.game_world.GameWorldBuilder
import com.example.sabong_game_4.game_world.playables.PlayerOne


class MainActivity : AppCompatActivity() {
    private var topLevelLayout: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topLevelLayout = findViewById(R.id.root_layout)

        PhoneConfigurator.apply {
            setToFullScreen(this@MainActivity)
            setToLandScape(this@MainActivity)
        }

        GameWorldBuilder.setWorld(topLevelLayout, this)
        GameWorldBuilder.setWorldBackground(
            backgroundColor = Color.TRANSPARENT,
            borderColor = Color.BLACK,
            lineWidth = 15,
            padding = 15
        )
        GameWorldBuilder.buildWorld()?.apply {
            addPlayableCharacter(PlayerOne(this@MainActivity))

            initGame()

//            while (true) {
//                // game loop here in separate thread, not a coroutine for this one
////                updateWorld()
//            }
        }
    }
}