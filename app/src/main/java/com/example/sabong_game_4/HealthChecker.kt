package com.example.sabong_game_4

import android.util.Log

object HealthChecker: IHealthChecker {
    override fun logFps() {
        Thread {
            var startTime = System.currentTimeMillis()
            var frameCount = 0
            while (true) {
                frameCount++
                if (System.currentTimeMillis() >= startTime + 1000) {
                    Log.i("HealthChecker", "fps: ${(frameCount / (System.currentTimeMillis() - startTime))}")
                    startTime = System.currentTimeMillis()
                    frameCount = 0
                }
            }
        }.start()
    }
}