package com.aryav.aadhaartoolkit.test;

import java.io.File;

import org.w3c.dom.Document;

import com.aryav.aadhaartoolkit.AadhaarMasker;
import com.aryav.aadhaartoolkit.AadhaarPDFParser;
import com.aryav.aadhaartoolkit.AadhaarQRReader;
import com.aryav.aadhaartoolkit.AadhaarValidator;
import com.aryav.aadhaartoolkit.AadhaarXMLParser;

public class test {
    public static void main(String[] args) {
        // AadhaarValidator Tests
        String validAadhaar = "234512341234";
        String invalidAadhaar = "123456789012";
        System.out.println("Valid Aadhaar: " + validAadhaar + " => " + AadhaarValidator.isValid(validAadhaar));
        System.out.println("Invalid Aadhaar: " + invalidAadhaar + " => " + AadhaarValidator.isValid(invalidAadhaar));

        // AadhaarMasker Tests
        String masked = AadhaarMasker.mask(validAadhaar);
        System.out.println("Masked Aadhaar: " + masked);
        System.out.println("Unmasked Aadhaar: " + AadhaarMasker.unmask(masked, validAadhaar.substring(8)));

        // AadhaarQRReader Test (needs an image file with QR)
        try {
            File qrImage = new File("src/test/resources/sample_qr.png");
            String qrText = AadhaarQRReader.readQRCode(qrImage);
            System.out.println("QR Code Data: " + qrText);
        } catch (Exception e) {
            System.out.println("QR Reader failed: " + e.getMessage());
        }

        // AadhaarPDFParser Test (needs sample PDF file)
        try {
            File pdf = new File("src/test/resources/sample_aadhaar.pdf");
            String pdfText = AadhaarPDFParser.extractText(pdf);
            System.out.println("PDF Text: " + pdfText);
        } catch (Exception e) {
            System.out.println("PDF Parser failed: " + e.getMessage());
        }

        // AadhaarXMLParser Test (needs sample XML file)
        try {
            File xml = new File("src/test/resources/sample_aadhaar.xml");
            Document doc = AadhaarXMLParser.parse(xml);
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            System.out.println("XML Parser failed: " + e.getMessage());
        }
    }
}
