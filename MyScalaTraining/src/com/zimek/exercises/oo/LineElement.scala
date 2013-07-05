package com.zimek.exercises.oo

class LineElement(val s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1

}