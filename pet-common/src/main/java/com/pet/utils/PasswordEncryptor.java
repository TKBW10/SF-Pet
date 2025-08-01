package com.pet.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PasswordEncryptor {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private PasswordEncryptor() {
        throw new UnsupportedOperationException("工具类不允许实例化");
    }

    // 加密密码（不可逆）
    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    // 校验密码
    public static boolean matches(String rawPassword, String encryptedPassword) {
        return encoder.matches(rawPassword, encryptedPassword);
    }
}
