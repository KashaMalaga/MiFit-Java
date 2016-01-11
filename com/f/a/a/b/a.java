package com.f.a.a.b;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class a implements c {
    private final Map<String, Reference<Bitmap>> a = Collections.synchronizedMap(new HashMap());

    public Bitmap a(String str) {
        Reference reference = (Reference) this.a.get(str);
        return reference != null ? (Bitmap) reference.get() : null;
    }

    protected abstract Reference<Bitmap> a(Bitmap bitmap);

    public Collection<String> a() {
        Collection hashSet;
        synchronized (this.a) {
            hashSet = new HashSet(this.a.keySet());
        }
        return hashSet;
    }

    public /* synthetic */ void a(Object obj) {
        b((String) obj);
    }

    public boolean a(String str, Bitmap bitmap) {
        this.a.put(str, a(bitmap));
        return true;
    }

    public /* synthetic */ Object b(Object obj) {
        return a((String) obj);
    }

    public void b() {
        this.a.clear();
    }

    public void b(String str) {
        this.a.remove(str);
    }
}
