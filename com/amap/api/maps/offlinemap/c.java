package com.amap.api.maps.offlinemap;

import com.activeandroid.b;
import com.amap.api.mapcore.n;
import com.amap.api.mapcore.util.az;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.account.openauth.h;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class c extends Thread {
    String a;
    long b;
    long c;
    int d;
    boolean e = false;
    boolean f = false;
    b g = null;
    HttpURLConnection h;
    InputStream i;
    private int j = 0;

    public c(String str, String str2, long j, long j2, int i) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.g = new b(str2, this.b);
    }

    public synchronized int a() {
        return this.j;
    }

    public void b() {
        try {
            this.f = true;
            interrupt();
        } catch (Throwable th) {
            Thread.interrupted();
            az.a(th, "FileSplitterFetch", "splitterStop");
            th.printStackTrace();
        }
    }

    public void run() {
        while (this.b < this.c && !this.f) {
            try {
                if (isInterrupted()) {
                    if (this.i != null) {
                        try {
                            this.i.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        this.i = null;
                    }
                    if (this.h != null) {
                        this.h.disconnect();
                        this.h = null;
                    }
                    m.a((int) h.E);
                    return;
                } else if (this.j > 3) {
                    b();
                    if (this.i != null) {
                        try {
                            this.i.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        this.i = null;
                    }
                    if (this.h != null) {
                        this.h.disconnect();
                        this.h = null;
                    }
                    m.a((int) h.E);
                    return;
                } else {
                    this.h = (HttpURLConnection) new URL(this.a).openConnection();
                    this.h.setRequestProperty("User-Agent", n.c);
                    this.h.setRequestMethod(Constants.HTTP_GET);
                    this.h.setRequestProperty("Content-Type", "text/xml;");
                    String str = "bytes=" + this.b + "-";
                    this.h.setRequestProperty("RANGE", str);
                    m.a(str);
                    this.i = this.h.getInputStream();
                    byte[] bArr = new byte[b.a];
                    while (true) {
                        int read = this.i.read(bArr, 0, b.a);
                        if (read <= 0 || this.b >= this.c || this.f) {
                            break;
                        }
                        this.b += (long) this.g.a(bArr, 0, read);
                    }
                    m.a("Thread " + this.d + " is over!");
                    this.e = true;
                    if (this.i != null) {
                        try {
                            this.i.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                        this.i = null;
                    }
                    if (this.h != null) {
                        this.h.disconnect();
                        this.h = null;
                    }
                    m.a((int) h.E);
                }
            } catch (Throwable e3) {
                az.a(e3, "FileSplitterFetch", SocialConstants.TYPE_REQUEST);
                this.j++;
                e3.printStackTrace();
                m.b("failuetimes:" + System.currentTimeMillis() + "\n");
                m.b(e3.getMessage() + "\n");
                m.b(m.a(e3) + "\n");
                if (this.i != null) {
                    try {
                        this.i.close();
                    } catch (IOException e222) {
                        e222.printStackTrace();
                    }
                    this.i = null;
                }
                if (this.h != null) {
                    this.h.disconnect();
                    this.h = null;
                }
                m.a((int) h.E);
            } catch (Throwable th) {
                if (this.i != null) {
                    try {
                        this.i.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    this.i = null;
                }
                if (this.h != null) {
                    this.h.disconnect();
                    this.h = null;
                }
                m.a((int) h.E);
            }
        }
    }
}
