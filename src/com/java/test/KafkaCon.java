package com.java.test;


import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.record.MemoryRecords;
import org.stringtemplate.v4.ST;

import java.util.Properties;

public class KafkaCon {
    static Properties prop;

    public static void main(String[] args){
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(prop);
        ConsumerRecords<String,String> records = consumer.poll(1000);
        MemoryRecords.RecordsIterator.class.getTypeName();
    }
}
