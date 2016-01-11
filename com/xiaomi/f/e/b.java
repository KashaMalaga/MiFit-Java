package com.xiaomi.f.e;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class b extends Writer {
    Writer a = null;
    List b = new ArrayList();

    public b(Writer writer) {
        this.a = writer;
    }

    private void a(String str) {
        synchronized (this.b) {
            l[] lVarArr = new l[this.b.size()];
            this.b.toArray(lVarArr);
        }
        for (l a : lVarArr) {
            a.a(str);
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            synchronized (this.b) {
                if (!this.b.contains(lVar)) {
                    this.b.add(lVar);
                }
            }
        }
    }

    public void b(l lVar) {
        synchronized (this.b) {
            this.b.remove(lVar);
        }
    }

    public void close() {
        this.a.close();
    }

    public void flush() {
        this.a.flush();
    }

    public void write(int i) {
        this.a.write(i);
    }

    public void write(String str) {
        this.a.write(str);
        a(str);
    }

    public void write(String str, int i, int i2) {
        this.a.write(str, i, i2);
        a(str.substring(i, i + i2));
    }

    public void write(char[] cArr) {
        this.a.write(cArr);
        a(new String(cArr));
    }

    public void write(char[] cArr, int i, int i2) {
        this.a.write(cArr, i, i2);
        a(new String(cArr, i, i2));
    }
}
