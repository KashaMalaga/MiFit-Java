package cn.com.smartdevices.bracelet.gps.model;

import java.io.Serializable;

public class g implements Serializable {
    private static final long serialVersionUID = 1;
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;

    public g() {
        this.a = 0;
        this.b = false;
        this.c = false;
        this.d = true;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = true;
        this.j = 1;
    }

    public g(boolean z) {
        this(z, false);
    }

    public g(boolean z, int i) {
        this.a = 0;
        this.b = false;
        this.c = false;
        this.d = true;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = true;
        this.j = 1;
        this.b = z;
        this.e = i;
    }

    public g(boolean z, boolean z2) {
        this(z, 0);
        this.c = z2;
        if (this.c) {
            this.g = true;
            this.h = true;
        }
        this.f = false;
    }

    public static g a(boolean z) {
        g gVar = new g(z);
        gVar.g = true;
        gVar.h = true;
        return gVar;
    }

    public static g a(boolean z, boolean z2, boolean z3) {
        g gVar = new g(z);
        gVar.g = z2;
        gVar.h = z3;
        return gVar;
    }

    public static g b(boolean z) {
        g gVar = new g(z);
        gVar.f = true;
        gVar.g = true;
        gVar.h = true;
        gVar.i = true;
        return gVar;
    }

    public static g c(boolean z) {
        g gVar = new g(z);
        gVar.f = true;
        gVar.g = true;
        gVar.h = true;
        gVar.i = false;
        return gVar;
    }

    public g a() {
        g gVar = new g();
        gVar.e = this.e;
        gVar.a = this.a;
        gVar.b = this.b;
        gVar.f = this.f;
        gVar.g = this.g;
        gVar.h = this.h;
        gVar.c = this.c;
        gVar.i = this.i;
        gVar.d = this.d;
        return gVar;
    }

    public /* synthetic */ Object clone() {
        return a();
    }
}
