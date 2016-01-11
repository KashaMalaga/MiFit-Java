package com.f.a.a.b.a;

import android.graphics.Bitmap;
import com.f.a.a.b.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d extends b {
    private final Map<Bitmap, Integer> a = Collections.synchronizedMap(new HashMap());

    public d(int i) {
        super(i);
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
        this.a.put(bitmap, Integer.valueOf(b(bitmap)));
        return true;
    }

    protected int b(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public void b() {
        this.a.clear();
        super.b();
    }

    public void b(String str) {
        Bitmap a = super.a(str);
        if (a != null) {
            this.a.remove(a);
        }
        super.b(str);
    }

    protected Bitmap d() {
        Bitmap bitmap = null;
        Set<Entry> entrySet = this.a.entrySet();
        synchronized (this.a) {
            Integer num = null;
            for (Entry entry : entrySet) {
                Bitmap bitmap2;
                Integer num2;
                if (bitmap == null) {
                    bitmap2 = (Bitmap) entry.getKey();
                    num2 = (Integer) entry.getValue();
                } else {
                    Integer num3 = (Integer) entry.getValue();
                    if (num3.intValue() > num.intValue()) {
                        Bitmap bitmap3 = (Bitmap) entry.getKey();
                        num2 = num3;
                        bitmap2 = bitmap3;
                    } else {
                        bitmap2 = bitmap;
                        num2 = num;
                    }
                }
                bitmap = bitmap2;
                num = num2;
            }
        }
        this.a.remove(bitmap);
        return bitmap;
    }
}
