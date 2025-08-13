package com.pet.utils;

import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class JwtBlacklistUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    public JwtBlacklistUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static final String BLACKLIST_PREFIX = "jwt:blacklist:";

    /**
     * 将 Token 加入黑名单
     */
    public void addToBlacklist(String token) {
        Claims claims = JwtUtil.parseToken(token);
        long expireMillis = claims.getExpiration().getTime() - System.currentTimeMillis();
        if (expireMillis > 0) {
            redisTemplate.opsForValue().set(
                BLACKLIST_PREFIX + token,
                "",
                expireMillis,
                TimeUnit.MILLISECONDS
            );
        }
    }

    /**
     * 判断 Token 是否在黑名单
     */
    public boolean isBlacklisted(String token) {
        return redisTemplate.hasKey(BLACKLIST_PREFIX + token);
    }
}
