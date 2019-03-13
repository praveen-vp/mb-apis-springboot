package com.pvp.bank.app.bankapi.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Utils {

    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String SHA512 = "SHA-512";
    public static final String SHA384 = "SHA-384";

    public static String generateReqId(String inputString) throws NoSuchAlgorithmException {
        return get_SHA_SecurePassword(inputString, SHA1);
    }

    public static String get_SHA_SecurePassword(String inputString, String algorithm)
            throws NoSuchAlgorithmException {

        String generatedPassword;
        MessageDigest
                md = MessageDigest.getInstance(algorithm);
        md.update(getSecureRandomByteArray(16));
        byte[] bytes = md.digest(inputString.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        generatedPassword = sb.toString();
        return generatedPassword;
    }

    public static byte[] getSecureRandomByteArray(int size) throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[size];
        sr.nextBytes(salt);
        return salt;
    }

}
