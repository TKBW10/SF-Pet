package com.pet.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PhoneIdGenerator {

    // 生成 10 位唯一 ID
    public static String generateId(String phoneNumber) {
        String salt = "IoT$" + new Random().nextInt(9999);
        String input = phoneNumber + salt;

        try {
            // MD5 哈希
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());

            // 转成无符号整数，再转36进制压缩
            String base36 = new BigInteger(1, hash).toString(36).toUpperCase();

            // 补零截取
            return padLeft(base36).substring(0, 10);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 算法不可用", e);
        }
    }

    // 左侧补零
    private static String padLeft(String input) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + input.length() < 10) {
            sb.append('0');
        }
        sb.append(input);
        return sb.toString();
    }
}