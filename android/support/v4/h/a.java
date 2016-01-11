package android.support.v4.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;

public final class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 1;
    public static final int f = 2;
    h g;

    public a(Context context) {
        if (a()) {
            this.g = new d(context);
        } else {
            this.g = new g();
        }
    }

    public static boolean a() {
        return VERSION.SDK_INT >= 19;
    }

    public void a(int i) {
        this.g.a(i);
    }

    public void a(String str, Bitmap bitmap) {
        this.g.a(str, bitmap, null);
    }

    public void a(String str, Bitmap bitmap, c cVar) {
        this.g.a(str, bitmap, cVar);
    }

    public void a(String str, Uri uri) {
        this.g.a(str, uri, null);
    }

    public void a(String str, Uri uri, c cVar) {
        this.g.a(str, uri, cVar);
    }

    public int b() {
        return this.g.a();
    }

    public void b(int i) {
        this.g.b(i);
    }

    public int c() {
        return this.g.b();
    }

    public void c(int i) {
        this.g.c(i);
    }

    public int d() {
        return this.g.c();
    }
}
