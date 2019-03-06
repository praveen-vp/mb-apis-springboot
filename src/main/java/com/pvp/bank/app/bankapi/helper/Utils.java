package com.pvp.bank.app.bankapi.helper;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Utils {

    public static String getSHA1_diget(String inputString) throws Exception {
        java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(inputString.getBytes(StandardCharsets.UTF_8));
        return Arrays.toString(digest.digest());
    }

}
