package com.zimek.examples.abstractmembers.enums

object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

object Color2 extends Enumeration {
  val Red, Green, Blue = Value
}

object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}

object Main {
	def main(args: Array[String]) {
		println(Direction.East.id)
		println(Direction(2))
	}
}