package com.a.a.a;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.InputStream;
import java.nio.ByteBuffer;

class C0892a extends InputStream {
    private final ByteBuffer a;

    public C0892a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public int read() {
        return !this.a.hasRemaining() ? -1 : this.a.get() & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.a.remaining());
        this.a.get(bArr, i, min);
        return min;
    }
}
