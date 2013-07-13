package com.zimek.exercises.traits

class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

abstract class Component extends Rectangular {
  // other methods...
}

class Rectangle(val topLeft: Point, val bottomRight: Point)
  extends Rectangular {

  // other methods...
}