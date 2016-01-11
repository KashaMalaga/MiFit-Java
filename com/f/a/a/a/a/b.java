package com.f.a.a.a.a;

import android.graphics.Bitmap;
import com.f.a.b.a;
import com.f.a.c.e;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b extends a {
    private final long j;
    private final Map<File, Long> k;

    public b(File file, long j) {
        this(file, null, a.b(), j);
    }

    public b(File file, File file2, long j) {
        this(file, file2, a.b(), j);
    }

    public b(File file, File file2, com.f.a.a.a.b.a aVar, long j) {
        super(file, file2, aVar);
        this.k = Collections.synchronizedMap(new HashMap());
        this.j = 1000 * j;
    }

    private void d(String str) {
        File c = c(str);
        long currentTimeMillis = System.currentTimeMillis();
        c.setLastModified(currentTimeMillis);
        this.k.put(c, Long.valueOf(currentTimeMillis));
    }

    public File a(String str) {
        File a = super.a(str);
        if (a != null && a.exists()) {
            Object obj;
            Long l = (Long) this.k.get(a);
            if (l == null) {
                obj = null;
                l = Long.valueOf(a.lastModified());
            } else {
                obj = 1;
            }
            if (System.currentTimeMillis() - l.longValue() > this.j) {
                a.delete();
                this.k.remove(a);
            } else if (obj == null) {
                this.k.put(a, l);
            }
        }
        return a;
    }

    public boolean a(String str, Bitmap bitmap) {
        boolean a = super.a(str, bitmap);
        d(str);
        return a;
    }

    public boolean a(String str, InputStream inputStream, e eVar) {
        boolean a = super.a(str, inputStream, eVar);
        d(str);
        return a;
    }

    public boolean b(String str) {
        this.k.remove(c(str));
        return super.b(str);
    }

    public void c() {
        super.c();
        this.k.clear();
    }
}
