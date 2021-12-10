package com.kafkalibrary.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.KafkaHeaders;

@Configuration
@EnableKafka
public class LibraryEventConsumerConfig {

//    @KafkaListener(topicPattern = "kafka.enes")
//    @Bean
//    public void getTopic(){
//        String topic = KafkaHeaders.RECEIVED_TOPIC;
//        NewTopic deadlettertopic = TopicBuilder.name(String.format("%s_deadletter",topic))
//                .partitions(1)
//                .replicas(1)
//                .build();
//    }
}

