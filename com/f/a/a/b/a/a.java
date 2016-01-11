package com.f.a.a.b.a;

import android.graphics.Bitmap;
import com.f.a.a.b.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class a extends b {
    private final List<Bitmap> a = Collections.synchronizedList(new LinkedList());

    public a(int i) {
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
        this.a.add(bitmap);
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
        return (Bitmap) this.a.remove(0);
    }
}
