object Demo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(23); 

  var result = 8.+(7);System.out.println("""result  : Int = """ + $show(result ));$skip(18); 
  println(result)

  case class Student(var rollno: Int = 1, var name: String, var marks: Int = 90) {};$skip(122); 

  var s1 = Student(name = "Harsh");System.out.println("""s1  : Demo.Student = """ + $show(s1 ));$skip(46); ;

  var nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(32); 

  for { n <- nums } println(n);$skip(15); val res$0 = 
  nums.reverse;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(23); val res$1 = 
  nums.drop(2).take(2);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(15); val res$2 = 
  nums.take(2);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(21); val res$3 = 
  nums drop 1 take 1;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(32); 
  nums.foreach(i => println(i));$skip(31); 
  var nums2 = List(1, 2, true);System.out.println("""nums2  : List[AnyVal] = """ + $show(nums2 ));$skip(42); 
  var nums3 = List(1, 2, true, "aString");System.out.println("""nums3  : List[Any] = """ + $show(nums3 ));$skip(95); 

  val students = List(Student(1, "Harsh", 90), Student(2, "Ami", 88), Student(3, "Bill", 50));System.out.println("""students  : List[Demo.Student] = """ + $show(students ));$skip(32); 
  val firstStud = students.head;System.out.println("""firstStud  : Demo.Student = """ + $show(firstStud ));$skip(31); 
  val lastStud = students.tail;System.out.println("""lastStud  : List[Demo.Student] = """ + $show(lastStud ));$skip(36); 
  val tailtail = students.tail.tail;System.out.println("""tailtail  : List[Demo.Student] = """ + $show(tailtail ));$skip(52); 

  val toppers = students.filter(s => s.marks > 70);System.out.println("""toppers  : List[Demo.Student] = """ + $show(toppers ));$skip(53); 

  val parts = students.partition(s => s.marks > 70);System.out.println("""parts  : (List[Demo.Student], List[Demo.Student]) = """ + $show(parts ));$skip(36); 

  //Tuples

  val part1 = parts._1;System.out.println("""part1  : List[Demo.Student] = """ + $show(part1 ));$skip(23); 
  val part2 = parts._2;System.out.println("""part2  : List[Demo.Student] = """ + $show(part2 ));$skip(56); 

  val (p1, p2) = students.partition(s => s.marks > 70);System.out.println("""p1  : List[Demo.Student] = """ + $show(p1 ));System.out.println("""p2  : List[Demo.Student] = """ + $show(p2 ));$skip(223); 

  //match statements
  //Pattern guard and OR-ed expression :  ways to add conditions to case clause in a match expression
  //match all : value binding patterns and _ wildcard operator patttern
  val dayOfWeek = "Friday";System.out.println("""dayOfWeek  : String = """ + $show(dayOfWeek ));$skip(394); 
  val typeOfDay = dayOfWeek match {
    case "Monday" => "Manic Monday"
    case "Sunday" | "Saturday" => "Super Weekend"
    case someOtherDay if someOtherDay == "Tuesday" => "Other working day"
    case someOtherDay if someOtherDay == "Wednesday" => "Yet another working day"
    case someOtherDay => {
      println(s"None of the above days, its $someOtherDay")
      someOtherDay
    }
  };System.out.println("""typeOfDay  : String = """ + $show(typeOfDay ));$skip(83); 
  //for wildcard way
  val typeOfDay1 = dayOfWeek match {
    case _ => "HiHi"
  };System.out.println("""typeOfDay1  : String = """ + $show(typeOfDay1 ));$skip(120); 

  //Type identification using match statement
  // case <identifier> : <Type> => <expression>
  var radius: Any = 10.5;System.out.println("""radius  : Any = """ + $show(radius ));$skip(166); 
  val typeOFRadius = radius match {
    case radius: Int => "Integer"
    case radius: Double => "Double"
    case radius: String => "String"
    case _ => "Any"
  };System.out.println("""typeOFRadius  : String = """ + $show(typeOFRadius ));$skip(127); 

  val typeOfRadius1 = radius match {
    case radius: Int => "Integer"
    case _: AnyRef => "String"
    case _ => "Any"
  };System.out.println("""typeOfRadius1  : String = """ + $show(typeOfRadius1 ));$skip(155); 
  // Types declared in match case must be subtypes of a var for which match case is present

  //FOR LOOP
  val days = List("Monday", "Tuesday", "Sunday");System.out.println("""days  : List[String] = """ + $show(days ));$skip(125); 
  for (aDay <- days) {
    aDay match {
      case "Monday" => println("Manic Monday")
      case _ => println("rest")
    }

  };$skip(168); val res$4 = 
  //With word "yeild" for loop "returns" a value
   for (aDay <- days) yield {
    aDay match {
      case "Monday" => "Manic Monday"
      case _ => "rest"
    }
  };System.out.println("""res4: List[String] = """ + $show(res$4));$skip(72); 
  for(aDay <- days if aDay == "Monday") {
  println("Manic Monday")
  };$skip(73); 
  
  for{i <- 0 until 2
      j <- 0 to 3} {
      println(s"$i $j")}
  }
  //While and do-while loops in scala are STATEMENTS
  
}
