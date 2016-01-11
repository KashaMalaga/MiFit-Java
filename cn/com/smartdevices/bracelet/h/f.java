package cn.com.smartdevices.bracelet.h;

import android.content.ContentResolver;
import android.database.Cursor;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.market.sdk.p;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class f {
    private static final String b = "SensorHubReader";
    String[] a = new String[]{p.a, h.b, h.c, h.d, h.e};
    private ContentResolver c = null;

    public f(ContentResolver contentResolver) {
        this.c = contentResolver;
    }

    private g a(Cursor cursor) {
        return new g(cursor.getInt(cursor.getColumnIndex(p.a)), cursor.getLong(cursor.getColumnIndex(h.b)), cursor.getLong(cursor.getColumnIndex(h.c)), cursor.getInt(cursor.getColumnIndex(h.d)), cursor.getInt(cursor.getColumnIndex(h.e)));
    }

    public static boolean a(android.content.ContentResolver r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0059 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = 1;
        r6 = 0;
        r8 = 0;
        r0 = 5;
        r2 = new java.lang.String[r0];
        r0 = "_id";
        r2[r6] = r0;
        r0 = "_begin_time";
        r2[r7] = r0;
        r0 = 2;
        r1 = "_end_time";
        r2[r0] = r1;
        r0 = 3;
        r1 = "_mode";
        r2[r0] = r1;
        r0 = 4;
        r1 = "_steps";
        r2[r0] = r1;
        r1 = cn.com.smartdevices.bracelet.h.h.i;	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r3 = 0;	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r4 = 0;	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r5 = 0;	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r0 = r9;	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        if (r0 != 0) goto L_0x0030;
    L_0x0029:
        if (r0 == 0) goto L_0x002e;
    L_0x002b:
        r0.close();
    L_0x002e:
        r0 = r6;
    L_0x002f:
        return r0;
    L_0x0030:
        if (r0 == 0) goto L_0x0035;
    L_0x0032:
        r0.close();
    L_0x0035:
        r0 = r7;
        goto L_0x002f;
    L_0x0037:
        r0 = move-exception;
        r1 = "SensorHubReader";	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r2.<init>();	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r3 = "checkValid has Exception:";	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        cn.com.smartdevices.bracelet.C0596r.d(r1, r0);	 Catch:{ Exception -> 0x0037, all -> 0x005b }
        if (r8 == 0) goto L_0x0059;
    L_0x0056:
        r8.close();
    L_0x0059:
        r0 = r6;
        goto L_0x002f;
    L_0x005b:
        r0 = move-exception;
        if (r8 == 0) goto L_0x0061;
    L_0x005e:
        r8.close();
    L_0x0061:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.h.f.a(android.content.ContentResolver):boolean");
    }

    public SportDay a() {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.c.query(h.i, this.a, null, null, h.f);
        long b = (query == null || !query.moveToFirst()) ? currentTimeMillis : a(query).b();
        if (query != null) {
            query.close();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(b);
        return instance.after(new SportDay().calendar) ? new SportDay(2014, 11, 3) : new SportDay(instance);
    }

    public LinkedList<g> a(long j) {
        C0596r.e(b, "start time:" + new Date(j) + ",ts:" + j);
        LinkedList<g> linkedList = new LinkedList();
        String[] strArr = new String[]{String.valueOf(j)};
        Cursor query = this.c.query(h.i, this.a, "_begin_time>=?", strArr, h.f);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return linkedList;
        }
        do {
            linkedList.add(a(query));
        } while (query.moveToNext());
        if (query != null) {
            query.close();
        }
        return linkedList;
    }

    public LinkedList<g> a(long j, long j2) {
        C0596r.e(b, "start time:" + new Date(j) + ",ts:" + j);
        C0596r.e(b, "stop time:" + new Date(j2) + ",ts:" + j2);
        LinkedList<g> linkedList = new LinkedList();
        String[] strArr = new String[]{String.valueOf(j), String.valueOf(j2)};
        Cursor query = this.c.query(h.i, this.a, "_begin_time>=? AND _end_time<=?", strArr, h.f);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return linkedList;
        }
        do {
            linkedList.add(a(query));
        } while (query.moveToNext());
        if (query != null) {
            query.close();
        }
        return linkedList;
    }

    public LinkedList<g> a(String str) {
        Calendar toCalenday = SportDay.toCalenday(str);
        long timeInMillis = toCalenday.getTimeInMillis();
        toCalenday.set(11, 23);
        toCalenday.set(12, 59);
        toCalenday.set(13, 59);
        return a(timeInMillis, toCalenday.getTimeInMillis());
    }

    public LinkedList<g> b() {
        LinkedList<g> linkedList = new LinkedList();
        Cursor query = this.c.query(h.i, this.a, null, null, h.f);
        if (query.moveToFirst()) {
            do {
                linkedList.add(a(query));
            } while (query.moveToNext());
        }
        if (query != null) {
            query.close();
        }
        return linkedList;
    }

    public LinkedList<g> b(long j) {
        C0596r.e(b, "getStepByTimestampNearBy:" + new Date(j).toString());
        LinkedList<g> linkedList = new LinkedList();
        String[] strArr = new String[]{String.valueOf(j)};
        Cursor query = this.c.query(h.i, this.a, "_end_time>=?", strArr, h.f);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return linkedList;
        }
        do {
            linkedList.add(a(query));
        } while (query.moveToNext());
        if (query != null) {
            query.close();
        }
        return linkedList;
    }
}
