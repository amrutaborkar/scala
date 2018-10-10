object Demo3_collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 
  println("Welcome to the Scala worksheet");$skip(335); 
  
  //Tuples
  //These are not collections, they do not reside in either of the namespaces where either of the collection classes exist
  //they also do not impletement Iterable interface, which all scala collections do.
  //Tuples are ordered containers of values of different types.
  val personInfo = ("Amruta", "Borkar", 20, "F");System.out.println("""personInfo  : (String, String, Int, String) = """ + $show(personInfo ));$skip(70); 
  //tuple of 2 is called pair
  val genderPair = "Amruta" -> "Female";System.out.println("""genderPair  : (String, String) = """ + $show(genderPair ));$skip(16); val res$0 = 
  personInfo._1;System.out.println("""res0: String = """ + $show(res$0));$skip(16); val res$1 = 
  personInfo._4;System.out.println("""res1: String = """ + $show(res$1));$skip(84); 
  //personInfo._5 //Compile error
  val(firstName,lastName,age,gender) = personInfo;System.out.println("""firstName  : String = """ + $show(firstName ));System.out.println("""lastName  : String = """ + $show(lastName ));System.out.println("""age  : Int = """ + $show(age ));System.out.println("""gender  : String = """ + $show(gender ));$skip(43); 
 val(firstName1,_,age1,gender1)=personInfo;System.out.println("""firstName1  : String = """ + $show(firstName1 ));System.out.println("""age1  : Int = """ + $show(age1 ));System.out.println("""gender1  : String = """ + $show(gender1 ));$skip(139); 
                                                  
 //To iterate on tuple
  personInfo.productIterator.foreach{i => println("Value=" + i)};$skip(128); val res$2 = 
                                                  
  //To find how many numbers of elems. a tuple has
  personInfo.productArity;System.out.println("""res2: Int = """ + $show(res$2));$skip(119); 
 
 //Passing tuples to a function as argument
 
 def printNameGender(s1:String,s2:String) {
 println(s"$s1 is $s2")
 };System.out.println("""printNameGender: (s1: String, s2: String)Unit""");$skip(42); 
 
 (printNameGender _).tupled(genderPair);$skip(274); 
 
 //LISTS
 //Higher order functions
 //Map: map functions yeild a new list , map takes in a function and applies it to every element of the list
 //Reduce: reduce functionnshrink lists into value
 //foreach statement
 val weekdays = List("Mon", "Tue", "Wed", "Thu", "Fri");System.out.println("""weekdays  : List[String] = """ + $show(weekdays ));$skip(30); 
 weekdays.foreach(println(_));$skip(47); 
val printValue= (x:Any) => {println(x)} : Unit;System.out.println("""printValue  : Any => Unit = """ + $show(printValue ));$skip(30); 

weekdays.foreach(printValue);$skip(23); val res$3 = 
weekdays.map(_=="Mon");System.out.println("""res3: List[Boolean] = """ + $show(res$3));$skip(46); 
val isMonday = (x:Any) => {x=="Mon"} :Boolean;System.out.println("""isMonday  : Any => Boolean = """ + $show(isMonday ));$skip(23); val res$4 = 
weekdays.map(isMonday);System.out.println("""res4: List[Boolean] = """ + $show(res$4));$skip(69); val res$5 = 

//filter, partition
//sort by first character
weekdays.sortBy(_(0));System.out.println("""res5: List[String] = """ + $show(res$5));$skip(94); 

//HIGHER ORDER functions as they take in a function =:
val numbers = List(10,20,30,40,50,60);System.out.println("""numbers  : List[Int] = """ + $show(numbers ));$skip(26); val res$6 = 
numbers.scanRight(0)(_-_);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(25); val res$7 = 
numbers.scanLeft(0)(_-_);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(21); val res$8 = 
numbers.scan(0)(_-_);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(155); 
//FOLD similar to scan : returns last result of the operation
//REDUCE is similar except it does not take initial value

val weekends = List("Sat", "Sun");System.out.println("""weekends  : List[String] = """ + $show(weekends ));$skip(35); 
val allDays = weekdays ++ weekends;System.out.println("""allDays  : List[String] = """ + $show(allDays ));$skip(28); val res$9 = 
allDays startsWith weekdays;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(27); val res$10 = 
allDays forall (_ !="Mon");System.out.println("""res10: Boolean = """ + $show(res$10));$skip(30); val res$11 = 
allDays forall (_ !="Monday");System.out.println("""res11: Boolean = """ + $show(res$11))}

}
