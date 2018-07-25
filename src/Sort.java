import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    public void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array.length-i-1;j++){
                if(array[i]<array[j]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public void selectSort(int[] array){
        int t=0;
        for (int i = 0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    t=array[i];
                    array[i]=array[j];
                    array[j]=t;
                }
            }
        }
    }

    public void insertSort(int[] array){

    }

    public static void main(String[] args){
        //String appName = args[0];
        SparkConf conf = new SparkConf();
        conf.setAppName("Wow");
        conf.setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
//        List<JavaRDD<String>> rddList = new ArrayList<JavaRDD<String>>();
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        JavaRDD<String> rdd1=sc.parallelize(list);
//        String result=rdd1.reduce(new Function2<String, String, String>() {
//            @Override
//            public String call(String s, String s2) throws Exception {
//                return Integer.valueOf(s)+Integer.valueOf(s2)+"";
//            }
//        });

        JavaPairRDD<String,String> mapToPairRdd=rdd1.mapToPair(new PairFunction<String, String, String>() {
            @Override
            public Tuple2<String, String> call(String s) throws Exception {
                System.out.println("=============" + s);
                return new Tuple2<>(s, s + "a");
            }
        });
        System.out.println("mapToPair count: "+mapToPairRdd.count());

        
       // System.out.println(result);
    }



    //private SparkContext sc = new SparkContext();

}
