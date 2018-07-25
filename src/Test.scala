import org.apache.spark.SparkContext

import scala.collection.mutable
import scala.util.control._

object Test {
  def main(args: Array[String]): Unit = {
    //println("hello world!")
    //printS("kkjkjkjkj","kjdkfjsdfhjhasjfh","kkkk");
//    for (i <- 1 to 10){
//      print(i);
//    }
    //Test01.mapTest();
   // Test01.arrayTest();
   // Test01.mapTest();
    val q=new mutable.Queue[Int];
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3,4,5);
    val test01=Test01;
    test01.toNum(q);
  }
  def plus(a:Int,b:Int):Int={
    return a+b;
  }

  //var sc:SparkContext=new SparkContext();

  val loop = new Breaks;
  loop.breakable{
    loop.break;
  }


  def printS(str:String*): Unit ={
    var i:Int=0;
    for (str1 <- str){
      println("str1"+str1);
      i+=1;
    }
  }

}
