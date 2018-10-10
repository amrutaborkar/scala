object Demo3_collections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Tuples
  //These are not collections, they do not reside in either of the namespaces where either of the collection classes exist
  //they also do not impletement Iterable interface, which all scala collections do.
  //Tuples are ordered containers of values of different types.
  val personInfo = ("Amruta", "Borkar", 20, "F")  //> personInfo  : (String, String, Int, String) = (Amruta,Borkar,20,F)
  //tuple of 2 is called pair
  val genderPair = "Amruta" -> "Female"           //> genderPair  : (String, String) = (Amruta,Female)
  personInfo._1                                   //> res0: String = Amruta
  personInfo._4                                   //> res1: String = F
  //personInfo._5 //Compile error
  val(firstName,lastName,age,gender) = personInfo //> firstName  : String = Amruta
                                                  //| lastName  : String = Borkar
                                                  //| age  : Int = 20
                                                  //| gender  : String = F
 val(firstName1,_,age1,gender1)=personInfo        //> firstName1  : String = Amruta
                                                  //| age1  : Int = 20
                                                  //| gender1  : String = F
                                                  
 //To iterate on tuple
  personInfo.productIterator.foreach{i => println("Value=" + i)}
                                                  //> Value=Amruta
                                                  //| Value=Borkar
                                                  //| Value=20
                                                  //| Value=F
                                                  
  //To find how many numbers of elems. a tuple has
  personInfo.productArity                         //> res2: Int = 4
 
 //Passing tuples to a function as argument
 
 def printNameGender(s1:String,s2:String) {
 println(s"$s1 is $s2")
 }                                                //> printNameGender: (s1: String, s2: String)Unit
 
 (printNameGender _).tupled(genderPair)           //> Amruta is Female
 
 //LISTS
 //Higher order functions
 //Map: map functions yeild a new list , map takes in a function and applies it to every element of the list
 //Reduce: reduce functionnshrink lists into value
 //foreach statement
 val weekdays = List("Mon", "Tue", "Wed", "Thu", "Fri")
                                                  //> weekdays  : List[String] = List(Mon, Tue, Wed, Thu, Fri)
 weekdays.foreach(println(_))                     //> Mon
                                                  //| Tue
                                                  //| Wed
                                                  //| Thu
                                                  //| Fri
val printValue= (x:Any) => {println(x)} : Unit    //> printValue  : Any => Unit = Demo3_collections$$$Lambda$17/2034688500@3c0971
                                                  //| 1b

weekdays.foreach(printValue)                      //> Mon
                                                  //| Tue
                                                  //| Wed
                                                  //| Thu
                                                  //| Fri
weekdays.map(_=="Mon")                            //> res3: List[Boolean] = List(true, false, false, false, false)
val isMonday = (x:Any) => {x=="Mon"} :Boolean     //> isMonday  : Any => Boolean = Demo3_collections$$$Lambda$19/194494468@4590c9
                                                  //| c3
weekdays.map(isMonday)                            //> res4: List[Boolean] = List(true, false, false, false, false)

//filter, partition
//sort by first character
weekdays.sortBy(_(0))                             //> res5: List[String] = List(Fri, Mon, Tue, Thu, Wed)

//HIGHER ORDER functions as they take in a function =:
val numbers = List(10,20,30,40,50,60)             //> numbers  : List[Int] = List(10, 20, 30, 40, 50, 60)
numbers.scanRight(0)(_-_)                         //> res6: List[Int] = List(-30, 40, -20, 50, -10, 60, 0)
numbers.scanLeft(0)(_-_)                          //> res7: List[Int] = List(0, -10, -30, -60, -100, -150, -210)
numbers.scan(0)(_-_)                              //> res8: List[Int] = List(0, -10, -30, -60, -100, -150, -210)
//FOLD similar to scan : returns last result of the operation
//REDUCE is similar except it does not take initial value

val weekends = List("Sat", "Sun")                 //> weekends  : List[String] = List(Sat, Sun)
val allDays = weekdays ++ weekends                //> allDays  : List[String] = List(Mon, Tue, Wed, Thu, Fri, Sat, Sun)
allDays startsWith weekdays                       //> res9: Boolean = true
allDays forall (_ !="Mon")                        //> res10: Boolean = false
allDays forall (_ !="Monday")                     //> res11: Boolean = true

}