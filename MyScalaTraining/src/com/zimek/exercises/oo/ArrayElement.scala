package com.zimek.exercises.oo

class ArrayElement(val contents: Array[String]) extends Element {
  // val contents: Array[String] = conts //this is possible in Scala - override method with val with the same name
  //now val contents as class parameter will override Element's abstract contents method! (override methods by vals)
  final def demo() {
    println("ArrayElement's implementation invoked")
  }
}