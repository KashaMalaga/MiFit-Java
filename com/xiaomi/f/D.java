package com.xiaomi.f;

import com.xiaomi.f.c.j;
import com.xiaomi.f.c.k;
import java.io.PrintStream;
import java.io.PrintWriter;

public class D extends Exception {
    private j a = null;
    private k b = null;
    private Throwable c = null;

    public D(j jVar) {
        this.a = jVar;
    }

    public D(String str) {
        super(str);
    }

    public D(String str, k kVar) {
        super(str);
        this.b = kVar;
    }

    public D(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    public D(Throwable th) {
        this.c = th;
    }

    public Throwable a() {
        return this.c;
    }

    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.b == null) ? (message != null || this.a == null) ? message : this.a.toString() : this.b.toString();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.c != null) {
            printStream.println("Nested Exception: ");
            this.c.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.c != null) {
            printWriter.println("Nested Exception: ");
            this.c.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            stringBuilder.append(message).append(": ");
        }
        if (this.b != null) {
            stringBuilder.append(this.b);
        }
        if (this.a != null) {
            stringBuilder.append(this.a);
        }
        if (this.c != null) {
            stringBuilder.append("\n  -- caused by: ").append(this.c);
        }
        return stringBuilder.toString();
    }
}
