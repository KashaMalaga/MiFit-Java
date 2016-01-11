package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.s;
import android.support.v4.content.u;
import android.support.v4.l.f;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import kankan.wheel.widget.a;

final class aB implements u<Object> {
    final int a;
    final Bundle b;
    C0037az<Object> c;
    s<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    aB n;
    final /* synthetic */ aA o;

    public aB(aA aAVar, int i, Bundle bundle, C0037az<Object> c0037az) {
        this.o = aAVar;
        this.a = i;
        this.b = bundle;
        this.c = c0037az;
    }

    void a() {
        if (aA.b) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.i = true;
        this.j = this.h;
        this.h = false;
        this.c = null;
    }

    public void a(s<Object> sVar, Object obj) {
        if (aA.b) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.l) {
            if (aA.b) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.o.c.a(this.a) == this) {
            aB aBVar = this.n;
            if (aBVar != null) {
                if (aA.b) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + aBVar);
                }
                this.n = null;
                this.o.c.b(this.a, null);
                d();
                this.o.a(aBVar);
                return;
            }
            if (!(this.g == obj && this.e)) {
                this.g = obj;
                this.e = true;
                if (this.h) {
                    b(sVar, obj);
                }
            }
            aBVar = (aB) this.o.d.a(this.a);
            if (!(aBVar == null || aBVar == this)) {
                aBVar.f = false;
                aBVar.d();
                this.o.d.c(this.a);
            }
            if (this.o.f != null && !this.o.a()) {
                this.o.f.e.i();
            }
        } else if (aA.b) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mArgs=");
        printWriter.println(this.b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.d);
        if (this.d != null) {
            this.d.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.e || this.f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.m);
        if (this.n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.n);
            printWriter.println(a.ci);
            this.n.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void b() {
        if (this.i) {
            if (aA.b) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.i = false;
            if (!(this.h == this.j || this.h)) {
                stop();
            }
        }
        if (this.h && this.e && !this.k) {
            b(this.d, this.g);
        }
    }

    void b(s<Object> sVar, Object obj) {
        String str;
        if (this.c != null) {
            if (this.o.f != null) {
                String str2 = this.o.f.e.A;
                this.o.f.e.A = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (aA.b) {
                    Log.v("LoaderManager", "  onLoadFinished in " + sVar + ": " + sVar.c(obj));
                }
                this.c.a((s) sVar, obj);
                this.f = true;
            } finally {
                if (this.o.f != null) {
                    this.o.f.e.A = str;
                }
            }
        }
    }

    void c() {
        if (this.h && this.k) {
            this.k = false;
            if (this.e) {
                b(this.d, this.g);
            }
        }
    }

    void d() {
        String str;
        C0037az c0037az = null;
        if (aA.b) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.l = true;
        boolean z = this.f;
        this.f = false;
        if (this.c != null && this.d != null && this.e && z) {
            if (aA.b) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.o.f != null) {
                String str2 = this.o.f.e.A;
                this.o.f.e.A = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.c.a(this.d);
            } finally {
                c0037az = this.o.f;
                if (c0037az != null) {
                    c0037az = this.o.f.e;
                    c0037az.A = str;
                }
            }
        }
        this.c = c0037az;
        this.g = c0037az;
        this.e = false;
        if (this.d != null) {
            if (this.m) {
                this.m = false;
                this.d.a(this);
            }
            this.d.z();
        }
        if (this.n != null) {
            this.n.d();
        }
    }

    void start() {
        if (this.i && this.j) {
            this.h = true;
        } else if (!this.h) {
            this.h = true;
            if (aA.b) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.d == null && this.c != null) {
                this.d = this.c.a(this.a, this.b);
            }
            if (this.d == null) {
                return;
            }
            if (!this.d.getClass().isMemberClass() || Modifier.isStatic(this.d.getClass().getModifiers())) {
                if (!this.m) {
                    this.d.a(this.a, this);
                    this.m = true;
                }
                this.d.u();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
        }
    }

    void stop() {
        if (aA.b) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.h = false;
        if (!this.i && this.d != null && this.m) {
            this.m = false;
            this.d.a(this);
            this.d.w();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.a);
        stringBuilder.append(" : ");
        f.a(this.d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
