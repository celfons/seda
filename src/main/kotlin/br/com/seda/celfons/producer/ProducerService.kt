package br.com.seda.celfons.producer

import org.springframework.stereotype.Service

@Service
interface ProducerService {
    fun send(topic: String, message: String)
}