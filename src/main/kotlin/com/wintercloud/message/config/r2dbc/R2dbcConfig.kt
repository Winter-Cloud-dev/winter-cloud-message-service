package com.wintercloud.message.config.r2dbc

import com.wintercloud.message.converter.ByteBufferToUuidConverter
import com.wintercloud.message.converter.UuidToByteBufferConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.MySqlDialect

@Configuration
class R2dbcConfig {

    @Bean
    fun r2dbcCustomConversions(): R2dbcCustomConversions {
        val converters = listOf(
            ByteBufferToUuidConverter(),
            UuidToByteBufferConverter()
        )
        // MySqlDialect.INSTANCE를 전달하여 MySQL에 특화된 변환을 함께 사용
        return R2dbcCustomConversions.of(MySqlDialect.INSTANCE, converters)
    }
}