package br.com.seda.celfons.api

import br.com.seda.celfons.domain.Message
import br.com.seda.celfons.producer.ProducerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/test"])
class Controller(
        val service: ProducerService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody message: Message) {
        service.send(message.topic, message.body)
    }

}