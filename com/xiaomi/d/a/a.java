package com.xiaomi.d.a;

import com.xiaomi.f.e.b;
import com.xiaomi.f.e.f;
import com.xiaomi.f.l;
import com.xiaomi.f.p;
import com.xiaomi.f.r;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class a implements com.xiaomi.f.a.a {
    public static boolean a = false;
    private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
    private l c = null;
    private r d = null;
    private p e = null;
    private Writer f;
    private Reader g;
    private f h;
    private com.xiaomi.f.e.l i;

    public a(l lVar, Writer writer, Reader reader) {
        this.c = lVar;
        this.f = writer;
        this.g = reader;
        e();
    }

    private void e() {
        Reader aVar = new com.xiaomi.f.e.a(this.g);
        this.h = new b(this);
        aVar.a(this.h);
        Writer bVar = new b(this.f);
        this.i = new c(this);
        bVar.a(this.i);
        this.g = aVar;
        this.f = bVar;
        this.d = new d(this);
        this.e = new e(this);
    }

    public Reader a() {
        return this.g;
    }

    public Reader a(Reader reader) {
        ((com.xiaomi.f.e.a) this.g).b(this.h);
        Reader aVar = new com.xiaomi.f.e.a(reader);
        aVar.a(this.h);
        this.g = aVar;
        return this.g;
    }

    public Writer a(Writer writer) {
        ((b) this.f).b(this.i);
        Writer bVar = new b(writer);
        bVar.a(this.i);
        this.f = bVar;
        return this.f;
    }

    public Writer b() {
        return this.f;
    }

    public r c() {
        return this.d;
    }

    public r d() {
        return null;
    }
}
