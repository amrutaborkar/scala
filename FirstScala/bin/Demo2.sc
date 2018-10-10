import java.util.Calendar
object Demo2 /*extends App*/ {

  //extends App means: Code inside {} will be treated as it is in main() method
  //App is a trait (like an interface)
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //First class functions
  //Functions vs methods
  //Methods are used to define behaviour of objects or classes
  //
  /*
  Functions:
  You can store a function in a variable.
  You can have a method return a function.
  You can have a method take in a function as an argument.
  Methods are not objects, functions are
  Methods are associated with a class, functions can exist without class
  */
  //Method
  def getArea(radius: Double): Double = {
    val PI = 3.14
    PI * radius * radius
  }                                               //> getArea: (radius: Double)Double
  //Function
  val getArea1 = (radius: Double) => {
    val PI = 3.14
    PI * radius * radius
  }: Double                                       //> getArea1  : Double => Double = Demo2$$$Lambda$8/240650537@43a25848

  val are = getArea(10)                           //> are  : Double = 314.0
  val area = getArea1(10)                         //> area  : Double = 314.0
  val functionVar = getArea1                      //> functionVar  : Double => Double = Demo2$$$Lambda$8/240650537@43a25848
  // val methodVar = getArea    Method cannot be assigned directly to variable
  //Converting method to function by specifying method signature
  //Way 1
  val methodToFunctionThenVar: (Double) => Double = getArea
                                                  //> methodToFunctionThenVar  : Double => Double = Demo2$$$Lambda$9/985922955@55
                                                  //| 94a1b5
  //Way 2 : Eta expression
  val methodToFunctionThenVar2 = getArea _        //> methodToFunctionThenVar2  : Double => Double = Demo2$$$Lambda$10/1784662007
                                                  //| @3b6eb2ec
  def getAreaOfSquare(side1: Double, side2: Double = 2): Double = {
    side1 * side2
  }                                               //> getAreaOfSquare: (side1: Double, side2: Double)Double

  //Invoking functions with expression block
  val perimeterOfSquare = 10.6                    //> perimeterOfSquare  : Double = 10.6
  (getAreaOfSquare _).tupled({
    val sideOfSquare = perimeterOfSquare / 4;
    (sideOfSquare, sideOfSquare)
  })                                              //> res0: Double = 7.0225

  //Named method paramter (not possible with functions)
  getAreaOfSquare(side2 = 3, side1 = 4)           //> res1: Double = 12.0

  // Parameter default values
  getAreaOfSquare(3)                              //> res2: Double = 6.0
  getAreaOfSquare(side1 = 4)                      //> res3: Double = 8.0

  //Type paramters : parametric polymorphism
  val someList: List[String] = "a" :: "b" :: Nil  //> someList  : List[String] = List(a, b)

  def printPairType[K, V](k: K, v: V) {
    val keyType = k.getClass
    val valType = v.getClass
    println(s"$k, $v are of type $keyType and $valType")
  }                                               //> printPairType: [K, V](k: K, v: V)Unit

  printPairType(12, "12")                         //> 12, 12 are of type class java.lang.Integer and class java.lang.String
  
  val printPairTypeFunction = (printPairType _)   //> printPairTypeFunction  : (Any, Any) => Unit = Demo2$$$Lambda$16/1358444045@
                                                  //| 2cb4c3ab
  val printPairTypeFunction1 = (printPairType[Integer,String] _)
                                                  //> printPairTypeFunction1  : (Integer, String) => Unit = Demo2$$$Lambda$17/331
                                                  //| 844619@12843fce
                                                  
  //Vararg paraters : work only with methods
  def getAreaOfSquareForVarg(sides: Double*): Double = {
    var area = 1.0;
    for(side <- sides) { area = area * side}
    area
  }                                               //> getAreaOfSquareForVarg: (sides: Double*)Double
  
  val getAreaOfSquareForVargFunction = getAreaOfSquareForVarg _
                                                  //> getAreaOfSquareForVargFunction  : Seq[Double] => Double = Demo2$$$Lambda$18
                                                  //| /159259014@26f67b76
  //getAreaOfSquareForVargFunction(10.1,10.2,10.3) gives error too many arguments, therefore use Sequence object to give more arguments
  getAreaOfSquareForVargFunction(Seq(10.1,10.2,10.3))
                                                  //> res4: Double = 1061.106
  
