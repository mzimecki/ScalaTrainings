package com.zimek.examples.lists

import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]) {
    val buf = new ListBuffer[Int] //This is a very efficient way to build lists
    val xs = List(1, 2, 4, 5)
    for (x <- xs) buf += x + 1
    buf.toList
  }
}