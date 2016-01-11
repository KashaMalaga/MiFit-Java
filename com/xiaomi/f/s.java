package com.xiaomi.f;

import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.huami.android.widget.f;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.f.c.e;
import com.xiaomi.f.e.c;
import com.xiaomi.g.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class s {
    private Thread a;
    private A b;
    private XmlPullParser c;
    private boolean d;

    protected s(A a) {
        this.b = a;
        a();
    }

    private void a(e eVar) {
        if (eVar != null) {
            for (m a : this.b.f.values()) {
                a.a(eVar);
            }
        }
    }

    private void e() {
        this.c = XmlPullParserFactory.newInstance().newPullParser();
        this.c.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        this.c.setInput(this.b.i);
    }

    private void f() {
        e();
        int eventType = this.c.getEventType();
        String str = a.f;
        do {
            this.b.p();
            if (eventType == 2) {
                String name = this.c.getName();
                if (this.c.getName().equals(f.a)) {
                    a(c.a(this.c));
                    str = name;
                } else {
                    try {
                        if (this.c.getName().equals("iq")) {
                            a(c.a(this.c, this.b));
                            str = name;
                        } else if (this.c.getName().equals("presence")) {
                            a(c.b(this.c));
                            str = name;
                        } else if (this.c.getName().equals("stream")) {
                            str = a.f;
                            for (int i = 0; i < this.c.getAttributeCount(); i++) {
                                if (this.c.getAttributeName(i).equals(QQLogin.KEY_FROM)) {
                                    this.b.m.a(this.c.getAttributeValue(i));
                                } else if (this.c.getAttributeName(i).equals("challenge")) {
                                    str = this.c.getAttributeValue(i);
                                } else if ("dot".equals(this.c.getAttributeName(i))) {
                                    try {
                                        g.a().a(Integer.parseInt(this.c.getAttributeValue(i)));
                                    } catch (NumberFormatException e) {
                                    }
                                }
                            }
                            this.b.a((Object) this, str);
                            str = name;
                        } else if (this.c.getName().equals(h.P)) {
                            throw new D(c.d(this.c));
                        } else {
                            if (this.c.getName().equals("warning")) {
                                this.c.next();
                                if (this.c.getName().equals("multi-login")) {
                                    a(6, null);
                                    str = name;
                                }
                            } else if (this.c.getName().equals(NativeInterface.BIND)) {
                                a(c.c(this.c));
                                str = name;
                            }
                            str = name;
                        }
                    } catch (Throwable e2) {
                        com.xiaomi.channel.a.b.c.a(e2);
                        if (this.d) {
                            com.xiaomi.channel.a.b.c.b("reader is shutdown, ignore the exception.");
                            return;
                        } else {
                            a(9, e2);
                            return;
                        }
                    }
                }
            } else if (eventType == 3 && this.c.getName().equals("stream")) {
                a(13, null);
            }
            eventType = this.c.next();
            if (this.d) {
                break;
            }
        } while (eventType != 1);
        if (eventType == 1) {
            throw new Exception("SMACK: server close the connection or timeout happened, last element name=" + str + " host=" + this.b.e());
        }
    }

    protected void a() {
        this.d = false;
        this.a = new t(this, "Smack Packet Reader (" + this.b.l + ")");
    }

    void a(int i, Exception exception) {
        this.d = true;
        this.b.a(i, exception);
    }

    public void b() {
        this.a.start();
    }

    public void c() {
        this.d = true;
    }

    void d() {
        this.b.f.clear();
    }
}
