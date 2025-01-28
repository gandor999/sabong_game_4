package com.example.sabong_game_4.game_world

import android.content.Context
import android.view.ViewGroup
import com.example.sabong_game_4.game_world.playables.GameCharacter
import java.lang.ref.WeakReference

class GameWorld(
    private val worldLayout: WeakReference<ViewGroup>,
    private val worldContext: WeakReference<Context>,
) : IGameWorld {
    private val playableCharacters: MutableList<GameCharacter> = mutableListOf()

    override fun addPlayableCharacter(character: GameCharacter) {
        playableCharacters.add(character)
    }

    override fun initGame() {
        worldContext.get()?.let {
            worldLayout.get()?.apply {
                for (playableCharacter in playableCharacters) {
                    addView(playableCharacter)
                }
            }
        }
    }

    override fun updateWorld() {
        TODO("Not yet implemented")
    }
}