package com.huami.android.bitmapfun;

import com.activeandroid.b;
import com.d.a.a.h;
import com.xiaomi.e.a;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class m implements Closeable {
    static final String a = "journal";
    static final String b = "journal.tmp";
    static final String c = "libcore.io.DiskLruCache";
    static final String d = "1";
    static final long e = -1;
    private static final String f = "CLEAN";
    private static final String g = "DIRTY";
    private static final String h = "REMOVE";
    private static final String i = "READ";
    private static final Charset j = Charset.forName(h.DEFAULT_CHARSET);
    private static final int k = 8192;
    private final File l;
    private final File m;
    private final File n;
    private final int o;
    private final long p;
    private final int q;
    private long r = 0;
    private Writer s;
    private final LinkedHashMap<String, q> t = new LinkedHashMap(0, 0.75f, true);
    private int u;
    private long v = 0;
    private final ExecutorService w = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> x = new n(this);

    private m(File file, int i, int i2, long j) {
        this.l = file;
        this.o = i;
        this.m = new File(file, a);
        this.n = new File(file, b);
        this.q = i2;
        this.p = j;
    }

    public static m a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            m mVar = new m(file, i, i2, j);
            if (mVar.m.exists()) {
                try {
                    mVar.h();
                    mVar.i();
                    mVar.s = new BufferedWriter(new FileWriter(mVar.m, true), k);
                    return mVar;
                } catch (IOException e) {
                    mVar.f();
                }
            }
            file.mkdirs();
            mVar = new m(file, i, i2, j);
            mVar.j();
            return mVar;
        }
    }

    private synchronized o a(String str, long j) {
        o oVar;
        l();
        e(str);
        q qVar = (q) this.t.get(str);
        if (j == e || (qVar != null && qVar.f == j)) {
            q qVar2;
            if (qVar == null) {
                qVar = new q(this, str);
                this.t.put(str, qVar);
                qVar2 = qVar;
            } else if (qVar.e != null) {
                oVar = null;
            } else {
                qVar2 = qVar;
            }
            oVar = new o(this, qVar2);
            qVar2.e = oVar;
            this.s.write("DIRTY " + str + '\n');
            this.s.flush();
        } else {
            oVar = null;
        }
        return oVar;
    }

    public static String a(InputStream inputStream) {
        int read;
        StringBuilder stringBuilder = new StringBuilder(80);
        while (true) {
            read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                break;
            } else {
                stringBuilder.append((char) read);
            }
        }
        read = stringBuilder.length();
        if (read > 0 && stringBuilder.charAt(read - 1) == '\r') {
            stringBuilder.setLength(read - 1);
        }
        return stringBuilder.toString();
    }

    public static String a(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[b.a];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            return stringWriter2;
        } finally {
            reader.close();
        }
    }

    private synchronized void a(o oVar, boolean z) {
        int i = 0;
        synchronized (this) {
            q a = oVar.b;
            if (a.e != oVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.d) {
                    int i2 = 0;
                    while (i2 < this.q) {
                        if (a.b(i2).exists()) {
                            i2++;
                        } else {
                            oVar.b();
                            throw new IllegalStateException("edit didn't create file " + i2);
                        }
                    }
                }
            }
            while (i < this.q) {
                File b = a.b(i);
                if (!z) {
                    b(b);
                } else if (b.exists()) {
                    File a2 = a.a(i);
                    b.renameTo(a2);
                    long j = a.c[i];
                    long length = a2.length();
                    a.c[i] = length;
                    this.r = (this.r - j) + length;
                }
                i++;
            }
            this.u++;
            a.e = null;
            if ((a.d | z) != 0) {
                a.d = true;
                this.s.write("CLEAN " + a.b + a.a() + '\n');
                if (z) {
                    long j2 = this.v;
                    this.v = 1 + j2;
                    a.f = j2;
                }
            } else {
                this.t.remove(a.b);
                this.s.write("REMOVE " + a.b + '\n');
            }
            if (this.r > this.p || k()) {
                this.w.submit(this.x);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IllegalArgumentException("not a directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    private static <T> T[] a(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3);
            System.arraycopy(tArr, i, objArr, 0, min);
            return objArr;
        }
    }

    private static void b(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static String c(InputStream inputStream) {
        return a(new InputStreamReader(inputStream, j));
    }

    private void d(String str) {
        Object[] split = str.split(" ");
        if (split.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = split[1];
        if (split[0].equals(h) && split.length == 2) {
            this.t.remove(str2);
            return;
        }
        q qVar;
        q qVar2 = (q) this.t.get(str2);
        if (qVar2 == null) {
            qVar2 = new q(this, str2);
            this.t.put(str2, qVar2);
            qVar = qVar2;
        } else {
            qVar = qVar2;
        }
        if (split[0].equals(f) && split.length == this.q + 2) {
            qVar.d = true;
            qVar.e = null;
            qVar.a((String[]) a(split, 2, split.length));
        } else if (split[0].equals(g) && split.length == 2) {
            qVar.e = new o(this, qVar);
        } else if (!split[0].equals(i) || split.length != 2) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private void h() {
        Closeable bufferedInputStream = new BufferedInputStream(new FileInputStream(this.m), k);
        try {
            String a = a((InputStream) bufferedInputStream);
            String a2 = a((InputStream) bufferedInputStream);
            String a3 = a((InputStream) bufferedInputStream);
            String a4 = a((InputStream) bufferedInputStream);
            String a5 = a((InputStream) bufferedInputStream);
            if (c.equals(a) && d.equals(a2) && Integer.toString(this.o).equals(a3) && Integer.toString(this.q).equals(a4) && a.f.equals(a5)) {
                while (true) {
                    try {
                        d(a((InputStream) bufferedInputStream));
                    } catch (EOFException e) {
                        a(bufferedInputStream);
                        return;
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
        } catch (Throwable th) {
            a(bufferedInputStream);
        }
    }

    private void i() {
        b(this.n);
        Iterator it = this.t.values().iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            int i;
            if (qVar.e == null) {
                for (i = 0; i < this.q; i++) {
                    this.r += qVar.c[i];
                }
            } else {
                qVar.e = null;
                for (i = 0; i < this.q; i++) {
                    b(qVar.a(i));
                    b(qVar.b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void j() {
        if (this.s != null) {
            this.s.close();
        }
        Writer bufferedWriter = new BufferedWriter(new FileWriter(this.n), k);
        bufferedWriter.write(c);
        bufferedWriter.write("\n");
        bufferedWriter.write(d);
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.o));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.q));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (q qVar : this.t.values()) {
            if (qVar.e != null) {
                bufferedWriter.write("DIRTY " + qVar.b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + qVar.b + qVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.n.renameTo(this.m);
        this.s = new BufferedWriter(new FileWriter(this.m, true), k);
    }

    private boolean k() {
        return this.u >= kankan.wheel.widget.a.bZ && this.u >= this.t.size();
    }

    private void l() {
        if (this.s == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void m() {
        while (this.r > this.p) {
            c((String) ((Entry) this.t.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized r a(String str) {
        r rVar = null;
        synchronized (this) {
            l();
            e(str);
            q qVar = (q) this.t.get(str);
            if (qVar != null) {
                if (qVar.d) {
                    InputStream[] inputStreamArr = new InputStream[this.q];
                    int i = 0;
                    while (i < this.q) {
                        try {
                            inputStreamArr[i] = new FileInputStream(qVar.a(i));
                            i++;
                        } catch (FileNotFoundException e) {
                        }
                    }
                    this.u++;
                    this.s.append("READ " + str + '\n');
                    if (k()) {
                        this.w.submit(this.x);
                    }
                    rVar = new r(this, str, qVar.f, inputStreamArr);
                }
            }
        }
        return rVar;
    }

    public File a() {
        return this.l;
    }

    public long b() {
        return this.p;
    }

    public o b(String str) {
        return a(str, (long) e);
    }

    public synchronized long c() {
        return this.r;
    }

    public synchronized boolean c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            l();
            e(str);
            q qVar = (q) this.t.get(str);
            if (qVar == null || qVar.e != null) {
                z = false;
            } else {
                while (i < this.q) {
                    File a = qVar.a(i);
                    if (a.delete()) {
                        this.r -= qVar.c[i];
                        qVar.c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.u++;
                this.s.append("REMOVE " + str + '\n');
                this.t.remove(str);
                if (k()) {
                    this.w.submit(this.x);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized void close() {
        if (this.s != null) {
            Iterator it = new ArrayList(this.t.values()).iterator();
            while (it.hasNext()) {
                q qVar = (q) it.next();
                if (qVar.e != null) {
                    qVar.e.b();
                }
            }
            m();
            this.s.close();
            this.s = null;
        }
    }

    public boolean d() {
        return this.s == null;
    }

    public synchronized void e() {
        l();
        m();
        this.s.flush();
    }

    public void f() {
        close();
        a(this.l);
    }
}
