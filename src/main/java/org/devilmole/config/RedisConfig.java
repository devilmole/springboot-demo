package org.devilmole.config;

import org.devilmole.model.SystemUser;
import org.devilmole.util.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, SystemUser> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, SystemUser> templates = new RedisTemplate<String, SystemUser>();
        templates.setConnectionFactory(factory);
        templates.setKeySerializer(new StringRedisSerializer());
        templates.setValueSerializer(new RedisObjectSerializer());
        return templates;
    }

}
