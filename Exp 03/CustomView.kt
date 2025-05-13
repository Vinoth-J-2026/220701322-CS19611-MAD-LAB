package com.example.madexp_3322

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

open class CustomView(context: Context?) : View(context) {
    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        var paint =Paint()
        var textpaint=Paint()
        textpaint.color=Color.BLACK
        textpaint.textSize=50f
        paint.style=Paint.Style.FILL

        canvas.drawText("Circle",200f,350f,textpaint)
        paint.color=Color.parseColor("#ff0000")
        canvas.drawCircle(250F,600F,200F,paint)

        canvas.drawText("Rectangle",700f,350f,textpaint)
        paint.color=Color.parseColor("#fff000")
        canvas.drawRect(600F,400F,1000F,1000F,paint)

        canvas.drawText("Square",200f,1150f,textpaint)
        paint.color=Color.parseColor("#0000FF")
        canvas.drawRect(100f,1200f,400f,1500f,paint)

        canvas.drawText("Line",750f,1150f,textpaint)
        paint.color=Color.parseColor("#000000")
        canvas.drawLine(800f,1200f,800f,1500f,paint)
    }

}

