package com.c.b;

import android.support.v4.view.a.C0113o;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public abstract class j {
    private final int a;
    private final int b;

    protected j(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public j a(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public abstract byte[] a();

    public abstract byte[] a(int i, byte[] bArr);

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public j d() {
        return new i(this);
    }

    public j e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public j f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final int g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public final String toString() {
        byte[] bArr = new byte[this.a];
        StringBuilder stringBuilder = new StringBuilder(this.b * (this.a + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.b; i++) {
            bArr2 = a(i, bArr2);
            for (int i2 = 0; i2 < this.a; i2++) {
                int i3 = bArr2[i2] & HeartRateInfo.HR_EMPTY_VALUE;
                char c = i3 < 64 ? '#' : i3 < C0113o.h ? '+' : i3 < 192 ? '.' : ' ';
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
