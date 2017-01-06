package com.company.writer;

public class XmlWriter implements Writer {
    @Override
    public void write(String str) {
        System.out.println("xml: "+str);
    }
}

