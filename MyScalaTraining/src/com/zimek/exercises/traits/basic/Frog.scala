package com.zimek.exercises.traits.basic

class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "I am a frog"
  override def philosophize { println("Hi " + toString) }
}