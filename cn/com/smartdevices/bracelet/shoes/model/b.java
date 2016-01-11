package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;

public class b {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public String e = a.f;
    public int f = 0;
    public int g = 0;

    public b(String str, int i, int i2) {
        this.c = i;
        this.d = i2;
        this.e = str;
    }

    public String a() {
        return this.e + f.i + this.c + f.i + this.d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b) || TextUtils.isEmpty(this.e)) {
            return false;
        }
        b bVar = (b) obj;
        return this.e.equals(bVar.e) && bVar.c == this.c && bVar.d == this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CachedMinuteInfo: mLatestForeSteps = ").append(this.a).append(",mLatestSteps = ").append(this.b).append(",mMinuteIndex = ").append(this.c).append(",mDate = ").append(this.e).append(",mDistance = ").append(this.f).append(",mRunTime = ").append(this.g);
        return stringBuilder.toString();
    }
}
