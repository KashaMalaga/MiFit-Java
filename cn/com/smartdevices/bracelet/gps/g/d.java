package cn.com.smartdevices.bracelet.gps.g;

import android.text.TextUtils;
import com.xiaomi.e.a;
import java.util.List;
import java.util.UUID;

final class d {
    String a;
    List<String> b;
    int c;

    public d() {
        this.a = a.f;
        this.b = null;
        this.c = 0;
        this.a = UUID.randomUUID().toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        return this.a.equals(((d) obj).a);
    }
}
