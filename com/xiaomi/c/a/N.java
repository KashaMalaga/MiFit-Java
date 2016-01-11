package com.xiaomi.c.a;

class N implements Runnable {
    final /* synthetic */ L a;

    N(L l) {
        this.a = l;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:280)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.a;	 Catch:{ all -> 0x003f }
        r0 = r0.h;	 Catch:{ all -> 0x003f }
        r0.lock();	 Catch:{ all -> 0x003f }
        r0 = r4.a;	 Catch:{ all -> 0x003f }
        r0 = r0.u;	 Catch:{ all -> 0x003f }
        if (r0 == 0) goto L_0x001d;	 Catch:{ all -> 0x003f }
    L_0x0011:
        r0 = r4.a;	 Catch:{ all -> 0x003f }
        r0 = r0.u;	 Catch:{ all -> 0x003f }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x003f }
        if (r0 == 0) goto L_0x0027;
    L_0x001d:
        r0 = r4.a;
        r0 = r0.h;
        r0.unlock();
        return;
    L_0x0027:
        r0 = r4.a;
        r0 = r0.h;
        r0.unlock();
        r0 = r4.a;
        r2 = java.lang.System.currentTimeMillis();
        r0.z = r2;
        r0 = r4.a;
        r0.e();
        goto L_0x0000;
    L_0x003f:
        r0 = move-exception;
        r1 = r4.a;
        r1 = r1.h;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.c.a.N.run():void");
    }
}
