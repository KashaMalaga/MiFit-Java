package com.f.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.f.a.a.a.b;
import com.f.a.c.d;
import com.f.a.c.e;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public abstract class a implements b {
    public static final int a = 32768;
    public static final CompressFormat b = CompressFormat.PNG;
    public static final int c = 100;
    private static final String j = " argument must be not null";
    private static final String k = ".tmp";
    protected final File d;
    protected final File e;
    protected final com.f.a.a.a.b.a f;
    protected int g;
    protected CompressFormat h;
    protected int i;

    public a(File file) {
        this(file, null);
    }

    public a(File file, File file2) {
        this(file, file2, com.f.a.b.a.b());
    }

    public a(File file, File file2, com.f.a.a.a.b.a aVar) {
        this.g = a;
        this.h = b;
        this.i = c;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else {
            this.d = file;
            this.e = file2;
            this.f = aVar;
        }
    }

    public File a() {
        return this.d;
    }

    public File a(String str) {
        return c(str);
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(CompressFormat compressFormat) {
        this.h = compressFormat;
    }

    public boolean a(String str, Bitmap bitmap) {
        File c = c(str);
        File file = new File(c.getAbsolutePath() + k);
        Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.g);
        try {
            boolean compress = bitmap.compress(this.h, this.i, bufferedOutputStream);
            d.a(bufferedOutputStream);
            if (compress && !file.renameTo(c)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            d.a(bufferedOutputStream);
            file.delete();
        }
    }

    public boolean a(String str, InputStream inputStream, e eVar) {
        boolean a;
        Throwable th;
        File c = c(str);
        File file = new File(c.getAbsolutePath() + k);
        Closeable bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.g);
            a = d.a(inputStream, bufferedOutputStream, eVar, this.g);
            try {
                d.a(bufferedOutputStream);
                d.a((Closeable) inputStream);
                if (a && !file.renameTo(c)) {
                    a = false;
                }
                if (!a) {
                    file.delete();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                d.a((Closeable) inputStream);
                if (a && !file.renameTo(c)) {
                    a = false;
                }
                if (!a) {
                    file.delete();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = false;
            d.a((Closeable) inputStream);
            a = false;
            if (a) {
                file.delete();
            }
            throw th;
        }
    }

    public void b() {
    }

    public void b(int i) {
        this.i = i;
    }

    public boolean b(String str) {
        return c(str).delete();
    }

    protected File c(String str) {
        String a = this.f.a(str);
        File file = this.d;
        if (!(this.d.exists() || this.d.mkdirs() || this.e == null || (!this.e.exists() && !this.e.mkdirs()))) {
            file = this.e;
        }
        return new File(file, a);
    }

    public void c() {
        File[] listFiles = this.d.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
