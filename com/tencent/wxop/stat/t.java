package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.push.i;
import com.amap.api.location.LocationManagerProxy;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class t {
    private static b bZ = l.av();
    private static Context ca = null;
    private static t cb = null;
    volatile int aI = 0;
    private String ab = a.f;
    private ac bW = null;
    private ac bX = null;
    c bY = null;
    private f be = null;
    private String bq = a.f;
    private int cc = 0;
    private ConcurrentHashMap<d, String> cd = null;
    private boolean ce = false;
    private HashMap<String, String> cf = new HashMap();

    private t(Context context) {
        try {
            this.be = new f();
            ca = context.getApplicationContext();
            this.cd = new ConcurrentHashMap();
            this.ab = l.J(context);
            this.bq = "pri_" + l.J(context);
            this.bW = new ac(ca, this.ab);
            this.bX = new ac(ca, this.bq);
            b(true);
            b(false);
            aj();
            t(ca);
            I();
            an();
        } catch (Throwable th) {
            bZ.b(th);
        }
    }

    private void I() {
        Throwable th;
        Cursor query;
        try {
            query = this.bW.getReadableDatabase().query(i.e, null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    ah ahVar = new ah(i);
                    ahVar.aI = i;
                    ahVar.df = new JSONObject(string);
                    ahVar.c = string2;
                    ahVar.L = i2;
                    c.a(ca, ahVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private synchronized void a(int i, boolean z) {
        try {
            if (this.aI > 0 && i > 0 && !e.a()) {
                if (c.k()) {
                    bZ.b("Load " + this.aI + " unsent events");
                }
                List arrayList = new ArrayList(i);
                b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (c.k()) {
                        bZ.b("Peek " + arrayList.size() + " unsent events.");
                    }
                    a(arrayList, 2, z);
                    ak.Z(ca).b(arrayList, new aa(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            bZ.b(th);
        }
    }

    private synchronized void a(com.tencent.wxop.stat.a.d r7, com.tencent.wxop.stat.aj r8, boolean r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.t.a(com.tencent.wxop.stat.a.d, com.tencent.wxop.stat.aj, boolean, boolean):void. bs: [B:20:0x0092, B:51:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = com.tencent.wxop.stat.c.s();	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x0008:
        r0 = com.tencent.wxop.stat.c.ay;	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x0010;
    L_0x000c:
        if (r9 != 0) goto L_0x0010;
    L_0x000e:
        if (r10 == 0) goto L_0x0110;
    L_0x0010:
        r1 = r6.c(r9);	 Catch:{ Throwable -> 0x00cf }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00cf }
        if (r9 != 0) goto L_0x003c;	 Catch:{ Throwable -> 0x00cf }
    L_0x0019:
        r0 = r6.aI;	 Catch:{ Throwable -> 0x00cf }
        r2 = com.tencent.wxop.stat.c.s();	 Catch:{ Throwable -> 0x00cf }
        if (r0 <= r2) goto L_0x003c;	 Catch:{ Throwable -> 0x00cf }
    L_0x0021:
        r0 = bZ;	 Catch:{ Throwable -> 0x00cf }
        r2 = "Too many events stored in db.";	 Catch:{ Throwable -> 0x00cf }
        r0.warn(r2);	 Catch:{ Throwable -> 0x00cf }
        r0 = r6.aI;	 Catch:{ Throwable -> 0x00cf }
        r2 = r6.bW;	 Catch:{ Throwable -> 0x00cf }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x00cf }
        r3 = "events";	 Catch:{ Throwable -> 0x00cf }
        r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)";	 Catch:{ Throwable -> 0x00cf }
        r5 = 0;	 Catch:{ Throwable -> 0x00cf }
        r2 = r2.delete(r3, r4, r5);	 Catch:{ Throwable -> 0x00cf }
        r0 = r0 - r2;	 Catch:{ Throwable -> 0x00cf }
        r6.aI = r0;	 Catch:{ Throwable -> 0x00cf }
    L_0x003c:
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00cf }
        r0.<init>();	 Catch:{ Throwable -> 0x00cf }
        r2 = r7.af();	 Catch:{ Throwable -> 0x00cf }
        r3 = com.tencent.wxop.stat.c.k();	 Catch:{ Throwable -> 0x00cf }
        if (r3 == 0) goto L_0x005f;	 Catch:{ Throwable -> 0x00cf }
    L_0x004b:
        r3 = bZ;	 Catch:{ Throwable -> 0x00cf }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cf }
        r5 = "insert 1 event, content:";	 Catch:{ Throwable -> 0x00cf }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00cf }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x00cf }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00cf }
        r3.b(r4);	 Catch:{ Throwable -> 0x00cf }
    L_0x005f:
        r2 = com.tencent.wxop.stat.b.r.q(r2);	 Catch:{ Throwable -> 0x00cf }
        r3 = "content";	 Catch:{ Throwable -> 0x00cf }
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x00cf }
        r2 = "send_count";	 Catch:{ Throwable -> 0x00cf }
        r3 = "0";	 Catch:{ Throwable -> 0x00cf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00cf }
        r2 = "status";	 Catch:{ Throwable -> 0x00cf }
        r3 = 1;	 Catch:{ Throwable -> 0x00cf }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x00cf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00cf }
        r2 = "timestamp";	 Catch:{ Throwable -> 0x00cf }
        r4 = r7.ad();	 Catch:{ Throwable -> 0x00cf }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00cf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00cf }
        r2 = "events";	 Catch:{ Throwable -> 0x00cf }
        r3 = 0;	 Catch:{ Throwable -> 0x00cf }
        r2 = r1.insert(r2, r3, r0);	 Catch:{ Throwable -> 0x00cf }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00cf }
        if (r1 == 0) goto L_0x018a;
    L_0x0092:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c7 }
        r0 = r2;
    L_0x0096:
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00f7;
    L_0x009c:
        r0 = r6.aI;	 Catch:{ all -> 0x00ed }
        r0 = r0 + 1;	 Catch:{ all -> 0x00ed }
        r6.aI = r0;	 Catch:{ all -> 0x00ed }
        r0 = com.tencent.wxop.stat.c.k();	 Catch:{ all -> 0x00ed }
        if (r0 == 0) goto L_0x00c0;	 Catch:{ all -> 0x00ed }
    L_0x00a8:
        r0 = bZ;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "directStoreEvent insert event to db, event:";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r7.af();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.e(r1);	 Catch:{ all -> 0x00ed }
    L_0x00c0:
        if (r8 == 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x00c2:
        r8.ah();	 Catch:{ all -> 0x00ed }
    L_0x00c5:
        monitor-exit(r6);
        return;
    L_0x00c7:
        r0 = move-exception;
        r1 = bZ;	 Catch:{ all -> 0x00ed }
        r1.b(r0);	 Catch:{ all -> 0x00ed }
        r0 = r2;
        goto L_0x0096;
    L_0x00cf:
        r0 = move-exception;
        r2 = -1;
        r4 = bZ;	 Catch:{ all -> 0x00e6 }
        r4.b(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x018a;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        r0 = r2;
        goto L_0x0096;
    L_0x00de:
        r0 = move-exception;
        r1 = bZ;	 Catch:{ all -> 0x00ed }
        r1.b(r0);	 Catch:{ all -> 0x00ed }
        r0 = r2;
        goto L_0x0096;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00f0 }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ed }
    L_0x00ed:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x00f0:
        r1 = move-exception;
        r2 = bZ;	 Catch:{ all -> 0x00ed }
        r2.b(r1);	 Catch:{ all -> 0x00ed }
        goto L_0x00ec;	 Catch:{ all -> 0x00ed }
    L_0x00f7:
        r0 = bZ;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "Failed to store event:";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r7.af();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.error(r1);	 Catch:{ all -> 0x00ed }
        goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x0110:
        r0 = com.tencent.wxop.stat.c.ay;	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x0114:
        r0 = com.tencent.wxop.stat.c.k();	 Catch:{ all -> 0x00ed }
        if (r0 == 0) goto L_0x0164;	 Catch:{ all -> 0x00ed }
    L_0x011a:
        r0 = bZ;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "cacheEventsInMemory.size():";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r6.cd;	 Catch:{ all -> 0x00ed }
        r2 = r2.size();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = com.tencent.wxop.stat.c.ay;	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = ",numStoredEvents:";	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r2 = r6.aI;	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.b(r1);	 Catch:{ all -> 0x00ed }
        r0 = bZ;	 Catch:{ all -> 0x00ed }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ed }
        r2 = "cache event:";	 Catch:{ all -> 0x00ed }
        r1.<init>(r2);	 Catch:{ all -> 0x00ed }
        r2 = r7.af();	 Catch:{ all -> 0x00ed }
        r1 = r1.append(r2);	 Catch:{ all -> 0x00ed }
        r1 = r1.toString();	 Catch:{ all -> 0x00ed }
        r0.b(r1);	 Catch:{ all -> 0x00ed }
    L_0x0164:
        r0 = r6.cd;	 Catch:{ all -> 0x00ed }
        r1 = "";	 Catch:{ all -> 0x00ed }
        r0.put(r7, r1);	 Catch:{ all -> 0x00ed }
        r0 = r6.cd;	 Catch:{ all -> 0x00ed }
        r0 = r0.size();	 Catch:{ all -> 0x00ed }
        r1 = com.tencent.wxop.stat.c.ay;	 Catch:{ all -> 0x00ed }
        if (r0 < r1) goto L_0x0178;	 Catch:{ all -> 0x00ed }
    L_0x0175:
        r6.am();	 Catch:{ all -> 0x00ed }
    L_0x0178:
        if (r8 == 0) goto L_0x00c5;	 Catch:{ all -> 0x00ed }
    L_0x017a:
        r0 = r6.cd;	 Catch:{ all -> 0x00ed }
        r0 = r0.size();	 Catch:{ all -> 0x00ed }
        if (r0 <= 0) goto L_0x0185;	 Catch:{ all -> 0x00ed }
    L_0x0182:
        r6.am();	 Catch:{ all -> 0x00ed }
    L_0x0185:
        r8.ah();	 Catch:{ all -> 0x00ed }
        goto L_0x00c5;
    L_0x018a:
        r0 = r2;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(com.tencent.wxop.stat.a.d, com.tencent.wxop.stat.aj, boolean, boolean):void");
    }

    private synchronized void a(ah ahVar) {
        Cursor query;
        Throwable th;
        try {
            Object obj;
            long update;
            String jSONObject = ahVar.df.toString();
            String t = l.t(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ParamKey.CONTENT, ahVar.df.toString());
            contentValues.put("md5sum", t);
            ahVar.c = t;
            contentValues.put(o.x, Integer.valueOf(ahVar.L));
            query = this.bW.getReadableDatabase().query(i.e, null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != ahVar.aI);
            obj = 1;
            this.bW.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.bW.getWritableDatabase().update(i.e, contentValues, "type=?", new String[]{Integer.toString(ahVar.aI)});
            } else {
                contentValues.put(SocialConstants.PARAM_TYPE, Integer.valueOf(ahVar.aI));
                update = this.bW.getWritableDatabase().insert(i.e, null, contentValues);
            }
            if (update == -1) {
                bZ.d("Failed to store cfg:" + jSONObject);
            } else {
                bZ.e("Sucessed to store cfg:" + jSONObject);
            }
            this.bW.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.bW.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.bW.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    static /* synthetic */ void a(t tVar, int i, boolean z) {
        int ak = i == -1 ? !z ? tVar.ak() : tVar.al() : i;
        if (ak > 0) {
            int u = (c.u() * 60) * c.q();
            if (ak > u && u > 0) {
                ak = u;
            }
            int r = c.r();
            int i2 = ak / r;
            int i3 = ak % r;
            if (c.k()) {
                bZ.b("sentStoreEventsByDb sendNumbers=" + ak + ",important=" + z + ",maxSendNumPerFor1Period=" + u + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (ak = 0; ak < i2; ak++) {
                tVar.a(r, z);
            }
            if (i3 > 0) {
                tVar.a(i3, z);
            }
        }
    }

    private synchronized void a(List<ad> list, int i, boolean z) {
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int p = !z ? c.p() : c.n();
                SQLiteDatabase c;
                try {
                    String str2;
                    c = c(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + b((List) list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                bZ.b(th);
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th3) {
                                        bZ.b(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th5) {
                                        bZ.b(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    String str3 = "update events set status=" + i + " where " + b((List) list);
                    if (this.cc % 3 == 0) {
                        str = "delete from events where send_count>" + p;
                    }
                    this.cc++;
                    str2 = str3;
                    if (c.k()) {
                        bZ.b("update sql:" + str2);
                    }
                    c.beginTransaction();
                    c.execSQL(str2);
                    if (str != null) {
                        bZ.b("update for delete sql:" + str);
                        c.execSQL(str);
                        aj();
                    }
                    c.setTransactionSuccessful();
                    if (c != null) {
                        try {
                            c.endTransaction();
                        } catch (Throwable th32) {
                            bZ.b(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    c = null;
                    if (c != null) {
                        c.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    private synchronized void a(java.util.List<com.tencent.wxop.stat.ad> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.t.a(java.util.List, boolean):void. bs: [B:26:0x00c1, B:49:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.c.k();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = bZ;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.b(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.tencent.wxop.stat.ad) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.K;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.c(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.tencent.wxop.stat.c.k();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = bZ;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.b(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.aI;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.aI = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.aj();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = bZ;	 Catch:{ all -> 0x00ce }
        r1.b(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = bZ;	 Catch:{ all -> 0x00e6 }
        r2.b(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = bZ;	 Catch:{ all -> 0x00ce }
        r1.b(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = bZ;	 Catch:{ all -> 0x00ce }
        r2.b(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(java.util.List, boolean):void");
    }

    public static t ai() {
        return cb;
    }

    private void aj() {
        this.aI = ak() + al();
    }

    private int ak() {
        return (int) DatabaseUtils.queryNumEntries(this.bW.getReadableDatabase(), "events");
    }

    private int al() {
        return (int) DatabaseUtils.queryNumEntries(this.bX.getReadableDatabase(), "events");
    }

    private void am() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.t.am():void. bs: [B:42:0x011b, B:53:0x0133]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.ce;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.cd;
        monitor-enter(r2);
        r0 = r9.cd;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0013:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.ce = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.c.k();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = bZ;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.cd;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.c.ay;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.aI;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.b(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.bW;	 Catch:{ Throwable -> 0x00ca }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ca }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r9.cd;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00ca }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00ca }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00ca }
        if (r0 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x00ca }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00ca }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00ca }
        r0 = (com.tencent.wxop.stat.a.d) r0;	 Catch:{ Throwable -> 0x00ca }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ca }
        r4.<init>();	 Catch:{ Throwable -> 0x00ca }
        r5 = r0.af();	 Catch:{ Throwable -> 0x00ca }
        r6 = com.tencent.wxop.stat.c.k();	 Catch:{ Throwable -> 0x00ca }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00ca }
    L_0x0085:
        r6 = bZ;	 Catch:{ Throwable -> 0x00ca }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ca }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00ca }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ca }
        r6.b(r7);	 Catch:{ Throwable -> 0x00ca }
    L_0x0099:
        r5 = com.tencent.wxop.stat.b.r.q(r5);	 Catch:{ Throwable -> 0x00ca }
        r6 = "content";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00ca }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00ca }
        r6 = "0";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "status";	 Catch:{ Throwable -> 0x00ca }
        r6 = 1;	 Catch:{ Throwable -> 0x00ca }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00ca }
        r6 = r0.ad();	 Catch:{ Throwable -> 0x00ca }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00ca }
        r0 = "events";	 Catch:{ Throwable -> 0x00ca }
        r5 = 0;	 Catch:{ Throwable -> 0x00ca }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00ca }
        r3.remove();	 Catch:{ Throwable -> 0x00ca }
        goto L_0x0064;
    L_0x00ca:
        r0 = move-exception;
        r3 = bZ;	 Catch:{ all -> 0x0130 }
        r3.b(r0);	 Catch:{ all -> 0x0130 }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0129 }
        r9.aj();	 Catch:{ Throwable -> 0x0129 }
    L_0x00d8:
        r0 = 0;
        r9.ce = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.c.k();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ all -> 0x0013 }
    L_0x00e1:
        r0 = bZ;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.cd;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.c.ay;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.aI;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.b(r1);	 Catch:{ all -> 0x0013 }
    L_0x0113:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0116:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ca }
        if (r1 == 0) goto L_0x00d8;
    L_0x011b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0122 }
        r9.aj();	 Catch:{ Throwable -> 0x0122 }
        goto L_0x00d8;
    L_0x0122:
        r0 = move-exception;
        r1 = bZ;	 Catch:{ all -> 0x0013 }
        r1.b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;	 Catch:{ all -> 0x0013 }
    L_0x0129:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = bZ;	 Catch:{ all -> 0x0013 }
        r1.b(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;
    L_0x0130:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0139;
    L_0x0133:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013a }
        r9.aj();	 Catch:{ Throwable -> 0x013a }
    L_0x0139:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013a:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = bZ;	 Catch:{ all -> 0x0013 }
        r3.b(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.am():void");
    }

    private void an() {
        Throwable th;
        Cursor query;
        try {
            query = this.bW.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.cf.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static String b(List<ad> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (ad adVar : list) {
            stringBuilder.append(adVar.K);
            if (i != size - 1) {
                stringBuilder.append(com.xiaomi.mipush.sdk.f.i);
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void b(List<ad> list, int i, boolean z) {
        SQLiteDatabase readableDatabase;
        Throwable th;
        Cursor cursor;
        if (z) {
            readableDatabase = this.bX.getReadableDatabase();
        } else {
            try {
                readableDatabase = this.bW.getReadableDatabase();
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        cursor = readableDatabase.query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
        while (cursor.moveToNext()) {
            try {
                long j = cursor.getLong(0);
                String string = cursor.getString(1);
                if (!c.ad) {
                    string = r.t(string);
                }
                int i2 = cursor.getInt(2);
                int i3 = cursor.getInt(3);
                ad adVar = new ad(j, string, i2, i3);
                if (c.k()) {
                    bZ.b("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + cursor.getLong(4));
                }
                list.add(adVar);
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    private void b(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(LocationManagerProxy.KEY_STATUS_CHANGED, Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (c.k()) {
                bZ.b("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    bZ.b(th);
                }
            }
        } catch (Throwable th2) {
            bZ.b(th2);
        }
    }

    private SQLiteDatabase c(boolean z) {
        return !z ? this.bW.getWritableDatabase() : this.bX.getWritableDatabase();
    }

    public static t s(Context context) {
        if (cb == null) {
            synchronized (t.class) {
                if (cb == null) {
                    cb = new t(context);
                }
            }
        }
        return cb;
    }

    final void H() {
        if (c.l()) {
            try {
                this.be.a(new w(this));
            } catch (Throwable th) {
                bZ.b(th);
            }
        }
    }

    final void b(int i) {
        this.be.a(new ab(this, i));
    }

    final void b(d dVar, aj ajVar, boolean z, boolean z2) {
        if (this.be != null) {
            this.be.a(new x(this, dVar, ajVar, z, z2));
        }
    }

    final void b(ah ahVar) {
        if (ahVar != null) {
            this.be.a(new y(this, ahVar));
        }
    }

    final void b(List<ad> list, boolean z) {
        if (this.be != null) {
            this.be.a(new u(this, list, z));
        }
    }

    final void c(List<ad> list, boolean z) {
        if (this.be != null) {
            this.be.a(new v(this, list, z));
        }
    }

    public final int r() {
        return this.aI;
    }

    public final synchronized c t(Context context) {
        c cVar;
        Cursor query;
        Throwable th;
        Cursor cursor;
        if (this.bY != null) {
            cVar = this.bY;
        } else {
            try {
                this.bW.getWritableDatabase().beginTransaction();
                if (c.k()) {
                    bZ.b((Object) "try to load user info from db.");
                }
                query = this.bW.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String c;
                    if (query.moveToNext()) {
                        String t = r.t(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || l.d(query.getLong(3) * 1000).equals(l.d(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(l.G(context)) ? i2 | 2 : i2;
                        String[] split = t.split(com.xiaomi.mipush.sdk.f.i);
                        obj = null;
                        if (split == null || split.length <= 0) {
                            c = l.c(context);
                            obj = 1;
                            t = c;
                        } else {
                            c = split[0];
                            if (c == null || c.length() < 11) {
                                string = r.b(context);
                                if (string == null || string.length() <= 10) {
                                    string = c;
                                } else {
                                    obj = 1;
                                }
                                c = t;
                                t = string;
                            } else {
                                String str = c;
                                c = t;
                                t = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = l.w(context);
                            if (string != null && string.length() > 0) {
                                c = t + com.xiaomi.mipush.sdk.f.i + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            c = t + com.xiaomi.mipush.sdk.f.i + string;
                        }
                        this.bY = new c(t, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(kankan.wheel.widget.a.n, r.q(c));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", l.G(context));
                        contentValues.put(ay.H, Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.bW.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.bW.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = l.c(context);
                        c = l.w(context);
                        String str2 = (c == null || c.length() <= 0) ? string : string + com.xiaomi.mipush.sdk.f.i + c;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String G = l.G(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(kankan.wheel.widget.a.n, r.q(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", G);
                        contentValues2.put(ay.H, Long.valueOf(currentTimeMillis2));
                        this.bW.getWritableDatabase().insert("user", null, contentValues2);
                        this.bY = new c(string, c, 0);
                    }
                    this.bW.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            bZ.b(th2);
                        }
                    }
                    this.bW.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.bW.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.bW.getWritableDatabase().endTransaction();
                throw th2;
            }
            cVar = this.bY;
        }
        return cVar;
    }
}
