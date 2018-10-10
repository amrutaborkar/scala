object ScalaCourse {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  List("Hello", "World").mkString("", ", ", "!")  //> res0: String = Hello, World!

  object MySingleton
  val x = 3                                       //> x  : Int = 3

  object MySingleton1 {
    def foo(x: Int) = x + 2
  }

  MySingleton1.foo(4)                             //> res1: Int = 6

  class Employee(fname: String, lastname: String, dept: Department) //Default ctor
  {
    //Secondary ctor
    def this(fname: String, lname: String) = this(fname, lname, new Department("Toys"))

  }
  class Department(name: String)

  case class Country(name: String, capital: String)

  val denmark = new Country("Denmark", "cap")     //> denmark  : ScalaCourse.Country = Country(Denmark,cap)
  println(denmark.name)                           //> Denmark
  val copyCountry = denmark.copy(capital = "copy")//> copyCountry  : ScalaCourse.Country = Country(Denmark,copy)
  //println(denmark.capital) COMPILE ERROR

  //-5.abs
  //println((100 to 1 by -1)

  def add(x: Int, y: Int) = {
    if (x > 10) (x + y).toString
    else x + y
  }                                               //> add: (x: Int, y: Int)Any

  add(11, 4)                                      //> res2: Any = 15
  add(3, 4)                                       //> res3: Any = 7

  def testPrime(n: Int) =
    if (n == 1) false
    else if (n == 2) true
    else {
      var result = true
      for (x <- 2 to n / 2) {
        if (n % x == 0) {
          result = false
        }
      }
      result
    }                                             //> testPrime: (n: Int)Boolean

  testPrime(3)                                    //> res4: Boolean = true

  //def add(x:Int):Int = ???     RETURN NOTIMPLEMENTED Error
  //add(2)

  //INFIX operator
  //method with one argument can be called as infirx operator
  1.+(2)                                          //> res5: Int(3) = 3
  1 + 2                                           //> res6: Int(3) = 3

  // object is a singleton
  object MyObject
  val a = MyObject                                //> a  : ScalaCourse.MyObject.type = ScalaCourse$MyObject$2$@4411d970
  val b = MyObject                                //> b  : ScalaCourse.MyObject.type = ScalaCourse$MyObject$2$@4411d970
  a == b                                          //> res7: Boolean = true
  a eq b                                          //> res8: Boolean = true

  //Companion objects
//still singleton
}