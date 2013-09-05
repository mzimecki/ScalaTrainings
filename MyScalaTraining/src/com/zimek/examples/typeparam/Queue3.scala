package com.zimek.examples.typeparam

/**
 * As an example, suppose there is a class Fruit with two subclasses, Apple and Orange. 
 * With the new definition of class Queue, it is possible to append an Orange to a Queue[Apple]. The result will be a Queue[Fruit]
 */
class Queue3[+T] private ( 
    private val leading: List[T],
    private val trailing: List[T]) {

  private def mirror =
    if (leading.isEmpty)
      new Queue3(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new Queue3(q.leading.tail, q.trailing)
  }

  def append[U >: T](x: U) = //"U >: T", defines T as the lower bound for U. As a result, U is required to be a supertype of T
        new Queue3[U](leading, x :: trailing)
}

object Queue3 {
  // constructs a queue with initial elements `xs'
  def apply[T](xs: T*) = new Queue3[T](xs.toList, Nil)
}
