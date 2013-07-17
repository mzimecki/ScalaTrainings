package com.zimek.exercises.oo.test

import org.scalatest.FunSuite
import com.zimek.exercises.oo.Element.elem

class ElemSuiteFun extends FunSuite {
  test("elem result should have passed width") {
    val ele = elem('x', 5, 3)
    //assert(ele.width === 2) //=== this will give additional reason massage on fail
    expect(2) { //or use expect which also will give additional reason message on fail
      ele.width
    }
    //intercept[IllegalArgumentException] { //to test whether exception will be thrown
    //  elem('x', -2, 3)
    //}
  }
}