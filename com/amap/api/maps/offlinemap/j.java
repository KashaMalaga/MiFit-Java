package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.mapcore.util.x;
import com.xiaomi.e.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class j extends Thread {
    k a = null;
    long[] b;
    long[] c;
    c[] d;
    long e;
    boolean f = true;
    boolean g = false;
    File h;
    DataOutputStream i;
    d j;
    l k;
    private Context l;
    private Handler m;

    public j(k kVar, d dVar, l lVar, Context context, Handler handler) {
        this.a = kVar;
        this.h = new File(kVar.b() + File.separator + kVar.c() + ".info");
        if (this.h.exists() && g()) {
            this.f = false;
            g();
        } else {
            this.b = new long[kVar.d()];
            this.c = new long[kVar.d()];
        }
        this.j = dVar;
        this.k = lVar;
        this.l = context;
        this.m = handler;
    }

    private void a(int i) {
        System.err.println("Error Code : " + i);
    }

    private void a(ArrayList<OfflineMapProvince> arrayList) {
        String e = this.k.e();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (!offlineMapProvince.getProvinceCode().equalsIgnoreCase(e)) {
                Iterator it2 = offlineMapProvince.getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                    if (offlineMapCity.getAdcode().equalsIgnoreCase(e)) {
                        this.a.a(offlineMapCity.getUrl());
                        this.k.d(offlineMapCity.getUrl());
                        this.k.b(offlineMapCity.getSize());
                        this.k.a(offlineMapCity.getCity());
                        this.k.c(offlineMapCity.getAdcode());
                        this.k.a(offlineMapCity.getSize());
                        this.k.b(offlineMapCity.getVersion());
                        break;
                    }
                }
            }
            this.a.a(offlineMapProvince.getUrl());
            this.k.d(offlineMapProvince.getUrl());
            this.k.b(offlineMapProvince.getSize());
            this.k.a(offlineMapProvince.getProvinceName());
            this.k.c(offlineMapProvince.getProvinceCode());
            this.k.a(offlineMapProvince.getSize());
            this.k.b(offlineMapProvince.getVersion());
            return;
        }
    }

    private void c() {
        if (this.k != null) {
            this.j.a(this.k, -1, this.k.j());
        }
    }

    private boolean d() {
        e eVar = new e(this.l, OfflineMapManager.a);
        this.j.a(this.k, 6, 0);
        OfflineInitBean offlineInitBean = (OfflineInitBean) eVar.getData();
        if (offlineInitBean == null) {
            return false;
        }
        boolean z = offlineInitBean.a;
        if (z) {
            h hVar = new h(this.l, a.f);
            hVar.a(this.l);
            ArrayList arrayList = (ArrayList) hVar.getData();
            a(arrayList);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("update_file", arrayList);
            Message message = new Message();
            message.what = 1;
            message.setData(bundle);
            this.m.sendMessage(message);
        }
        return z;
    }

    private void e() {
        if (x.a == -1) {
            int i = 0;
            while (i < 3) {
                try {
                    if (!x.a(this.l, u.e())) {
                        i++;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    az.a(th, "SiteFileFetch", "authOffLineDownLoad");
                    Log.i("AuthFailure", th.getMessage());
                    th.printStackTrace();
                }
            }
        }
    }

    private boolean f() {
        try {
            this.i = new DataOutputStream(new FileOutputStream(this.h));
            this.i.writeLong(this.e);
            this.i.writeInt(this.b.length);
            int i = 0;
            long j = 0;
            while (i < this.b.length) {
                j = i == 0 ? j + this.d[i].b : j + (this.d[i].b - this.d[i - 1].c);
                this.i.writeLong(this.d[i].b);
                this.i.writeLong(this.d[i].c);
                i++;
            }
            this.i.close();
            if (this.e <= 0) {
                return false;
            }
            long j2 = (j * 100) / this.e;
            this.k.c(j);
            this.k.b((int) j2);
            if (u.c(this.l)) {
                this.j.a(this.k, 0, (int) j2);
            }
            return j2 >= 100;
        } catch (Throwable th) {
            az.a(th, "SiteFileFetch", "write_nPos");
            th.printStackTrace();
            return false;
        }
    }

    private boolean g() {
        Throwable th;
        boolean z = true;
        DataInputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(this.h));
            try {
                if (dataInputStream.available() >= 1) {
                    this.e = dataInputStream.readLong();
                    if (this.e <= 0) {
                        dataInputStream.close();
                        if (dataInputStream == null) {
                            return false;
                        }
                        try {
                            dataInputStream.close();
                            return false;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    int readInt = dataInputStream.readInt();
                    this.b = new long[readInt];
                    this.c = new long[readInt];
                    for (readInt = 0; readInt < this.b.length; readInt++) {
                        this.b[readInt] = dataInputStream.readLong();
                        this.c[readInt] = dataInputStream.readLong();
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return z;
                } else if (dataInputStream == null) {
                    return false;
                } else {
                    try {
                        dataInputStream.close();
                        return false;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    az.a(th, "SiteFileFetch", "read_nPos");
                    th.printStackTrace();
                    if (dataInputStream == null) {
                        try {
                            dataInputStream.close();
                            z = false;
                        } catch (IOException e32) {
                            e32.printStackTrace();
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a() {
        /*
        r5 = this;
        r1 = -1;
        r0 = new java.net.URL;	 Catch:{ Throwable -> 0x0046 }
        r2 = r5.a;	 Catch:{ Throwable -> 0x0046 }
        r2 = r2.a();	 Catch:{ Throwable -> 0x0046 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0046 }
        r0 = r0.openConnection();	 Catch:{ Throwable -> 0x0046 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Throwable -> 0x0046 }
        r2 = "User-Agent";
        r3 = com.amap.api.mapcore.n.c;	 Catch:{ Throwable -> 0x0046 }
        r0.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x0046 }
        r2 = r0.getResponseCode();	 Catch:{ Throwable -> 0x0046 }
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r2 < r3) goto L_0x0027;
    L_0x0021:
        r5.a(r2);	 Catch:{ Throwable -> 0x0046 }
        r0 = -2;
    L_0x0026:
        return r0;
    L_0x0027:
        r2 = 1;
    L_0x0028:
        r3 = r0.getHeaderFieldKey(r2);	 Catch:{ Throwable -> 0x0046 }
        if (r3 == 0) goto L_0x0051;
    L_0x002e:
        r4 = "Content-Length";
        r4 = r3.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x0046 }
        if (r4 == 0) goto L_0x0043;
    L_0x0036:
        r0 = r0.getHeaderField(r3);	 Catch:{ Throwable -> 0x0046 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x0046 }
    L_0x003e:
        com.amap.api.maps.offlinemap.m.b(r0);
        r0 = (long) r0;
        goto L_0x0026;
    L_0x0043:
        r2 = r2 + 1;
        goto L_0x0028;
    L_0x0046:
        r0 = move-exception;
        r2 = "SiteFileFetch";
        r3 = "getFileSize";
        com.amap.api.mapcore.util.az.a(r0, r2, r3);
        r0.printStackTrace();
    L_0x0051:
        r0 = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.j.a():long");
    }

    public void b() {
        this.g = true;
        int i = 0;
        while (i < this.b.length) {
            if (!(this.d == null || this.d[i] == null)) {
                this.d[i].b();
            }
            i++;
        }
    }

    public void run() {
        try {
            if (u.c(this.l)) {
                e();
            }
            if (x.a == 1) {
                if (this.f) {
                    d();
                    m.a(this.a.a());
                    this.e = a();
                    if (this.e == -1) {
                        m.a("File Length is not known!");
                    } else if (this.e == -2) {
                        m.a("File is not access!");
                    } else {
                        int i;
                        for (i = 0; i < this.b.length; i++) {
                            this.b[i] = ((long) i) * (this.e / ((long) this.b.length));
                        }
                        for (i = 0; i < this.c.length - 1; i++) {
                            this.c[i] = this.b[i + 1];
                        }
                        this.c[this.c.length - 1] = this.e;
                    }
                }
                this.d = new c[this.b.length];
                for (int i2 = 0; i2 < this.b.length; i2++) {
                    this.d[i2] = new c(this.a.a(), this.a.b() + File.separator + this.a.c(), this.b[i2], this.c[i2], i2);
                    m.a("Thread " + i2 + " , nStartPos = " + this.b[i2] + ", nEndPos = " + this.c[i2]);
                    this.d[i2].start();
                }
                boolean z = false;
                while (!this.g) {
                    Object obj;
                    z = f();
                    m.a((int) kankan.wheel.widget.a.aB);
                    int i3 = 0;
                    while (i3 < this.b.length) {
                        if (this.d[i3].a() > 3) {
                            b();
                            c();
                            m.b("\u4e0b\u8f7d\u51fa\u9519\n");
                            obj = 1;
                            break;
                        } else if (!this.d[i3].e) {
                            obj = null;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i3 = 1;
                    if (!isInterrupted()) {
                        if (obj == null) {
                            if (z) {
                                break;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (this.g && !z) {
                    this.j.b();
                }
                if (!this.g) {
                    this.j.b(this.k);
                }
                if (z) {
                    this.g = true;
                }
            }
        } catch (Throwable th) {
            az.a(th, "SiteFileFetch", "download");
            c();
            th.printStackTrace();
        }
    }
}
