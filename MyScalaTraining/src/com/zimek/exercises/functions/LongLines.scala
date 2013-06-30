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
		
		//partially applied functions
		def sum(a: Int, b: Int, c: Int) = a + b + c
		val s = sum(1, _: Int, 3)
		println(s(2))
		
		//closures
		var more = 1
		val f = (x: Int) => x + more //more is not a parameter of a function but it is taken from functions environment (closing free variable)
		println(f(2))
		
		//repeated parameters
		def echo(args: String*) =
		  for(arg <- args)
		    print(arg + " ")
		echo("s", "F")
		val a = Array[String]("A", "F", "f")
		// this won't compile echo(a)
		echo(a: _*) //this is fine - but strange for me :)
		
		//tail recursion
		def bang(x: Int): Int = 
			if (x == 0) throw new Exception("bang!")
			else bang(x - 1)
		//bang(3) //this function is tail recursive since it has as a last call in its body the recursive call
				//then compiler optimizes it and exception is thrown during first call! so it is as efficient as while loop
				//it does not work with indirect call to the function it starts (recursion by using other function which 
				//calls back the first function)
				//it does not work on function values as well for e.g. val f = bang _ 
	}
} 