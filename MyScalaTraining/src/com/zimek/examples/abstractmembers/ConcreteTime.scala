package com.zimek.examples.abstractmembers

class ConcreteTime extends AbstractTime {
  var timeH: Int = 12
  var timeM: Int = 3
  def hour = timeH
  def hour_=(t: Int) { timeH = t }
  def minute = timeM
  def minute_=(m: Int) { timeM = m }
}

object Main {
  def main(args: Array[String]) {
    val conTime = new ConcreteTime()
    conTime.hour_=(15)
    conTime.minute_=(8)
    println(conTime.hour + ":" + conTime.minute)
  }
}