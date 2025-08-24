package com.wintercloud.message.converter

import com.wintercloud.message.exception.BusinessException
import com.wintercloud.message.exception.ErrorCode
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class StringUuidConverter: Converter<String, UUID> {
    override fun convert(source: String): UUID {
        return try {
            UUID.fromString(source)
        } catch (e: Exception) {
            throw BusinessException(ErrorCode.INVALID_ERROR_CODE)
        }
    }
}