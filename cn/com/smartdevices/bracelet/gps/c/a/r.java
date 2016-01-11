package cn.com.smartdevices.bracelet.gps.c.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.relation.db.a;
import cn.com.smartdevices.bracelet.shoes.data.db.h;
import cn.com.smartdevices.bracelet.shoes.data.db.j;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.market.sdk.p;

class r {
    private r() {
    }

    public static void a(Context context, SQLiteDatabase sQLiteDatabase) {
        if (context == null || sQLiteDatabase == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e("SDB", "transferSportDataIfNeeded");
        long currentTimeMillis = System.currentTimeMillis();
        SQLiteDatabase a = C0425b.a(context).a(false);
        boolean a2 = a(sQLiteDatabase, a, h.a);
        boolean a3 = a(sQLiteDatabase, a, d.a);
        boolean a4 = a(sQLiteDatabase, a, f.a);
        boolean a5 = a(sQLiteDatabase, a, b.a);
        C0596r.e("SDB", "transferSportDataIfNeeded span = " + (System.currentTimeMillis() - currentTimeMillis) + ",isConfigDone = " + a2 + ",isTrackInfoDone = " + a3 + ",isTrackLocDone = " + a4 + ",isContourDone = " + a5 + ",isDeathBookDone = " + a(sQLiteDatabase, a, l.a));
    }

    private static void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        try {
            sQLiteDatabase.execSQL("INSERT INTO sportconfig(_id,type,data,sync) VALUES(?,?,?,?)", new Object[]{Integer.valueOf(cursor.getInt(cursor.getColumnIndex(p.a))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(SocialConstants.PARAM_TYPE))), cursor.getString(cursor.getColumnIndex(b.b)), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(i.d)))});
        } catch (SQLiteConstraintException e) {
            C0596r.a("SDB", e.getMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.database.sqlite.SQLiteDatabase r7, android.database.sqlite.SQLiteDatabase r8, java.lang.String r9) {
        /*
        r3 = 0;
        r0 = 0;
        r1 = 1;
        r2 = cn.com.smartdevices.bracelet.gps.c.a.a.a(r9);
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r2.<init>();	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r4 = "SELECT * FROM ";
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r2 = r2.append(r9);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r4 = 0;
        r3 = r8.rawQuery(r2, r4);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        if (r3 == 0) goto L_0x002a;
    L_0x0024:
        r2 = r3.getCount();	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        if (r2 != 0) goto L_0x004f;
    L_0x002a:
        r0 = "SDB";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        r2.<init>();	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        r4 = "transferDataByTable tableName = ";
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        r2 = r2.append(r9);	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        r4 = " is empty";
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        cn.com.smartdevices.bracelet.C0596r.e(r0, r2);	 Catch:{ Exception -> 0x014b, all -> 0x0146 }
        if (r3 == 0) goto L_0x004d;
    L_0x004a:
        r3.close();
    L_0x004d:
        r0 = r1;
        goto L_0x0009;
    L_0x004f:
        r2 = "SDB";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r4.<init>();	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r5 = "transferDataByTable tableName = ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r5 = ",cnt = ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r5 = r3.getCount();	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        cn.com.smartdevices.bracelet.C0596r.e(r2, r4);	 Catch:{ Exception -> 0x00ae, all -> 0x00ce }
        r7.beginTransaction();	 Catch:{ Exception -> 0x008a }
        r2 = "contourtrack";
        r2 = r2.equals(r9);	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x00da;
    L_0x0080:
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0127;
    L_0x0086:
        b(r7, r3);	 Catch:{ Exception -> 0x008a }
        goto L_0x0080;
    L_0x008a:
        r1 = move-exception;
        r2 = "SDB";
        r3 = r1.getMessage();	 Catch:{ all -> 0x00ec }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x00ec }
        r2 = "SDB";
        r1 = r1.getMessage();	 Catch:{ all -> 0x00ec }
        cn.com.smartdevices.bracelet.C0596r.a(r2, r1);	 Catch:{ all -> 0x00ec }
        r7.endTransaction();	 Catch:{ IllegalStateException -> 0x00a2 }
        goto L_0x0009;
    L_0x00a2:
        r1 = move-exception;
        r2 = "SDB";
        r1 = r1.getMessage();
        cn.com.smartdevices.bracelet.C0596r.a(r2, r1);
        goto L_0x0009;
    L_0x00ae:
        r2 = move-exception;
        r6 = r2;
        r2 = r0;
        r0 = r6;
    L_0x00b2:
        r4 = "SDB";
        r5 = r0.getMessage();	 Catch:{ all -> 0x0148 }
        android.util.Log.e(r4, r5, r0);	 Catch:{ all -> 0x0148 }
        r4 = "SDB";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0148 }
        cn.com.smartdevices.bracelet.C0596r.a(r4, r0);	 Catch:{ all -> 0x0148 }
        if (r2 == 0) goto L_0x00cb;
    L_0x00c6:
        if (r3 == 0) goto L_0x00cb;
    L_0x00c8:
        r3.close();
    L_0x00cb:
        r0 = r1;
        goto L_0x0009;
    L_0x00ce:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00d2:
        if (r1 == 0) goto L_0x00d9;
    L_0x00d4:
        if (r3 == 0) goto L_0x00d9;
    L_0x00d6:
        r3.close();
    L_0x00d9:
        throw r0;
    L_0x00da:
        r2 = "trackdeathbook";
        r2 = r2.equals(r9);	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x00f1;
    L_0x00e2:
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0127;
    L_0x00e8:
        c(r7, r3);	 Catch:{ Exception -> 0x008a }
        goto L_0x00e2;
    L_0x00ec:
        r0 = move-exception;
        r7.endTransaction();	 Catch:{ IllegalStateException -> 0x013b }
    L_0x00f0:
        throw r0;
    L_0x00f1:
        r2 = "sportconfig";
        r2 = r2.equals(r9);	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0103;
    L_0x00f9:
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0127;
    L_0x00ff:
        a(r7, r3);	 Catch:{ Exception -> 0x008a }
        goto L_0x00f9;
    L_0x0103:
        r2 = "trackloc";
        r2 = r2.equals(r9);	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0115;
    L_0x010b:
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0127;
    L_0x0111:
        e(r7, r3);	 Catch:{ Exception -> 0x008a }
        goto L_0x010b;
    L_0x0115:
        r2 = "trackinfo";
        r2 = r2.equals(r9);	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0127;
    L_0x011d:
        r2 = r3.moveToNext();	 Catch:{ Exception -> 0x008a }
        if (r2 == 0) goto L_0x0127;
    L_0x0123:
        d(r7, r3);	 Catch:{ Exception -> 0x008a }
        goto L_0x011d;
    L_0x0127:
        r7.setTransactionSuccessful();	 Catch:{ Exception -> 0x008a }
        r7.endTransaction();	 Catch:{ IllegalStateException -> 0x0130 }
    L_0x012d:
        r0 = r1;
        goto L_0x0009;
    L_0x0130:
        r0 = move-exception;
        r2 = "SDB";
        r0 = r0.getMessage();
        cn.com.smartdevices.bracelet.C0596r.a(r2, r0);
        goto L_0x012d;
    L_0x013b:
        r1 = move-exception;
        r2 = "SDB";
        r1 = r1.getMessage();
        cn.com.smartdevices.bracelet.C0596r.a(r2, r1);
        goto L_0x00f0;
    L_0x0146:
        r0 = move-exception;
        goto L_0x00d2;
    L_0x0148:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00d2;
    L_0x014b:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.gps.c.a.r.a(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    private static void b(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        try {
            sQLiteDatabase.execSQL("INSERT INTO contourtrack(_id,trackid,uri,summery,data,synced,gcnt,v,type) values(?,?,?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(cursor.getInt(cursor.getColumnIndex(p.a))), Long.valueOf(cursor.getLong(cursor.getColumnIndex(m.b))), cursor.getString(cursor.getColumnIndex(j.e)), cursor.getString(cursor.getColumnIndex(c.d)), cursor.getString(cursor.getColumnIndex(b.b)), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(h.k))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(c.g))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(SportBaseInfo.VERSION))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(SocialConstants.PARAM_TYPE)))});
        } catch (SQLiteConstraintException e) {
            C0596r.a("SDB", e.getMessage());
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        try {
            sQLiteDatabase.execSQL("INSERT INTO trackdeathbook(_id,trackid,type,summary,data) values(?,?,?,?)", new Object[]{Integer.valueOf(cursor.getInt(cursor.getColumnIndex(p.a))), Long.valueOf(cursor.getLong(cursor.getColumnIndex(m.b))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(SocialConstants.PARAM_TYPE))), cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_SUMMARY)), cursor.getString(cursor.getColumnIndex(b.b))});
        } catch (SQLiteConstraintException e) {
            C0596r.a("SDB", e.getMessage());
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        try {
            sQLiteDatabase.execSQL("INSERT INTO trackinfo(_id,type,date,trackid,distance,usedtime,summary,data,groupCnt,sync) values(?,?,?,?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(cursor.getInt(cursor.getColumnIndex(p.a))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(SocialConstants.PARAM_TYPE))), cursor.getString(cursor.getColumnIndex(g.a)), Long.valueOf(cursor.getLong(cursor.getColumnIndex(m.b))), Float.valueOf(cursor.getFloat(cursor.getColumnIndex(a.g))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(e.f))), cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_SUMMARY)), cursor.getString(cursor.getColumnIndex(b.b)), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(e.i))), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(i.d)))});
        } catch (SQLiteConstraintException e) {
            C0596r.a("SDB", e.getMessage());
        }
    }

    private static void e(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        try {
            sQLiteDatabase.execSQL("INSERT INTO trackloc(_id,trackid,latitude,longitude,altitude,time,extra) values(?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(cursor.getInt(cursor.getColumnIndex(p.a))), Long.valueOf(cursor.getLong(cursor.getColumnIndex(m.b))), Double.valueOf(cursor.getDouble(cursor.getColumnIndex(ParamKey.LATITUDE))), Double.valueOf(cursor.getDouble(cursor.getColumnIndex(ParamKey.LONGITUDE))), Double.valueOf(cursor.getDouble(cursor.getColumnIndex(g.e))), Long.valueOf(cursor.getLong(cursor.getColumnIndex(g.f))), cursor.getString(cursor.getColumnIndex(g.g))});
        } catch (SQLiteConstraintException e) {
            C0596r.a("SDB", e.getMessage());
        }
    }
}
