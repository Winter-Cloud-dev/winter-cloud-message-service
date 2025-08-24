package com.wintercloud.user.exception

import com.wintercloud.user.converter.MessageConverter

class BusinessException(
    val errorCode: ErrorCode,
    vararg args: Any?,
    messageConverter: MessageConverter = MessageConverter(),
) : RuntimeException(messageConverter.getMessage(errorCode.code, *args))