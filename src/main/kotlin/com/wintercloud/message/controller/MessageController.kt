package com.wintercloud.message.controller

import com.wintercloud.message.config.kafka.KAFKA_TOPIC
import com.wintercloud.message.entity.Message
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/messages")
class MessageController(
    private val kafkaTemplate: KafkaTemplate<String, Message>
) {

    @PostMapping("/send")
    fun sendMessage(
        @RequestBody message: Message,
    ) {
        message.createTimestamp()
        kafkaTemplate.send(KAFKA_TOPIC, message)
    }
}