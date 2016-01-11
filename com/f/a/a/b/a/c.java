package com.f.a.a.b.a;

import android.graphics.Bitmap;
import com.f.a.a.b.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c extends b {
    private static final int a = 10;
    private static final float b = 1.1f;
    private final Map<String, Bitmap> c = Collections.synchronizedMap(new LinkedHashMap(a, b, true));

    public c(int i) {
        super(i);
    }

    public Bitmap a(String str) {
        this.c.get(str);
        return super.a(str);
    }

    protected Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    public /* synthetic */ void a(Object obj) {
        b((String) obj);
    }

    public boolean a(String str, Bitmap bitmap) {
        if (!super.a(str, bitmap)) {
            return false;
        }
        this.c.put(str, bitmap);
        return true;
    }

    protected int b(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public /* synthetic */ Object b(Object obj) {
        return a((String) obj);
    }

    public void b() {
        this.c.clear();
        super.b();
    }

    public void b(String str) {
        this.c.remove(str);
        super.b(str);
    }

    protected Bitmap d() {
        Bitmap bitmap = null;
        synchronized (this.c) {
            Iterator it = this.c.entrySet().iterator();
            if (it.hasNext()) {
                bitmap = (Bitmap) ((Entry) it.next()).getValue();
                it.remove();
            }
        }
        return bitmap;
    }
}
