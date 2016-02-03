package com.activeandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.activeandroid.d.b;
import com.activeandroid.d.c;
import com.activeandroid.d.i;
import com.d.a.a.C1012a;
import com.xiaomi.e.a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class f extends SQLiteOpenHelper {
    public static final String a = "migrations";
    private final String b;

    public f(c cVar) {
        super(cVar.a(), cVar.b(), null, cVar.c());
        a(cVar.a(), cVar.b());
        this.b = cVar.d();
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (com.activeandroid.d.f.a) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
            b.c("Foreign Keys supported. Enabling foreign key features.");
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, InputStream inputStream) {
        for (String execSQL : i.a(inputStream)) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.database.sqlite.SQLiteDatabase r5, java.lang.String r6) {
        /*
        r4 = this;
        r1 = 0;
        r0 = com.activeandroid.b.f();	 Catch:{ IOException -> 0x0035 }
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x0035 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0035 }
        r2.<init>();	 Catch:{ IOException -> 0x0035 }
        r3 = "migrations/";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0035 }
        r2 = r2.append(r6);	 Catch:{ IOException -> 0x0035 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0035 }
        r1 = r0.open(r2);	 Catch:{ IOException -> 0x0035 }
        r0 = "delimited";
        r2 = r4.b;	 Catch:{ IOException -> 0x0035 }
        r0 = r0.equalsIgnoreCase(r2);	 Catch:{ IOException -> 0x0035 }
        if (r0 == 0) goto L_0x0031;
    L_0x002a:
        r4.a(r5, r1);	 Catch:{ IOException -> 0x0035 }
    L_0x002d:
        com.activeandroid.d.a.a(r1);
    L_0x0030:
        return;
    L_0x0031:
        r4.b(r5, r1);	 Catch:{ IOException -> 0x0035 }
        goto L_0x002d;
    L_0x0035:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0050 }
        r2.<init>();	 Catch:{ all -> 0x0050 }
        r3 = "Failed to execute ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0050 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0050 }
        r2 = r2.toString();	 Catch:{ all -> 0x0050 }
        com.activeandroid.d.b.e(r2, r0);	 Catch:{ all -> 0x0050 }
        com.activeandroid.d.a.a(r1);
        goto L_0x0030;
    L_0x0050:
        r0 = move-exception;
        com.activeandroid.d.a.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.activeandroid.f.a(android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z = false;
        try {
            List<String> asList = Arrays.asList(b.f().getAssets().list(a));
            Collections.sort(asList, new c());
            sQLiteDatabase.beginTransaction();
            try {
                for (String str : asList) {
                    int intValue = Integer.valueOf(str.replace(".sql", a.f)).intValue();
                    if (intValue > i && intValue <= i2) {
                        a(sQLiteDatabase, str);
                        z = true;
                        b.c(str + " executed succesfully.");
                    }
                    z = z;
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (Throwable e) {
                b.d("Skipping invalidly named file: " + str, e);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable e2) {
            b.e("Failed to execute migrations.", e2);
        }
        return z;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            for (j b : b.g()) {
                for (String execSQL : com.activeandroid.d.f.b(b)) {
                    sQLiteDatabase.execSQL(execSQL);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase, InputStream inputStream) {
        Throwable th;
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            Closeable inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            Object trim = readLine.replace(";", a.f).trim();
                            if (!TextUtils.isEmpty(trim)) {
                                sQLiteDatabase.execSQL(trim);
                            }
                        } else {
                            com.activeandroid.d.a.a(bufferedReader);
                            com.activeandroid.d.a.a(inputStreamReader);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = inputStreamReader;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                closeable = inputStreamReader;
                com.activeandroid.d.a.a(bufferedReader);
                com.activeandroid.d.a.a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            com.activeandroid.d.a.a(bufferedReader);
            com.activeandroid.d.a.a(closeable);
            throw th;
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            for (j c : b.g()) {
                sQLiteDatabase.execSQL(com.activeandroid.d.f.c(c));
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void a(Context context, String str) {
        File databasePath = context.getDatabasePath(str);
        if (!databasePath.exists()) {
            databasePath.getParentFile().mkdirs();
            try {
                InputStream open = context.getAssets().open(str);
                OutputStream fileOutputStream = new FileOutputStream(databasePath);
                byte[] bArr = new byte[C1012a.e];
                while (true) {
                    int read = open.read(bArr, 0, C1012a.e);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        open.close();
                        return;
                    }
                }
            } catch (Throwable e) {
                b.e("Failed to open file", e);
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
        c(sQLiteDatabase);
        a(sQLiteDatabase, -1, sQLiteDatabase.getVersion());
        b(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
        c(sQLiteDatabase);
        a(sQLiteDatabase, i, i2);
    }
}
