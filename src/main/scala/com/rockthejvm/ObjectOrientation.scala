package com.rockthejvm

object ObjectOrientation extends App {
  // class and instance
  class Animal {
    val age: Int = 0

    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  // inheritance
  class EDog(name: String) extends Animal

  val eDog = new EDog("Bush") //constructor argument is NOT fields

  // so eDog.name will be compile error
  // How to make a field from constructor argument
  class Dog(val name: String) extends Animal

  val aDog = new Dog("Bush")
  print(aDog.name)

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // จะเอา eat() จาก Class Animal มา เว้นแต่ว่า ถ้ามีการ override จาก Dog ก็จะเอาจาก Dog

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true

    def walk(): Unit
  }

  // interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  // single-class inheritance + multi-trait "mixing" (interfaces)
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I'm eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only for method with ONE argument
  aCroc ?! "Am I full now?"

  // operators is actually methods
  val basicMath = 1 + 2
  val anotherMath = 1.+(2)

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm gonna eat everything")
  }
  /*
  What compiler doo
  class Carnivore_Anonymous_24243 extends Carnivore {
    override def eat(animal: Animal): Unit = println("I'm gonna eat everything")
  }
  val dinosaur = new Carnivore_Anonymous_24243
   */

  // singleton object
  object MySingleton {
    val mySpecialValue = 3.14125
    def mySpecialMethod():Int = 22/7
    def apply(x: Int):Int = x + 1
  } // the only instance of it is itself

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  // ออกแบบ singleton object ชื่อเดียวกับ class,trait ใน file เดียวกันก็ได้ เรียก companions
  object Animal {
    // companions can access each other's private fields/methods
    // singletone Animal and instances of Animall are different things
    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // acdess via singleton object, not class instance

  /*
  case classes = lightweight data structures with some boilerplate
  - sensible equals and hash code
  - serialization
  - companion with appy
   */
  case class Person(name: String, age:Int)
  val bob = new Person("Bob", 54) // can instantiate without new
  // = Person.apply("Bob", 54)

  // exceptions like Java but slightly different in catch phrase
  try {
    val x:String = null
    x.length // the bad code
  } catch { // in Java : catch(Exception e) {...}
    case e: Exception => "You've made some mistake for sure!"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }
  val aList:List[Int] = List(1,2,3) //List.apply(1,2,3)
  val first = aList.head  // มาจาก list
  val rest = aList.tail   // มาจาก list
  val aStringList = List("hello","Scala")
  val firstStr = aStringList.head // มาจาก list ตรงๆ ไม่ได้มาจาก Generics Type T

  // Point #1 : in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
  benefits :
  1) works miracles in multithreaded / distributed env
  2) helps making sens of the code ("reasoning about")
   */
  val reversedList = aList.reverse // return as a New list

  // Point #2 : Scala is closest to the OO ideal
}

