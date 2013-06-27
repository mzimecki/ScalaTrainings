package com.zimek.exercises.rational

class Rational(n: Int, d: Int) {
	require(d != 0)

	private val g = gdc(n.abs, d.abs)
	val numer: Int = n / g
	val denom: Int = d / g

	def this(n: Int) = this(n, 1) //auxiliary constructor

	override def toString = if (denom == 1) numer.toString else numer + "/" + denom

	def +(that: Rational): Rational =
		new Rational(numer * that.denom + that.numer * denom,
			denom * that.denom)

	def +(i: Int): Rational =
		new Rational(numer + i * denom, denom)

	def -(that: Rational): Rational =
		new Rational(numer * that.denom - that.numer * denom,
			denom * that.denom)

	def -(i: Int): Rational =
		new Rational(numer - i * denom, denom)

	def *(that: Rational): Rational =
		new Rational(numer * that.numer, denom * that.denom)

	def *(i: Int): Rational =
		new Rational(numer * i, denom)

	def /(that: Rational): Rational =
		new Rational(numer * that.denom, denom * that.numer)

	def /(i: Int): Rational =
		new Rational(numer, denom * i)

	private def gdc(a: Int, b: Int): Int =
		if (b == 0) a else gdc(b, a % b)
}


