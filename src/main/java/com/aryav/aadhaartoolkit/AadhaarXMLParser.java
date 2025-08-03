package com.aryav.aadhaartoolkit;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class AadhaarXMLParser {
    public static Document parse(File xmlFile) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
    }
}
