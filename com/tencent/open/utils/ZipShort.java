package com.tencent.open.utils;

import android.support.v4.view.Y;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class ZipShort implements Cloneable {
    private int a;

    public ZipShort(int i) {
        this.a = i;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        this.a = (bArr[i + 1] << 8) & Y.g;
        this.a += bArr[i] & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.a == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        return new byte[]{(byte) (this.a & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((this.a & Y.g) >> 8)};
    }

    public int getValue() {
        return this.a;
    }

    public int hashCode() {
        return this.a;
    }
}
