package backend.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    @Qualifier("masterRedisTemplate")
    private final RedisTemplate<String, Object> masterRedisTemplate;

    @Autowired
    @Qualifier("slaveRedisTemplate")
    private final RedisTemplate<String, Object> slaveRedisTemplate;

    public RedisService(
                    @Qualifier("masterRedisTemplate") RedisTemplate<String, Object> masterRedisTemplate,
                    @Qualifier("slaveRedisTemplate") RedisTemplate<String, Object> slaveRedisTemplate
            )
    {
        this.masterRedisTemplate = masterRedisTemplate;
        this.slaveRedisTemplate = slaveRedisTemplate;
    }

    // 写入数据
    public void set(String key, Object value) {
        masterRedisTemplate.opsForValue().set(key, value);
    }

    // 读取数据
    public <T> T get(String key, Class<T> clazz) {
        Object value = slaveRedisTemplate.opsForValue().get(key);

        if (value != null && clazz.isInstance(value))
            return clazz.cast(value);

        return null;
    }
}

