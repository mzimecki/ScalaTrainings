package com.zimek.examples.abstractmembers

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
}

//Pre-initialized fields in an object definition
object twoThirds extends {
  val numerArg = 2
  val denomArg = 3
} with RationalTrait

object MainObj {
  def main(args: Array[String]) {

    //instantiate RationalTrait with implementation of abstract vals
    //its like implementation of interface in java via anonymous class
    val t = new RationalTrait {
      val numerArg = 1
      val denomArg = 2
    }

    println(t.denomArg)
  }
}

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g //initialization of numer will be deferred until the first time numer is used.
  lazy val denom = denomArg / g
  override def toString = numer + "/" + denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
