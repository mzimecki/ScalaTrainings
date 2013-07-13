package com.zimek.exercises.traits.stackable

trait Doubling extends IntQueue { //it means that this trait can be mixed in only into IntQueues objects
  abstract override def put(x: Int) { super.put(2 * x) } //this is possible in traits only!!!
}