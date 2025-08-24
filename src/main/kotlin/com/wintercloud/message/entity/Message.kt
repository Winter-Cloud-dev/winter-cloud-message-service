package com.wintercloud.message.entity

import java.time.LocalDateTime

data class Message(
    val sender: String?,
    val text: String?,
    val roomId: String?,
    var timestamp: String?,
) {
    fun createTimestamp() {
        this.timestamp = LocalDateTime.now().toString()
    }
}
