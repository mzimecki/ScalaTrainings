package com.zimek.excersises.actors

import scala.actors.Actor._
import java.net.{ InetAddress, UnknownHostException }
import scala.actors.Actor

object GoodActorsStyle {

  def main(args: Array[String]) = {

    /**
     * 1. Actors should not block
     *
     * An actor that uses a helper actor to avoid blocking itself
     */
    val sillyActor2 = actor {
        def emoteLater() {
          val mainActor = self
          actor {
            Thread.sleep(1000)
            mainActor ! "Emote"
          }
        }

      var emoted = 0
      emoteLater()

      loop {
        react {
          case "Emote" =>
            println("I'm acting!")
            emoted += 1
            if (emoted < 5)
              emoteLater()
          case msg =>
            println("Received: " + msg)
        }
      }
    }

    sillyActor2 ! "hi there"

    /**
     * 2. Communicate with actors only via messages
     * 3. Prefer immutable messages - The best way to ensure that message objects are thread-safe is to only use immutable objects for messages
     */
  }
}

/**
 * 4. Make messages self-contained
 * 
 * Can the actor remember what it was doing when it made the request?
 * One way to simplify the logic of an actors program is to include redundant information in the messages.
 * 
 * WE may use: An actor that uses case classes for messages and put in the response message information from request message
 * to track for what request the result was received by others actors.
 */
case class LookupIP(name: String, respondTo: Actor)
case class LookupResult(name: String, address: Option[InetAddress])

object NameResolver2 extends Actor {

  def act() {
    loop {
      react {
        case LookupIP(name, actor) =>
          actor ! LookupResult(name, getIp(name))
      }
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