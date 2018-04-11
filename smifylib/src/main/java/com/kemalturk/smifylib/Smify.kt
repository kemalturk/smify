package com.kemalturk.smifylib

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.kemalturk.smifylib.faces.FaceType1

class Smify: View {

  var w = 0
  var h = 0
  var face: Face? = null

  var bgColor = 0
  var secondColor = 0

  private var typeSelect = 0

  constructor(context: Context?) : super(context){
    init(context, null, 0, 0)
  }
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
    init(context, attrs, 0, 0)
  }
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
    init(context, attrs, defStyleAttr, 0)
  }


  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes){
    init(context, attrs, defStyleAttr, defStyleRes)
  }

  private fun init(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int){

    val a = context!!.obtainStyledAttributes(attrs, R.styleable.Smify, defStyleAttr, defStyleRes)

    try {

      typeSelect = a.getInt(R.styleable.Smify_type, 1)
      bgColor = a.getColor(R.styleable.Smify_bgcolor, Color.parseColor("#FFCF17"))
      secondColor = a.getColor(R.styleable.Smify_secondcolor, Color.parseColor("#6A4500"))

      a?.recycle()
    }catch (e: Exception){
      Log.e("Smify error", e.message)
    }

  }

  override fun draw(canvas: Canvas?) {
    super.draw(canvas)

    if (face != null){

      canvas?.save()
      face?.draw(canvas)
      canvas?.restore()

    }


  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    w = MeasureSpec.getSize(widthMeasureSpec)
    h = MeasureSpec.getSize(heightMeasureSpec)

    selectFaceType(typeSelect)

  }

  private fun selectFaceType(p0: Int){

    face = when(p0){
      1 -> FaceType1(w, h, bgColor, secondColor)
      else -> FaceType1(w, h, bgColor, secondColor)
    }

  }



}