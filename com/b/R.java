package com.b;

import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

public final class R implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream p = new X();
    final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private long j = 0;
    private Writer k;
    private final LinkedHashMap<String, U> l = new LinkedHashMap(0, 0.75f, true);
    private int m;
    private long n = 0;
    private final Callable<Void> o = new W(this);

    private R(File file, int i, int i2, long j) {
        this.c = file;
        this.g = i;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i2;
        this.h = j;
    }

    public static R a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            R r = new R(file, i, i2, j);
            if (r.d.exists()) {
                try {
                    r.c();
                    r.d();
                    r.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r.d, true), an.a));
                    return r;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    r.a();
                }
            }
            file.mkdirs();
            r = new R(file, i, i2, j);
            r.e();
            return r;
        }
    }

    private synchronized S a(String str, long j) {
        S s;
        if (this.k == null) {
            s = null;
        } else {
            g();
            e(str);
            U u = (U) this.l.get(str);
            if (j == -1 || (u != null && u.f == j)) {
                U u2;
                if (u == null) {
                    u = new U(this, str);
                    this.l.put(str, u);
                    u2 = u;
                } else if (u.e != null) {
                    s = null;
                } else {
                    u2 = u;
                }
                s = new S(this, u2);
                u2.e = s;
                this.k.write("DIRTY " + str + '\n');
                this.k.flush();
            } else {
                s = null;
            }
        }
        return s;
    }

    private synchronized void a(S s, boolean z) {
        int i = 0;
        synchronized (this) {
            U a = s.b;
            if (a.e != s) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.d) {
                    int i2 = 0;
                    while (i2 < this.i) {
                        if (!s.c[i2]) {
                            s.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.b(i2).exists()) {
                            s.b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.i) {
                File b = a.b(i);
                if (!z) {
                    a(b);
                } else if (b.exists()) {
                    File a2 = a.a(i);
                    b.renameTo(a2);
                    long j = a.c[i];
                    long length = a2.length();
                    a.c[i] = length;
                    this.j = (this.j - j) + length;
                }
                i++;
            }
            this.m++;
            a.e = null;
            if ((a.d | z) != 0) {
                a.d = true;
                this.k.write("CLEAN " + a.b + a.a() + '\n');
                if (z) {
                    long j2 = this.n;
                    this.n = 1 + j2;
                    a.f = j2;
                }
            } else {
                this.l.remove(a.b);
                this.k.write("REMOVE " + a.b + '\n');
            }
            this.k.flush();
            if (this.j > this.h || f()) {
                this.b.submit(this.o);
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

    private void c() {
        int i;
        Closeable alVar = new al(new FileInputStream(this.d), an.a);
        try {
            String a = alVar.a();
            String a2 = alVar.a();
            String a3 = alVar.a();
            String a4 = alVar.a();
            String a5 = alVar.a();
            if ("libcore.io.DiskLruCache".equals(a) && Constants.VIA_TO_TYPE_QQ_GROUP.equals(a2) && Integer.toString(this.g).equals(a3) && Integer.toString(this.i).equals(a4) && a.f.equals(a5)) {
                i = 0;
                while (true) {
                    d(alVar.a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.m = i - this.l.size();
            an.a(alVar);
        } catch (Throwable th) {
            an.a(alVar);
        }
    }

    private void d() {
        a(this.e);
        Iterator it = this.l.values().iterator();
        while (it.hasNext()) {
            U u = (U) it.next();
            int i;
            if (u.e == null) {
                for (i = 0; i < this.i; i++) {
                    this.j += u.c[i];
                }
            } else {
                u.e = null;
                for (i = 0; i < this.i; i++) {
                    a(u.a(i));
                    a(u.b(i));
                }
                it.remove();
            }
        }
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
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        U u = (U) this.l.get(str2);
        if (u == null) {
            u = new U(this, str2);
            this.l.put(str2, u);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            u.d = true;
            u.e = null;
            u.a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            u.e = new S(this, u);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private synchronized void e() {
        if (this.k != null) {
            this.k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), an.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(Constants.VIA_TO_TYPE_QQ_GROUP);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (U u : this.l.values()) {
                if (u.e != null) {
                    bufferedWriter.write("DIRTY " + u.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + u.b + u.a() + '\n');
                }
            }
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), an.a));
        } finally {
            bufferedWriter.close();
        }
    }

    private void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private boolean f() {
        return this.m >= kankan.wheel.widget.a.bZ && this.m >= this.l.size();
    }

    private void g() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void h() {
        while (this.j > this.h) {
            c((String) ((Entry) this.l.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized V a(String str) {
        V v = null;
        synchronized (this) {
            if (this.k != null) {
                g();
                e(str);
                U u = (U) this.l.get(str);
                if (u != null && u.d) {
                    InputStream[] inputStreamArr = new InputStream[this.i];
                    int i = 0;
                    while (i < this.i) {
                        try {
                            inputStreamArr[i] = new FileInputStream(u.a(i));
                            i++;
                        } catch (FileNotFoundException e) {
                            int i2 = 0;
                            while (i2 < this.i && inputStreamArr[i2] != null) {
                                an.a(inputStreamArr[i2]);
                                i2++;
                            }
                        }
                    }
                    this.m++;
                    this.k.append("READ " + str + '\n');
                    if (f()) {
                        this.b.submit(this.o);
                    }
                    v = new V(this, str, u.f, inputStreamArr, u.c);
                }
            }
        }
        return v;
    }

    public void a() {
        close();
        an.a(this.c);
    }

    public S b(String str) {
        return a(str, -1);
    }

    public synchronized boolean c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            g();
            e(str);
            U u = (U) this.l.get(str);
            if (u == null || u.e != null) {
                z = false;
            } else {
                while (i < this.i) {
                    File a = u.a(i);
                    if (!a.exists() || a.delete()) {
                        this.j -= u.c[i];
                        u.c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.m++;
                this.k.append("REMOVE " + str + '\n');
                this.l.remove(str);
                if (f()) {
                    this.b.submit(this.o);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized void close() {
        if (this.k != null) {
            Iterator it = new ArrayList(this.l.values()).iterator();
            while (it.hasNext()) {
                U u = (U) it.next();
                if (u.e != null) {
                    u.e.b();
                }
            }
            h();
            this.k.close();
            this.k = null;
        }
    }
}
