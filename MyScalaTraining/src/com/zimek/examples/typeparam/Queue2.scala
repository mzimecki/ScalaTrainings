package com.zimek.examples.typeparam

/**
 * Hiding implementation here is done by:
 * Another, more radical way is to hide the class itself and only export a trait that reveals the public interface of the class.
 */
trait Queue2[T] {
  def head: T
  def tail: Queue2[T]
  def append(x: T): Queue2[T]
}

object Queue2 {
  
      def apply[T](xs: T*): Queue2[T] = 
        new QueueImpl[T](xs.toList, Nil)
  
      private class QueueImpl[T](
        private val leading: List[T],
        private val trailing: List[T]
      ) extends Queue2[T] {
  
        def mirror = 
          if (leading.isEmpty)
            new QueueImpl(trailing.reverse, Nil)
          else 
            this
  
        def head: T = mirror.leading.head
  
        def tail: QueueImpl[T] = {
          val q = mirror
          new QueueImpl(q.leading.tail, q.trailing)
        }
  
        def append(x: T) = 
          new QueueImpl(leading, x :: trailing)
      }
    }