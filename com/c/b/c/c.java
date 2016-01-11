package com.c.b.c;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class c {
    private final byte[] a;
    private int b;
    private int c;

    public c(byte[] bArr) {
        this.a = bArr;
    }

    public int a() {
        return this.c;
    }

    public int a(int i) {
        if (i < 1 || i > 32 || i > c()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        int i3;
        if (this.c > 0) {
            i2 = 8 - this.c;
            i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((HeartRateInfo.HR_EMPTY_VALUE >> (8 - i3)) << i2) & this.a[this.b]) >> i2;
            i -= i3;
            this.c = i3 + this.c;
            if (this.c == 8) {
                this.c = 0;
                this.b++;
            }
            i3 = i2;
            i2 = i;
        } else {
            i3 = 0;
            i2 = i;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            i3 = (i3 << 8) | (this.a[this.b] & HeartRateInfo.HR_EMPTY_VALUE);
            this.b++;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i4 = 8 - i2;
        i3 = (i3 << i2) | ((((HeartRateInfo.HR_EMPTY_VALUE >> i4) << i4) & this.a[this.b]) >> i4);
        this.c = i2 + this.c;
        return i3;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return ((this.a.length - this.b) * 8) - this.c;
    }
}
