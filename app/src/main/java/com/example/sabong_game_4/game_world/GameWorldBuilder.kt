package com.example.sabong_game_4.game_world

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import androidx.core.view.setPadding
import java.lang.ref.WeakReference

object GameWorldBuilder: IGameWorldBuilder {
    private var worldLayout: WeakReference<ViewGroup>? = null
    private var worldContext: WeakReference<Context>? = null

    override fun setWorld(worldLayout: ViewGroup?, worldContext: Context) {
        this.worldLayout = WeakReference(worldLayout)
        this.worldContext = WeakReference(worldContext)
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

    override fun buildWorld(): IGameWorld? {
        worldLayout?.let {
            worldContext?.let {
                return GameWorld(worldLayout!!, worldContext!!)
            }
        }

        return null
    }
}