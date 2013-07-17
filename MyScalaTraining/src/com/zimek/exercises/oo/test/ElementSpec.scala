package com.zimek.exercises.oo.test

import org.scalatest.Spec
import com.zimek.exercises.oo.Element.elem

class ElementSpec extends Spec { //behavior-driven development (BDD) testing style

  describe("A UniformElement") {

    it("should have a width equal to the passed value") {
      val ele = elem('x', 2, 3)
      assert(ele.width === 2)
    }

    it("should have a height equal to the passed value") {
      val ele = elem('x', 2, 3)
      assert(ele.height === 3)
    }

    it("should throw an IAE if passed a negative width") {
      intercept[IllegalArgumentException] {
        elem('x', -2, 3)
      }
    }
  }
}