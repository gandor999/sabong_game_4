package com.example.sabong_game_4.custom

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.View
import android.widget.LinearLayout

class GandorView(context: Context): View(context), ICustomView {
    override fun setViewDimensions(width: Int, height: Int) {
        Log.d("Gandor", "resources.displayMetrics.widthPixels: ${resources.displayMetrics.widthPixels}")
        Log.d("Gandor", "resources.displayMetrics.heightPixels: ${resources.displayMetrics.heightPixels}")

        // add ratio conversion
        // was developing the dimensions on a Pixel 3a XL API 34
        layoutParams = LinearLayout.LayoutParams(150, 150)
    }

    override fun setBorderLine(backgroundColor: Int, borderColor: Int, lineWidth: Int) {
        background = GradientDrawable().apply {
            setColor(backgroundColor)
            setStroke(lineWidth, borderColor)
        }
    }
}