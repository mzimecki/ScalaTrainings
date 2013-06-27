package com.zimek.exercises.rational

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

/**
 * Chapters 1 - 7 code examples.
 */
object MainApp {
  
  //this allows for implicit conversion of integers into rationals
  implicit def intToRational(x: Int) = new Rational(x)
  
  def main(args: Array[String]) {
    val r = new Rational(1, 3)
    val r2 = new Rational(1, 2)
    val r3 = new Rational(8, 4)
    val r4 = new Rational(22, 33)
    
    println(r + r2)
    println(r2 + 1)
    println(r3)
    println(r4)
    println(r * r2)
    println(r / 3)
    
    println(2 * r)
    
    //if statements
    val test = if (r.denom == 3) r else r3
    
    //for expression
    val filesHere = (new java.io.File(".")).listFiles
  
    for (file <- filesHere)
      println(file)
      
    for (i <- 1 to 4)
      println("Iter: " + i)
    
    for (i <- 1 until 4)
      println("Iter: " + i)
    
    //filtering
    for (file <- filesHere if file.getName().startsWith("b"))
      println(file)
      
    for (file <- filesHere 
        if file.isFile(); 
    	if file.getName().endsWith("h")
    ) println(file)
    
    //Exceptions
    val n = 2
    val half =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
    
    //in scala we do not have to catch checked exceptions!
    try {
      val f = new FileReader("r.txt")
    } catch {
      case ex: FileNotFoundException => println("File not found!")
      case ex: IOException => println("I/O Excep")
    }
    
    println(multiTable)
  }
  
  // Returns a row as a sequence
    def makeRowSeq(row: Int) =
      for (col <- 1 to 10) yield {
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
      }
  
    // Returns a row as a string
    def makeRow(row: Int) = { println(makeRowSeq(row).mkString); makeRowSeq(row).mkString}
  
    // Returns table as a string with one row per line
    def multiTable() = {
  
      val tableSeq = // a sequence of row strings
        for (row <- 1 to 10)
        yield makeRow(row)
  
      tableSeq.mkString("\n")
    }
}
