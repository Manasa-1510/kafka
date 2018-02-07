package com.practice.kafka;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerEx {
	
	public static void main(String[] args){
		Properties properties = new Properties();

		//kafka bootstrap server
		properties.setProperty("bootstrap.servers","localhost:9092");
		properties.setProperty("key.serializer",StringSerializer.class.getName());
		properties.setProperty("value.serializer",StringSerializer.class.getName());
		//producer acks
		properties.setProperty("acks","1");
		properties.setProperty("retries","3");
		properties.setProperty("linger.ms","1");
		//topic name


		 org.apache.kafka.clients.producer.Producer<String,String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String,String>(properties);

		ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("new_topic", "message test");

		producer.send(producerRecord);
		producer.close();
	}
}