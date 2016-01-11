package com.xiaomi.c.a;

import java.lang.ref.SoftReference;
import org.xmlpull.v1.XmlPullParser;

final class C1075g extends ThreadLocal<SoftReference<XmlPullParser>> {
    C1075g() {
    }

    protected SoftReference<XmlPullParser> a() {
        return new SoftReference(null);
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}
