package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.services.core.AMapException;
import com.b.C0916a;
import com.b.M;
import com.b.Y;
import com.b.Z;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;

public class c implements Runnable {
    Z a = null;
    volatile boolean b = false;
    boolean c = true;
    private volatile boolean d = false;
    private Context e;
    private long f = 2000;
    private a g;
    private a h;
    private boolean i = false;

    c(Context context, a aVar, a aVar2) {
        this.h = aVar2;
        b(false);
        this.e = context;
        this.a = new C0916a();
        this.g = aVar;
    }

    private AMapLocation a(M m) {
        AMapLocation aMapLocation = new AMapLocation(a.f);
        aMapLocation.setProvider(LocationProviderProxy.AMapNetwork);
        aMapLocation.setLatitude(m.f());
        aMapLocation.setLongitude(m.e());
        aMapLocation.setAccuracy(m.g());
        aMapLocation.setTime(m.h());
        aMapLocation.setPoiId(m.b());
        aMapLocation.setFloor(m.c());
        aMapLocation.setCountry(m.n());
        aMapLocation.setRoad(m.q());
        aMapLocation.setPoiName(m.s());
        aMapLocation.setAMapException(m.a());
        Bundle bundle = new Bundle();
        bundle.putString("citycode", m.k());
        bundle.putString(SocialConstants.PARAM_APP_DESC, m.l());
        bundle.putString("adcode", m.m());
        aMapLocation.setExtras(bundle);
        String k = m.k();
        String l = m.l();
        String m2 = m.m();
        aMapLocation.setCityCode(k);
        aMapLocation.setAdCode(m2);
        if (m2 == null || m2.trim().length() <= 0) {
            aMapLocation.b(l);
        } else {
            aMapLocation.b(l.replace(" ", a.f));
        }
        aMapLocation.setCity(m.p());
        aMapLocation.setDistrict(m.d());
        aMapLocation.a(m.r());
        aMapLocation.setProvince(m.o());
        return aMapLocation;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
        r5 = this;
        r0 = r5.e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        com.amap.api.location.core.c.a(r0);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r5.a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r5.a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r5.e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0.a(r1);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
    L_0x0010:
        r0 = r5.a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0040;
    L_0x0014:
        r0 = r5.a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1.<init>();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = "api_serverSDK_130905##S128DF1572465B890OE3F7A13167KLEI##";
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = r5.e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = com.amap.api.location.core.c.b(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = ",";
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = com.amap.api.location.core.c.b();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0.a(r1);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
    L_0x0040:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1.<init>();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = "key";
        r2 = r5.e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = com.amap.api.location.core.c.b(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = "X-INFO";
        r2 = r5.e;	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
        r2 = com.amap.api.location.core.c.a(r2);	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
        r3 = "loc";
        r2 = r2.a(r3);	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
        r1.put(r0, r2);	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
    L_0x0061:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2.<init>();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r5.e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = com.amap.api.location.core.c.a(r0);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r0.c();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r3 = "ex";
        r4 = "UTF-8";
        r0 = r0.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x00a2 }
        r0 = com.b.E.a(r0);	 Catch:{ UnsupportedEncodingException -> 0x00a2 }
        r2.put(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x00a2 }
    L_0x007f:
        r0 = "X-BIZ";
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = "User-Agent";
        r2 = "AMAP Location SDK Android 1.3.1";
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r5.a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0094;
    L_0x008f:
        r0 = r5.a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0.a(r1);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
    L_0x0094:
        r0 = 1;
        r5.i = r0;
        return;
    L_0x0098:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        goto L_0x0061;
    L_0x009d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0094;
    L_0x00a2:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        goto L_0x007f;
    L_0x00a7:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.c.d():void");
    }

    private M e() {
        M f = f();
        if (f != null) {
            return f;
        }
        f = new M();
        f.a(new AMapLocException(AMapException.ERROR_UNKNOWN));
        this.c = false;
        return f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.b.M f() {
        /*
        r4 = this;
        r2 = 0;
        r1 = 0;
        r0 = r4.a;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
        if (r0 == 0) goto L_0x002f;
    L_0x0006:
        r0 = r4.a;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
        r0 = r0.a();	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
    L_0x000c:
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r1 = 0;
        r4.c = r1;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x002d }
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = 1;
        r4.c = r1;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x002d }
        goto L_0x0011;
    L_0x0016:
        r0 = move-exception;
        r1 = r0;
        r0 = new com.b.M;
        r0.<init>();
        r0.a(r1);
        r4.c = r2;
        goto L_0x0011;
    L_0x0023:
        r0 = move-exception;
        r3 = r0;
        r0 = r1;
        r1 = r3;
    L_0x0027:
        r4.c = r2;
        r1.printStackTrace();
        goto L_0x0011;
    L_0x002d:
        r1 = move-exception;
        goto L_0x0027;
    L_0x002f:
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.c.f():com.b.M");
    }

    private boolean g() {
        if (System.currentTimeMillis() - this.h.d <= 5 * this.f) {
            return false;
        }
        this.h.c = false;
        return true;
    }

    void a(long j) {
        if (j > this.f) {
            this.f = j;
        }
    }

    void a(PendingIntent pendingIntent) {
        this.a.a(pendingIntent);
    }

    void a(Y y, PendingIntent pendingIntent) {
        this.a.a(y, pendingIntent);
    }

    synchronized void a(boolean z) {
        this.b = z;
    }

    public synchronized boolean a() {
        return this.b;
    }

    synchronized void b() {
        a(true);
        if (!this.d) {
            c();
        }
        if (this.h != null) {
            this.h.b();
        }
        this.i = false;
    }

    void b(PendingIntent pendingIntent) {
        this.a.b(pendingIntent);
    }

    void b(Y y, PendingIntent pendingIntent) {
        this.a.b(y, pendingIntent);
    }

    synchronized void b(boolean z) {
        this.d = z;
    }

    synchronized void c() {
        if (this.a != null) {
            this.a.b();
        }
        this.a = null;
    }

    public void run() {
        Looper.prepare();
        if (a()) {
            c();
            return;
        }
        if (!this.i && this.d) {
            d();
        }
        while (this.d && !Thread.currentThread().isInterrupted() && !a()) {
            Message message;
            try {
                if ((!this.h.c || g()) && this.h.e) {
                    M e = e();
                    Object a = e != null ? a(e) : null;
                    if (a != null) {
                        if (this.h.e && (!this.h.c || g())) {
                            Message message2 = new Message();
                            message2.obj = a;
                            message2.what = 100;
                            this.g.sendMessage(message2);
                        }
                    }
                    if (com.amap.api.location.core.a.a() == -1) {
                        com.amap.api.location.core.a.a(this.e);
                    }
                    if (this.c) {
                        Thread.sleep(this.f);
                    } else {
                        Thread.sleep(30000);
                    }
                } else {
                    try {
                        this.c = true;
                        Thread.sleep(this.f);
                        if (null != null) {
                            try {
                                if (this.h.e && (!this.h.c || g())) {
                                    message = new Message();
                                    message.obj = null;
                                    message.what = 100;
                                    this.g.sendMessage(message);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        if (com.amap.api.location.core.a.a() == -1) {
                            com.amap.api.location.core.a.a(this.e);
                        }
                        if (this.c) {
                            Thread.sleep(this.f);
                        } else {
                            Thread.sleep(30000);
                        }
                    } catch (Throwable th2) {
                        if (null != null) {
                            if (this.h.e && (!this.h.c || g())) {
                                message = new Message();
                                message.obj = null;
                                message.what = 100;
                                this.g.sendMessage(message);
                            }
                        }
                        if (com.amap.api.location.core.a.a() == -1) {
                            com.amap.api.location.core.a.a(this.e);
                        }
                        if (this.c) {
                            Thread.sleep(this.f);
                        } else {
                            Thread.sleep(30000);
                        }
                    }
                }
            } catch (Throwable th3) {
            }
        }
        if (a()) {
            c();
        }
    }
}
