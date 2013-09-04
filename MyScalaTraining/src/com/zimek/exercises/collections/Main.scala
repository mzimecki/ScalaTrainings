package com.zimek.exercises.collections

import scala.collection.immutable.Queue
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack
import scala.collection.immutable.TreeSet
import scala.collection.immutable.TreeMap
import scala.collection.mutable.{ Map, SynchronizedMap, HashMap }

object Main {
  def main(args: Array[String]) {
    //List
    val colors = List("red", "blue", "green")

    //Array
    val fiveInts = new Array[Int](5)
    val fiveToOne = Array(5, 4, 3, 2, 1)

    //ListBuffer
    val buf = new ListBuffer[Int]
    buf += 1
    buf += 2

    //ArrayBuffer
    val buf2 = new ArrayBuffer[Int]()
    buf2 += 1

    //Queue
    val empty = Queue()
    val has1 = empty.enqueue(1)
    has1.enqueue(List(2, 3))
    val has123 = has1.enqueue(List(2, 3))
    val (element, has23) = has123.dequeue

    val q = new scala.collection.mutable.Queue[String]
    q += "a"
    q ++= List("b", "c")
    q.dequeue

    //Stack
    val stack = new Stack[Int]
    stack.push(1)
    stack.top

    //Set
    val text = "See Spot run. Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")
    val words = mutable.Set.empty[String]
    for (word <- wordsArray)
      words += word.toLowerCase

    //Maps
    val map = mutable.Map.empty[String, Int]
    map("hello") = 1
    println(map("hello"))
    println(countWords("See Spot run! Run, Spot. Run!"))

    //Default Set implementations
    //0 	scala.collection.immutable.EmptySet
    //1 	scala.collection.immutable.Set1
    //2 	scala.collection.immutable.Set2
    //3 	scala.collection.immutable.Set3
    //4 	scala.collection.immutable.Set4
    //5 or more 	scala.collection.immutable.HashSet

    //Default Map implementations
    //0 	scala.collection.immutable.EmptyMap
    //1 	scala.collection.immutable.Map1
    //2 	scala.collection.immutable.Map2
    //3 	scala.collection.immutable.Map3
    //4 	scala.collection.immutable.Map4
    //5 or more 	scala.collection.immutable.HashMap

    //Sorted Set and Map
    val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
    val cs = TreeSet('f', 'u', 'n')

    var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
    tm += (2 -> 'x')

    //Synchronized sets and maps
    val capital = MapMaker.makeMap
    capital += "US" -> "Washington"
    capital += "Paris" -> "France"
    capital += "Japan" -> "Tokyo"
    println(capital("Japan"))

    val synchroSet = new mutable.HashSet[Int] with mutable.SynchronizedSet[Int]

    //Initializing collections
    List(1, 2, 3)
    Set('a', 'b', 'c')
    mutable.Map("hi" -> 2, "there" -> 5)
    Array(1.0, 2.0, 3.0)
    val stuff = mutable.Set(42) //defining Set of ints (int type will be inferred)
    val anyStuff = mutable.Set[Any](42) //Set of Anys

    val colors3 = List("blue", "yellow", "red", "green")
    val treeSet = TreeSet[String]() ++ colors //initializing TreeSet unsing List
    treeSet.toList //will produce List with sorted elements
    treeSet.toArray //will produce Array with sorted elements

    val mutaSet = mutable.Set.empty ++ treeSet
    val immutaSet = Set.empty ++ mutaSet //converting mutable set into immutable

    val muta = mutable.Map("i" -> 1, "ii" -> 2)
    val immu = Map.empty ++ muta //converting mutable map into immutable map
    
    //Tuples
    val longest = longestWord("The quick brown fox".split(" "))
    println(longest)
    println(longest._1)
    println(longest._2)
    val (word, idx) = longest
  }
  
  /**
   * Returns a tuple.
   */
  def longestWord(words: Array[String]) = {
    var word = words(0)
    var idx = 0
    for (i <- 1 until words.length)
      if (words(i).length > word.length) {
        word = words(i)
        idx = i
      }
    (word, idx)
  }

  def countWords(text: String) = {
    val counts = mutable.Map.empty[String, Int]
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }
}

/**
 * Returns synchronized Map (just mixin SynchronizedMap trait.
 */
object MapMaker {

  def makeMap: Map[String, String] = {

    new HashMap[String, String] with SynchronizedMap[String, String] {

      //will be called when queried with a non-existent key
      override def default(key: String) =
        "Why do you want to know?"
    }
  }
}