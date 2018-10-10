import java.util.Calendar
object Demo2 /*extends App*/ {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(220); 

  //extends App means: Code inside {} will be treated as it is in main() method
  //App is a trait (like an interface)
  println("Welcome to the Scala worksheet");$skip(501); 

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
  };System.out.println("""getArea: (radius: Double)Double""");$skip(107); 
  //Function
  val getArea1 = (radius: Double) => {
    val PI = 3.14
    PI * radius * radius
  }: Double;System.out.println("""getArea1  : Double => Double = """ + $show(getArea1 ));$skip(25); 

  val are = getArea(10);System.out.println("""are  : Double = """ + $show(are ));$skip(26); 
  val area = getArea1(10);System.out.println("""area  : Double = """ + $show(area ));$skip(29); 
  val functionVar = getArea1;System.out.println("""functionVar  : Double => Double = """ + $show(functionVar ));$skip(214); 
  // val methodVar = getArea    Method cannot be assigned directly to variable
  //Converting method to function by specifying method signature
  //Way 1
  val methodToFunctionThenVar: (Double) => Double = getArea;System.out.println("""methodToFunctionThenVar  : Double => Double = """ + $show(methodToFunctionThenVar ));$skip(70); 
  //Way 2 : Eta expression
  val methodToFunctionThenVar2 = getArea _;System.out.println("""methodToFunctionThenVar2  : Double => Double = """ + $show(methodToFunctionThenVar2 ));$skip(90); 
  def getAreaOfSquare(side1: Double, side2: Double = 2): Double = {
    side1 * side2
  };System.out.println("""getAreaOfSquare: (side1: Double, side2: Double)Double""");$skip(77); 

  //Invoking functions with expression block
  val perimeterOfSquare = 10.6;System.out.println("""perimeterOfSquare  : Double = """ + $show(perimeterOfSquare ));$skip(115); val res$0 = 
  (getAreaOfSquare _).tupled({
    val sideOfSquare = perimeterOfSquare / 4;
    (sideOfSquare, sideOfSquare)
  });System.out.println("""res0: Double = """ + $show(res$0));$skip(97); val res$1 = 

  //Named method paramter (not possible with functions)
  getAreaOfSquare(side2 = 3, side1 = 4);System.out.println("""res1: Double = """ + $show(res$1));$skip(52); val res$2 = 

  // Parameter default values
  getAreaOfSquare(3);System.out.println("""res2: Double = """ + $show(res$2));$skip(29); val res$3 = 
  getAreaOfSquare(side1 = 4);System.out.println("""res3: Double = """ + $show(res$3));$skip(95); 

  //Type paramters : parametric polymorphism
  val someList: List[String] = "a" :: "b" :: Nil;System.out.println("""someList  : List[String] = """ + $show(someList ));$skip(160); 

  def printPairType[K, V](k: K, v: V) {
    val keyType = k.getClass
    val valType = v.getClass
    println(s"$k, $v are of type $keyType and $valType")
  };System.out.println("""printPairType: [K, V](k: K, v: V)Unit""");$skip(27); 

  printPairType(12, "12");$skip(51); 
  
  val printPairTypeFunction = (printPairType _);System.out.println("""printPairTypeFunction  : (Any, Any) => Unit = """ + $show(printPairTypeFunction ));$skip(65); 
  val printPairTypeFunction1 = (printPairType[Integer,String] _);System.out.println("""printPairTypeFunction1  : (Integer, String) => Unit = """ + $show(printPairTypeFunction1 ));$skip(231); 
                                                  
  //Vararg paraters : work only with methods
  def getAreaOfSquareForVarg(sides: Double*): Double = {
    var area = 1.0;
    for(side <- sides) { area = area * side}
    area
  };System.out.println("""getAreaOfSquareForVarg: (sides: Double*)Double""");$skip(67); 
  
  val getAreaOfSquareForVargFunction = getAreaOfSquareForVarg _;System.out.println("""getAreaOfSquareForVargFunction  : Seq[Double] => Double = """ + $show(getAreaOfSquareForVargFunction ));$skip(190); val res$4 = 
  //getAreaOfSquareForVargFunction(10.1,10.2,10.3) gives error too many arguments, therefore use Sequence object to give more arguments
  getAreaOfSquareForVargFunction(Seq(10.1,10.2,10.3));System.out.println("""res4: Double = """ + $show(res$4));$skip(141); 
  
  //Procedures are named reusable statements, procedures are functions that do not return a value
  def printHello : Unit= print("Hello");System.out.println("""printHello: => Unit""");$skip(13); 
  printHello;$skip(35); 
  def printHello1 = print("Hello");System.out.println("""printHello1: => Unit""");$skip(62); 
  
  //Method with no input
  def sayHello():String = "Hello";System.out.println("""sayHello: ()String""");$skip(13); val res$5 = 
  sayHello();System.out.println("""res5: String = """ + $show(res$5));$skip(11); val res$6 = 
  sayHello;System.out.println("""res6: String = """ + $show(res$6));$skip(33); 
  def sayHello2:String = "Hello";System.out.println("""sayHello2: => String""");$skip(35); val res$7 = 
  // sayHello2() ERROR
  sayHello2;System.out.println("""res7: String = """ + $show(res$7));$skip(207); 
  
  //Nested Functions
  def getCircleStats(r: Double) {
  	val PI =3.14
  	def getCirArea(r:Double)  = PI * r* r
  	def getCirCircumference(r: Double)= 2*PI*r
  	(getCirArea(r),getCirCircumference(r))
  };System.out.println("""getCircleStats: (r: Double)Unit""");$skip(192); 
  
  //Higher order functions/methods: they either take function as paramter or return a function
  def compareStrings(s1:String,s2:String): Int = {
   return 1 //return result of compare
  };System.out.println("""compareStrings: (s1: String, s2: String)Int""");$skip(140); 
  
  //Function that takes a function
  def smartCompare(s1:String, s2: String, cmpFun:(String, String) =>Int) : Int ={
  cmpFun(s1,s2)
  };System.out.println("""smartCompare: (s1: String, s2: String, cmpFun: (String, String) => Int)Int""");$skip(177); 
  
 //function that returns a function:
 def getComparator(reverse : Boolean) : (String, String) => Int = {
  if(reverse) compareStrings//in descending
  else compareStrings
 };System.out.println("""getComparator: (reverse: Boolean)(String, String) => Int""");$skip(89); 

// Anonymous function or function literal
val getString = (s1:String) => {
s1
} :String;System.out.println("""getString  : String => String = """ + $show(getString ));$skip(125); 

//Partially applied functions : allow code reuse

val defaultCompare = smartCompare (_ :String, _ : String, compareStrings);System.out.println("""defaultCompare  : (String, String) => Int = """ + $show(defaultCompare ));$skip(229); 

// Currying : applies to both function and methods : code reuse
//paramter group
//two groups of paramters, two sets of parantheses
def curriedCompare (cmpFun:(String,String)=>Int) (s1:String, s2:String):Int = {
cmpFun(s1,s2)
};System.out.println("""curriedCompare: (cmpFun: (String, String) => Int)(s1: String, s2: String)Int""");$skip(740); 

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
};System.out.println("""sayHello1: (name: => String)String""");$skip(1143); 


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
};System.out.println("""greeting: (lang: String)String => Unit""");$skip(100); 


def functioncallingouterfunction() {
 val greetEnglish = greeting("english")
 greetEnglish("A")
};System.out.println("""functioncallingouterfunction: ()Unit""")}
}
