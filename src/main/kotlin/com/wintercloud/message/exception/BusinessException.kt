package com.wintercloud.message.exception

import com.wintercloud.message.converter.MessageConverter

class BusinessException(
    val errorCode: ErrorCode,
    vararg args: Any?,
    messageConverter: MessageConverter = MessageConverter(),
) : RuntimeException(messageConverter.getMessage(errorCode.code, *args))