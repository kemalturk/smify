package com.kemalturk.smifylib

import android.graphics.*
import android.graphics.drawable.Drawable

abstract class Face(width: Int, height: Int, bgColor: Int, secondColor: Int): Drawable() {

  var mBGPaint = Paint()
  var mMouthPaint = Paint()
  var mEyePaint = Paint()

  var minSide = 1f
  var strokeWidth = 0f

  init {

    minSide = when{

      width > height -> height.toFloat()
      width < height -> width.toFloat()
      else -> width.toFloat()

    }

    strokeWidth = minSide / 20

    mBGPaint.color = bgColor
    mBGPaint.style = Paint.Style.FILL
    mBGPaint.isAntiAlias = true

    mMouthPaint.color = secondColor
    mMouthPaint.isDither = true
    mMouthPaint.style = Paint.Style.STROKE
    mMouthPaint.strokeJoin = Paint.Join.ROUND
    mMouthPaint.strokeCap = Paint.Cap.ROUND
    mMouthPaint.strokeWidth = 10f
    mMouthPaint.pathEffect = CornerPathEffect(50f)
    mMouthPaint.isAntiAlias = true

    mEyePaint.color = secondColor
    mEyePaint.style = Paint.Style.FILL
    mEyePaint.isAntiAlias = true

  }

  override fun setAlpha(alpha: Int) {}

  override fun getOpacity(): Int {
    return PixelFormat.OPAQUE
  }

  override fun setColorFilter(colorFilter: ColorFilter?) {}
}