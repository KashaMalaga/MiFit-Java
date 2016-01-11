package cn.com.smartdevices.bracelet.gps.b;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.h.i;

public class d extends a {
    private static final float a = 3.2f;
    private static final float b = 4.0f;
    private static final float c = 5.5f;
    private static final float d = 6.0f;
    private static final float e = 6.5f;
    private static final float f = 7.0f;
    private static final float g = 7.5f;
    private static final float h = 8.0f;
    private static final float i = 8.4f;
    private static final float j = 9.7f;
    private static final float k = 10.8f;
    private static final float l = 11.3f;
    private static final float m = 12.1f;
    private static final float n = 12.9f;
    private static final float o = 13.8f;
    private static final float p = 14.5f;
    private static final float q = 16.0f;
    private static final float r = 17.5f;
    private static final float s = 19.2f;
    private static final float t = 20.8f;
    private static final float u = 22.4f;

    public /* bridge */ /* synthetic */ float a(int i, long j) {
        return super.a(i, j);
    }

    public /* bridge */ /* synthetic */ float a(int i, long j, float f) {
        return super.a(i, j, f);
    }

    protected float b(int i, long j) {
        float b = j > 0 ? i.b(((float) i) / ((float) j)) : 0.0f;
        C0596r.e("Cal", "getMets  speed = " + b);
        return b <= 0.0f ? 0.0f : b <= a ? 2.0f : b <= b ? 3.0f : b <= c ? 4.8f : b <= d ? 6.7f : b <= e ? 7.2f : b <= f ? 7.7f : b <= g ? 8.1f : b <= h ? 8.6f : b <= i ? 9.0f : b <= j ? 10.0f : b <= k ? 11.0f : b <= l ? 11.5f : b <= m ? 12.5f : b <= n ? 13.5f : b <= o ? 14.0f : b <= p ? 15.0f : b <= q ? q : b <= r ? 18.0f : b <= s ? 19.0f : b <= t ? 20.0f : b <= u ? 23.0f : 23.0f;
    }
}
