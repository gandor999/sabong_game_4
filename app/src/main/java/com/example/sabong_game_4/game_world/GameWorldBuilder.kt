package com.example.sabong_game_4.game_world

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.setPadding
import java.lang.ref.WeakReference

object GameWorldBuilder: IGameWorldBuilder {
    private var worldLayout: WeakReference<ViewGroup>? = null
    private var worldContext: WeakReference<Context>? = null

    override fun setWorld(worldLayout: ViewGroup?, worldContext: Context): GameWorldBuilder {
        this.worldLayout = WeakReference(worldLayout)
        this.worldContext = WeakReference(worldContext)

        return this
    }

    override fun setWorldBackground(backgroundColor: Int, borderColor: Int, lineWidth: Int, padding: Int): GameWorldBuilder {
        worldLayout?.get()?.apply {
            background = GradientDrawable().apply {
                setColor(backgroundColor)
                setStroke(lineWidth, borderColor)
                setPadding(padding)
            }
        }

        return this
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun buildWorld(): IGameWorld? {
        worldLayout?.let {
            worldContext?.let {
                return GameWorld(worldLayout!!, worldContext!!)
            }
        }

        return null
    }
}