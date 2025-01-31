package com.example.sabong_game_4.custom

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.example.sabong_game_4.MainActivity

@RequiresApi(Build.VERSION_CODES.R)
open class GandorView(context: Context) : View(context), ICustomView {
    var scaledWidth: Int? = null
    var scaledHeight: Int? = null

    override fun setViewDimensions(width: Int, height: Int, toScale: Boolean) {
        // was developing the dimensions on a Pixel 3a XL API 34
        // ratio is (150 / 2160) = (x / widthPixels) => x = (150 * widthPixels / 2160)
        // no need to convert dp and such

        val phoneWidth = resources.displayMetrics.widthPixels

        scaledWidth = if (toScale) ((width * phoneWidth) / 2160) else width
        scaledHeight = if (toScale) ((height * phoneWidth) / 2160) else height

        layoutParams = ViewGroup.LayoutParams(
            scaledWidth!!,
            scaledHeight!!
        )

        requestLayout()
    }

    override fun setBorderLine(backgroundColor: Int, borderColor: Int, lineWidth: Int) {
        background = GradientDrawable().apply {
            setColor(backgroundColor)
            val phoneWidth = resources.displayMetrics.widthPixels
            setStroke(
                (lineWidth * phoneWidth) / 2160,
                borderColor
            )

            requestLayout()
        }
    }
}