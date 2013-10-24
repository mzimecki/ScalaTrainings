package com.zimek.excersises.actors

import java.net.{ InetAddress, UnknownHostException }
import scala.actors.Actor
import scala.actors.Actor._

/**
 * This approach is so effective that if every actor in a program uses react instead of receive,
 * only a single thread is necessary in principle to host all of the program's actors
 * (to be sure, if your computer has several processor cores, the actors subsystem will use enough threads to utilize all cores when it can).
 * 
 * Here an actor that calls react instead of receive
 */
object NameResolver extends Actor {

  def act() {
    react {
      case (name: String, actor: Actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver exiting.")
        exit
      case msg =>
        println("Unhandled message: " + msg)
        act()
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }
}

object MainNameRes {
  def main(args: Array[String]): Unit = {
    NameResolver.start
    NameResolver !(("www.wp.pl", self))
    println(self.receiveWithin(100){case x => x})
    NameResolver !(("www.onet.pl", self))
    println(self.receiveWithin(100){case x => x})
    NameResolver ! "EXIT"
    
  }
}