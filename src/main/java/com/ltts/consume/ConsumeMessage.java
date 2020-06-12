package com.ltts.consume;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumeMessage {


    private static final String HOSTS = System.getenv("KAFKA_BROKER_LIST");
    //    "52.172.24.230:9092,13.71.124.119:9092,52.140.16.51:9092";
    private static final String EVENT_TOPIC = System.getenv("EVENT_TOPIC");
    private static final String ALARM_TOPIC = System.getenv("ALARM_TOPIC");
    private static final String TEST_TOPIC = "midnight";


    public static void consume(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", HOSTS);
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        @SuppressWarnings("resource")
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        System.out.println("trying to connect... Listing topics... ");
        System.out.println("topics: " + consumer.listTopics().toString());

        // Kafka Consumer subscribes list of topics here.
        consumer.subscribe(Arrays.asList(topicName));

        // print the topic name
        System.out.println("Subscribed to topic " + topicName);


        while (true) {
            @SuppressWarnings("deprecation")
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
        }
    }

    public static void main(String[] args) {
        consume(TEST_TOPIC);
    }
}
