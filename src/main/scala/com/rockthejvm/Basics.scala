package com.rockthejvm

object Basics extends App {
  //defining a value
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42;
  //  Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type inference
  val aString = "ฉันรักสกาลา"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  //  Interpolation string, ~ GString in groovy
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //  think in term of expression, not machine instructions
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  //  code block is one of the main expression
  //  must be return something!
  val aCodeBlock = {
    val aLocalValue = 67
    aLocalValue + 3 // value of the last expression will be returned
  }

  // define a funstion
  def myFuntion(x: Int, y: String): String = {
    y + " " + x
  }

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /*
  factorial(5) = 5 * factorial(4) = 5 * 4
  factorial(4) = 4 * factorial(3) = 4 * 3
  factorial(3) = 3 * factorial(2) = 3 * 2
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
   */

  // in Scala we don't use loops or iteration, we use RECURSION!

  //  the Unit type = no meaningful value === "void" in other lang
  print("I love scala")

  // this expression has type of SIDE EFFECTS, and return Unit
  // System.out.println, printf, print, console.log will do the same
  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()
}

