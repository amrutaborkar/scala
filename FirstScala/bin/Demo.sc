object Demo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  var result = 8.+(7)                             //> result  : Int = 15
  println(result)                                 //> 15

  case class Student(var rollno: Int = 1, var name: String, var marks: Int = 90) {}

  var s1 = Student(name = "Harsh");               //> s1  : Demo.Student = Student(1,Harsh,90)

  var nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9)      //> nums  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  for { n <- nums } println(n)                    //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
  nums.reverse                                    //> res0: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1)
  nums.drop(2).take(2)                            //> res1: List[Int] = List(3, 4)
  nums.take(2)                                    //> res2: List[Int] = List(1, 2)
  nums drop 1 take 1                              //> res3: List[Int] = List(2)
  nums.foreach(i => println(i))                   //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
  var nums2 = List(1, 2, true)                    //> nums2  : List[AnyVal] = List(1, 2, true)
  var nums3 = List(1, 2, true, "aString")         //> nums3  : List[Any] = List(1, 2, true, aString)

  val students = List(Student(1, "Harsh", 90), Student(2, "Ami", 88), Student(3, "Bill", 50))
                                                  //> students  : List[Demo.Student] = List(Student(1,Harsh,90), Student(2,Ami,88)
                                                  //| , Student(3,Bill,50))
  val firstStud = students.head                   //> firstStud  : Demo.Student = Student(1,Harsh,90)
  val lastStud = students.tail                    //> lastStud  : List[Demo.Student] = List(Student(2,Ami,88), Student(3,Bill,50))
                                                  //| 
  val tailtail = students.tail.tail               //> tailtail  : List[Demo.Student] = List(Student(3,Bill,50))

  val toppers = students.filter(s => s.marks > 70)//> toppers  : List[Demo.Student] = List(Student(1,Harsh,90), Student(2,Ami,88))
                                                  //| 

  val parts = students.partition(s => s.marks > 70)
                                                  //> parts  : (List[Demo.Student], List[Demo.Student]) = (List(Student(1,Harsh,90
                                                  //| ), Student(2,Ami,88)),List(Student(3,Bill,50)))

  //Tuples

  val part1 = parts._1                            //> part1  : List[Demo.Student] = List(Student(1,Harsh,90), Student(2,Ami,88))
  val part2 = parts._2                            //> part2  : List[Demo.Student] = List(Student(3,Bill,50))

  val (p1, p2) = students.partition(s => s.marks > 70)
                                                  //> p1  : List[Demo.Student] = List(Student(1,Harsh,90), Student(2,Ami,88))
                                                  //| p2  : List[Demo.Student] = List(Student(3,Bill,50))

  //match statements
  //Pattern guard and OR-ed expression :  ways to add conditions to case clause in a match expression
  //match all : value binding patterns and _ wildcard operator patttern
  val dayOfWeek = "Friday"                        //> dayOfWeek  : String = Friday
  val typeOfDay = dayOfWeek match {
    case "Monday" => "Manic Monday"
    case "Sunday" | "Saturday" => "Super Weekend"
    case someOtherDay if someOtherDay == "Tuesday" => "Other working day"
    case someOtherDay if someOtherDay == "Wednesday" => "Yet another working day"
    case someOtherDay => {
      println(s"None of the above days, its $someOtherDay")
      someOtherDay
    }
  }                                               //> None of the above days, its Friday
                                                  //| typeOfDay  : String = Friday
  //for wildcard way
  val typeOfDay1 = dayOfWeek match {
    case _ => "HiHi"
  }                                               //> typeOfDay1  : String = HiHi

  //Type identification using match statement
  // case <identifier> : <Type> => <expression>
  var radius: Any = 10.5                          //> radius  : Any = 10.5
  val typeOFRadius = radius match {
    case radius: Int => "Integer"
    case radius: Double => "Double"
    case radius: String => "String"
    case _ => "Any"
  }                                               //> typeOFRadius  : String = Double

  val typeOfRadius1 = radius match {
    case radius: Int => "Integer"
    case _: AnyRef => "String"
    case _ => "Any"
  }                                               //> typeOfRadius1  : String = String
  // Types declared in match case must be subtypes of a var for which match case is present

  //FOR LOOP
  val days = List("Monday", "Tuesday", "Sunday")  //> days  : List[String] = List(Monday, Tuesday, Sunday)
  for (aDay <- days) {
    aDay match {
      case "Monday" => println("Manic Monday")
      case _ => println("rest")
    }                                             //> Manic Monday
                                                  //| rest
                                                  //| rest

  }
  //With word "yeild" for loop "returns" a value
   for (aDay <- days) yield {
    aDay match {
      case "Monday" => "Manic Monday"
      case _ => "rest"
    }                                             //> res4: List[String] = List(Manic Monday, rest, rest)
  }
  for(aDay <- days if aDay == "Monday") {
  println("Manic Monday")                         //> Manic Monday
  }
  
  for{i <- 0 until 2
      j <- 0 to 3} {
      println(s"$i $j")                           //> 0 0
                                                  //| 0 1
                                                  //| 0 2
                                                  //| 0 3
                                                  //| 1 0
                                                  //| 1 1
                                                  //| 1 2
                                                  //| 1 3
  }
  //While and do-while loops in scala are STATEMENTS
  
}