package com.xiaomi.channel.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.File;

public class t implements o {
    private int a;
    private s b;
    private final int c;
    private p d;
    private int e;

    @Deprecated
    public t(int i, s sVar, int i2) {
        this(sVar, i2);
    }

    public t(s sVar, int i) {
        this.a = 0;
        this.e = 0;
        this.b = sVar;
        this.c = i;
    }

    public Bundle a() {
        Object obj = 1;
        Bundle bundle = new Bundle();
        bundle.putInt(v.n, this.c);
        if (this.b != null) {
            Object obj2;
            if (TextUtils.isEmpty(this.b.c)) {
                obj2 = null;
            } else {
                bundle.putString(v.g, this.b.c);
                obj2 = 1;
            }
            if (!TextUtils.isEmpty(this.b.b)) {
                bundle.putString(v.f, this.b.b);
                obj2 = 1;
            }
            Object obj3;
            if (TextUtils.isEmpty(this.b.a)) {
                obj3 = null;
            } else {
                bundle.putString(v.k, this.b.a);
                obj3 = 1;
            }
            if (!TextUtils.isEmpty(this.b.g)) {
                bundle.putString(v.p, this.b.g);
            }
            if (TextUtils.isEmpty(this.b.e)) {
                if (this.b.d != null) {
                    Parcelable a = this.b.d.a();
                    if (a != null) {
                        File a2 = w.a();
                        if (a2 != null) {
                            if (a2.exists()) {
                                a2.delete();
                            }
                            String absolutePath = a2.getAbsolutePath();
                            if (w.a(a, absolutePath)) {
                                bundle.putString(v.j, absolutePath);
                            } else {
                                bundle.putParcelable(v.i, a);
                            }
                        } else {
                            bundle.putParcelable(v.i, a);
                        }
                    }
                } else if (!TextUtils.isEmpty(this.b.f)) {
                    bundle.putString(v.j, this.b.f);
                }
                obj = null;
            } else {
                bundle.putString(v.l, this.b.e);
            }
            if (obj2 != null && obj == null && r3 == null) {
                this.a = v.E;
            } else if (obj != null && obj2 == null && r3 == null) {
                this.a = v.F;
            } else if ((obj == null || obj2 == null) && ((obj == null || r3 == null) && (obj2 == null || r3 == null))) {
                return null;
            } else {
                this.a = v.I;
            }
            if (!TextUtils.isEmpty(this.b.h)) {
                bundle.putString(v.q, this.b.h);
            } else if (!TextUtils.isEmpty(this.b.i)) {
                bundle.putString(v.r, this.b.i);
            }
            bundle.putInt(v.e, this.a);
            if (this.e > 0) {
                bundle.putInt(v.o, this.e);
            }
        }
        return bundle;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getInt(v.e);
            String string = bundle.getString(v.g);
            this.b = new s();
            this.b.c = string;
            if (bundle.containsKey(v.f)) {
                this.b.b = bundle.getString(v.f);
            }
            if (bundle.containsKey(v.k)) {
                this.b.a = bundle.getString(v.k);
            }
            if (bundle.containsKey(v.i)) {
                this.b.d = new q((Bitmap) bundle.getParcelable(v.i));
            }
        }
    }

    public void a(p pVar) {
        this.d = pVar;
    }

    public p b() {
        return this.d;
    }
}
