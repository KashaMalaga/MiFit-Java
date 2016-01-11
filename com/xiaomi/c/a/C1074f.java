package com.xiaomi.c.a;

import com.xiaomi.e.a;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.SoftReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class C1074f implements C1072d {
    private static final Logger a = Logger.getLogger(C1074f.class.getName());
    private static final ThreadLocal<SoftReference<XmlPullParser>> b = new C1075g();

    C1074f() {
    }

    private static XmlPullParser a() {
        XmlPullParser xmlPullParser = (XmlPullParser) ((SoftReference) b.get()).get();
        if (xmlPullParser != null) {
            return xmlPullParser;
        }
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            newInstance.setValidating(false);
            xmlPullParser = newInstance.newPullParser();
            b.set(new SoftReference(xmlPullParser));
            return xmlPullParser;
        } catch (Throwable e) {
            throw new IllegalStateException("Could not create XmlPull parser", e);
        }
    }

    public C1073e a(String str) {
        Throwable e;
        C1073e c1073e = new C1073e();
        try {
            XmlPullParser a = C1074f.a();
            a.setInput(new StringReader(str));
            for (int eventType = a.getEventType(); eventType != 1; eventType = a.next()) {
                if (eventType == 2) {
                    if (a.isLoggable(Level.FINEST)) {
                        a.finest("Start tag: " + a.getName());
                    }
                    String prefix = a.getPrefix();
                    if (prefix == null) {
                        prefix = a.f;
                    }
                    String namespace = a.getNamespace();
                    String name = a.getName();
                    C1086q c1086q = new C1086q(namespace, name, prefix);
                    if (a.isLoggable(Level.FINEST)) {
                        a.finest("Start element: ");
                        a.finest("    prefix: " + prefix);
                        a.finest("    URI: " + namespace);
                        a.finest("    local: " + name);
                    }
                    C1076h f = C1078u.f();
                    if (f.a(c1086q)) {
                        for (int i = 0; i < a.getAttributeCount(); i++) {
                            prefix = a.getAttributeNamespace(i);
                            namespace = prefix.length() == 0 ? a.getNamespace(null) : prefix;
                            prefix = a.getAttributePrefix(i);
                            if (prefix == null) {
                                prefix = a.f;
                            }
                            String attributeName = a.getAttributeName(i);
                            String attributeValue = a.getAttributeValue(i);
                            f = C1076h.a(namespace, attributeName, prefix);
                            if (a.isLoggable(Level.FINEST)) {
                                a.finest("        Attribute: {" + namespace + "}" + attributeName + " = '" + attributeValue + "'");
                            }
                            c1073e.a(f, attributeValue);
                        }
                        return c1073e;
                    }
                    throw new IllegalStateException("Root element was not '" + f.b() + "' in the '" + f.a() + "' namespace.  (Was '" + name + "' in '" + namespace + "')");
                }
            }
            return c1073e;
        } catch (RuntimeException e2) {
            e = e2;
        } catch (XmlPullParserException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
        throw new C1070b("Could not parse body:\n" + str, e);
    }
}
