package com.b;

import com.xiaomi.e.a;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class ae extends DefaultHandler {
    public String a;
    private boolean b;

    private ae() {
        this.a = a.f;
        this.b = false;
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.b) {
            this.a = String.valueOf(cArr, i, i2);
        }
    }

    public void endElement(String str, String str2, String str3) {
        if (str2.equals("sres")) {
            this.b = false;
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str2.equals("sres")) {
            this.b = true;
        }
    }
}
