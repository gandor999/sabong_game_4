package com.example.sabong_game_4.custom

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.LinearLayout

open class GandorView(context: Context) : View(context), ICustomView {
    override fun setViewDimensions(width: Int, height: Int) {
        // was developing the dimensions on a Pixel 3a XL API 34
        // ratio is (150 / 2160) = (x / widthPixels) => x = (150 * widthPixels / 2160)
        layoutParams = LinearLayout.LayoutParams(
            (width * resources.displayMetrics.widthPixels) / 2160,
            (height * resources.displayMetrics.heightPixels) / 1020
        )
    }

    override fun setBorderLine(backgroundColor: Int, borderColor: Int, lineWidth: Int) {
        background = GradientDrawable().apply {
            setColor(backgroundColor)
            setStroke(lineWidth, borderColor)
        }
    }
}