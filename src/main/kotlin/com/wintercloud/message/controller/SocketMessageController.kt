package com.wintercloud.message.controller

import com.wintercloud.message.config.kafka.KAFKA_TOPIC
import com.wintercloud.message.entity.Message
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller

@Controller
class SocketMessageController(
    private val kafkaTemplate: KafkaTemplate<String, Message>
) {
    @MessageMapping("/messages")
    fun broadcastGroupMessage(
        @Payload message: Message,
    ) {
        message.createTimestamp()
        kafkaTemplate.send(KAFKA_TOPIC, message)
    }
}