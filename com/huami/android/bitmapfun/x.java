package com.huami.android.bitmapfun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class x extends y {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final String h = "ImageFetcher";
    private static final int i = 10485760;
    private static final String j = "http";
    private static final int k = 8192;
    private static final int p = 0;
    private m l;
    private File m;
    private boolean n = true;
    private final Object o = new Object();

    public x(Context context, int i) {
        super(context, i);
        a(context);
    }

    public x(Context context, int i, int i2) {
        super(context, i, i2);
        a(context);
    }

    private Bitmap a(String str) {
        return a(str, (int) a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(java.lang.String r9, int r10) {
        /*
        r8 = this;
        r2 = 0;
        r1 = com.huami.android.bitmapfun.s.c(r9);
        r3 = r8.o;
        monitor-enter(r3);
    L_0x0008:
        r0 = r8.n;	 Catch:{ all -> 0x00d8 }
        if (r0 == 0) goto L_0x0014;
    L_0x000c:
        r0 = r8.o;	 Catch:{ InterruptedException -> 0x0012 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0012 }
        goto L_0x0008;
    L_0x0012:
        r0 = move-exception;
        goto L_0x0008;
    L_0x0014:
        r0 = r8.l;	 Catch:{ all -> 0x00d8 }
        if (r0 == 0) goto L_0x00fc;
    L_0x0018:
        r0 = 1;
        if (r10 != r0) goto L_0x0092;
    L_0x001b:
        r0 = r8.l;	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r0 = r0.a(r1);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        if (r0 != 0) goto L_0x003f;
    L_0x0023:
        r0 = r8.l;	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r0 = r0.b(r1);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        if (r0 == 0) goto L_0x0039;
    L_0x002b:
        r4 = 0;
        r4 = r0.c(r4);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r4 = r8.b(r9, r4);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        if (r4 == 0) goto L_0x006b;
    L_0x0036:
        r0.a();	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
    L_0x0039:
        r0 = r8.l;	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r0 = r0.a(r1);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
    L_0x003f:
        if (r0 == 0) goto L_0x00a2;
    L_0x0041:
        r1 = 0;
        r0 = r0.a(r1);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r0 = (java.io.FileInputStream) r0;	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r1 = r0.getFD();	 Catch:{ IOException -> 0x00f0, IllegalStateException -> 0x00e9, all -> 0x00e2 }
        r7 = r0;
        r0 = r1;
        r1 = r7;
    L_0x004f:
        if (r0 != 0) goto L_0x0056;
    L_0x0051:
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r1.close();	 Catch:{ IOException -> 0x00db }
    L_0x0056:
        monitor-exit(r3);	 Catch:{ all -> 0x00d8 }
        if (r0 == 0) goto L_0x0065;
    L_0x0059:
        r2 = r8.d;
        r3 = r8.e;
        r4 = r8.f();
        r2 = com.huami.android.bitmapfun.y.a(r0, r2, r3, r4);
    L_0x0065:
        if (r1 == 0) goto L_0x006a;
    L_0x0067:
        r1.close();	 Catch:{ IOException -> 0x00e0 }
    L_0x006a:
        return r2;
    L_0x006b:
        r0.b();	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        goto L_0x0039;
    L_0x006f:
        r0 = move-exception;
        r1 = r2;
    L_0x0071:
        r4 = "ImageFetcher";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e7 }
        r5.<init>();	 Catch:{ all -> 0x00e7 }
        r6 = "processBitmap - ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x00e7 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x00e7 }
        r0 = r0.toString();	 Catch:{ all -> 0x00e7 }
        android.util.Log.e(r4, r0);	 Catch:{ all -> 0x00e7 }
        if (r2 != 0) goto L_0x00f9;
    L_0x008b:
        if (r1 == 0) goto L_0x00f9;
    L_0x008d:
        r1.close();	 Catch:{ IOException -> 0x00a5 }
        r0 = r2;
        goto L_0x0056;
    L_0x0092:
        r0 = 2;
        if (r10 != r0) goto L_0x009f;
    L_0x0095:
        r1 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r1.<init>(r9);	 Catch:{ IOException -> 0x006f, IllegalStateException -> 0x00a8, all -> 0x00ce }
        r0 = r1.getFD();	 Catch:{ IOException -> 0x00f6, IllegalStateException -> 0x00ee }
        goto L_0x004f;
    L_0x009f:
        r0 = 3;
        if (r10 != r0) goto L_0x00a2;
    L_0x00a2:
        r1 = r2;
        r0 = r2;
        goto L_0x004f;
    L_0x00a5:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0056;
    L_0x00a8:
        r0 = move-exception;
        r1 = r2;
    L_0x00aa:
        r4 = "ImageFetcher";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e7 }
        r5.<init>();	 Catch:{ all -> 0x00e7 }
        r6 = "processBitmap - ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x00e7 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x00e7 }
        r0 = r0.toString();	 Catch:{ all -> 0x00e7 }
        android.util.Log.e(r4, r0);	 Catch:{ all -> 0x00e7 }
        if (r2 != 0) goto L_0x00f9;
    L_0x00c4:
        if (r1 == 0) goto L_0x00f9;
    L_0x00c6:
        r1.close();	 Catch:{ IOException -> 0x00cb }
        r0 = r2;
        goto L_0x0056;
    L_0x00cb:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0056;
    L_0x00ce:
        r0 = move-exception;
        r1 = r2;
    L_0x00d0:
        if (r2 != 0) goto L_0x00d7;
    L_0x00d2:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d4:
        r1.close();	 Catch:{ IOException -> 0x00de }
    L_0x00d7:
        throw r0;	 Catch:{ all -> 0x00d8 }
    L_0x00d8:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00d8 }
        throw r0;
    L_0x00db:
        r4 = move-exception;
        goto L_0x0056;
    L_0x00de:
        r1 = move-exception;
        goto L_0x00d7;
    L_0x00e0:
        r0 = move-exception;
        goto L_0x006a;
    L_0x00e2:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00d0;
    L_0x00e7:
        r0 = move-exception;
        goto L_0x00d0;
    L_0x00e9:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00aa;
    L_0x00ee:
        r0 = move-exception;
        goto L_0x00aa;
    L_0x00f0:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0071;
    L_0x00f6:
        r0 = move-exception;
        goto L_0x0071;
    L_0x00f9:
        r0 = r2;
        goto L_0x0056;
    L_0x00fc:
        r1 = r2;
        r0 = r2;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huami.android.bitmapfun.x.a(java.lang.String, int):android.graphics.Bitmap");
    }

    private void a(Context context) {
        b(context);
        this.m = s.a(context, j);
    }

    private void b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            Log.e(h, "checkConnection - no connection found");
        }
    }

    @SuppressLint({"NewApi"})
    public static void e() {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void j() {
        if (!this.m.exists()) {
            this.m.mkdirs();
        }
        synchronized (this.o) {
            if (s.a(this.m) > 10485760) {
                try {
                    this.l = m.a(this.m, a, a, 10485760);
                } catch (IOException e) {
                    this.l = null;
                }
            }
            this.n = false;
            this.o.notifyAll();
        }
    }

    protected Bitmap a(Object obj) {
        return a(String.valueOf(obj));
    }

    protected Bitmap a(Object obj, int i) {
        return a(String.valueOf(obj), i);
    }

    protected void a() {
        super.a();
        j();
    }

    public boolean a(String str, OutputStream outputStream) {
        FileInputStream fileInputStream;
        Object e;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream, k);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream, k);
                    while (true) {
                        try {
                            int read = bufferedInputStream3.read();
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream2.write(read);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream2 = bufferedInputStream3;
                            bufferedOutputStream = bufferedOutputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream2 = bufferedInputStream3;
                            bufferedOutputStream = bufferedOutputStream2;
                        }
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e3) {
                            return true;
                        }
                    }
                    if (bufferedInputStream3 != null) {
                        bufferedInputStream3.close();
                    }
                    if (fileInputStream == null) {
                        return true;
                    }
                    fileInputStream.close();
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedInputStream = bufferedInputStream3;
                    bufferedOutputStream = null;
                    bufferedInputStream2 = bufferedInputStream;
                    try {
                        Log.e(h, "Error in downloadBitmap - " + e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e5) {
                                return false;
                            }
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e6) {
                                throw th;
                            }
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream3;
                    bufferedOutputStream = null;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedOutputStream = null;
                Log.e(h, "Error in downloadBitmap - " + e);
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fileInputStream = null;
            bufferedOutputStream = null;
            Log.e(h, "Error in downloadBitmap - " + e);
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    protected void b() {
        super.b();
        synchronized (this.o) {
            if (!(this.l == null || this.l.d())) {
                try {
                    this.l.f();
                } catch (IOException e) {
                    Log.e(h, "clearCacheInternal - " + e);
                }
                this.l = null;
                this.n = true;
                j();
            }
        }
    }

    public boolean b(String str, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        IOException iOException;
        BufferedInputStream bufferedInputStream2;
        Object obj;
        Throwable th;
        BufferedInputStream bufferedInputStream3;
        BufferedOutputStream bufferedOutputStream = null;
        e();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream(), k);
            } catch (IOException e) {
                httpURLConnection = httpURLConnection2;
                iOException = e;
                bufferedInputStream2 = null;
                try {
                    Log.e(h, "Error in downloadBitmap - " + obj);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            return false;
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            throw th;
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection = httpURLConnection2;
                th = th3;
                bufferedInputStream2 = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream, k);
                while (true) {
                    try {
                        int read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(read);
                    } catch (IOException e4) {
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream3 = bufferedInputStream;
                        httpURLConnection = httpURLConnection2;
                        obj = e4;
                        bufferedInputStream2 = bufferedInputStream3;
                    } catch (Throwable th32) {
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream3 = bufferedInputStream;
                        httpURLConnection = httpURLConnection2;
                        th = th32;
                        bufferedInputStream2 = bufferedInputStream3;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return true;
            } catch (IOException e42) {
                IOException iOException2 = e42;
                bufferedInputStream2 = bufferedInputStream;
                httpURLConnection = httpURLConnection2;
                iOException = iOException2;
                Log.e(h, "Error in downloadBitmap - " + obj);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                return false;
            } catch (Throwable th322) {
                Throwable th4 = th322;
                bufferedInputStream2 = bufferedInputStream;
                httpURLConnection = httpURLConnection2;
                th = th4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            obj = e6;
            bufferedInputStream2 = null;
            httpURLConnection = null;
            Log.e(h, "Error in downloadBitmap - " + obj);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream2 = null;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    protected void c() {
        super.c();
        synchronized (this.o) {
            if (this.l != null) {
                try {
                    this.l.e();
                } catch (IOException e) {
                    Log.e(h, "flush - " + e);
                }
            }
        }
    }

    protected void d() {
        super.d();
        synchronized (this.o) {
            if (this.l != null) {
                try {
                    if (!this.l.d()) {
                        this.l.close();
                        this.l = null;
                    }
                } catch (IOException e) {
                    Log.e(h, "closeCacheInternal - " + e);
                }
            }
        }
    }
}
