package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.ui.dW;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.s;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kankan.wheel.widget.a;
import org.json.JSONException;

class d {
    private static String h = null;
    private static Context i = null;
    protected CopyOnWriteArrayList<l> a;
    protected CopyOnWriteArrayList<l> b;
    protected CopyOnWriteArrayList<OfflineMapProvince> c;
    protected CopyOnWriteArrayList<OfflineMapProvince> d;
    j e;
    private Handler f;
    private Bundle g;
    private OfflineMapManager j;
    private AMap k;

    public d(Context context, Handler handler, OfflineMapManager offlineMapManager) {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.g = new Bundle();
        i = context;
        this.j = offlineMapManager;
        this.f = handler;
        h = u.a(context);
    }

    public d(Context context, Handler handler, OfflineMapManager offlineMapManager, AMap aMap) {
        this(context, handler, offlineMapManager);
        this.k = aMap;
    }

    public static String a() {
        return u.b(i);
    }

    private void a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable e;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, a.bO));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                    } catch (JSONException e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        e = th;
                        bufferedReader2 = bufferedReader;
                    }
                }
                a(stringBuffer.toString());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e52) {
                        e52.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
                try {
                    az.a(e, "MapDownloadManager", "readOfflineSD filenotfound");
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e522) {
                            e522.printStackTrace();
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5222) {
                            e5222.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = fileInputStream2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e72) {
                            e72.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (IOException e8) {
                e = e8;
                try {
                    az.a(e, "MapDownloadManager", "readOfflineSD io");
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e52222) {
                            e52222.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e522222) {
                            e522222.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    e = th3;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e;
                }
            } catch (JSONException e9) {
                e = e9;
                az.a(e, "MapDownloadManager", "readOfflineSD parseJson");
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5222222) {
                        e5222222.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e52222222) {
                        e52222222.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            bufferedReader = null;
            az.a(e, "MapDownloadManager", "readOfflineSD filenotfound");
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (IOException e11) {
            e = e11;
            fileInputStream = null;
            az.a(e, "MapDownloadManager", "readOfflineSD io");
            e.printStackTrace();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (JSONException e12) {
            e = e12;
            fileInputStream = null;
            az.a(e, "MapDownloadManager", "readOfflineSD parseJson");
            e.printStackTrace();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            fileInputStream = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e;
        }
    }

    private void a(String str) {
        List c = m.c(str);
        e();
        a(c);
    }

    private Message b(l lVar, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(LocationManagerProxy.KEY_STATUS_CHANGED, i);
        bundle.putInt("complete", i2);
        if (lVar != null) {
            bundle.putString("name", lVar.b());
            bundle.putString("adcode", lVar.e());
            bundle.putBoolean("sheng", lVar.i());
        }
        Message obtainMessage = this.f.obtainMessage();
        obtainMessage.setData(bundle);
        return obtainMessage;
    }

    private void f() {
        try {
            a(u.a(s.a(i).open("offlinemap3.png")));
        } catch (Throwable th) {
            az.a(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
        }
    }

    public void a(int i) {
        if (this.b != null && this.b.size() > 0) {
            l lVar = (l) this.b.get(i);
            try {
                this.e = new j(new k(lVar.f(), a(), (lVar.e() + ".zip") + dW.c, 5), this, lVar, i, this.f);
                this.e.start();
                this.j.setStart(true);
            } catch (Throwable th) {
                az.a(th, "MapDownloadManager", "startDownload");
                th.printStackTrace();
            }
        }
    }

    public void a(l lVar, int i, int i2) {
        if (!lVar.e().equalsIgnoreCase(this.g.getString("adcode")) || i != this.g.getInt(LocationManagerProxy.KEY_STATUS_CHANGED) || i2 != this.g.getInt("complete")) {
            if (i2 == 100) {
                lVar.b(100);
            }
            this.f.sendMessage(b(lVar, i, i2));
            lVar.a = i;
            lVar.l();
            this.g.putInt(LocationManagerProxy.KEY_STATUS_CHANGED, i);
            this.g.putInt("complete", i2);
            this.g.putString("adcode", lVar.e());
            this.g.putString("name", lVar.b());
            this.g.putBoolean("sheng", lVar.i());
        }
    }

    protected void a(List<OfflineMapProvince> list) {
        for (OfflineMapProvince offlineMapProvince : list) {
            this.d.add(offlineMapProvince);
            this.c.add(offlineMapProvince);
        }
    }

    public boolean a(l lVar) {
        boolean delete;
        boolean delete2;
        lVar.a = 3;
        this.b.remove(lVar);
        this.a.remove(lVar);
        String d = lVar.d();
        String str = d + ".dt";
        if (d != null && d.length() > 0) {
            try {
                delete = new File(d).delete();
            } catch (Throwable th) {
                az.a(th, "MapDownloadManager", "delDownload");
                th.printStackTrace();
            }
            if (str.length() > 0) {
                try {
                    new File(str).delete();
                } catch (Throwable th2) {
                    az.a(th2, "MapDownloadManager", "delDownload dt");
                    th2.printStackTrace();
                }
            }
            str = d + ".info";
            if (str.length() > 0) {
                try {
                    delete2 = new File(str).delete();
                } catch (Throwable th22) {
                    az.a(th22, "MapDownloadManager", "delDownload info");
                    th22.printStackTrace();
                }
                return !delete && delete2;
            }
            delete2 = false;
            if (!delete) {
                return false;
            }
        }
        delete = false;
        if (str.length() > 0) {
            new File(str).delete();
        }
        str = d + ".info";
        if (str.length() > 0) {
            delete2 = new File(str).delete();
            if (!delete) {
                return false;
            }
        }
        delete2 = false;
        if (!delete) {
            return false;
        }
    }

    public synchronized void b() {
        Message message = new Message();
        this.g.putInt(LocationManagerProxy.KEY_STATUS_CHANGED, 3);
        message.setData(this.g);
        this.f.sendMessage(message);
    }

    public void b(int i) {
        if (this.e != null) {
            this.e.b();
            this.e.interrupt();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.amap.api.maps.offlinemap.l r11) {
        /*
        r10 = this;
        r9 = -1;
        r8 = 4;
        r2 = 0;
        r7 = 100;
        r0 = 0;
        r1 = 100;
        r10.a(r11, r0, r1);	 Catch:{ Throwable -> 0x00fe }
        r0 = r10.k;	 Catch:{ Throwable -> 0x00fe }
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = r10.k;	 Catch:{ Throwable -> 0x00fe }
        r1 = 1;
        r0.setLoadOfflineData(r1);	 Catch:{ Throwable -> 0x00fe }
    L_0x0015:
        r0 = r11.e();	 Catch:{ Throwable -> 0x00fe }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fe }
        r1.<init>();	 Catch:{ Throwable -> 0x00fe }
        r3 = a();	 Catch:{ Throwable -> 0x00fe }
        r1 = r1.append(r3);	 Catch:{ Throwable -> 0x00fe }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00fe }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00fe }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fe }
        r1.<init>();	 Catch:{ Throwable -> 0x00fe }
        r1 = r1.append(r0);	 Catch:{ Throwable -> 0x00fe }
        r3 = ".zip";
        r1 = r1.append(r3);	 Catch:{ Throwable -> 0x00fe }
        r3 = r1.toString();	 Catch:{ Throwable -> 0x00fe }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fe }
        r1.<init>();	 Catch:{ Throwable -> 0x00fe }
        r1 = r1.append(r3);	 Catch:{ Throwable -> 0x00fe }
        r4 = ".tmp";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00fe }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00fe }
        r4 = 1;
        r11.a = r4;	 Catch:{ Throwable -> 0x00fe }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x00fe }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x00fe }
        r5 = r4.exists();	 Catch:{ Throwable -> 0x00fe }
        if (r5 != 0) goto L_0x006a;
    L_0x0062:
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x00fe }
        r5.<init>(r1);	 Catch:{ Throwable -> 0x00fe }
        r5.renameTo(r4);	 Catch:{ Throwable -> 0x00fe }
    L_0x006a:
        r1 = r4.exists();	 Catch:{ Throwable -> 0x00fe }
        if (r1 == 0) goto L_0x0128;
    L_0x0070:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fe }
        r1.<init>();	 Catch:{ Throwable -> 0x00fe }
        r1 = r1.append(r0);	 Catch:{ Throwable -> 0x00fe }
        r4 = "/";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00fe }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00fe }
        r1 = com.amap.api.maps.offlinemap.n.a(r1, r3, r11, r10);	 Catch:{ Throwable -> 0x00fe }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r4.<init>();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = a();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = "vmap/";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r11.f(r4);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5.<init>();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r0 = r5.append(r0);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = "/";
        r0 = r0.append(r5);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r4.<init>(r0);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5.<init>();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r6 = h;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r6 = "vmap/";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r0.<init>(r5);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        com.amap.api.maps.offlinemap.m.a(r4, r0);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        if (r1 == 0) goto L_0x00e3;
    L_0x00d8:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        r0.delete();	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
        com.amap.api.maps.offlinemap.m.a(r4);	 Catch:{ Throwable -> 0x0126, all -> 0x0120 }
    L_0x00e3:
        r0 = r10.k;	 Catch:{ Throwable -> 0x0126 }
        if (r0 == 0) goto L_0x00ed;
    L_0x00e7:
        r0 = r10.k;	 Catch:{ Throwable -> 0x0126 }
        r3 = 0;
        r0.setLoadOfflineData(r3);	 Catch:{ Throwable -> 0x0126 }
    L_0x00ed:
        if (r1 == 0) goto L_0x00fa;
    L_0x00ef:
        r11.a = r8;
        r10.a(r11, r8, r7);
        r0 = r10.b;
        r0.remove(r11);
    L_0x00f9:
        return;
    L_0x00fa:
        r10.a(r11, r9, r7);
        goto L_0x00f9;
    L_0x00fe:
        r0 = move-exception;
        r1 = r2;
    L_0x0100:
        r3 = "MapDownloadManager";
        r4 = "unZip";
        com.amap.api.mapcore.util.az.a(r0, r3, r4);	 Catch:{ all -> 0x0123 }
        r0.printStackTrace();	 Catch:{ all -> 0x010e }
        r10.a(r11, r9, r7);
        goto L_0x00f9;
    L_0x010e:
        r0 = move-exception;
    L_0x010f:
        if (r2 == 0) goto L_0x011c;
    L_0x0111:
        r11.a = r8;
        r10.a(r11, r8, r7);
        r1 = r10.b;
        r1.remove(r11);
    L_0x011b:
        throw r0;
    L_0x011c:
        r10.a(r11, r9, r7);
        goto L_0x011b;
    L_0x0120:
        r0 = move-exception;
        r2 = r1;
        goto L_0x010f;
    L_0x0123:
        r0 = move-exception;
        r2 = r1;
        goto L_0x010f;
    L_0x0126:
        r0 = move-exception;
        goto L_0x0100;
    L_0x0128:
        r1 = r2;
        goto L_0x00e3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.d.b(com.amap.api.maps.offlinemap.l):void");
    }

    public void c() {
        if (this.e != null) {
            this.e.b();
            this.e.interrupt();
            this.b.clear();
            if (this.e != null) {
                this.e.b();
            }
        }
    }

    public void d() {
        if (!a().equals(com.xiaomi.e.a.f)) {
            this.c.clear();
            File file = new File(a() + "offlinemap3.png");
            if (file.exists()) {
                a(file);
            } else {
                f();
            }
        }
    }

    protected void e() {
        this.d.clear();
        this.c.clear();
        this.a.clear();
        this.b.clear();
    }
}
