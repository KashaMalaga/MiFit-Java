package com.xiaomi.f;

import android.text.TextUtils;
import com.xiaomi.network.c;
import java.net.URI;
import kankan.wheel.widget.a;

public class C1090a extends o {
    private boolean b;
    private String c;
    private c d = null;
    private String e = "mibind.chat.gslb.mi-idc.com";

    public C1090a(boolean z, c cVar, int i, String str, String str2, q qVar) {
        super(null, i, str2, qVar);
        this.d = cVar;
        this.b = z;
        if (str == null) {
            str = "/";
        }
        this.c = str;
    }

    public c a() {
        return this.d;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.d = cVar;
            this.e = "mibind.chat.gslb.mi-idc.com";
            if (!this.d.c().isEmpty()) {
                String str = (String) this.d.c().get(0);
                if (!TextUtils.isEmpty(str)) {
                    this.e = str;
                }
            }
        }
    }

    public String b() {
        return this.e;
    }

    public URI c() {
        if (this.c.charAt(0) != '/') {
            this.c = '/' + this.c;
        }
        return new URI((this.b ? "https://" : "http://") + this.e + a.ci + g() + this.c);
    }
}
