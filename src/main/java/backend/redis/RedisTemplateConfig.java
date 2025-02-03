package backend.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

    @Bean("masterRedisTemplate")
    public RedisTemplate<String, Object> masterRedisTemplate(
            @Qualifier("masterRedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory);
    }

    @Bean("slaveRedisTemplate")
    public RedisTemplate<String, Object> slaveRedisTemplate(
            @Qualifier("slaveRedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory);
    }

    private RedisTemplate<String, Object> createRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 设置 Key 采用 String 序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);

        // Jackson 序列化器，并直接在构造方法中传入 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // 处理 LocalDateTime
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);

        // Value 采用 Jackson 序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }
}


