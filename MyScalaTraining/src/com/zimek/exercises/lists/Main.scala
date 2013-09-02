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

    val lst = List(1, 3) ::: List(4, 5) //concatenation of lists
    for (l <- lst) {
      print(l + " ")
    }

    println()
    println(append(List(1, 4), List(5, 6, 7)))

    println(z.head)
    println(z.tail) //returns a list consisting of all elements except the first
    println(z.last)
    println(z.init) //returns a list without last element
    println(z.reverse)
    println(z.take(1))
    println(z.drop(1))
    println(z.splitAt(1))
    println(z.indices)
    println(z.zip(lst))
    println(z.mkString("[", ",", "]"))
    println(z.toArray)

    println(List(1, 2, 3) map (x => x + 1))
    println(List(1, 2, 3) map (_ + 1))
    val words = List("test", "bla", "b")
    println(words map (x => x.length()))
    println(words map (_.length))
    println(words map (_.toList.reverse.mkString))
    var sum = 0
    List(1, 2, 3, 4, 5) foreach (sum += _)
    println(sum)

    /**
     * For each element of list (1, 2, 3, 4):
     * 1) 1 => (1,1) gives empty list () so no result for 1
     * 2) 2 => (1) map 1 => (2, 1) - range (1, 2) gives (1)
     * 3) 3 => (1,2) map 1 = > (3, 1)
     * 3) 3 => (1,2) map 2 = > (3, 2)
     * 4) 4 => (1,2,3) map 1 = > (4, 1)
     * 4) 4 => (1,2,3) map 2 = > (4, 2)
     * 4) 4 => (1,2,3) map 3 = > (4, 3)
     * List((2,1), (3,1), (4, 1), (4, 2), (4,3))
     */
    println(List.range(1, 5) flatMap (
      i => List.range(1, i) map (j => (i, j))))

    //The same as above with for loops and yield      
    println(for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j))

    //filtering
    println()
    println(List(1, 2, 3, 4, 5) filter (_ % 2 == 0))
    println(words filter (_.length == 3))
    println(List(1, 2, 3, 4, 5) partition (_ % 2 == 0))
    println(List(1, 2, 3, 4, 5) find (_ % 2 == 0))
    println(List(1, 2, 3, -4, 5) takeWhile (_ > 0))
    println(words dropWhile (_ startsWith "t"))
    println(List(1, 2, 3, -4, 5) span (_ > 0))

    //sorting
    println(List(1, -3, 4, 2, 6) sortWith (_ < _))

    println(List.range(1, 10, 2))
    println(List.make(4, "hi"))
    val xss =
      List(List('a', 'b'), List('c'), List('d', 'e'))
    println(List.flatten(xss))
    println(List.concat(List('a', 'b'), List('c')))
    println(List.map2(List(10, 20), List(3, 4, 5)) (_ * _))
    println(List.forall2(List("abc", "de"), List(3, 2)) (_.length == _))
    println(List.exists2(List("abc", "de"), List(3, 2)) (_.length != _))

  }

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }

  def hasZeroRow(m: List[List[Int]]) =
    m exists (row => row forall (_ == 0))

  def sum(xs: List[Int]): Int = (0 /: xs)(_ + _)
}
