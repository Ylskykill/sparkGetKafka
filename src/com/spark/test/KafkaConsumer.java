package com.spark.test;

import kafka.consumer.Consumer;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.datanucleus.store.types.backed.ArrayList;
import scala.actors.threadpool.Arrays;

import java.util.HashSet;

public class KafkaConsumer {

    public static void main(String[] args){
        String topic = "test01";
        String broker = "ip2:6667,ip2:6667";
        long seconds = 10;

        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("KafkaConsumerTest");
        JavaStreamingContext jsc = new JavaStreamingContext(sparkConf,Durations.seconds(seconds));

        HashSet<String> topicSet = new HashSet<>(Arrays.asList(topic.split(",")));





    }
    //JavaStreamingContext jsc = new JavaStreamingContext();

}
