package cn.com.smartdevices.bracelet.shoes.sync;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;

class S {
    S() {
    }

    public static String a(byte[] bArr) {
        String str = a.f;
        if (bArr == null) {
            return str;
        }
        try {
            return new String(bArr);
        } catch (Exception e) {
            C0596r.e("SyncUtils", "error:" + e.getMessage());
            return str;
        }
    }
}
