package com.xiaomi.network;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class l extends FilterInputStream {
    private boolean a;

    public l(InputStream inputStream) {
        super(inputStream);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.a) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
        }
        this.a = true;
        return -1;
    }
}
