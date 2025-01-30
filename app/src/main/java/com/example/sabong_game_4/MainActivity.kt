package com.example.sabong_game_4

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.config.PhoneConfigurator
import com.example.sabong_game_4.game_world.GameWorldBuilder
import com.example.sabong_game_4.game_world.IGameWorld
import com.example.sabong_game_4.game_world.playables.PlayerOne


class MainActivity : AppCompatActivity() {
    private var topLevelLayout: ViewGroup? = null
    private var gameWorld: IGameWorld? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topLevelLayout = findViewById(R.id.root_layout)

        PhoneConfigurator.apply {
            setToFullScreen(this@MainActivity)
            setToLandScape(this@MainActivity)
        }

        HealthChecker.logFps()

        GameWorldBuilder.setWorld(topLevelLayout, this)
        GameWorldBuilder.setWorldBackground(
            backgroundColor = Color.TRANSPARENT,
            borderColor = Color.BLACK,
            lineWidth = 15,
            padding = GlobalConstants.FULL_SCREEN_PADDING
        )
        gameWorld = GameWorldBuilder.buildWorld()

        gameWorld?.apply {
            addGameCharacter(PlayerOne(this@MainActivity))
            initGame()
            runGameLoop()
        }
    }
}