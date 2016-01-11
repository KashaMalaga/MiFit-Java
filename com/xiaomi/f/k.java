package com.xiaomi.f;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import com.huami.android.widget.f;
import com.xiaomi.account.openauth.h;
import com.xiaomi.c.a.C1071c;
import com.xiaomi.c.a.C1076h;
import com.xiaomi.c.a.C1078u;
import com.xiaomi.c.a.U;
import com.xiaomi.f.c.g;
import com.xiaomi.f.c.i;
import com.xiaomi.f.e.c;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class k implements U {
    private C1091b a;

    public k(C1091b c1091b) {
        this.a = c1091b;
    }

    public boolean a(C1071c c1071c) {
        boolean z;
        Exception exception;
        C1078u a = c1071c.a();
        boolean z2 = false;
        if (a != null) {
            try {
                XmlPullParser newPullParser;
                int next;
                if (this.a.i()) {
                    Object a2 = a.a(C1076h.a("xm", "challenge"));
                    if (!TextUtils.isEmpty(a2)) {
                        this.a.a((Object) this, (String) a2);
                        z = true;
                        if (this.a.b == null) {
                            this.a.b = a.a(C1076h.a("xm", "sid"));
                            z = true;
                        }
                        if (this.a.a == null) {
                            this.a.a = a.a(C1076h.a("xm", "authid"));
                            z = true;
                        }
                        newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(new StringReader(a.d()));
                        newPullParser.getEventType();
                        while (true) {
                            next = newPullParser.next();
                            this.a.p();
                            if (next == 2) {
                                if (newPullParser.getName().equals("body")) {
                                    z2 = z;
                                } else if (newPullParser.getName().equals(f.a)) {
                                    this.a.b(c.a(newPullParser));
                                    z2 = true;
                                } else if (newPullParser.getName().equals("iq")) {
                                    this.a.b(c.a(newPullParser, this.a));
                                    z2 = true;
                                } else if (newPullParser.getName().equals("presence")) {
                                    this.a.b(c.b(newPullParser));
                                    z2 = true;
                                } else if (newPullParser.getName().equals("challenge")) {
                                    this.a.a((Object) this, newPullParser.nextText());
                                    z2 = true;
                                } else if (newPullParser.getName().equals(h.P)) {
                                    if (newPullParser.getName().equals("warning")) {
                                        try {
                                            newPullParser.next();
                                            if (newPullParser.getName().equals("multi-login")) {
                                                this.a.a(new g(i.unavailable), 6, null);
                                                z2 = true;
                                            }
                                        } catch (Exception e) {
                                            Exception exception2 = e;
                                            z2 = true;
                                            exception = exception2;
                                        }
                                    } else if (newPullParser.getName().equals(NativeInterface.BIND)) {
                                        this.a.b(c.c(newPullParser));
                                    }
                                    z2 = true;
                                } else {
                                    throw new D(c.d(newPullParser));
                                }
                                if (next != 1) {
                                    break;
                                }
                                z = z2;
                            }
                            z2 = z;
                            if (next != 1) {
                                break;
                            }
                            z = z2;
                        }
                    }
                }
                z = false;
                try {
                    if (this.a.b == null) {
                        this.a.b = a.a(C1076h.a("xm", "sid"));
                        z = true;
                    }
                    if (this.a.a == null) {
                        this.a.a = a.a(C1076h.a("xm", "authid"));
                        z = true;
                    }
                    newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(new StringReader(a.d()));
                    newPullParser.getEventType();
                    while (true) {
                        next = newPullParser.next();
                        this.a.p();
                        if (next == 2) {
                            if (newPullParser.getName().equals("body")) {
                                z2 = z;
                            } else if (newPullParser.getName().equals(f.a)) {
                                this.a.b(c.a(newPullParser));
                                z2 = true;
                            } else if (newPullParser.getName().equals("iq")) {
                                this.a.b(c.a(newPullParser, this.a));
                                z2 = true;
                            } else if (newPullParser.getName().equals("presence")) {
                                this.a.b(c.b(newPullParser));
                                z2 = true;
                            } else if (newPullParser.getName().equals("challenge")) {
                                this.a.a((Object) this, newPullParser.nextText());
                                z2 = true;
                            } else if (newPullParser.getName().equals(h.P)) {
                                if (newPullParser.getName().equals("warning")) {
                                    newPullParser.next();
                                    if (newPullParser.getName().equals("multi-login")) {
                                        this.a.a(new g(i.unavailable), 6, null);
                                        z2 = true;
                                    }
                                } else if (newPullParser.getName().equals(NativeInterface.BIND)) {
                                    this.a.b(c.c(newPullParser));
                                }
                                z2 = true;
                            } else {
                                throw new D(c.d(newPullParser));
                            }
                            if (next != 1) {
                                break;
                            }
                            z = z2;
                        }
                        z2 = z;
                        if (next != 1) {
                            break;
                        }
                        z = z2;
                    }
                } catch (Exception e2) {
                    exception = e2;
                    z2 = z;
                }
            } catch (Exception e3) {
                exception = e3;
                if (this.a.j()) {
                    this.a.a(exception);
                }
                return z2;
            }
        }
        return z2;
    }
}
