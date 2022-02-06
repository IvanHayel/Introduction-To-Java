package com.epam.introduction.tasks.task_3.util.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

public class Encoder {
    private static Encoder instance;

    private final String ALGORITHM = "AES";
    private final String TRANSFORMATION = "AES";
    private final int KEY_LENGTH = 16;
    private final String KEY = "3141592653589793";

    private byte[] decodedKey = Base64.getDecoder().decode(KEY);

    private Encoder() {
    }

    public String encrypt(String input) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKey secretKey = new SecretKeySpec(Arrays.copyOf(decodedKey, KEY_LENGTH), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedInput = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedInput);
        } catch (Exception e) {
            throw new IOException("Security error!");
        }
    }

    public String decrypt(String input) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKey secretKey = new SecretKeySpec(Arrays.copyOf(decodedKey, KEY_LENGTH), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedInput = cipher.doFinal(Base64.getDecoder().decode(input));
            return new String(decryptedInput);
        } catch (Exception e) {
            throw new IOException("Security error!");
        }
    }

    public static Encoder instance() {
        if (instance == null) {
            instance = new Encoder();
        }
        return instance;
    }
}