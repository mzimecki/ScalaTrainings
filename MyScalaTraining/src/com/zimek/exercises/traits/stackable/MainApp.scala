package com.zimek.exercises.traits.stackable

object MainApp {
  def main(args: Array[String]) {
    val queue2 = new BasicIntQueue with Incrementing with Filtering //order of mixing traits is significant
    queue2.put(-1); queue2.put(0); queue2.put(1)
    println(queue2.get)
    println(queue2.get)
  }
}