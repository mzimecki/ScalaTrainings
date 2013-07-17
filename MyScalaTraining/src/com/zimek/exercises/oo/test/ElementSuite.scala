package com.zimek.exercises.oo.test

import org.scalatest.Suite
import com.zimek.exercises.oo.Element.elem

class ElementSuite extends Suite {
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}