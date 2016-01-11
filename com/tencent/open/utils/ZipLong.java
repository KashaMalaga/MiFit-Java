package com.tencent.open.utils;

import android.support.v4.view.Y;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class ZipLong implements Cloneable {
    private long a;

    public ZipLong(long j) {
        this.a = j;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        this.a = ((long) (bArr[i + 3] << 24)) & 4278190080L;
        this.a += (long) ((bArr[i + 2] << 16) & 16711680);
        this.a += (long) ((bArr[i + 1] << 8) & Y.g);
        this.a += (long) (bArr[i] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipLong) && this.a == ((ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        return new byte[]{(byte) ((int) (this.a & 255)), (byte) ((int) ((this.a & 65280) >> 8)), (byte) ((int) ((this.a & 16711680) >> 16)), (byte) ((int) ((this.a & 4278190080L) >> 24))};
    }

    public long getValue() {
        return this.a;
    }

    public int hashCode() {
        return (int) this.a;
    }
}
