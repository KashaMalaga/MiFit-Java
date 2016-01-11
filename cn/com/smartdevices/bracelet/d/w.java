package cn.com.smartdevices.bracelet.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class w extends SQLiteOpenHelper {
    private static w a = null;
    private static final String b = "exercises_db";
    private static final int c = 1;
    private static final String d = "exercises";
    private static final String e = "_id";
    private static final String f = "subtype";
    private static final String g = "type";
    private static final String h = "desc";
    private static final String i = "mets";

    public w(Context context) {
        super(context, b, null, c);
    }

    private SQLiteDatabase a(boolean z) {
        if (!z) {
            return getReadableDatabase();
        }
        try {
            return getWritableDatabase();
        } catch (Exception e) {
            close();
            return z ? getWritableDatabase() : getReadableDatabase();
        }
    }

    public static w a() {
        return a;
    }

    public static void a(Context context) {
        if (a == null) {
            a = new w(context);
        }
    }

    public double a(java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0020 in list [B:11:0x003a]
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
        r10 = this;
        r4 = 1;
        r8 = 0;
        r5 = 0;
        r1 = 0;
        r2 = new java.lang.String[r4];
        r0 = "mets";
        r2[r1] = r0;
        r3 = "desc=?";
        r4 = new java.lang.String[r4];
        r4[r1] = r11;
        r0 = r10.a(r1);
        r1 = "exercises";
        r6 = r5;
        r7 = r5;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        if (r2 != 0) goto L_0x0021;
    L_0x001f:
        r0 = r8;
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = r2.getCount();	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0045;	 Catch:{ all -> 0x003e }
    L_0x0027:
        r0 = r2.moveToFirst();	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0045;	 Catch:{ all -> 0x003e }
    L_0x002d:
        r0 = "mets";	 Catch:{ all -> 0x003e }
        r0 = r2.getColumnIndex(r0);	 Catch:{ all -> 0x003e }
        r8 = r2.getDouble(r0);	 Catch:{ all -> 0x003e }
        r0 = r8;
    L_0x0038:
        if (r2 == 0) goto L_0x0020;
    L_0x003a:
        r2.close();
        goto L_0x0020;
    L_0x003e:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0044;
    L_0x0041:
        r2.close();
    L_0x0044:
        throw r0;
    L_0x0045:
        r0 = r8;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.d.w.a(java.lang.String):double");
    }

    public void b() {
        a(true).execSQL("DELETE FROM exercises");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS exercises(_id INTEGER PRIMARY KEY AUTOINCREMENT, uuid INTEGER, type INTEGER DEFAULT -1, subtype INTEGER DEFAULT -1, desc TEXT, mets DOUBLE, reserved1 TEXT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT, reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, reserved11 TEXT, reserved12 TEXT, reserved13 TEXT, reserved14 TEXT, reserved15 TEXT, reserved16 TEXT, reserved17 TEXT, reserved18 TEXT, reserved19 TEXT, reserved20 TEXT);");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
