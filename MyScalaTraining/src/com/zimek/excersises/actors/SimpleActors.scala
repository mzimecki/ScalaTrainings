package com.zimek.excersises.actors

import scala.actors.Actor
import scala.actors.Actor._

/**
 * Default and simple usage of actors.
 */
object SillyActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("I'm acting")
      Thread.sleep(1000)
    }
  }
}

object SeriousActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("To be or not to be")
      Thread.sleep(1000)
    }
  }
}

object MainApp {

  def main(args: Array[String]): Unit = {
    val seriousActor2 = actor {
      for (i <- 1 to 5) {
        println("That's the question")
        Thread.sleep(1000)
      }
    }

    val echoActor = actor {
      while (true) {
        receive {
          case msg => println("received message: " + msg)
        }
      }
    }

    val intActor = actor {
      while (true) {
        receive {
          case x: Int => println("Got an int: " + x)
        }
      }
    }

    //SillyActor.start
    //SeriousActor.start
    echoActor ! "hi there"
    intActor ! 5
    intActor ! 5.5
  }
}