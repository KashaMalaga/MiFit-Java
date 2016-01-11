package android.support.v4.content;

import android.content.Context;
import android.support.v4.l.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class s<D> {
    int o;
    u<D> p;
    Context q;
    boolean r = false;
    boolean s = false;
    boolean t = true;
    boolean u = false;
    boolean v = false;

    public s(Context context) {
        this.q = context.getApplicationContext();
    }

    public boolean A() {
        boolean z = this.u;
        this.u = false;
        this.v |= z;
        return z;
    }

    public void B() {
        this.v = false;
    }

    public void C() {
        if (this.v) {
            this.u = true;
        }
    }

    public void D() {
        if (this.r) {
            v();
        } else {
            this.u = true;
        }
    }

    protected void a() {
    }

    public void a(int i, u<D> uVar) {
        if (this.p != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.p = uVar;
        this.o = i;
    }

    public void a(u<D> uVar) {
        if (this.p == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.p != uVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.p = null;
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.o);
        printWriter.print(" mListener=");
        printWriter.println(this.p);
        if (this.r || this.u || this.v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.v);
        }
        if (this.s || this.t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.s);
            printWriter.print(" mReset=");
            printWriter.println(this.t);
        }
    }

    public void b(D d) {
        if (this.p != null) {
            this.p.a(this, d);
        }
    }

    public String c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        f.a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected void h() {
    }

    protected void i() {
    }

    protected void j() {
    }

    public Context p() {
        return this.q;
    }

    public int q() {
        return this.o;
    }

    public boolean r() {
        return this.r;
    }

    public boolean s() {
        return this.s;
    }

    public boolean t() {
        return this.t;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        f.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.o);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void u() {
        this.r = true;
        this.t = false;
        this.s = false;
        h();
    }

    public void v() {
        a();
    }

    public void w() {
        this.r = false;
        i();
    }

    public void x() {
        this.s = true;
        y();
    }

    protected void y() {
    }

    public void z() {
        j();
        this.t = true;
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
    }
}
