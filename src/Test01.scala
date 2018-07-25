import scala.collection.mutable

object Test01 {
    def TepleTest(): Unit ={
      val array=("jkjk","jkjkjkjsdf","jhsdjhfjh");
      println(array._1);
      println(array._2);
      println(array._3);
    }

   def arrayTest(): Unit ={
     val array=Array(1,2,3,4,5);
     for (i<-0 until(array.length)) {
       println(array(i));
     }

     for (elem<-array) println(elem);
   }

  def mapTest(): Unit ={
    var map=Map("spark"->1,"scala"->3);
    for ((k,v)<-map){
      println("k is :"+k,"v is ："+v);
    }

    for ((k,_)<-map){
      println("k is :"+k);
    }

    for ((_,v)<-map){
      println("v is :"+v);
    }

//    def main(args: Array[String]): Unit = {
//      this.TepleTest();
//      this.arrayTest();
//      this.mapTest();
//    }
  }

  def bubblesort(array: Array[Int]): Unit ={
    for (i <- 0 until(array.length-1);j <- 0 until(array.length-1-i)){
      if(array(i)<array(j)){
        val tmp=array(j);
        array(j)=array(i);
        array(j)=tmp;
      }
    }

  }

  //Queue Operation
  def toNum(q:mutable.Queue[Int]): Unit ={
    var num=0;
    while(!q.isEmpty){
      //num *= 10;
      num += q.dequeue()
    }
    println(num);
  }


  def selectSort(array: Array[Int]): Unit ={
    for(i <- 0 until(array.length)){

    }
  }




}
