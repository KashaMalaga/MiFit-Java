package com.a.a.a;

import android.util.Log;
import java.io.InputStream;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class R {
    private static final String a = "ExifReader";
    private final C0895d b;

    R(C0895d c0895d) {
        this.b = c0895d;
    }

    protected C0894c a(InputStream inputStream) {
        N a = N.a(inputStream, this.b);
        C0894c c0894c = new C0894c(a.q());
        for (int a2 = a.a(); a2 != 5; a2 = a.a()) {
            S c;
            byte[] bArr;
            switch (a2) {
                case a.i /*0*/:
                    c0894c.a(new T(a.e()));
                    break;
                case l.a /*1*/:
                    c = a.c();
                    if (!c.f()) {
                        a.a(c);
                        break;
                    }
                    c0894c.b(c.a()).a(c);
                    break;
                case a.k /*2*/:
                    c = a.c();
                    if (c.c() == (short) 7) {
                        a.b(c);
                    }
                    c0894c.b(c.a()).a(c);
                    break;
                case a.l /*3*/:
                    bArr = new byte[a.i()];
                    if (bArr.length != a.a(bArr)) {
                        Log.w(a, "Failed to read the compressed thumbnail");
                        break;
                    }
                    c0894c.a(bArr);
                    break;
                case a.aQ /*4*/:
                    bArr = new byte[a.h()];
                    if (bArr.length != a.a(bArr)) {
                        Log.w(a, "Failed to read the strip bytes");
                        break;
                    }
                    c0894c.a(a.f(), bArr);
                    break;
                default:
                    break;
            }
        }
        return c0894c;
    }
}
