package com.zimek.exercises.functions

import scala.io.Source

/**
 * Chapter 8.
 */
object LongLines {
	def processFile(filename: String, width: Int) {

		def processLine(line: String) { //local function - it has access to outer function parameters
			if (line.length > width)
				println(filename + ": " + line.trim)
		}

		val source = Source.fromFile(filename)
		for (line <- source.getLines)
			processLine(line)
	}
}

object FindLongLines {
	def main(args: Array[String]) {
		
		var increase = (x: Int) => x + 1 //function literal assigned to var
		
		var increase2 = (x: Int) => {
			println("one")
			println("two")
			x + 1
		}
						
		val width = args(0).toInt
		for (arg <- args.drop(1))
			LongLines.processFile(arg, width)
			
		val l = List[Int](1, 2, 3, 4, 5)
		l.foreach((x: Int) => print(" " + (x + 1))) //function literal used as argument of other function
		print("\n")
		l.filter((x: Int) => x > 3).foreach(println)
		l.filter(x => x > 3).foreach(println) //shorter form of function literal (target typing) - type of x is inferred
		l.filter(_ > 2).foreach(println) // placeholder syntax
		l.filter((_: Int) > 2).foreach(println) // placeholder syntax
	}
} 