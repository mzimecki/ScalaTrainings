package com.zimek.exercises.oo

/**
 * Chapter 10 examples
 */
abstract class Element {
  //these are parameterless methods - no parameters and they are reading only mutable state (contents) without changing it
  //they can be defined as val's as well so that they shouldn't change mutable state
  // it is encouraged style in Scala to define methods that take no parameters and have no side effects as parameterless methods, i.e., leaving off the empty parentheses 
  //on the other hand, you should never define a method that has side-effects without parentheses
  //def height(): Int, are called empty-paren methods. They have ()
  def contents: Array[String] //abstract method - no abstract keyword is needed, returns Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}