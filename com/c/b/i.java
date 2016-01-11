package com.c.b;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class i extends j {
    private final j a;

    public i(j jVar) {
        super(jVar.g(), jVar.h());
        this.a = jVar;
    }

    public j a(int i, int i2, int i3, int i4) {
        return new i(this.a.a(i, i2, i3, i4));
    }

    public byte[] a() {
        byte[] a = this.a.a();
        int h = h() * g();
        byte[] bArr = new byte[h];
        for (int i = 0; i < h; i++) {
            bArr[i] = (byte) (255 - (a[i] & HeartRateInfo.HR_EMPTY_VALUE));
        }
        return bArr;
    }

    public byte[] a(int i, byte[] bArr) {
        byte[] a = this.a.a(i, bArr);
        int g = g();
        for (int i2 = 0; i2 < g; i2++) {
            a[i2] = (byte) (255 - (a[i2] & HeartRateInfo.HR_EMPTY_VALUE));
        }
        return a;
    }

    public boolean b() {
        return this.a.b();
    }

    public boolean c() {
        return this.a.c();
    }

    public j d() {
        return this.a;
    }

    public j e() {
        return new i(this.a.e());
    }

    public j f() {
        return new i(this.a.f());
    }
}
