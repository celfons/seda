package br.com.seda.celfons.core

import br.com.seda.celfons.producer.ProducerService
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PaymentTask(
        private val producer: ProducerService
) : ITask {

    @KafkaListener(topics = ["\${kafka.topic.payment}", "\${kafka.topic.payment-dlq}"], groupId = "\${kafka.group}")
    override fun execute(@Header(KafkaHeaders.RECEIVED_TOPIC) originTopic: String, @Payload message: String) {
        //TODO implements business rules
        println("payment")
    }

}