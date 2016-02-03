package com.f.a.a.a.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

final class a implements Closeable {
    private static final OutputStream B = new c();
    static final String a = "journal";
    static final String b = "journal.tmp";
    static final String c = "journal.bkp";
    static final String d = "libcore.io.DiskLruCache";
    static final String e = "1";
    static final long f = -1;
    static final Pattern g = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final String i = "CLEAN";
    private static final String j = "DIRTY";
    private static final String k = "REMOVE";
    private static final String l = "READ";
    private final Callable<Void> A = new b(this);
    final ThreadPoolExecutor h = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File m;
    private final File n;
    private final File o;
    private final File p;
    private final int q;
    private long r;
    private int s;
    private final int t;
    private long u = 0;
    private int v = 0;
    private Writer w;
    private final LinkedHashMap<String, f> x = new LinkedHashMap(0, 0.75f, true);
    private int y;
    private long z = 0;

    private a(File file, int i, int i2, long j, int i3) {
        this.m = file;
        this.q = i;
        this.n = new File(file, a);
        this.o = new File(file, b);
        this.p = new File(file, c);
        this.t = i2;
        this.r = j;
        this.s = i3;
    }

    public static a a(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, c);
            if (file2.exists()) {
                File file3 = new File(file, a);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j, i3);
            if (aVar.n.exists()) {
                try {
                    aVar.j();
                    aVar.k();
                    aVar.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.n, true), k.a));
                    return aVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    aVar.h();
                }
            }
            file.mkdirs();
            aVar = new a(file, i, i2, j, i3);
            aVar.l();
            return aVar;
        }
    }

    private synchronized d a(String str, long j) {
        d dVar;
        n();
        e(str);
        f fVar = (f) this.x.get(str);
        if (j == f || (fVar != null && fVar.f == j)) {
            f fVar2;
            if (fVar == null) {
                fVar = new f(this, str);
                this.x.put(str, fVar);
                fVar2 = fVar;
            } else if (fVar.e != null) {
                dVar = null;
            } else {
                fVar2 = fVar;
            }
            dVar = new d(this, fVar2);
            fVar2.e = dVar;
            this.w.write("DIRTY " + str + '\n');
            this.w.flush();
        } else {
            dVar = null;
        }
        return dVar;
    }

    private synchronized void a(d dVar, boolean z) {
        int i = 0;
        synchronized (this) {
            f a = dVar.b;
            if (a.e != dVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.d) {
                    int i2 = 0;
                    while (i2 < this.t) {
                        if (!dVar.c[i2]) {
                            dVar.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.b(i2).exists()) {
                            dVar.b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.t) {
                File b = a.b(i);
                if (!z) {
                    a(b);
                } else if (b.exists()) {
                    File a2 = a.a(i);
                    b.renameTo(a2);
                    long j = a.c[i];
                    long length = a2.length();
                    a.c[i] = length;
                    this.u = (this.u - j) + length;
                    this.v++;
                }
                i++;
            }
            this.y++;
            a.e = null;
            if ((a.d | z) != 0) {
                a.d = true;
                this.w.write("CLEAN " + a.b + a.a() + '\n');
                if (z) {
                    long j2 = this.z;
                    this.z = 1 + j2;
                    a.f = j2;
                }
            } else {
                this.x.remove(a.b);
                this.w.write("REMOVE " + a.b + '\n');
            }
            this.w.flush();
            if (this.u > this.r || this.v > this.s || m()) {
                this.h.submit(this.A);
            }
        }
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static String b(InputStream inputStream) {
        return k.a(new InputStreamReader(inputStream, k.b));
    }

    private void d(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == k.length() && str.startsWith(k)) {
                this.x.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        f fVar = (f) this.x.get(str2);
        if (fVar == null) {
            fVar = new f(this, str2);
            this.x.put(str2, fVar);
        }
        if (indexOf2 != -1 && indexOf == i.length() && str.startsWith(i)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            fVar.d = true;
            fVar.e = null;
            fVar.a(split);
        } else if (indexOf2 == -1 && indexOf == j.length() && str.startsWith(j)) {
            fVar.e = new d(this, fVar);
        } else if (indexOf2 != -1 || indexOf != l.length() || !str.startsWith(l)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e(String str) {
        if (!g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    private void j() {
        Closeable iVar = new i(new FileInputStream(this.n), k.a);
        int i;
        try {
            String a = iVar.a();
            String a2 = iVar.a();
            String a3 = iVar.a();
            String a4 = iVar.a();
            String a5 = iVar.a();
            if (d.equals(a) && e.equals(a2) && Integer.toString(this.q).equals(a3) && Integer.toString(this.t).equals(a4) && com.xiaomi.e.a.f.equals(a5)) {
                i = 0;
                while (true) {
                    d(iVar.a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.y = i - this.x.size();
            k.a(iVar);
        } catch (Throwable th) {
            k.a(iVar);
        }
    }

    private void k() {
        a(this.o);
        Iterator it = this.x.values().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            int i;
            if (fVar.e == null) {
                for (i = 0; i < this.t; i++) {
                    this.u += fVar.c[i];
                    this.v++;
                }
            } else {
                fVar.e = null;
                for (i = 0; i < this.t; i++) {
                    a(fVar.a(i));
                    a(fVar.b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void l() {
        if (this.w != null) {
            this.w.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.o), k.a));
        try {
            bufferedWriter.write(d);
            bufferedWriter.write("\n");
            bufferedWriter.write(e);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.q));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.t));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (f fVar : this.x.values()) {
                if (fVar.e != null) {
                    bufferedWriter.write("DIRTY " + fVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + fVar.b + fVar.a() + '\n');
                }
            }
            if (this.n.exists()) {
                a(this.n, this.p, true);
            }
            a(this.o, this.n, false);
            this.p.delete();
            this.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n, true), k.a));
        } finally {
            bufferedWriter.close();
        }
    }

    private boolean m() {
        return this.y >= kankan.wheel.widget.a.bZ && this.y >= this.x.size();
    }

    private void n() {
        if (this.w == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void o() {
        while (this.u > this.r) {
            c((String) ((Entry) this.x.entrySet().iterator().next()).getKey());
        }
    }

    private void p() {
        while (this.v > this.s) {
            c((String) ((Entry) this.x.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized g a(String str) {
        int i;
        g gVar = null;
        synchronized (this) {
            n();
            e(str);
            f fVar = (f) this.x.get(str);
            if (fVar != null) {
                if (fVar.d) {
                    File[] fileArr = new File[this.t];
                    InputStream[] inputStreamArr = new InputStream[this.t];
                    int i2 = 0;
                    while (i2 < this.t) {
                        try {
                            File a = fVar.a(i2);
                            fileArr[i2] = a;
                            inputStreamArr[i2] = new FileInputStream(a);
                            i2++;
                        } catch (FileNotFoundException e) {
                            i = 0;
                            while (i < this.t && inputStreamArr[i] != null) {
                                k.a(inputStreamArr[i]);
                                i++;
                            }
                        }
                    }
                    this.y++;
                    this.w.append("READ " + str + '\n');
                    if (m()) {
                        this.h.submit(this.A);
                    }
                    gVar = new g(this, str, fVar.f, fileArr, inputStreamArr, fVar.c);
                }
            }
        }
        return gVar;
    }

    public File a() {
        return this.m;
    }

    public synchronized void a(long j) {
        this.r = j;
        this.h.submit(this.A);
    }

    public synchronized long b() {
        return this.r;
    }

    public d b(String str) {
        return a(str, (long) f);
    }

    public synchronized int c() {
        return this.s;
    }

    public synchronized boolean c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            n();
            e(str);
            f fVar = (f) this.x.get(str);
            if (fVar == null || fVar.e != null) {
                z = false;
            } else {
                while (i < this.t) {
                    File a = fVar.a(i);
                    if (!a.exists() || a.delete()) {
                        this.u -= fVar.c[i];
                        this.v--;
                        fVar.c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.y++;
                this.w.append("REMOVE " + str + '\n');
                this.x.remove(str);
                if (m()) {
                    this.h.submit(this.A);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized void close() {
        if (this.w != null) {
            Iterator it = new ArrayList(this.x.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.e != null) {
                    fVar.e.b();
                }
            }
            o();
            p();
            this.w.close();
            this.w = null;
        }
    }

    public synchronized long d() {
        return this.u;
    }

    public synchronized long e() {
        return (long) this.v;
    }

    public synchronized boolean f() {
        return this.w == null;
    }

    public synchronized void g() {
        n();
        o();
        p();
        this.w.flush();
    }

    public void h() {
        close();
        k.a(this.m);
    }
}
