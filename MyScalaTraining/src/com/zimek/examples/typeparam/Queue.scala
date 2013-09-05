package com.zimek.examples.typeparam

/**
 * Hiding implementation here is done by hiding default constructor
 * and providing companion object with factory method.  
 */
class Queue[T] private ( //private here hides default constructor
    private val leading: List[T],
    private val trailing: List[T]) {

  private def mirror =
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def append(x: T) =
    new Queue(leading, x :: trailing)
}

//factory method that builds Queue (default constructor is hidden in Queue class)
object Queue {
  // constructs a queue with initial elements `xs'
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

object Main {
  def main(args: Array[String]) {
    val q = Queue(List(1, 2)) //this will call apply method from Queue object
  }
}