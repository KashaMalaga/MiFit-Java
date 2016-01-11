package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import com.xiaomi.e.a;

public final class d extends a {
    public static final String k = "LN";

    public d(String str, String str2) {
        super(str, str2, a.f);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        g(k);
    }

    public d(String str, String str2, String str3) {
        super(str, str2, str3);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        g(k);
    }

    public d(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        g(k);
    }

    public void a(int i) {
        super.a(i);
    }

    public void a(int i, String str) {
        super.a(i, str);
    }

    public void b(int i) {
        super.b(i);
    }

    public void b(String str) {
        super.b(str);
    }

    public void c(int i) {
        super.c(i);
    }

    public void e(int i) {
        super.e(i);
    }

    public void e(String str) {
        super.e(str);
    }

    public void z() {
        super.a(System.currentTimeMillis() / 1000);
    }
}
