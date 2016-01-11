package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import java.util.ArrayList;

public class ShoesProvider extends ContentProvider {
    static final String a = "update";
    static final String b = "delete";
    static final String c = "insert";
    public static final String d = "mac";
    public static final String e = "sn";
    public static final String f = "shoesid";
    public static final String g = "deviceid";
    public static final String h = "state";
    private static final String i = "ShoesProvider";
    private static final int k = 20480;
    private static final int l = 20481;
    private static final int m = 20482;
    private static final int n = 20483;
    private static final int o = 20484;
    private final UriMatcher j = new UriMatcher(-1);
    private final Object p = new Object();
    private SQLiteDatabase q;

    private int a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        int i = -1;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT state FROM myshoes WHERE " + "(mac=? AND sn=? OR mac=? AND sn='')", new String[]{str, str2, str});
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor.moveToNext()) {
                i = cursor.getInt(cursor.getColumnIndex(h));
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C0596r.d(i, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    private int a(Uri uri, String str) {
        int match = this.j.match(uri);
        if (match >= 0) {
            return match;
        }
        throw new IllegalArgumentException("Unknown uri: " + uri);
    }

    private static Builder a(Uri uri, String str, String str2, String str3, String str4) {
        return uri.buildUpon().appendQueryParameter(d, str).appendQueryParameter(e, str2).appendQueryParameter(f, str3).appendQueryParameter(g, str4);
    }

    private void a(Context context) {
        synchronized (this.j) {
            this.j.addURI(r.f, "myshoes/update", l);
            this.j.addURI(r.f, "myshoes/insert", m);
            this.j.addURI(r.f, "datedata/update", n);
            this.j.addURI(r.f, "datedata/insert", o);
        }
    }

    private SQLiteDatabase b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.p) {
            if (this.q != null) {
                sQLiteDatabase = this.q;
            } else {
                a();
                this.q = s.a(getContext()).a(true);
                sQLiteDatabase = this.q;
            }
        }
        return sQLiteDatabase;
    }

    public void a() {
        synchronized (this.p) {
            if (this.q != null) {
                this.q = null;
            }
        }
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase b = b();
        try {
            b.beginTransaction();
            ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
            b.setTransactionSuccessful();
            if (applyBatch != null) {
                getContext().getContentResolver().notifyChange(u.c.buildUpon().appendPath(r.k).appendPath(String.valueOf(applyBatch.length)).build(), null);
            }
            C0596r.d(i, "applyBatch result = " + applyBatch);
            return applyBatch;
        } finally {
            b.endTransaction();
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int i = 0;
        SQLiteDatabase b = b();
        try {
            b.beginTransaction();
            for (ContentValues insert : contentValuesArr) {
                if (b.insert(g.a, null, insert) >= 0) {
                    i++;
                }
            }
            b.setTransactionSuccessful();
            if (i > 0) {
                getContext().getContentResolver().notifyChange(u.c.buildUpon().appendPath(r.k).appendPath(String.valueOf(i)).build(), null);
            }
            C0596r.d(i, "bulkInsert count = " + i);
            return i;
        } finally {
            b.endTransaction();
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        long insert;
        long j;
        SQLiteException sQLiteException;
        int a = a(uri, c);
        SQLiteDatabase b = b();
        switch (a) {
            case m /*20482*/:
                Object queryParameter = uri.getQueryParameter(d);
                Object queryParameter2 = uri.getQueryParameter(e);
                String queryParameter3 = uri.getQueryParameter(f);
                String queryParameter4 = uri.getQueryParameter(g);
                if (!TextUtils.isEmpty(queryParameter) || !TextUtils.isEmpty(queryParameter2)) {
                    insert = b.insert(c.a, null, contentValues);
                    if (insert > 0) {
                        try {
                            getContext().getContentResolver().notifyChange(a(n.c, queryParameter, queryParameter2, queryParameter3, queryParameter4).appendQueryParameter(h, contentValues.getAsString(h)).build(), null);
                            break;
                        } catch (SQLiteException e) {
                            j = insert;
                            sQLiteException = e;
                            break;
                        }
                    }
                }
                C0596r.d(i, "INSERTED_MYSHOES no mac, sn");
                insert = 0;
                break;
                break;
            case o /*20484*/:
                insert = b.insert(g.a, null, contentValues);
                break;
            default:
                try {
                    throw new IllegalArgumentException("Unknown URL " + uri);
                } catch (SQLiteException e2) {
                    sQLiteException = e2;
                    j = 0;
                    break;
                }
        }
        C0596r.d(i, sQLiteException.getMessage());
        a();
        insert = j;
        return insert > 0 ? ContentUris.withAppendedId(uri, insert) : null;
    }

    public boolean onCreate() {
        a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) {
        /*
        r10 = this;
        r0 = 0;
        r1 = "update";
        r1 = r10.a(r11, r1);
        r2 = r10.b();
        switch(r1) {
            case 20481: goto L_0x0035;
            case 20482: goto L_0x000e;
            case 20483: goto L_0x00e7;
            default: goto L_0x000e;
        };
    L_0x000e:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ SQLiteException -> 0x0027 }
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0027 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0027 }
        r3 = "Unknown URL ";
        r2 = r2.append(r3);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r2.append(r11);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r2.toString();	 Catch:{ SQLiteException -> 0x0027 }
        r1.<init>(r2);	 Catch:{ SQLiteException -> 0x0027 }
        throw r1;	 Catch:{ SQLiteException -> 0x0027 }
    L_0x0027:
        r1 = move-exception;
        r2 = "ShoesProvider";
        r1 = r1.getMessage();
        cn.com.smartdevices.bracelet.C0596r.d(r2, r1);
        r10.a();
    L_0x0034:
        return r0;
    L_0x0035:
        r1 = "mac";
        r1 = r11.getQueryParameter(r1);	 Catch:{ SQLiteException -> 0x0027 }
        r3 = "sn";
        r3 = r11.getQueryParameter(r3);	 Catch:{ SQLiteException -> 0x0027 }
        r4 = "shoesid";
        r4 = r11.getQueryParameter(r4);	 Catch:{ SQLiteException -> 0x0027 }
        r5 = "deviceid";
        r5 = r11.getQueryParameter(r5);	 Catch:{ SQLiteException -> 0x0027 }
        r6 = android.text.TextUtils.isEmpty(r1);	 Catch:{ SQLiteException -> 0x0027 }
        if (r6 == 0) goto L_0x0061;
    L_0x0053:
        r6 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x0027 }
        if (r6 == 0) goto L_0x0061;
    L_0x0059:
        r1 = "ShoesProvider";
        r2 = "UPDATED_MYSHOES no mac, sn";
        cn.com.smartdevices.bracelet.C0596r.d(r1, r2);	 Catch:{ SQLiteException -> 0x0027 }
        goto L_0x0034;
    L_0x0061:
        r6 = r10.a(r2, r1, r3, r4);	 Catch:{ SQLiteException -> 0x0027 }
        r7 = "(mac=? AND sn=? OR mac=? AND sn='')";
        r8 = 3;
        r8 = new java.lang.String[r8];	 Catch:{ SQLiteException -> 0x0027 }
        r9 = 0;
        r8[r9] = r1;	 Catch:{ SQLiteException -> 0x0027 }
        r9 = 1;
        r8[r9] = r3;	 Catch:{ SQLiteException -> 0x0027 }
        r9 = 2;
        r8[r9] = r1;	 Catch:{ SQLiteException -> 0x0027 }
        r9 = "myshoes";
        r0 = r2.update(r9, r12, r7, r8);	 Catch:{ SQLiteException -> 0x0027 }
        if (r0 <= 0) goto L_0x0034;
    L_0x007b:
        r2 = "state";
        r2 = r12.containsKey(r2);	 Catch:{ SQLiteException -> 0x0027 }
        if (r2 == 0) goto L_0x0034;
    L_0x0083:
        r2 = "state";
        r2 = r12.getAsInteger(r2);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r2.intValue();	 Catch:{ SQLiteException -> 0x0027 }
        if (r2 == r6) goto L_0x0034;
    L_0x008f:
        r7 = cn.com.smartdevices.bracelet.shoes.data.db.n.c;	 Catch:{ SQLiteException -> 0x0027 }
        r3 = a(r7, r1, r3, r4, r5);	 Catch:{ SQLiteException -> 0x0027 }
        r4 = "state";
        r5 = java.lang.String.valueOf(r2);	 Catch:{ SQLiteException -> 0x0027 }
        r3 = r3.appendQueryParameter(r4, r5);	 Catch:{ SQLiteException -> 0x0027 }
        r3 = r3.build();	 Catch:{ SQLiteException -> 0x0027 }
        r4 = r10.getContext();	 Catch:{ SQLiteException -> 0x0027 }
        r4 = r4.getContentResolver();	 Catch:{ SQLiteException -> 0x0027 }
        r5 = 0;
        r4.notifyChange(r3, r5);	 Catch:{ SQLiteException -> 0x0027 }
        r4 = "ShoesProvider";
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0027 }
        r5.<init>();	 Catch:{ SQLiteException -> 0x0027 }
        r7 = "update newState = ";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r5.append(r2);	 Catch:{ SQLiteException -> 0x0027 }
        r5 = ",oldState:";
        r2 = r2.append(r5);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r2.append(r6);	 Catch:{ SQLiteException -> 0x0027 }
        r5 = ",mac:";
        r2 = r2.append(r5);	 Catch:{ SQLiteException -> 0x0027 }
        r1 = r2.append(r1);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = ",notify:";
        r1 = r1.append(r2);	 Catch:{ SQLiteException -> 0x0027 }
        r1 = r1.append(r3);	 Catch:{ SQLiteException -> 0x0027 }
        r1 = r1.toString();	 Catch:{ SQLiteException -> 0x0027 }
        cn.com.smartdevices.bracelet.C0596r.d(r4, r1);	 Catch:{ SQLiteException -> 0x0027 }
        goto L_0x0034;
    L_0x00e7:
        r1 = "shoesdata";
        r0 = r2.update(r1, r12, r13, r14);	 Catch:{ SQLiteException -> 0x0027 }
        r1 = "ShoesProvider";
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0027 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0027 }
        r3 = "UPDATED_DATE_DATA udpateId = ";
        r2 = r2.append(r3);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r2.append(r0);	 Catch:{ SQLiteException -> 0x0027 }
        r2 = r2.toString();	 Catch:{ SQLiteException -> 0x0027 }
        cn.com.smartdevices.bracelet.C0596r.e(r1, r2);	 Catch:{ SQLiteException -> 0x0027 }
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.shoes.data.db.ShoesProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
