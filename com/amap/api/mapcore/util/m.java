package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import kankan.wheel.widget.l;

public abstract class m {
    private j a;
    private com.amap.api.mapcore.util.j.a b;
    protected boolean c = false;
    protected Resources d;
    private boolean e = false;
    private final Object f = new Object();

    public class a extends f<Boolean, Void, Bitmap> {
        final /* synthetic */ m a;
        private final WeakReference<com.amap.api.mapcore.ay.a> e;

        public a(m mVar, com.amap.api.mapcore.ay.a aVar) {
            this.a = mVar;
            this.e = new WeakReference(aVar);
        }

        private com.amap.api.mapcore.ay.a e() {
            com.amap.api.mapcore.ay.a aVar = (com.amap.api.mapcore.ay.a) this.e.get();
            return this == m.c(aVar) ? aVar : null;
        }

        protected Bitmap a(Boolean... boolArr) {
            Bitmap bitmap = null;
            o.a("ImageWorker", "doInBackground - starting work", 111);
            boolean booleanValue = boolArr[0].booleanValue();
            Object obj = (com.amap.api.mapcore.ay.a) this.e.get();
            if (obj == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj.a);
            stringBuilder.append("-");
            stringBuilder.append(obj.b);
            stringBuilder.append("-");
            stringBuilder.append(obj.c);
            String stringBuilder2 = stringBuilder.toString();
            synchronized (this.a.f) {
                while (this.a.c && !d()) {
                    try {
                        this.a.f.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!(this.a.a == null || d() || e() == null || this.a.e)) {
                bitmap = this.a.a.b(stringBuilder2);
            }
            Bitmap a = (!booleanValue || bitmap != null || d() || e() == null || this.a.e) ? bitmap : this.a.a(obj);
            if (!(a == null || this.a.a == null)) {
                this.a.a.a(stringBuilder2, a);
            }
            o.a("ImageWorker", "doInBackground - finished work", 111);
            return a;
        }

        protected void a(Bitmap bitmap) {
            if (d() || this.a.e) {
                bitmap = null;
            }
            com.amap.api.mapcore.ay.a e = e();
            if (bitmap != null && !bitmap.isRecycled() && e != null) {
                o.a("ImageWorker", "onPostExecute - setting bitmap: " + e.toString(), 111);
                e.a(bitmap);
            }
        }

        protected void b(Bitmap bitmap) {
            super.b((Object) bitmap);
            synchronized (this.a.f) {
                this.a.f.notifyAll();
            }
        }
    }

    public class b extends f<Object, Void, Void> {
        final /* synthetic */ m a;

        protected b(m mVar) {
            this.a = mVar;
        }

        protected /* synthetic */ Object a(Object[] objArr) {
            return d(objArr);
        }

        protected Void d(Object... objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case kankan.wheel.widget.a.i /*0*/:
                    this.a.c();
                    break;
                case l.a /*1*/:
                    this.a.b();
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    this.a.d();
                    break;
                case kankan.wheel.widget.a.l /*3*/:
                    this.a.e();
                    break;
            }
            return null;
        }
    }

    protected m(Context context) {
        this.d = context.getResources();
    }

    public static void a(com.amap.api.mapcore.ay.a aVar) {
        a c = c(aVar);
        if (c != null) {
            c.a(true);
            o.a("ImageWorker", "cancelWork - cancelled work for " + aVar, 111);
        }
    }

    private static a c(com.amap.api.mapcore.ay.a aVar) {
        return aVar != null ? aVar.j : null;
    }

    protected abstract Bitmap a(Object obj);

    protected j a() {
        return this.a;
    }

    public void a(com.amap.api.mapcore.util.j.a aVar) {
        this.b = aVar;
        this.a = j.a(this.b);
        new b(this).c(Integer.valueOf(1));
    }

    public void a(boolean z) {
        this.e = z;
        b(false);
    }

    public void a(boolean z, com.amap.api.mapcore.ay.a aVar) {
        if (aVar != null) {
            Bitmap bitmap = null;
            if (this.a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(aVar.a);
                stringBuilder.append("-");
                stringBuilder.append(aVar.b);
                stringBuilder.append("-");
                stringBuilder.append(aVar.c);
                bitmap = this.a.a(stringBuilder.toString());
            }
            if (bitmap != null) {
                aVar.a(bitmap);
                return;
            }
            a aVar2 = new a(this, aVar);
            aVar.j = aVar2;
            aVar2.a(f.d, (Object[]) new Boolean[]{Boolean.valueOf(z)});
        }
    }

    protected void b() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void b(boolean z) {
        synchronized (this.f) {
            this.c = z;
            if (!this.c) {
                this.f.notifyAll();
            }
        }
    }

    protected void c() {
        if (this.a != null) {
            this.a.b();
        }
    }

    protected void d() {
        if (this.a != null) {
            this.a.c();
        }
    }

    protected void e() {
        if (this.a != null) {
            this.a.d();
            this.a = null;
        }
    }

    public void f() {
        new b(this).c(Integer.valueOf(0));
    }

    public void g() {
        new b(this).c(Integer.valueOf(2));
    }

    public void h() {
        new b(this).c(Integer.valueOf(3));
    }
}
