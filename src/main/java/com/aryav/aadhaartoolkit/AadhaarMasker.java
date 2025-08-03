package com.aryav.aadhaartoolkit;

public class AadhaarMasker {
    public static String mask(String aadhaar) {
        return AadhaarValidator.mask(aadhaar);
    }

    public static String unmask(String masked, String last4Digits) {
        return AadhaarValidator.unmask(masked, last4Digits);
    }
}
