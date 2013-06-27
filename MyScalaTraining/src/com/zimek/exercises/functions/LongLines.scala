package com.zimek.exercises.functions

import scala.io.Source

/**
 * Chapter 8.
 */
object LongLines {
	def processFile(filename: String, width: Int) {

		def processLine(line: String) { //local function - it has acces to outer function parameters
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
		val width = args(0).toInt
		for (arg <- args.drop(1))
			LongLines.processFile(arg, width)
	}
} 