package com.aryav.aadhaartoolkit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class AadhaarQRReader {
    public static String readQRCode(File file) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(file);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        Result result = new MultiFormatReader().decode(bitmap, hints);

        return result.getText();
    }
}