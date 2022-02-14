package br.com.seda.celfons.core

import br.com.seda.celfons.producer.ProducerService
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class CustomerTask(
        private val producer: ProducerService,
        @Value("\${kafka.topic.payment}") private val destinationTopic: String
) : ITask {

    @KafkaListener(topics = ["\${kafka.topic.customer}", "\${kafka.topic.customer-dlq}"], groupId = "\${kafka.group}")
    override fun execute(@Header(KafkaHeaders.RECEIVED_TOPIC) originTopic: String, @Payload message: String) {
        //TODO implements business rules
        try {
            producer.send(destinationTopic, message)
            println("customer")
        } catch (e: Exception) {
            producer.send("$originTopic-dlq", message)
        }
    }

}