package com.example.sabong_game_4

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sabong_game_4.config.PhoneConfigurator
import com.example.sabong_game_4.custom.GandorView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PhoneConfigurator.apply {
            setToFullScreen(this@MainActivity)
            setToLandScape(this@MainActivity)
        }

        findViewById<ViewGroup>(R.id.root_layout).apply {
            background = GradientDrawable().apply {
                setColor(Color.TRANSPARENT)
                setStroke(10, Color.BLACK)
//                setPadding(25, 25, 25, 25)
            }

            addView(GandorView(this@MainActivity).apply {
                setViewDimensions(150, 150)
                setBorderLine(Color.TRANSPARENT, Color.BLUE, 10)
            })
        }
    }
}