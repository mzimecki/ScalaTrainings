package com.zimek.exercises.caseclass

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr

/**
 * Case classes and pattern matching.
 */
object MainApp {
  def main(args: Array[String]) {
    val v = Var("x") //it's case class so "new" keyword is not needed
    val op = BinOp("+", Number(1), v) //looks nice when nested
    println(v.name) //class parameters are implicitly get vals so they are accessible
    println(op.right == Var("x")) //the compiler adds "natural" implementations of methods toString, hashCode, and equals
  }

  def simplifyTop(expr: Expr): Expr = expr match {
    //e is a variable of Expr and can be any Expr  
    case UnOp("-", UnOp("-", e)) => e // Double negation
    case BinOp("+", e, Number(0)) => e // Adding zero
    case BinOp("*", e, Number(1)) => e // Multiplying by one
    case _ => expr
  }
}

