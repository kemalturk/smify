package com.kemalturk.smifylib.faces

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import com.kemalturk.smifylib.Face

class FaceType1(w: Int, h: Int, bgColor: Int, secondColor: Int): Face(w, h, bgColor, secondColor) {

  var centerW = 0f
  var centerH = 0f

  init {

    centerW = w / 2f
    centerH = h / 2f

  }

  override fun draw(canvas: Canvas?) {

    canvas?.drawCircle(centerW, centerH, minSide / 2, mBGPaint) // BG Circle

    drawEye(canvas, mEyePaint, "left")

    drawEye(canvas, mEyePaint, "right")

    drawMouth(0, canvas, mMouthPaint)

  }

  private fun drawEye(canvas: Canvas?, paint: Paint, direction: String){

    val oval = when(direction){
      "left" -> RectF(centerW - (minSide/3.5f), centerH - (minSide/4),
          centerW - (minSide/10), centerH - (minSide/40))

      "right" -> RectF(centerW + (minSide/10), centerH - (minSide/4),
          centerW + (minSide/3.5f), centerH - (minSide/40))

      else -> null
    }

    val path = Path()

    path.addOval(oval, Path.Direction.CW)
    canvas?.drawPath(path, paint)

  }

  private fun drawMouth(curveRadius: Int, canvas: Canvas?, paint: Paint){

    println("minSide : $minSide")

    val oval1 = RectF(centerW - (minSide/4), centerH + (minSide/54), centerW + (minSide/4), centerH + (minSide/6))
    val oval2 = RectF(centerW - (minSide/4), centerH + (minSide/21.6f), centerW + (minSide/4), centerH + (minSide/9))


    val path = Path()
    path.arcTo(oval1, 0f, 180f)
    path.close()

    val path2 = Path()
    path2.addArc(oval2, 0f, 180f)
    path2.close()

    canvas?.drawPath(path, paint)
    canvas?.drawPath(path2, mBGPaint)






  }

}