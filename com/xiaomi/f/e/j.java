package com.xiaomi.f.e;

import android.text.TextUtils;
import com.xiaomi.e.a;

class j {
    public String a = a.f;
    public long b = 0;
    public int c = -1;
    public int d = -1;
    public String e = a.f;
    public long f = 0;

    public j(String str, long j, int i, int i2, String str2, long j2) {
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = str2;
        this.f = j2;
    }

    public boolean a(j jVar) {
        return TextUtils.equals(jVar.a, this.a) && TextUtils.equals(jVar.e, this.e) && jVar.c == this.c && jVar.d == this.d && Math.abs(jVar.b - this.b) <= 5000;
    }
}
