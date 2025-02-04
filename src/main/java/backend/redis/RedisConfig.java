package backend.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.master.host}")
    private String masterHostName;

    @Value("${spring.redis.master.port}")
    private String masterPort;

    @Value("${spring.redis.master.password}")
    private String masterPassword;

    @Value("${spring.redis.slave.host}")
    private String slaveHostName;

    @Value("${spring.redis.slave.port}")
    private String slavePort;

    @Value("${spring.redis.slave.password}")
    private String slavePassword;

    @Bean("masterRedisConnectionFactory")
    @Primary
    public RedisConnectionFactory masterRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(masterHostName);
        config.setPort(Integer.parseInt(masterPort));
        config.setPassword(masterPassword);

        return new LettuceConnectionFactory(config, LettucePoolingClientConfiguration.defaultConfiguration());
    }

    @Bean("slaveRedisConnectionFactory")
    public RedisConnectionFactory slaveRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(slaveHostName);
        config.setPort(Integer.parseInt(slavePort));
        config.setPassword(slavePassword);

        return new LettuceConnectionFactory(config, LettucePoolingClientConfiguration.defaultConfiguration());
    }
}

