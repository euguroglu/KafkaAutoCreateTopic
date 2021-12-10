package com.kafkalibrary.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    @KafkaListener(topicPattern = "kafka.enes")
    public void onMessage(String consumerRecord, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws Exception{

        log.info("ConsumerRecord : {}", consumerRecord);

        String deadlettertopic = String.format("%s_deadletter",topic);
        System.out.println(deadlettertopic);
        System.out.println(KafkaHeaders.RECEIVED_TOPIC);

        NewTopic deadlettertopic2 = TopicBuilder.name(String.format("%s_deadletter",topic))
                .partitions(1)
                .replicas(1)
                .build();

        System.out.println(deadlettertopic2);
    }

}

/*
*     public void send(String eventMessage, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws Exception {


        String deadlettertopic = String.format("%s_deadletter",topic);
        System.out.println(deadlettertopic);
        System.out.println(KafkaHeaders.RECEIVED_TOPIC);
        //Invoke kafka producer
        log.info("before-sendLibraryEvent"); // To observe asyncronus behaviour
        kafkaProducerService.sendOnFailure(deadlettertopic, eventMessage);
        log.info("after-sendLibraryEvent");
        //libraryEventProducer.sendLibraryEventSynchronous(libraryEvent)
    }
*
* */