  //Procedures are named reusable statements, procedures are functions that do not return a value
  def printHello : Unit= print("Hello")           //> printHello: => Unit
  printHello                                      //> Hello
  def printHello1 = print("Hello")                //> printHello1: => Unit
  
  //Method with no input
  def sayHello():String = "Hello"                 //> sayHello: ()String
  sayHello()                                      //> res5: String = Hello
  sayHello                                        //> res6: String = Hello
  def sayHello2:String = "Hello"                  //> sayHello2: => String
  // sayHello2() ERROR
  sayHello2                                       //> res7: String = Hello
  
  //Nested Functions
  def getCircleStats(r: Double) {
  	val PI =3.14
  	def getCirArea(r:Double)  = PI * r* r
  	def getCirCircumference(r: Double)= 2*PI*r
  	(getCirArea(r),getCirCircumference(r))
  }                                               //> getCircleStats: (r: Double)Unit
  
  //Higher order functions/methods: they either take function as paramter or return a function
  def compareStrings(s1:String,s2:String): Int = {
   return 1 //return result of compare
  }                                               //> compareStrings: (s1: String, s2: String)Int
  
  //Function that takes a function
  def smartCompare(s1:String, s2: String, cmpFun:(String, String) =>Int) : Int ={
  cmpFun(s1,s2)
  }                                               //> smartCompare: (s1: String, s2: String, cmpFun: (String, String) => Int)Int
  
 //function that returns a function:
 def getComparator(reverse : Boolean) : (String, String) => Int = {
  if(reverse) compareStrings//in descending
  else compareStrings
 }                                                //> getComparator: (reverse: Boolean)(String, String) => Int

// Anonymous function or function literal
val getString = (s1:String) => {
s1
} :String                                         //> getString  : String => String = Demo2$$$Lambda$21/2032251042@174d20a

//Partially applied functions : allow code reuse

val defaultCompare = smartCompare (_ :String, _ : String, compareStrings)
                                                  //> defaultCompare  : (String, String) => Int = Demo2$$$Lambda$22/1725097945@1e
                                                  //| fbd816

// Currying : applies to both function and methods : code reuse
//paramter group
//two groups of paramters, two sets of parantheses
def curriedCompare (cmpFun:(String,String)=>Int) (s1:String, s2:String):Int = {
cmpFun(s1,s2)
}                                                 //> curriedCompare: (cmpFun: (String, String) => Int)(s1: String, s2: String)In
                                                  //| t

//using currying we can partially specify functions

//By - name parameters : work with methods and functions
//Lazy first time evaluation, accompanied by eager reevaluation
//If you specify a function parameter as being a by-name paramter of a certain type,
//1. you could pass in a value of that type or 2. you could pass in a function call that returns a value of that type
//This parameter is first evaluated onlywhen the first referenced inside the function - lazy evaluation
//Every reference to the parameter causes the function to be reevaluated - Eager reevaluation


//Paramter by name : useful when function is operating on valatile data
def sayHello1(name : =>String) : String = {
	println(s"Hello")
	println(s"$name")
	name
}                                                 //> sayHello1: (name: => String)String


//CLOSURES
//Applies to functions and methods
// closure = nested function object + variables local to the outer scope
//clusres are important in javascript , because of client -server environment , and in scala where lot of distributing computing happens ,
//functions are used in a place different than where they were created.
//variables local to the outer scope => referncing environment
//1. Nested function can access the referencing environment even though those variables are out of scope
//2. The nested function carries around its referencing environment even after the scope has gone away
//You want the greeting to be changed based on the language of the user : EX Hello A, Namaste B, Bonjour C
// can create a match statement for 'lang' and generate these statements

def greeting(lang:String) = {
 //current date will be frozen to whatever current date was when outer scope existed.
 val currentDate = Calendar.getInstance().getTime().toString
 val referencingEnvVar : String = " This will still be accessed"
 lang match {
  case "english" => (x:String) =>println("Hello"+x + referencingEnvVar + currentDate) //and so on
 }
}                                                 //> greeting: (lang: String)String => Unit


def functioncallingouterfunction() {
 val greetEnglish = greeting("english")
 greetEnglish("A")
}                                                 //> functioncallingouterfunction: ()Unit
}