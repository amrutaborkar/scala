object Demo4_OO {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet")
  
  class Rectangle (l:Double,b:Double) {
  val length = l
  val breadth = b
  }
  
  class AreaCalculator {
  def apply (s:Rectangle) {
  println("hi"+ s.length)
  s.length*s.breadth}
  };$skip(222); 
  val rect = new Rectangle(5,5);System.out.println("""rect  : Demo4_OO.Rectangle = """ + $show(rect ));$skip(34); 
  val area = new AreaCalculator();System.out.println("""area  : Demo4_OO.AreaCalculator = """ + $show(area ));$skip(22); 
  println(area(rect))}
}
