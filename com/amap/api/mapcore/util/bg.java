package com.amap.api.mapcore.util;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class bg {
    static final String a = "/a/";
    static final String b = c.d;
    static final String c = GroupItemBaseInfo.KEY_COUNT;
    static final String d = "d";

    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Context b;
        final /* synthetic */ Throwable c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        AnonymousClass1(int i, Context context, Throwable th, String str, String str2) {
            this.a = i;
            this.b = context;
            this.c = th;
            this.d = str;
            this.e = str2;
        }

        public void run() {
            try {
                bj a = bj.a(this.a);
                if (a != null) {
                    a.a(this.b, this.c, this.d, this.e);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r0 = 0;
            r1 = r7.a;	 Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0035, all -> 0x0055 }
            r2 = 0;
            r2 = com.amap.api.mapcore.util.bh.a(r1, r2);	 Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0035, all -> 0x0055 }
            r1 = r7.a;	 Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x0092, all -> 0x007b }
            r3 = 1;
            r1 = com.amap.api.mapcore.util.bh.a(r1, r3);	 Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x0092, all -> 0x007b }
            r3 = r7.a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x0099, all -> 0x0082 }
            r4 = 2;
            r0 = com.amap.api.mapcore.util.bh.a(r3, r4);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x0099, all -> 0x0082 }
            r3 = r7.a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r2.b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r3 = r7.a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r1.b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r3 = r7.a;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            r0.b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
            if (r2 == 0) goto L_0x002a;
        L_0x0027:
            r2.c();
        L_0x002a:
            if (r1 == 0) goto L_0x002f;
        L_0x002c:
            r1.c();
        L_0x002f:
            if (r0 == 0) goto L_0x0034;
        L_0x0031:
            r0.c();
        L_0x0034:
            return;
        L_0x0035:
            r1 = move-exception;
            r2 = r0;
            r3 = r0;
            r6 = r1;
            r1 = r0;
            r0 = r6;
        L_0x003b:
            r4 = "Log";
            r5 = "processLog";
            com.amap.api.mapcore.util.az.a(r0, r4, r5);	 Catch:{ all -> 0x0090 }
            r0.printStackTrace();	 Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x004a;
        L_0x0047:
            r3.c();
        L_0x004a:
            if (r2 == 0) goto L_0x004f;
        L_0x004c:
            r2.c();
        L_0x004f:
            if (r1 == 0) goto L_0x0034;
        L_0x0051:
            r1.c();
            goto L_0x0034;
        L_0x0055:
            r1 = move-exception;
            r2 = r0;
            r3 = r0;
            r6 = r1;
            r1 = r0;
            r0 = r6;
        L_0x005b:
            if (r3 == 0) goto L_0x0060;
        L_0x005d:
            r3.c();
        L_0x0060:
            if (r2 == 0) goto L_0x0065;
        L_0x0062:
            r2.c();
        L_0x0065:
            if (r1 == 0) goto L_0x006a;
        L_0x0067:
            r1.c();
        L_0x006a:
            throw r0;
        L_0x006b:
            r1 = move-exception;
            r1 = r0;
            r2 = r0;
        L_0x006e:
            if (r2 == 0) goto L_0x0073;
        L_0x0070:
            r2.c();
        L_0x0073:
            if (r1 == 0) goto L_0x0078;
        L_0x0075:
            r1.c();
        L_0x0078:
            if (r0 == 0) goto L_0x0034;
        L_0x007a:
            goto L_0x0031;
        L_0x007b:
            r1 = move-exception;
            r3 = r2;
            r2 = r0;
            r6 = r0;
            r0 = r1;
            r1 = r6;
            goto L_0x005b;
        L_0x0082:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x005b;
        L_0x0089:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x005b;
        L_0x0090:
            r0 = move-exception;
            goto L_0x005b;
        L_0x0092:
            r1 = move-exception;
            r3 = r2;
            r2 = r0;
            r6 = r0;
            r0 = r1;
            r1 = r6;
            goto L_0x003b;
        L_0x0099:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x003b;
        L_0x00a0:
            r3 = move-exception;
            r6 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r6;
            goto L_0x003b;
        L_0x00a7:
            r1 = move-exception;
            r1 = r0;
            goto L_0x006e;
        L_0x00aa:
            r3 = move-exception;
            goto L_0x006e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bg.2.run():void");
        }
    }

    static void a(Context context) {
        try {
            bj a = bj.a(2);
            if (a != null) {
                a.a(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static void a(Context context, Throwable th, int i, String str, String str2) {
        try {
            ExecutorService a = az.a();
            if (a != null && !a.isShutdown()) {
                a.submit(new AnonymousClass1(i, context, th, str, str2));
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static void b(Context context) {
        try {
            ExecutorService a = az.a();
            if (a != null && !a.isShutdown()) {
                a.submit(new AnonymousClass2(context));
            }
        } catch (Throwable th) {
            az.a(th, "Log", "processLog");
            th.printStackTrace();
        }
    }
}
