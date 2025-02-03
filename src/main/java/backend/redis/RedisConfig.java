package backend.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

@Configuration
public class RedisConfig {

    @Bean("masterRedisConnectionFactory")
    @Primary
    public RedisConnectionFactory masterRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("47.130.53.29"); // 主节点 IP
        config.setPort(6379); // 主节点端口
        config.setPassword("liuxingzhao"); // 如果有密码

        return new LettuceConnectionFactory(config, LettucePoolingClientConfiguration.defaultConfiguration());
    }

    @Bean("slaveRedisConnectionFactory")
    public RedisConnectionFactory slaveRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("47.130.53.29"); // 从节点 IP
        config.setPort(6380); // 从节点端口
        config.setPassword("liuxingzhao"); // 如果有密码

        return new LettuceConnectionFactory(config, LettucePoolingClientConfiguration.defaultConfiguration());
    }
}

