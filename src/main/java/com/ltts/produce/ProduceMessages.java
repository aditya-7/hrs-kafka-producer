package com.ltts.produce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class ProduceMessages {

    //    private static final String HOSTS = System.getenv("KAFKA_BROKER_LIST");
    private static final String HOSTS = "52.172.24.230:9092,13.71.124.119:9092,52.140.16.51:9092";
    //    private static final String EVENT_TOPIC = System.getenv("EVENT_TOPIC");
    private static final String EVENT_TOPIC = "hrs-event-3";
    //    private static final String ALARM_TOPIC = System.getenv("ALARM_TOPIC");
    private static final String ALARM_TOPIC = "hrs-alarm";

    // FROM Date
    private static final int FROM_YEAR = 2017;
    private static final int FROM_MONTH = 11;
    private static final int FROM_DATE = 01;
    private static final int FROM_HOURS = 01;
    private static final int FROM_MINUTES = 01;
    private static final int FROM_SECONDS = 01;

    // TO Date
    private static final int TO_YEAR = 2020;
    private static final int TO_MONTH = 05;
    private static final int TO_DATE = 01;
    private static final int TO_HOURS = 01;
    private static final int TO_MINUTES = 01;
    private static final int TO_SECONDS = 20;

    /*
     * Specify the no.of messages needed to be generated / sec NOTE:
     * MAX_NO_OF_EVENTS should always be greater than MIN_NO_OF_EVENTS
     */
    private static int MAX_NO_OF_EVENTS_OR_ALARMS = 300;
    private static int MIN_NO_OF_EVENTS_OR_ALARMS = 100;

    // List of servers
    private static final String[] SERVERS = {"INMUMCDCEBI11A", "CDCTPEBIRAPPPA", "INMUMCDCEBI10", "INPUNSPEBI09A",
            "CHNSIREBI13A", "INTVMPPEBI06A", "INBLRPIOEBI03A", "CDCTPEBIRAPPPA", "INHYDSPEBI07A", "INCHNSIREBI05",
            "IE22P2R500TCS1A"};

    public static Date addSeconds(Calendar calendar, Date fromDate, Integer secondsToAdd) {
        calendar.setTime(fromDate);
        calendar.add(Calendar.SECOND, secondsToAdd);
        return calendar.getTime();
    }

    public static Date getDate(Calendar calendar, int year, int month, int date, int hours, int minutes, int seconds) {
        calendar.set(year, month, date, hours, minutes, seconds);
        return calendar.getTime();
    }

    public static int getRandomNumber(boolean status) {
        Random random = new Random();
        // status=true for random no.of iterations to generate message
        if (status) {
            int range = MAX_NO_OF_EVENTS_OR_ALARMS - MIN_NO_OF_EVENTS_OR_ALARMS + 1;
            return random.nextInt(range) + MIN_NO_OF_EVENTS_OR_ALARMS;
        }
        // status=false for generating big number used for EventID/AlarmID
        MAX_NO_OF_EVENTS_OR_ALARMS = 9999;
        MIN_NO_OF_EVENTS_OR_ALARMS = 6000;
        int range = MAX_NO_OF_EVENTS_OR_ALARMS - MIN_NO_OF_EVENTS_OR_ALARMS + 1;
        return random.nextInt(range) + MIN_NO_OF_EVENTS_OR_ALARMS;
    }

    public static String getTimestamp() {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'+05:30'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public static Properties createProperties(final String HOSTS) {
        Properties props = new Properties();
        props.put("bootstrap.servers", HOSTS);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public static void startProducing() {

        Properties props = createProperties(HOSTS);
        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Closing the kafka producer");
            producer.close();
        }));

        Calendar calendar = Calendar.getInstance();
        // -1 for Month since the Months starts from 0(JANUARY)
        Date fromDate = getDate(calendar, FROM_YEAR, FROM_MONTH - 1, FROM_DATE, FROM_HOURS, FROM_MINUTES, FROM_SECONDS);
        Date toDate = getDate(calendar, TO_YEAR, TO_MONTH - 1, TO_DATE, TO_HOURS, TO_MINUTES, TO_SECONDS);
        String timestamp = getTimestamp();
        int seconds = 1;
        while (true) {
            Date newDate = addSeconds(calendar, fromDate, seconds++);
            int iterations = getRandomNumber(false);
            for (int i = 0; i < iterations; i++) {
                for (int j = 0; j < SERVERS.length; j++) {
                    // Alarm
                    producer.send(new ProducerRecord<String, String>(ALARM_TOPIC,
                            AlarmMessage.createAlarmsMessage(SERVERS[j], getRandomNumber(false), timestamp).toString()));
                    // Event
                    producer.send(new ProducerRecord<String, String>(EVENT_TOPIC,
                            EventMessage.createEventMessage(SERVERS[j], getRandomNumber(false), timestamp).toString()));
                }
            }
            if (toDate.compareTo(newDate) == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        startProducing();
    }
}
