package com.zimek.exercises.filematcher

import java.io.PrintWriter
import java.io.File

/**
 * Examples from chapter 8.
 */
object FileMatcher {
	private def filesHere = (new java.io.File(".")).listFiles

	//reducing code redundancy
	private def filesMatching(matcher: String => Boolean) =
		for (file <- filesHere; if matcher(file.getName))
			yield file

	def filesEnding(query: String) =
		filesMatching(_.endsWith(query))

	def filesContaining(query: String) =
		filesMatching(_.contains(query))

	def filesRegex(query: String) =
		filesMatching(_.matches(query))

	//exists function - simplifying its argument
	def containsNeg2(nums: List[Int]) = nums.exists((x: Int) => x < 0)
	def containsNeg3(nums: List[Int]) = nums.exists((x) => x < 0)
	def containsNeg4(nums: List[Int]) = nums.exists(x => x < 0)
	def containsNeg5(nums: List[Int]) = nums.exists(_ < 0)

	//currying
	//arguments as 2 separate list
	def curriedSum(x: Int)(y: Int) = x + y

	//new control structures
	def twice(op: Double => Double, x: Double) = op(op(x))

	def withPrintWriter(file: File, op: PrintWriter => Unit) {
		val writer = new PrintWriter(file)
		try {
			op(writer)
		} finally {
			writer.close()
		}
	}

	def withPrintWriter2(file: File)(op: PrintWriter => Unit) { //arguments as 2 separate lists
		val writer = new PrintWriter(file)
		try {
			op(writer)
		} finally {
			writer.close()
		}
	}

	def main(args: Array[String]) {
		//curried functions call
		println(curriedSum(1)(2))
		val onePlus = curriedSum(1)_
		println(onePlus(3))

		println(twice(_ + 1, 2))

		//new control structures
		withPrintWriter(
			new File("date.txt"),
			writer => writer.println(new java.util.Date))

		println { "Hello, world!" } //{} can be used instead of () to pass function's argument if there is only one argument	

		val file = new File("date.txt")

		//in this call one parameter is in {} so it looks like new control structure
		withPrintWriter2(file) {
			writer => writer.println(new java.util.Date)
		}

		//by-name parameters

		var assertionsEnabled = true

			//without by-name parameters
			def myAssert(predicate: () => Boolean) =
				if (assertionsEnabled && !predicate())
					throw new AssertionError
		myAssert(() => 5 > 3) //strange call is then

			//by-name version
			def byNameAssert(predicate: => Boolean) =
				if (assertionsEnabled && !predicate)
					throw new AssertionError
		byNameAssert(5 > 3) //now we can omit () => //5 > 3 will be evaluated inside byNameAssert
			
			//with Boolean parameter
			def boolAssert(predicate: Boolean) =
				if (assertionsEnabled && !predicate)
					throw new AssertionError
		boolAssert(5 > 3) //5 > 3 will be evaluated before boolAssert call 
		//this means if assertionEnabled = false then
		//byNameAssert(x / 0 == 0) will not raise an exception while
		//boolAssert(x / 0 == 0) will raise exception
		

	}
}