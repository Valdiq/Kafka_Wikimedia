package org.example.kafka_consumer.repository;

import org.example.kafka_consumer.entity.WikimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaEntity, Long> {

}
