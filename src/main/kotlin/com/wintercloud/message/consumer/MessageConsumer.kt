package com.wintercloud.message.consumer

import com.wintercloud.message.config.kafka.KAFKA_TOPIC
import com.wintercloud.message.entity.Message
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class MessageConsumer(
    private var template: SimpMessagingTemplate,
) {

    @KafkaListener(
        topics = [KAFKA_TOPIC],
        groupId = "message-consumer",
    )
    fun consume(message: Message) {
        template.convertAndSend("/topic/room/${message.roomId}", message)
    }
}