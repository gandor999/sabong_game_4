package com.example.sabong_game_4

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.sabong_game_4.config.GlobalConstants
import com.example.sabong_game_4.config.PhoneConfigurator
import com.example.sabong_game_4.controls.ControllersMapper
import com.example.sabong_game_4.game_world.GameWorldBuilder
import com.example.sabong_game_4.game_world.playables.PlayerOne

@RequiresApi(Build.VERSION_CODES.R)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topLevelLayout: ViewGroup? = findViewById(R.id.root_layout)

        PhoneConfigurator.apply {
            setToFullScreen(this@MainActivity)
            setToLandScape(this@MainActivity)
        }

//        HealthChecker.logFps()

        val gameWorld = GameWorldBuilder.setWorld(topLevelLayout, this).setWorldBackground(
            backgroundColor = Color.TRANSPARENT,
            borderColor = Color.BLACK,
            lineWidth = 15,
            padding = GlobalConstants.FULL_SCREEN_PADDING
        ).buildWorld()

        // do not optional chain this one from buildWorld, it gets harder to read after 1 week of not coding
        gameWorld?.apply {
            val playerOne = PlayerOne(this@MainActivity)
            val playerOneController = ControllersMapper.getMovementControl(this@MainActivity, playerOne)

            addGameCharacter(playerOne)
            attachMoveControllers(playerOneController)
            initGame()
            runGameLoop()
        }
    }
}