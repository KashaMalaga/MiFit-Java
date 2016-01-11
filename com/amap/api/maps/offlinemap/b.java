package com.amap.api.maps.offlinemap;

import com.amap.api.mapcore.util.az;
import com.xiaomi.e.a;
import java.io.File;
import java.io.RandomAccessFile;

class b {
    RandomAccessFile a;

    public b() {
        this(a.f, 0);
    }

    public b(String str, long j) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable e) {
                az.a(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        this.a = new RandomAccessFile(str, "rw");
        this.a.seek(j);
    }

    public synchronized int a(byte[] bArr, int i, int i2) {
        try {
            this.a.write(bArr, i, i2);
        } catch (Throwable e) {
            az.a(e, "FileAccessI", "write");
            e.printStackTrace();
            i2 = -1;
        }
        return i2;
    }
}
