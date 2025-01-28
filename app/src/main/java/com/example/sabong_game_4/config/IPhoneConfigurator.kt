package com.example.sabong_game_4.config

import android.app.Activity

interface IPhoneConfigurator {
    fun setToFullScreen(activity: Activity)

    fun setToLandScape(activity: Activity)
}