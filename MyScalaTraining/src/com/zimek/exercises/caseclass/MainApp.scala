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

  def wildcardPattern(expr: Expr) = expr match {
    case BinOp(op, left, right) => println(expr + "is a binary operation")
    //op, left, right can be replaced by _
    //case BinOp(_, _, _) => println(expr +"is a binary operation")
    case _ => println("It's something else")
  }

  def constantPattern(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  def variablePattern(expr: Int) = expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  def constructorPattern(expr: Expr) = expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }

  def sequencePattern(expr: List[Int]) = expr match {
    case List(0, _*) => println("found it") //checks if there is List with 0 at first place and _* says that you do not care about length
    case List(0, _, _) => println("found it 2") //3 element list with 0 at the beginning
    case _ =>
  }

  def tuplePattern(expr: Any) = expr match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ =>
  }

  def typedPattern(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }
}

