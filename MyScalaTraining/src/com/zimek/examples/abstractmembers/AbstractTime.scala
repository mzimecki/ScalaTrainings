package com.zimek.examples.abstractmembers

trait AbstractTime {
  def hour: Int // getter for `hour'
  def hour_=(x: Int) // setter for `hour'
  def minute: Int // getter for `minute'
  def minute_=(x: Int) // setter for `minute'
}