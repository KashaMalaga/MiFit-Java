package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.mapcore.util.bl.b;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class j {
    private static final CompressFormat a = CompressFormat.PNG;
    private bl b;
    private p<String, Bitmap> c;
    private a d;
    private final Object e = new Object();
    private boolean f = true;
    private HashMap<String, WeakReference<Bitmap>> g;

    public class a {
        public int a = 5242880;
        public int b = 10485760;
        public File c;
        public CompressFormat d = j.a;
        public int e = 100;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;

        public a(Context context, String str) {
            this.c = j.a(context, str);
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str) {
            this.c = new File(str);
        }

        public void a(boolean z) {
            this.f = z;
        }

        public void b(int i) {
            if (i <= 0) {
                this.g = false;
            }
            this.b = i;
        }

        public void b(boolean z) {
            this.g = z;
        }
    }

    private j(a aVar) {
        b(aVar);
    }

    public static int a(Bitmap bitmap) {
        return u.d() ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static long a(File file) {
        if (u.b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static j a(a aVar) {
        return new j(aVar);
    }

    public static File a(Context context) {
        if (u.a()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    public static File a(Context context, String str) {
        File a = a(context);
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !e()) && a != null) ? a.getPath() : context.getCacheDir().getPath();
        o.a("ImageCache", "Disk cachePath: " + path, 111);
        return new File(path + File.separator + str);
    }

    private static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private void b(a aVar) {
        this.d = aVar;
        if (this.d.f) {
            o.a("ImageCache", "Memory cache created (size = " + this.d.a + ")", 111);
            if (u.c()) {
                this.g = new HashMap();
            }
            this.c = new p<String, Bitmap>(this, this.d.a) {
                final /* synthetic */ j a;

                protected int a(String str, Bitmap bitmap) {
                    int a = j.a(bitmap);
                    return a == 0 ? 1 : a;
                }

                protected void a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (u.c() && this.a.g != null && bitmap != null && !bitmap.isRecycled()) {
                        this.a.g.put(str, new WeakReference(bitmap));
                    }
                }
            };
        }
        if (aVar.h) {
            a();
        }
    }

    private void b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                b(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(kankan.wheel.widget.a.bO));
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        } catch (UnsupportedEncodingException e2) {
            return String.valueOf(str.hashCode());
        }
    }

    public static boolean e() {
        return u.b() ? Environment.isExternalStorageRemovable() : true;
    }

    public Bitmap a(String str) {
        Bitmap bitmap;
        if (u.c() && this.g != null) {
            WeakReference weakReference = (WeakReference) this.g.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
                this.g.remove(str);
                if (bitmap == null && this.c != null) {
                    bitmap = (Bitmap) this.c.a((Object) str);
                }
                if (bitmap == null && !bitmap.isRecycled()) {
                    o.a("ImageCache", "Memory cache hit", 111);
                    return bitmap;
                }
            }
        }
        bitmap = null;
        bitmap = (Bitmap) this.c.a((Object) str);
        return bitmap == null ? null : null;
    }

    public void a() {
        synchronized (this.e) {
            if (this.b == null || this.b.a()) {
                File file = this.d.c;
                if (this.d.g && file != null) {
                    try {
                        if (file.exists()) {
                            b(file);
                        }
                        file.mkdir();
                    } catch (Exception e) {
                    }
                    if (a(file) > ((long) this.d.b)) {
                        try {
                            this.b = bl.a(file, 1, 1, (long) this.d.b);
                            o.a("ImageCache", "Disk cache initialized", 111);
                        } catch (IOException e2) {
                            this.d.c = null;
                            o.a("ImageCache", "initDiskCache - " + e2, 112);
                        }
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    public void a(String str, Bitmap bitmap) {
        IOException iOException;
        OutputStream outputStream;
        Object obj;
        Throwable th;
        Throwable th2;
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.c != null) {
                this.c.b(str, bitmap);
            }
            synchronized (this.e) {
                if (this.b != null) {
                    String c = c(str);
                    OutputStream outputStream2 = null;
                    try {
                        b a = this.b.a(c);
                        if (a == null) {
                            com.amap.api.mapcore.util.bl.a b = this.b.b(c);
                            if (b != null) {
                                outputStream2 = b.a(0);
                                try {
                                    bitmap.compress(this.d.d, this.d.e, outputStream2);
                                    b.a();
                                    outputStream2.close();
                                } catch (IOException e) {
                                    iOException = e;
                                    outputStream = outputStream2;
                                    IOException iOException2 = iOException;
                                    try {
                                        o.a("ImageCache", "addBitmapToCache - " + obj, 112);
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e2) {
                                            }
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    outputStream = outputStream2;
                                    th = th2;
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            a.a(0).close();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        outputStream = null;
                        obj = iOException;
                        o.a("ImageCache", "addBitmapToCache - " + obj, 112);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return;
                    } catch (Throwable th42) {
                        th2 = th42;
                        outputStream = null;
                        th = th2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                }
            }
            return;
        }
        return;
    }

    public Bitmap b(String str) {
        InputStream a;
        Object e;
        Throwable th;
        Bitmap bitmap = null;
        String c = c(str);
        synchronized (this.e) {
            while (this.f) {
                try {
                    this.e.wait();
                } catch (InterruptedException e2) {
                }
            }
            if (this.b != null) {
                try {
                    b a2 = this.b.a(c);
                    if (a2 != null) {
                        o.a("ImageCache", "Disk cache hit", 111);
                        a = a2.a(0);
                        if (a != null) {
                            try {
                                bitmap = l.a(((FileInputStream) a).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    o.a("ImageCache", "getBitmapFromDiskCache - " + e, 112);
                                    if (a != null) {
                                        try {
                                            a.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    return bitmap;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a != null) {
                                        try {
                                            a.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    Object obj = bitmap;
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    a = bitmap;
                    o.a("ImageCache", "getBitmapFromDiskCache - " + e, 112);
                    if (a != null) {
                        a.close();
                    }
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    a = bitmap;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        }
        return bitmap;
    }

    public void b() {
        if (u.c() && this.g != null) {
            this.g.clear();
        }
        if (this.c != null) {
            this.c.a();
            o.a("ImageCache", "Memory cache cleared", 111);
        }
        synchronized (this.e) {
            this.f = true;
            if (!(this.b == null || this.b.a())) {
                try {
                    this.b.c();
                    o.a("ImageCache", "Disk cache cleared", 111);
                } catch (IOException e) {
                    o.a("ImageCache", "clearCache - " + e, 112);
                }
                this.b = null;
                a();
            }
        }
    }

    public void c() {
        synchronized (this.e) {
            if (this.b != null) {
                try {
                    this.b.b();
                    o.a("ImageCache", "Disk cache flushed", 111);
                } catch (IOException e) {
                    o.a("ImageCache", "flush - " + e, 112);
                }
            }
        }
    }

    public void d() {
        if (u.c() && this.g != null) {
            this.g.clear();
        }
        if (this.c != null) {
            this.c.a();
            o.a("ImageCache", "Memory cache cleared", 111);
        }
        synchronized (this.e) {
            if (this.b != null) {
                try {
                    if (!this.b.a()) {
                        this.b.c();
                        this.b = null;
                        o.a("ImageCache", "Disk cache closed", 111);
                    }
                } catch (IOException e) {
                    o.a("ImageCache", "close - " + e, 112);
                }
            }
        }
    }
}
