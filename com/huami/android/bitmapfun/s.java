package com.huami.android.bitmapfun;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.Fragment;
import android.support.v4.app.R;
import android.support.v4.l.i;
import android.util.Log;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"NewApi"})
public class s {
    private static final String a = "ImageCache";
    private static final int b = 5120;
    private static final int c = 10485760;
    private static final CompressFormat d = CompressFormat.JPEG;
    private static final int e = 70;
    private static final int f = 0;
    private static final boolean g = true;
    private static final boolean h = true;
    private static final boolean i = false;
    private m j;
    private i<String, BitmapDrawable> k;
    private u l;
    private final Object m = new Object();
    private boolean n = h;
    private Set<SoftReference<Bitmap>> o;

    private s(u uVar) {
        a(uVar);
    }

    private static int a(Config config) {
        return config == Config.ARGB_8888 ? 4 : (config == Config.RGB_565 || config == Config.ARGB_4444) ? 2 : config == Config.ALPHA_8 ? 1 : 1;
    }

    @TargetApi(19)
    public static int a(BitmapDrawable bitmapDrawable) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (E.f()) {
            return bitmap.getAllocationByteCount();
        }
        if (E.d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    @TargetApi(9)
    public static long a(File file) {
        if (E.b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static s a(FragmentManager fragmentManager, u uVar) {
        w a = a(fragmentManager);
        s sVar = (s) a.a();
        if (sVar != null) {
            return sVar;
        }
        sVar = new s(uVar);
        a.a(sVar);
        return sVar;
    }

    public static s a(R r, u uVar) {
        v a = a(r);
        s sVar = (s) a.a();
        if (sVar != null) {
            return sVar;
        }
        sVar = new s(uVar);
        a.a(sVar);
        return sVar;
    }

    private static v a(R r) {
        v vVar = (v) r.a(a);
        if (vVar != null) {
            return vVar;
        }
        Fragment vVar2 = new v();
        r.a().a(vVar2, a).i();
        return vVar2;
    }

    private static w a(FragmentManager fragmentManager) {
        w wVar = (w) fragmentManager.findFragmentByTag(a);
        if (wVar != null) {
            return wVar;
        }
        android.app.Fragment wVar2 = new w();
        fragmentManager.beginTransaction().add(wVar2, a).commitAllowingStateLoss();
        return wVar2;
    }

    @TargetApi(8)
    public static File a(Context context) {
        if (E.a()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    public static File a(Context context, String str) {
        String path = ("mounted".equals(Environment.getExternalStorageState()) || !e()) ? a(context) != null ? a(context).getPath() : context.getCacheDir().getPath() : context.getCacheDir().getPath();
        return new File(path + File.separator + str);
    }

    private static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = f; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i] & HeartRateInfo.HR_EMPTY_VALUE);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private void a(u uVar) {
        this.l = uVar;
        if (this.l.f) {
            if (E.c()) {
                this.o = Collections.synchronizedSet(new HashSet());
            }
            this.k = new t(this, this.l.a);
        }
        if (uVar.h) {
            a();
        }
    }

    @TargetApi(19)
    private static boolean a(Bitmap bitmap, Options options) {
        return !E.f() ? (bitmap.getWidth() == options.outWidth && bitmap.getHeight() == options.outHeight && options.inSampleSize == 1) ? h : false : ((options.outWidth / options.inSampleSize) * (options.outHeight / options.inSampleSize)) * a(bitmap.getConfig()) > bitmap.getAllocationByteCount() ? false : h;
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    @TargetApi(9)
    public static boolean e() {
        return E.b() ? Environment.isExternalStorageRemovable() : h;
    }

    protected Bitmap a(Options options) {
        if (this.o == null || this.o.isEmpty()) {
            return null;
        }
        Bitmap bitmap;
        synchronized (this.o) {
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                bitmap = (Bitmap) ((SoftReference) it.next()).get();
                if (bitmap == null || !bitmap.isMutable()) {
                    it.remove();
                } else if (a(bitmap, options)) {
                    it.remove();
                    break;
                }
            }
            bitmap = null;
        }
        return bitmap;
    }

    public BitmapDrawable a(String str) {
        return this.k != null ? (BitmapDrawable) this.k.a((Object) str) : null;
    }

    public void a() {
        synchronized (this.m) {
            if (this.j == null || this.j.d()) {
                File file = this.l.c;
                if (this.l.g && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (a(file) > ((long) this.l.b)) {
                        try {
                            this.j = m.a(file, 1, 1, (long) this.l.b);
                        } catch (IOException e) {
                            this.l.c = null;
                            Log.e(a, "initDiskCache - " + e);
                        }
                    }
                }
            }
            this.n = false;
            this.m.notifyAll();
        }
    }

    public void a(String str, BitmapDrawable bitmapDrawable) {
        IOException iOException;
        OutputStream outputStream;
        Object obj;
        Throwable th;
        Exception exception;
        Throwable th2;
        if (str != null && bitmapDrawable != null) {
            if (this.k != null) {
                if (D.class.isInstance(bitmapDrawable)) {
                    ((D) bitmapDrawable).b(h);
                }
                this.k.a(str, bitmapDrawable);
            }
            synchronized (this.m) {
                if (this.j != null) {
                    String c = c(str);
                    OutputStream outputStream2 = null;
                    try {
                        r a = this.j.a(c);
                        if (a == null) {
                            o b = this.j.b(c);
                            if (b != null) {
                                outputStream2 = b.c(f);
                                try {
                                    bitmapDrawable.getBitmap().compress(this.l.d, this.l.e, outputStream2);
                                    b.a();
                                    outputStream2.close();
                                } catch (IOException e) {
                                    iOException = e;
                                    outputStream = outputStream2;
                                    IOException iOException2 = iOException;
                                    try {
                                        Log.e(a, "addBitmapToCache - " + obj);
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
                                } catch (Exception e4) {
                                    exception = e4;
                                    outputStream = outputStream2;
                                    Exception exception2 = exception;
                                    Log.e(a, "addBitmapToCache - " + obj);
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    return;
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
                            a.a(f).close();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e6) {
                            }
                        }
                    } catch (IOException e7) {
                        iOException = e7;
                        outputStream = null;
                        obj = iOException;
                        Log.e(a, "addBitmapToCache - " + obj);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return;
                    } catch (Exception e42) {
                        exception = e42;
                        outputStream = null;
                        obj = exception;
                        Log.e(a, "addBitmapToCache - " + obj);
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
        Object e;
        Throwable th;
        Bitmap bitmap = null;
        String c = c(str);
        synchronized (this.m) {
            while (this.n) {
                try {
                    this.m.wait();
                } catch (InterruptedException e2) {
                }
            }
            if (this.j != null) {
                InputStream a;
                try {
                    r a2 = this.j.a(c);
                    if (a2 != null) {
                        a = a2.a(f);
                        if (a != null) {
                            try {
                                bitmap = y.a(((FileInputStream) a).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    Log.e(a, "getBitmapFromDiskCache - " + e);
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
                    Log.e(a, "getBitmapFromDiskCache - " + e);
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
        if (this.k != null) {
            this.k.a();
        }
        synchronized (this.m) {
            this.n = h;
            if (!(this.j == null || this.j.d())) {
                try {
                    this.j.f();
                } catch (IOException e) {
                    Log.e(a, "clearCache - " + e);
                }
                this.j = null;
                a();
            }
        }
    }

    public void c() {
        synchronized (this.m) {
            if (this.j != null) {
                try {
                    this.j.e();
                } catch (IOException e) {
                    Log.e(a, "flush - " + e);
                }
            }
        }
    }

    public void d() {
        synchronized (this.m) {
            if (this.j != null) {
                try {
                    if (!this.j.d()) {
                        this.j.close();
                        this.j = null;
                    }
                } catch (IOException e) {
                    Log.e(a, "close - " + e);
                }
            }
        }
    }
}
