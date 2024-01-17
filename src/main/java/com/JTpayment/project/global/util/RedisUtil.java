package com.JTpayment.project.global.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisUtil {
    private final StringRedisTemplate redisTemplate;

    public String getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setDataExpire(String key, String value, Long time) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, time, java.util.concurrent.TimeUnit.SECONDS);
    }
}
