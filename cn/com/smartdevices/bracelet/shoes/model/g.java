package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import com.xiaomi.e.a;

public class g {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public String d = a.f;
    public String e = a.f;

    public void a(String str) {
        if (TextUtils.isEmpty(this.d) || this.d.compareTo(str) >= 0) {
            this.d = str;
        }
        if (TextUtils.isEmpty(this.e) || this.e.compareTo(str) <= 0) {
            this.e = str;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CachedMinuteInfo: mSteps = ").append(this.a).append(",mForefootSteps = ").append(this.c).append(",mRunDistance = ").append(this.b).append(",mFromStatisicDate = ").append(this.d).append(",mToStatisicDate = ").append(this.e);
        return stringBuilder.toString();
    }
}
