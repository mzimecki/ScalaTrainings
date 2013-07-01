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

	def main(args: Array[String]) {
		//curried functions call
		println(curriedSum(1)(2))
		val onePlus = curriedSum(1)_
		println(onePlus(3))

		println(twice(_ + 1, 2))
		
		withPrintWriter(
			new File("date.txt"),
			writer => writer.println(new java.util.Date))

	}
}