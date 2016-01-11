package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.a$android.support.v4.content.b;
import android.support.v4.l.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class C0090a<D> extends s<D> {
    static final String a = "AsyncTaskLoader";
    static final boolean b = false;
    volatile b c;
    volatile b d;
    long e;
    long f = -10000;
    Handler g;

    public C0090a(Context context) {
        super(context);
    }

    protected void a() {
        super.a();
        b();
        this.c = new C0091b(this);
        c();
    }

    public void a(long j) {
        this.e = j;
        if (j != 0) {
            this.g = new Handler();
        }
    }

    void a(b bVar, D d) {
        a((Object) d);
        if (this.d == bVar) {
            C();
            this.f = SystemClock.uptimeMillis();
            this.d = null;
            c();
        }
    }

    public void a(D d) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.c);
            printWriter.print(" waiting=");
            printWriter.println(this.c.b);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.d);
            printWriter.print(" waiting=");
            printWriter.println(this.d.b);
        }
        if (this.e != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            w.a(this.e, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            w.a(this.f, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void b(b bVar, D d) {
        if (this.c != bVar) {
            a(bVar, d);
        } else if (s()) {
            a((Object) d);
        } else {
            B();
            this.f = SystemClock.uptimeMillis();
            this.c = null;
            b(d);
        }
    }

    public boolean b() {
        boolean z = false;
        if (this.c != null) {
            if (this.d != null) {
                if (this.c.b) {
                    this.c.b = false;
                    this.g.removeCallbacks(this.c);
                }
                this.c = null;
            } else if (this.c.b) {
                this.c.b = false;
                this.g.removeCallbacks(this.c);
                this.c = null;
            } else {
                z = this.c.a(false);
                if (z) {
                    this.d = this.c;
                }
                this.c = null;
            }
        }
        return z;
    }

    void c() {
        if (this.d == null && this.c != null) {
            if (this.c.b) {
                this.c.b = false;
                this.g.removeCallbacks(this.c);
            }
            if (this.e <= 0 || SystemClock.uptimeMillis() >= this.f + this.e) {
                this.c.a(z.d, (Object[]) (Void[]) null);
                return;
            }
            this.c.b = true;
            this.g.postAtTime(this.c, this.f + this.e);
        }
    }

    public abstract D d();

    protected D e() {
        return d();
    }

    public void f() {
        C0091b c0091b = this.c;
        if (c0091b != null) {
            try {
                c0091b.e.await();
            } catch (InterruptedException e) {
            }
        }
    }
}
