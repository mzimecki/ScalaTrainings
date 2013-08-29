package com.zimek.exercises.lists

object Main {
  def main(args: Array[String]) {
    val fruit: List[String] = List("apples", "oranges", "pears")
    val nums: List[Int] = List(1, 2, 3, 4)
    val diag3: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1))
    val empty: List[Nothing] = List()

    val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
    val nums2 = 1 :: (2 :: (3 :: (4 :: Nil)))
    val diag32 = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
    val empty2 = Nil

    val z = "a" :: ("b", "c") :: "f" :: Nil
    for (s <- z) {
      println(s)
    }
    
    println(z.head)
    println(z.tail) //returns a list consisting of all elements except the first
    
    val lst = List(1,3) ::: List(4,5) //concatenation of lists
    for(l <- lst)
    	print(l + " ")
    
  }
}
