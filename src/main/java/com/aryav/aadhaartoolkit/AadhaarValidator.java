package com.aryav.aadhaartoolkit;

import com.aryav.aadhaartoolkit.utils.VerhoeffChecksum;

public class AadhaarValidator {

    /**
     * Validates Aadhaar number using regex and Verhoeff checksum.
     */
    public static boolean isValid(String aadhaar) {
        return VerhoeffChecksum.validateVerhoeff(aadhaar);
    }

    /**
     * Masks Aadhaar number: 123412341234 → XXXX-XXXX-1234
     */
    public static String mask(String aadhaar) {
        if (!isValid(aadhaar)) return "Invalid Aadhaar";
        return "XXXX-XXXX-" + aadhaar.substring(aadhaar.length() - 4);
    }

    /**
     * Unmasks placeholder for testing
     */
    public static String unmask(String masked, String last4Digits) {
        if (masked == null || !masked.matches("X{4}-X{4}-\\d{4}")) return "Invalid format";
        return "XXXXXXXX" + last4Digits;
    }

    public static void main(String[] args) {
        String aadhaar = "123412341234";
        System.out.println("Valid: " + isValid(aadhaar));
        System.out.println("Masked: " + mask(aadhaar));
        System.out.println("Unmasked: " + unmask(mask(aadhaar), aadhaar.substring(8)));
    }
}