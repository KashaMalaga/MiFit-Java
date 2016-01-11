package android.support.v4.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

final class d implements h {
    private final i a;

    d(Context context) {
        this.a = new i(context);
    }

    public int a() {
        return this.a.a();
    }

    public void a(int i) {
        this.a.a(i);
    }

    public void a(String str, Bitmap bitmap, c cVar) {
        n nVar = null;
        if (cVar != null) {
            nVar = new e(this, cVar);
        }
        this.a.a(str, bitmap, nVar);
    }

    public void a(String str, Uri uri, c cVar) {
        n nVar = null;
        if (cVar != null) {
            nVar = new f(this, cVar);
        }
        this.a.a(str, uri, nVar);
    }

    public int b() {
        return this.a.c();
    }

    public void b(int i) {
        this.a.b(i);
    }

    public int c() {
        return this.a.b();
    }

    public void c(int i) {
        this.a.c(i);
    }
}
