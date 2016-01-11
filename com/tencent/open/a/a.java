package com.tencent.open.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.activeandroid.b;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class a extends i implements Callback {
    private b a;
    private FileWriter b;
    private File c;
    private char[] d;
    private volatile g e;
    private volatile g f;
    private volatile g g;
    private volatile g h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(int i, boolean z, h hVar, b bVar) {
        super(i, z, hVar);
        this.i = false;
        a(bVar);
        this.e = new g();
        this.f = new g();
        this.g = this.e;
        this.h = this.f;
        this.d = new char[bVar.f()];
        bVar.b();
        g();
        this.j = new HandlerThread(bVar.c(), bVar.h());
        if (this.j != null) {
            this.j.start();
        }
        if (this.j.isAlive() && this.j.getLooper() != null) {
            this.k = new Handler(this.j.getLooper(), this);
        }
    }

    public a(b bVar) {
        this(c.b, true, h.a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            i();
            try {
                this.h.a(g(), this.d);
            } catch (IOException e) {
            } finally {
                this.h.b();
            }
            this.i = false;
        }
    }

    private Writer g() {
        File a = c().a();
        if (!(a == null || a.equals(this.c))) {
            this.c = a;
            h();
            try {
                this.b = new FileWriter(this.c, true);
            } catch (IOException e) {
                return null;
            }
        }
        return this.b;
    }

    private void h() {
        try {
            if (this.b != null) {
                this.b.flush();
                this.b.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.g == this.e) {
                this.g = this.f;
                this.h = this.e;
            } else {
                this.g = this.e;
                this.h = this.f;
            }
        }
    }

    public void a() {
        if (this.k.hasMessages(b.a)) {
            this.k.removeMessages(b.a);
        }
        this.k.sendEmptyMessage(b.a);
    }

    protected void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    protected void a(String str) {
        this.g.a(str);
        if (this.g.a() >= c().f()) {
            a();
        }
    }

    public void b() {
        h();
        this.j.quit();
    }

    public b c() {
        return this.a;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case b.a /*1024*/:
                f();
                break;
        }
        return true;
    }
}
