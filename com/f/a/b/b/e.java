package com.f.a.b.b;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.f.a.b.a.f;
import com.f.a.b.a.i;
import com.f.a.b.d;
import com.f.a.b.d.c;

public class e {
    private final String a;
    private final String b;
    private final String c;
    private final f d;
    private final com.f.a.b.a.e e;
    private final i f;
    private final c g;
    private final Object h;
    private final boolean i;
    private final Options j = new Options();

    public e(String str, String str2, String str3, f fVar, i iVar, c cVar, d dVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = fVar;
        this.e = dVar.j();
        this.f = iVar;
        this.g = cVar;
        this.h = dVar.n();
        this.i = dVar.m();
        a(dVar.k(), this.j);
    }

    private void a(Options options, Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (VERSION.SDK_INT >= 10) {
            b(options, options2);
        }
        if (VERSION.SDK_INT >= 11) {
            c(options, options2);
        }
    }

    @TargetApi(10)
    private void b(Options options, Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void c(Options options, Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public f d() {
        return this.d;
    }

    public com.f.a.b.a.e e() {
        return this.e;
    }

    public i f() {
        return this.f;
    }

    public c g() {
        return this.g;
    }

    public Object h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public Options j() {
        return this.j;
    }
}
