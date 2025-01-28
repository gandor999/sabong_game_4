package com.example.sabong_game_4.game_world

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import androidx.core.view.setPadding
import com.example.sabong_game_4.custom.GandorView
import java.lang.ref.WeakReference

object GameWorld: IGameWorld {
    private var worldLayout: WeakReference<ViewGroup>? = null
    private var worldContext: WeakReference<Context>? = null

    override fun setWorld(worldLayout: ViewGroup?, worldContext: Context) {
        this.worldLayout = WeakReference(worldLayout)
        this.worldContext = WeakReference(worldContext)
    }

    override fun buildWorld() {
        worldContext?.get()?.let {
            worldLayout?.get()?.apply {
                addView(GandorView(worldContext!!.get()!!).apply {
                    setViewDimensions(150, 150)
                    setBorderLine(Color.TRANSPARENT, Color.BLUE, 10)
                })
            }
        }
    }

    override fun updateWorld() {
        TODO("Not yet implemented")
    }

    override fun setWorldBackground(backgroundColor: Int, borderColor: Int, lineWidth: Int, padding: Int) {
        worldLayout?.get()?.apply {
            background = GradientDrawable().apply {
                setColor(backgroundColor)
                setStroke(lineWidth, borderColor)
                setPadding(padding)
            }
        }
    }
}