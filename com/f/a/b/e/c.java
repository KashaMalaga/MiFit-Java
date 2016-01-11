package com.f.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.f.a.b.a.f;
import com.f.a.b.a.i;

public class c implements a {
    protected final String a;
    protected final f b;
    protected final i c;

    public c(f fVar, i iVar) {
        this(null, fVar, iVar);
    }

    public c(String str, f fVar, i iVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        } else if (iVar == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        } else {
            this.a = str;
            this.b = fVar;
            this.c = iVar;
        }
    }

    public int a() {
        return this.b.a();
    }

    public boolean a(Bitmap bitmap) {
        return true;
    }

    public boolean a(Drawable drawable) {
        return true;
    }

    public int b() {
        return this.b.b();
    }

    public i c() {
        return this.c;
    }

    public View d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public int f() {
        return TextUtils.isEmpty(this.a) ? super.hashCode() : this.a.hashCode();
    }
}
