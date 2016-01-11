package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.s;
import android.support.v4.l.f;
import android.support.v4.l.v;
import android.support.v4.view.a.C0113o;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class aA extends ay {
    static final String a = "LoaderManager";
    static boolean b = false;
    final v<aB> c = new v();
    final v<aB> d = new v();
    final String e;
    FragmentActivity f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;

    aA(String str, FragmentActivity fragmentActivity, boolean z) {
        this.e = str;
        this.f = fragmentActivity;
        this.g = z;
    }

    private aB c(int i, Bundle bundle, C0037az<Object> c0037az) {
        aB aBVar = new aB(this, i, bundle, c0037az);
        aBVar.d = c0037az.a(i, bundle);
        return aBVar;
    }

    private aB d(int i, Bundle bundle, C0037az<Object> c0037az) {
        try {
            this.j = true;
            aB c = c(i, bundle, c0037az);
            a(c);
            return c;
        } finally {
            this.j = false;
        }
    }

    public <D> s<D> a(int i, Bundle bundle, C0037az<D> c0037az) {
        if (this.j) {
            throw new IllegalStateException("Called while creating a loader");
        }
        aB aBVar = (aB) this.c.a(i);
        if (b) {
            Log.v(a, "initLoader in " + this + ": args=" + bundle);
        }
        if (aBVar == null) {
            aBVar = d(i, bundle, c0037az);
            if (b) {
                Log.v(a, "  Created new loader " + aBVar);
            }
        } else {
            if (b) {
                Log.v(a, "  Re-using existing loader " + aBVar);
            }
            aBVar.c = c0037az;
        }
        if (aBVar.e && this.g) {
            aBVar.b(aBVar.d, aBVar.g);
        }
        return aBVar.d;
    }

    public void a(int i) {
        if (this.j) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (b) {
            Log.v(a, "destroyLoader in " + this + " of " + i);
        }
        int g = this.c.g(i);
        if (g >= 0) {
            aB aBVar = (aB) this.c.f(g);
            this.c.d(g);
            aBVar.d();
        }
        g = this.d.g(i);
        if (g >= 0) {
            aBVar = (aB) this.d.f(g);
            this.d.d(g);
            aBVar.d();
        }
        if (this.f != null && !a()) {
            this.f.e.i();
        }
    }

    void a(FragmentActivity fragmentActivity) {
        this.f = fragmentActivity;
    }

    void a(aB aBVar) {
        this.c.b(aBVar.a, aBVar);
        if (this.g) {
            aBVar.start();
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.c.b(); i2++) {
                aB aBVar = (aB) this.c.f(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.e(i2));
                printWriter.print(": ");
                printWriter.println(aBVar.toString());
                aBVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.d.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.d.b()) {
                aBVar = (aB) this.d.f(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.d.e(i));
                printWriter.print(": ");
                printWriter.println(aBVar.toString());
                aBVar.a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean a() {
        int b = this.c.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            aB aBVar = (aB) this.c.f(i);
            int i2 = (!aBVar.h || aBVar.f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    public <D> s<D> b(int i) {
        if (this.j) {
            throw new IllegalStateException("Called while creating a loader");
        }
        aB aBVar = (aB) this.c.a(i);
        return aBVar != null ? aBVar.n != null ? aBVar.n.d : aBVar.d : null;
    }

    public <D> s<D> b(int i, Bundle bundle, C0037az<D> c0037az) {
        if (this.j) {
            throw new IllegalStateException("Called while creating a loader");
        }
        aB aBVar = (aB) this.c.a(i);
        if (b) {
            Log.v(a, "restartLoader in " + this + ": args=" + bundle);
        }
        if (aBVar != null) {
            aB aBVar2 = (aB) this.d.a(i);
            if (aBVar2 == null) {
                if (b) {
                    Log.v(a, "  Making last loader inactive: " + aBVar);
                }
                aBVar.d.x();
                this.d.b(i, aBVar);
            } else if (aBVar.e) {
                if (b) {
                    Log.v(a, "  Removing last inactive loader: " + aBVar);
                }
                aBVar2.f = false;
                aBVar2.d();
                aBVar.d.x();
                this.d.b(i, aBVar);
            } else if (aBVar.h) {
                if (aBVar.n != null) {
                    if (b) {
                        Log.v(a, "  Removing pending loader: " + aBVar.n);
                    }
                    aBVar.n.d();
                    aBVar.n = null;
                }
                if (b) {
                    Log.v(a, "  Enqueuing as new pending loader");
                }
                aBVar.n = c(i, bundle, c0037az);
                return aBVar.n.d;
            } else {
                if (b) {
                    Log.v(a, "  Current loader is stopped; replacing");
                }
                this.c.b(i, null);
                aBVar.d();
            }
        }
        return d(i, bundle, c0037az).d;
    }

    void b() {
        if (b) {
            Log.v(a, "Starting in " + this);
        }
        if (this.g) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(a, "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.g = true;
        for (int b = this.c.b() - 1; b >= 0; b--) {
            ((aB) this.c.f(b)).start();
        }
    }

    void c() {
        if (b) {
            Log.v(a, "Stopping in " + this);
        }
        if (this.g) {
            for (int b = this.c.b() - 1; b >= 0; b--) {
                ((aB) this.c.f(b)).stop();
            }
            this.g = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w(a, "Called doStop when not started: " + this, runtimeException);
    }

    void d() {
        if (b) {
            Log.v(a, "Retaining in " + this);
        }
        if (this.g) {
            this.h = true;
            this.g = false;
            for (int b = this.c.b() - 1; b >= 0; b--) {
                ((aB) this.c.f(b)).a();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w(a, "Called doRetain when not started: " + this, runtimeException);
    }

    void e() {
        if (this.h) {
            if (b) {
                Log.v(a, "Finished Retaining in " + this);
            }
            this.h = false;
            for (int b = this.c.b() - 1; b >= 0; b--) {
                ((aB) this.c.f(b)).b();
            }
        }
    }

    void f() {
        for (int b = this.c.b() - 1; b >= 0; b--) {
            ((aB) this.c.f(b)).k = true;
        }
    }

    void g() {
        for (int b = this.c.b() - 1; b >= 0; b--) {
            ((aB) this.c.f(b)).c();
        }
    }

    void h() {
        int b;
        if (!this.h) {
            if (b) {
                Log.v(a, "Destroying Active in " + this);
            }
            for (b = this.c.b() - 1; b >= 0; b--) {
                ((aB) this.c.f(b)).d();
            }
            this.c.c();
        }
        if (b) {
            Log.v(a, "Destroying Inactive in " + this);
        }
        for (b = this.d.b() - 1; b >= 0; b--) {
            ((aB) this.d.f(b)).d();
        }
        this.d.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        f.a(this.f, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
