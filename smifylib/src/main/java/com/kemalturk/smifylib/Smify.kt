package com.kemalturk.smifylib

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View

class Smify: View {

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

    val a = context?.obtainStyledAttributes(attrs, R.styleable.Smify, defStyleAttr, defStyleRes)

    try {



      a?.recycle()
    }catch (e: Exception){
      Log.e("Smify err", e.message)
    }

  }

  override fun draw(canvas: Canvas?) {
    super.draw(canvas)



  }



}