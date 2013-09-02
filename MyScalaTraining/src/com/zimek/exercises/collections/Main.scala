package com.zimek.exercises.collections

import scala.collection.immutable.Queue
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack

object Main {
	def main(args: Array[String]) {
	  //List
	  val colors = List("red", "blue", "green")
	  
	  //Array
	  val fiveInts = new Array[Int](5)
	  val fiveToOne = Array(5, 4, 3, 2, 1)
	  
	  //ListBuffer
	  val buf = new ListBuffer[Int]
	  buf += 1
	  buf += 2
	  
	  //ArrayBuffer
	  val buf2 = new ArrayBuffer[Int]()
	  buf2 += 1
	  
	  //Queue
	  val empty = Queue()
	  val has1 = empty.enqueue(1)
	  has1.enqueue(List(2, 3))
	  val has123 = has1.enqueue(List(2, 3))
	  val (element, has23) = has123.dequeue
	  
	  val q = new scala.collection.mutable.Queue[String]
	  q += "a"
	  q ++= List("b", "c")
	  q.dequeue
	  
	  //Stack
	  val stack = new Stack[Int] 
	  stack.push(1)
	  stack.top
	}
}