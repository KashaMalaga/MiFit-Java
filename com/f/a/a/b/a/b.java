package com.f.a.a.b.a;

import android.graphics.Bitmap;
import com.f.a.a.b.c;
import java.util.Collection;
import java.util.Comparator;

public class b implements c {
    private final c a;
    private final Comparator<String> b;

    public b(c cVar, Comparator<String> comparator) {
        this.a = cVar;
        this.b = comparator;
    }

    public Bitmap a(String str) {
        return (Bitmap) this.a.b(str);
    }

    public Collection<String> a() {
        return this.a.a();
    }

    public /* synthetic */ void a(Object obj) {
        b((String) obj);
    }

    public boolean a(String str, Bitmap bitmap) {
        synchronized (this.a) {
            for (Object obj : this.a.a()) {
                if (this.b.compare(str, obj) == 0) {
                    break;
                }
            }
            Object obj2 = null;
            if (obj2 != null) {
                this.a.a(obj2);
            }
        }
        return this.a.a(str, bitmap);
    }

    public /* synthetic */ Object b(Object obj) {
        return a((String) obj);
    }

    public void b() {
        this.a.b();
    }

    public void b(String str) {
        this.a.a(str);
    }
}
