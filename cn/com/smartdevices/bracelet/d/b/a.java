package cn.com.smartdevices.bracelet.d.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;

public class a {
    public static java.util.List<java.lang.String> a(android.database.sqlite.SQLiteDatabase r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0024 in list [B:11:0x0021]
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
        r1 = 0;
        r3 = 0;
        if (r4 != 0) goto L_0x000a;
    L_0x0004:
        r0 = new java.lang.IllegalArgumentException;
        r0.<init>();
        throw r0;
    L_0x000a:
        r0 = "SELECT name FROM sqlite_sequence";	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r2 = 0;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r1 = r4.rawQuery(r0, r2);	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        if (r1 == 0) goto L_0x0019;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
    L_0x0013:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        if (r0 != 0) goto L_0x0025;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
    L_0x0019:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r2 = 0;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        if (r1 == 0) goto L_0x0024;
    L_0x0021:
        r1.close();
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r2 = r1.getCount();	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
    L_0x002e:
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        if (r2 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
    L_0x0034:
        r2 = 0;	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r0.add(r2);	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        goto L_0x002e;
    L_0x003d:
        r0 = move-exception;
        r2 = "DB";	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        cn.com.smartdevices.bracelet.C0596r.a(r2, r0);	 Catch:{ Exception -> 0x003d, all -> 0x0058 }
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.close();
    L_0x004c:
        r0 = new java.util.ArrayList;
        r0.<init>(r3);
        goto L_0x0024;
    L_0x0052:
        if (r1 == 0) goto L_0x0024;
    L_0x0054:
        r1.close();
        goto L_0x0024;
    L_0x0058:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1.close();
    L_0x005e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.d.b.a.a(android.database.sqlite.SQLiteDatabase):java.util.List<java.lang.String>");
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        boolean z = false;
        if (sQLiteDatabase == null) {
            throw new IllegalArgumentException();
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_sequence", null);
                if (cursor != null && cursor.getCount() != 0) {
                    do {
                        if (!cursor.moveToNext()) {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    } while (!cursor.getString(0).equals(str));
                    z = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                } else if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                C0596r.a("DB", e.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return z;
    }
}
