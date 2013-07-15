package com.zimek.exercises.traits.stackable

trait Decrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x - 1) }
}

object MainApp {
  def main(args: Array[String]) {
    val queue2 = new BasicIntQueue with Incrementing with Filtering //order of mixing traits is significant
    val decQueue = new BasicIntQueue with Decrementing
    queue2.put(-1); queue2.put(0); queue2.put(1)
    println(queue2.get)
    println(queue2.get)
    
    decQueue.put(3)
    decQueue.put(0)
    println(decQueue.get)
    println(decQueue.get)
  }
}