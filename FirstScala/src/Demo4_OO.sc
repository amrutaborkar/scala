object Demo4_OO {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  class Rectangle (l:Double,b:Double) {
  val length = l
  val breadth = b
  }
  
  class AreaCalculator {
  def apply (s:Rectangle) {
  println("hi"+ s.length)
  s.length*s.breadth}
  }
  val rect = new Rectangle(5,5)                   //> rect  : Demo4_OO.Rectangle = Demo4_OO$Rectangle$1@27f674d
  val area = new AreaCalculator()                 //> area  : Demo4_OO.AreaCalculator = Demo4_OO$AreaCalculator$1@1d251891
  println(area(rect))                             //> hi5.0
                                                  //| ()
}