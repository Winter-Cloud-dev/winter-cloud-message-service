package com.wintercloud.message.entity

import java.time.LocalDateTime
import java.util.UUID

data class Message(
    val sender: String?,
    val text: String?,
    val roomId: UUID?,
    var timestamp: String?,
) {
    fun createTimestamp() {
        this.timestamp = LocalDateTime.now().toString()
    }
}
