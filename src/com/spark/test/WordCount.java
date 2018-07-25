package com.spark.test;

import org.apache.spark.SparkConf;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.codehaus.janino.Java;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class WordCount {
    public  static void main(String[] args){
        SparkConf conf = new SparkConf();
        conf.setAppName("LOACLMASHINE");
        conf.setMaster("local");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        // lines = sc.textFi
        JavaRDD<String> lines = sparkContext.textFile("source\\wordcount.txt");
        long count = lines.count();
        //System.out.println("Count : "+count);
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            private static final long serialVersionID=1L;
            @Override
            public Iterator<String> call(String lines) throws Exception {
                return Arrays.asList(lines.split(" ")).iterator();
            }
        });
        //System.out.println(words);

        JavaPairRDD<String,Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            private static final long sericalVersionID=1L;
            @Override
            public Tuple2<String, Integer> call(String words) throws Exception {
                return new Tuple2<>(words,1);
            }
        });

        //System.out.println(pairs);

        JavaPairRDD<String,Integer> wordcounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            private static final long serialVersionID =1L;
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1+v2;
            }
        });
        //wordcounts.cache();
        wordcounts.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> wordCount) throws Exception {
                    //System.out.println(wordCount._1+"----------"+wordCount._2+" times.");
            }
        });

        sparkContext.close();
    }
}
