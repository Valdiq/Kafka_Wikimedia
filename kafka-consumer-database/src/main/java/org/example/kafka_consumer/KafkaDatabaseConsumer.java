package org.example.kafka_consumer;

import lombok.RequiredArgsConstructor;
import org.example.kafka_consumer.entity.WikimediaEntity;
import org.example.kafka_consumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaRepository repository;

    @KafkaListener(topics = "Wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message recieved -> %s", eventMessage));

        WikimediaEntity wikimediaEntity = new WikimediaEntity();
        wikimediaEntity.setWikiEventData(eventMessage.substring(0,50));

        repository.save(wikimediaEntity);
    }
}
