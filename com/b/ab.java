package com.b;

import com.amap.api.location.LocationManagerProxy;
import com.d.a.a.h;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ab {
    protected ab() {
    }

    String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes(h.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            byteArrayInputStream = null;
        }
        DefaultHandler aeVar = new ae();
        if (byteArrayInputStream != null) {
            try {
                SAXParserFactory.newInstance().newSAXParser().parse(byteArrayInputStream, aeVar);
                byteArrayInputStream.close();
            } catch (SAXException e2) {
            } catch (Throwable th) {
                th.printStackTrace();
                ao.a(th);
            }
        }
        return aeVar.a;
    }

    M b(String str) {
        if (str == null || str.length() == 0 || str.contains("SuccessCode=\"0\"")) {
            return null;
        }
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes(h.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            byteArrayInputStream = null;
        }
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        DefaultHandler adVar = new ad();
        if (byteArrayInputStream != null) {
            try {
                newInstance.newSAXParser().parse(byteArrayInputStream, adVar);
                byteArrayInputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        adVar.a.f(LocationManagerProxy.NETWORK_PROVIDER);
        if (adVar.a.h() == 0) {
            adVar.a.a(ao.a());
        }
        return adVar.a;
    }
}
