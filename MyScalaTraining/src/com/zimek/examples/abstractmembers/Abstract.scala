package com.zimek.examples.abstractmembers

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T //abstract val
  var current: T //abstract var
}