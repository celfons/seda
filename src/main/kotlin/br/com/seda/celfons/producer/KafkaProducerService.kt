package br.com.seda.celfons.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerService(
        private val kafkaTemplate: KafkaTemplate<String, String>
): ProducerService {
    override fun send(topic: String, message: String) {
        kafkaTemplate.send(topic, message)
    }
}