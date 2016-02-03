package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.model.k;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.List;

class l {
    private static final String a = "SDB";

    private l() {
    }

    public static ContentProviderOperation a(Context context, h hVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (hVar == null) {
            return null;
        } else {
            c k = hVar.k();
            if (k == null || k.e() || TextUtils.isEmpty(hVar.e())) {
                C0596r.d(a, "getDateDataOperation identity or date is empty:" + k);
                return null;
            }
            Builder newInsert;
            if (hVar.A()) {
                newInsert = ContentProviderOperation.newInsert(u.e);
            } else {
                String[] strArr = new String[]{hVar.e(), String.valueOf(d.a), String.valueOf(0), k.b(), k.d(), k.b()};
                newInsert = ContentProviderOperation.newUpdate(u.d).withSelection("date=? AND type=? AND source=? AND (mac=? AND sn=? OR mac=? AND sn='')", strArr);
            }
            newInsert.withValues(a(hVar));
            return newInsert.build();
        }
    }

    private static ContentValues a(h hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.h, Integer.valueOf(d.a));
        contentValues.put(o.L, Integer.valueOf(0));
        contentValues.put(g.q, hVar.l());
        if (!TextUtils.isEmpty(hVar.s())) {
            contentValues.put(g.p, hVar.s());
        }
        if (!TextUtils.isEmpty(hVar.f())) {
            contentValues.put(g.t, hVar.f());
        }
        contentValues.put(b.e, hVar.r());
        contentValues.put(g.a, hVar.e());
        contentValues.put(SocialConstants.PARAM_SUMMARY, hVar.a());
        byte[] m = hVar.m();
        if (m != null) {
            contentValues.put(b.b, m);
        }
        contentValues.put(h.k, Integer.valueOf(hVar.x()));
        return contentValues;
    }

    public static h a(Context context, String str, c cVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        List a = a(context, cVar, str, str, k.STATE_UNSYNCED, true);
        return (a == null || a.size() == 0) ? null : (h) a.get(0);
    }

    public static h a(Context context, String str, c cVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        List a = a(context, cVar, str, str, k.SYNC_STATE_DEFAULT, z);
        return (a == null || a.size() == 0) ? null : (h) a.get(0);
    }

    public static List<h> a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        return a(context, null, null, null, k.SYNC_STATE_DEFAULT, true);
    }

    public static List<h> a(Context context, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        return a(context, cVar, null, null, k.STATE_UNSYNCED, true);
    }

    private static java.util.List<cn.com.smartdevices.bracelet.shoes.model.h> a(android.content.Context r15, cn.com.smartdevices.bracelet.shoes.model.c r16, java.lang.String r17, java.lang.String r18, cn.com.smartdevices.bracelet.shoes.model.k r19, boolean r20) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002f in list [B:10:0x002c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = cn.com.smartdevices.bracelet.shoes.data.db.s.a(r15);
        r2 = 0;
        r3 = r1.a(r2);
        r2 = 0;
        r1 = b(r15, r16, r17, r18, r19, r20);
        r3.beginTransaction();	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = r1.b;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = r1.a;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r2 = r3.rawQuery(r4, r1);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        if (r2 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x001b:
        r1 = r2.getCount();	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        if (r1 != 0) goto L_0x0030;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x0021:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = 0;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r3.endTransaction();	 Catch:{ Exception -> 0x0100 }
    L_0x002a:
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        r2.close();
    L_0x002f:
        return r1;
    L_0x0030:
        r1 = "";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = "";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = "";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = "";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = "";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = "";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = r2.getCount();	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x0045:
        r4 = r2.moveToNext();	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        if (r4 == 0) goto L_0x00e9;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x004b:
        r4 = "mac";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        if (r5 != 0) goto L_0x0045;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x005b:
        r5 = "_id";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r5 = r2.getColumnIndex(r5);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r5 = r2.getInt(r5);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r6 = "summary";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r6 = r2.getColumnIndex(r6);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r6 = r2.getString(r6);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r7 = "synced";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r7 = r2.getColumnIndex(r7);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r7 = r2.getInt(r7);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r8 = "date";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r8 = r2.getColumnIndex(r8);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r8 = r2.getString(r8);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r9 = "type";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r9 = r2.getInt(r9);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r10 = "sn";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r10 = r2.getColumnIndex(r10);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r10 = r2.getString(r10);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r11 = "deviceid";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r11 = r2.getColumnIndex(r11);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r11 = r2.getString(r11);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r12 = "shoesid";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r12 = r2.getColumnIndex(r12);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r13 = new cn.com.smartdevices.bracelet.shoes.model.h;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r14 = new cn.com.smartdevices.bracelet.shoes.model.c;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r14.<init>(r4, r10, r11, r12);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r0 = r20;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r13.<init>(r14, r8, r9, r0);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r13.f(r5);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r13.l(r7);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r13.a(r6);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        if (r20 == 0) goto L_0x00cf;	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x00c2:
        r4 = "data";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r4 = r2.getBlob(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r13.a(r4);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
    L_0x00cf:
        r1.add(r13);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        goto L_0x0045;
    L_0x00d4:
        r1 = move-exception;
        r4 = "SDB";	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        cn.com.smartdevices.bracelet.C0596r.d(r4, r1);	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r3.endTransaction();
    L_0x00e1:
        if (r2 == 0) goto L_0x00e6;
    L_0x00e3:
        r2.close();
    L_0x00e6:
        r1 = 0;
        goto L_0x002f;
    L_0x00e9:
        r3.setTransactionSuccessful();	 Catch:{ Exception -> 0x00d4, all -> 0x00f6 }
        r3.endTransaction();	 Catch:{ Exception -> 0x0103 }
    L_0x00ef:
        if (r2 == 0) goto L_0x002f;
    L_0x00f1:
        r2.close();
        goto L_0x002f;
    L_0x00f6:
        r1 = move-exception;
        r3.endTransaction();	 Catch:{ Exception -> 0x0107 }
    L_0x00fa:
        if (r2 == 0) goto L_0x00ff;
    L_0x00fc:
        r2.close();
    L_0x00ff:
        throw r1;
    L_0x0100:
        r3 = move-exception;
        goto L_0x002a;
    L_0x0103:
        r3 = move-exception;
        goto L_0x00ef;
    L_0x0105:
        r1 = move-exception;
        goto L_0x00e1;
    L_0x0107:
        r3 = move-exception;
        goto L_0x00fa;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.shoes.data.db.l.a(android.content.Context, cn.com.smartdevices.bracelet.shoes.model.c, java.lang.String, java.lang.String, cn.com.smartdevices.bracelet.shoes.model.k, boolean):java.util.List<cn.com.smartdevices.bracelet.shoes.model.h>");
    }

    public static List<String> a(Context context, c cVar, String str, String str2, boolean z) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null || cVar == null || cVar.e() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        Cursor rawQuery;
        try {
            List<String> arrayList;
            rawQuery = s.a(context).a(false).rawQuery("SELECT date FROM shoesdata WHERE " + "mac =? AND sn=? OR mac =? AND sn=''" + " AND " + g.a + " >=? AND " + g.a + " <=? AND " + b.b + (z ? " NOT NULL " : " IS NULL ") + " ORDER BY " + g.a + " DESC ", new String[]{cVar.b(), cVar.d(), cVar.b(), str, str2});
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() != 0) {
                        String str3 = com.xiaomi.e.a.f;
                        arrayList = new ArrayList(rawQuery.getCount());
                        while (rawQuery.moveToNext()) {
                            CharSequence string = rawQuery.getString(rawQuery.getColumnIndex(g.a));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                        if (rawQuery == null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.d(a, e.getMessage());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            arrayList = new ArrayList(0);
            if (rawQuery == null) {
                return arrayList;
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            C0596r.d(a, e.getMessage());
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static boolean a(Context context, SQLiteDatabase sQLiteDatabase, h hVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (hVar == null) {
            return true;
        } else {
            c k = hVar.k();
            if (k == null || k.e() || TextUtils.isEmpty(hVar.e())) {
                C0596r.d(a, "mac or date is null:" + k);
                return false;
            }
            String str = "date=? AND type=? AND source=? AND (mac=? AND sn=? OR mac=? AND sn='')";
            String[] strArr = new String[]{hVar.e(), String.valueOf(d.a), String.valueOf(0), k.b(), k.d(), k.b()};
            try {
                ContentValues a = a(hVar);
                boolean z = sQLiteDatabase.update(g.a, a, str, strArr) > 0;
                return !z ? sQLiteDatabase.insert(g.a, null, a) > 0 : z;
            } catch (Exception e) {
                C0596r.d(a, e.getMessage());
                return false;
            }
        }
    }

    public static boolean a(Context context, c cVar, String str) {
        if (context != null && cVar != null && !cVar.e()) {
            return a(context, cVar, str, k.STATE_SYNCED_TO_SERVER);
        }
        throw new IllegalArgumentException();
    }

    private static boolean a(Context context, c cVar, String str, k kVar) {
        if (context == null || cVar == null || cVar.e() || kVar == null) {
            throw new IllegalArgumentException();
        }
        try {
            String[] strArr;
            String str2 = "(mac=? AND sn=? OR mac=? AND sn='')";
            if (TextUtils.isEmpty(str)) {
                strArr = new String[]{cVar.b(), cVar.d(), cVar.b()};
            } else {
                str2 = str2 + " AND date=?";
                strArr = new String[]{cVar.b(), cVar.d(), cVar.b(), str};
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(h.k, Integer.valueOf(kVar.a()));
            return s.a(context).a(true).update(g.a, contentValues, str2, strArr) > 0;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    public static ContentProviderResult[] a(Context context, List<h> list) {
        if (context != null && list != null) {
            return list.size() == 0 ? new ContentProviderResult[0] : cn.com.smartdevices.bracelet.shoes.c.b.a() ? b(context, (List) list) : c(context, (List) list);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String[] a(Context context, c cVar, String str, String str2) {
        if (TextUtils.isEmpty(str2) || cVar == null || cVar.e() || context == null) {
            throw new IllegalArgumentException();
        }
        List<h> a = a(context, cVar, str, str2, k.SYNC_STATE_DEFAULT, false);
        if (a == null || a.size() == 0) {
            return null;
        }
        CharSequence charSequence = com.xiaomi.e.a.f;
        int i = 0;
        for (h hVar : a) {
            String e;
            i += hVar.g();
            if (TextUtils.isEmpty(charSequence)) {
                e = hVar.e();
            } else {
                CharSequence charSequence2 = charSequence;
            }
            Object obj = e;
        }
        return new String[]{String.valueOf(i), charSequence};
    }

    private static m b(Context context, c cVar, String str, String str2, k kVar, boolean z) {
        Object obj;
        Object key;
        if (TextUtils.isEmpty(str)) {
            obj = com.xiaomi.e.a.f;
        }
        if (TextUtils.isEmpty(str2)) {
            key = new SportDay().getKey();
        }
        String str3 = com.xiaomi.e.a.f;
        String str4 = com.xiaomi.e.a.f;
        List arrayList = new ArrayList(8);
        arrayList.add(obj);
        arrayList.add(key);
        arrayList.add(String.valueOf(d.a));
        arrayList.add(String.valueOf(0));
        if (!k.SYNC_STATE_DEFAULT.equals(kVar)) {
            str3 = " AND synced =? ";
            arrayList.add(String.valueOf(kVar.a()));
        }
        String str5 = str3;
        if (cVar != null) {
            str4 = " AND (mac=? AND sn=? OR mac=? AND sn='')";
            arrayList.add(cVar.b());
            arrayList.add(cVar.d());
            arrayList.add(cVar.b());
        }
        str3 = "*";
        if (!z) {
            str3 = "_id,date,mac,sn,deviceid,shoesid,summary,type,source,synced";
        }
        return new m("SELECT " + str3 + " FROM " + g.a + " WHERE " + g.a + " >=? AND " + g.a + " <=? AND " + a.h + " =? AND " + o.L + " =? " + str5 + str4 + " ORDER BY " + g.a + " DESC ", (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    private static void b(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(Unknown Source)
	at java.util.HashMap$KeyIterator.next(Unknown Source)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return;
    L_0x0004:
        r0 = cn.com.smartdevices.bracelet.shoes.data.db.s.a(r7);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = 0;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.a(r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = "SELECT date,mac,summary FROM shoesdata";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r3 = 0;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r1 = r0.rawQuery(r2, r3);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        if (r1 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
    L_0x0016:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        if (r0 != 0) goto L_0x0029;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
    L_0x001c:
        r0 = "SDB";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = "printDataForSample none data";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        cn.com.smartdevices.bracelet.C0596r.d(r0, r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        if (r1 == 0) goto L_0x0003;
    L_0x0025:
        r1.close();
        goto L_0x0003;
    L_0x0029:
        r0 = "SDB";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2.<init>();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r3 = "printDataForSample dateCnt = ";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r3 = r1.getCount();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        cn.com.smartdevices.bracelet.C0596r.d(r0, r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = "";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = "";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = "";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
    L_0x004b:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        if (r0 == 0) goto L_0x00ad;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
    L_0x0051:
        r0 = "date";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = "mac";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r3 = "summary";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r4 = "SDB";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r5.<init>();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r6 = "printDataForSample date = ";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r5 = ",mac = ";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r2 = ",summary = ";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        cn.com.smartdevices.bracelet.C0596r.d(r4, r0);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        goto L_0x004b;
    L_0x009c:
        r0 = move-exception;
        r2 = "SDB";	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r0);	 Catch:{ Exception -> 0x009c, all -> 0x00b4 }
        if (r1 == 0) goto L_0x0003;
    L_0x00a8:
        r1.close();
        goto L_0x0003;
    L_0x00ad:
        if (r1 == 0) goto L_0x0003;
    L_0x00af:
        r1.close();
        goto L_0x0003;
    L_0x00b4:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ba;
    L_0x00b7:
        r1.close();
    L_0x00ba:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.shoes.data.db.l.b(android.content.Context):void");
    }

    public static boolean b(Context context, h hVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            return a(context, s.a(context).a(true), hVar);
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.ContentProviderResult[] b(android.content.Context r6, java.util.List<cn.com.smartdevices.bracelet.shoes.model.h> r7) {
        /*
        r1 = 0;
        r2 = 1;
        r0 = "SDB";
        r3 = "applyFakeBatch";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r3);
        if (r6 == 0) goto L_0x000d;
    L_0x000b:
        if (r7 != 0) goto L_0x0013;
    L_0x000d:
        r0 = new java.lang.IllegalArgumentException;
        r0.<init>();
        throw r0;
    L_0x0013:
        r0 = cn.com.smartdevices.bracelet.shoes.data.db.s.a(r6);
        r3 = r0.a(r2);
        r4 = r7.size();
        r3.beginTransaction();	 Catch:{ Exception -> 0x0069 }
        r5 = r7.iterator();	 Catch:{ Exception -> 0x0069 }
    L_0x0026:
        r0 = r5.hasNext();	 Catch:{ Exception -> 0x0069 }
        if (r0 == 0) goto L_0x0038;
    L_0x002c:
        r0 = r5.next();	 Catch:{ Exception -> 0x0069 }
        r0 = (cn.com.smartdevices.bracelet.shoes.model.h) r0;	 Catch:{ Exception -> 0x0069 }
        r0 = a(r6, r3, r0);	 Catch:{ Exception -> 0x0069 }
        r2 = r2 & r0;
        goto L_0x0026;
    L_0x0038:
        r3.setTransactionSuccessful();	 Catch:{ Exception -> 0x0069 }
        r3.endTransaction();	 Catch:{ Exception -> 0x0080 }
    L_0x003e:
        if (r2 == 0) goto L_0x007e;
    L_0x0040:
        r0 = cn.com.smartdevices.bracelet.shoes.data.db.u.c;
        r0 = r0.buildUpon();
        r2 = "batch";
        r0 = r0.appendPath(r2);
        r2 = java.lang.String.valueOf(r4);
        r0 = r0.appendPath(r2);
        r0 = r0.build();
        r2 = r6.getContentResolver();
        r2.notifyChange(r0, r1);
        r0 = "SDB";
        r1 = "applyFakeBatch notify";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r0 = new android.content.ContentProviderResult[r4];
    L_0x0068:
        return r0;
    L_0x0069:
        r0 = move-exception;
        r5 = "SDB";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0079 }
        cn.com.smartdevices.bracelet.C0596r.d(r5, r0);	 Catch:{ all -> 0x0079 }
        r3.endTransaction();	 Catch:{ Exception -> 0x0077 }
        goto L_0x003e;
    L_0x0077:
        r0 = move-exception;
        goto L_0x003e;
    L_0x0079:
        r0 = move-exception;
        r3.endTransaction();	 Catch:{ Exception -> 0x0082 }
    L_0x007d:
        throw r0;
    L_0x007e:
        r0 = r1;
        goto L_0x0068;
    L_0x0080:
        r0 = move-exception;
        goto L_0x003e;
    L_0x0082:
        r1 = move-exception;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.shoes.data.db.l.b(android.content.Context, java.util.List):android.content.ContentProviderResult[]");
    }

    public static String[] b(Context context, c cVar) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Cursor rawQuery;
        try {
            String str;
            String[] strArr;
            SQLiteDatabase a = s.a(context).a(false);
            String str2 = "SELECT max(date) as max, min(date) as min FROM shoesdata";
            if (cVar == null || TextUtils.isEmpty(cVar.b())) {
                str = str2;
                strArr = null;
            } else {
                str = str2 + " WHERE (mac=? AND sn=? OR mac=? AND sn='')";
                strArr = new String[]{cVar.b(), cVar.d(), cVar.b()};
            }
            rawQuery = a.rawQuery(str, strArr);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() != 0) {
                        strArr = new String[2];
                        if (rawQuery.moveToNext()) {
                            strArr[0] = rawQuery.getString(rawQuery.getColumnIndex("min"));
                            strArr[1] = rawQuery.getString(rawQuery.getColumnIndex("max"));
                            if (rawQuery == null) {
                                return strArr;
                            }
                            rawQuery.close();
                            return strArr;
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.d(a, e.getMessage());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            C0596r.d(a, e.getMessage());
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean c(Context context, c cVar) {
        if (context == null || cVar == null || cVar.e() || TextUtils.isEmpty(cVar.a())) {
            throw new IllegalArgumentException();
        }
        try {
            String[] strArr = new String[]{cVar.b(), cVar.d(), cVar.b()};
            ContentValues contentValues = new ContentValues();
            contentValues.put(g.t, cVar.a());
            return s.a(context).a(true).update(g.a, contentValues, "mac=? AND sn=? OR mac=? AND sn=''", strArr) > 0;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    private static ContentProviderResult[] c(Context context, List<h> list) {
        C0596r.d(a, "applyRealBatch");
        if (context == null || list == null) {
            throw new IllegalArgumentException();
        }
        try {
            ArrayList arrayList = new ArrayList(list.size());
            for (h a : list) {
                ContentProviderOperation a2 = a(context, a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return context.getContentResolver().applyBatch(r.f, arrayList);
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return null;
        }
    }

    public static boolean d(Context context, c cVar) {
        if (context != null && cVar != null && !cVar.e()) {
            return a(context, cVar, com.xiaomi.e.a.f, k.STATE_SYNCED_FROM_SERVER);
        }
        throw new IllegalArgumentException();
    }

    public static boolean e(Context context, c cVar) {
        if (context != null && cVar != null && !cVar.e()) {
            return a(context, cVar, com.xiaomi.e.a.f, k.STATE_SYNCED_TO_SERVER);
        }
        throw new IllegalArgumentException();
    }

    public static boolean f(Context context, c cVar) {
        if (context != null && cVar != null && !cVar.e()) {
            return a(context, cVar, com.xiaomi.e.a.f, k.STATE_UNSYNCED);
        }
        throw new IllegalArgumentException();
    }
}
