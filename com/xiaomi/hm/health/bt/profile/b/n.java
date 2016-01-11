package com.xiaomi.hm.health.bt.profile.b;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.ByteArrayOutputStream;

public class n extends b implements B {
    private static final String b = "RunningSyncDataTask";
    private static final int c = 2;
    private f d = null;
    private d e = null;
    private byte[] f = null;
    private Object g = new Object();
    private int h = 0;
    private int i = 0;
    private ByteArrayOutputStream j = null;

    public n(f fVar, d dVar) {
        this.d = fVar;
        this.e = dVar;
    }

    static /* synthetic */ int a(n nVar, int i) {
        int i2 = nVar.i + i;
        nVar.i = i2;
        return i2;
    }

    private byte[] a(byte b) {
        C0596r.d(b, "in doCommand:" + b);
        synchronized (this.g) {
            this.f = null;
            if (this.d.a(b)) {
                if (this.f == null) {
                    try {
                        this.g.wait(5000);
                    } catch (InterruptedException e) {
                    }
                }
                C0596r.d(b, "out doCommand:" + b);
                return this.f;
            }
            C0596r.d(b, "sendDataControlCommand:" + b + " failed!!!");
            return null;
        }
    }

    private int b(byte[] bArr) {
        if (bArr == null) {
            C0596r.d(b, "data head is null!!!");
            return -1;
        }
        C0596r.d(b, "in:" + y.b(bArr));
        if (bArr[0] == (byte) -127) {
            C0596r.d(b, "data head indicate in syncing!!!");
            return -1;
        } else if (bArr.length == 5) {
            return (((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[c] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((bArr[3] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[4] & HeartRateInfo.HR_EMPTY_VALUE) << 24);
        } else {
            C0596r.d(b, "data head lenght is wrong!!!");
            return -1;
        }
    }

    public void a(byte[] bArr) {
        synchronized (this.g) {
            C0596r.d(b, "sync data control notify:" + y.b(bArr));
            this.f = bArr;
            this.g.notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
        r15 = this;
        r0 = r15.e;
        r0.c();
        r0 = r15.d;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r15.d;
        r0 = r0.u();
        if (r0 != 0) goto L_0x001c;
    L_0x0011:
        r0 = r15.e;
        r1 = 0;
        r1 = java.lang.Boolean.valueOf(r1);
        r0.d(r1);
    L_0x001b:
        return;
    L_0x001c:
        r0 = r15.d;
        r0 = r0.b(r15);
        if (r0 != 0) goto L_0x0032;
    L_0x0024:
        r0 = "RunningSyncDataTask";
        r1 = "registerDataControlNotification failed!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r0 = r15.e;
        r1 = 0;
        r0.a(r1);
        goto L_0x001b;
    L_0x0032:
        r0 = 1;
        r0 = r15.a(r0);
        r0 = r15.b(r0);
        r15.h = r0;
        r0 = r15.h;
        if (r0 > 0) goto L_0x006d;
    L_0x0041:
        r0 = "RunningSyncDataTask";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "invalid total size:";
        r1 = r1.append(r2);
        r2 = r15.h;
        r1 = r1.append(r2);
        r1 = r1.toString();
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r0 = r15.d;
        r0.E();
        r0 = r15.d;
        r1 = 5;
        r0.a(r1);
        r0 = r15.e;
        r1 = 0;
        r0.a(r1);
        goto L_0x001b;
    L_0x006d:
        r9 = new java.util.ArrayList;
        r9.<init>();
        r0 = r15.d;
        r1 = new com.xiaomi.hm.health.bt.profile.b.o;
        r1.<init>(r15);
        r0 = r0.c(r1);
        if (r0 != 0) goto L_0x008d;
    L_0x007f:
        r0 = "RunningSyncDataTask";
        r1 = "registerDataNotification failed!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r0 = r15.e;
        r1 = 0;
        r0.a(r1);
        goto L_0x001b;
    L_0x008d:
        r1 = 0;
        r0 = 0;
        r7 = r0;
        r8 = r1;
    L_0x0091:
        r0 = 2;
        r0 = r15.a(r0);
        if (r0 == 0) goto L_0x00a5;
    L_0x0098:
        r1 = r0.length;
        r2 = 1;
        if (r1 != r2) goto L_0x00c3;
    L_0x009c:
        r1 = 0;
        r1 = r0[r1];
        r1 = r1 & 255;
        r2 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        if (r1 != r2) goto L_0x00c3;
    L_0x00a5:
        r0 = "RunningSyncDataTask";
        r1 = "SYNC_DATA_CMD_HEAD stop!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
    L_0x00ac:
        r0 = r15.d;
        r0.E();
        r0 = r15.d;
        r1 = 5;
        r0.a(r1);
        r0 = r15.d;
        r0.F();
        r0 = r15.e;
        r0.a(r9);
        goto L_0x001b;
    L_0x00c3:
        if (r0 == 0) goto L_0x00d2;
    L_0x00c5:
        r1 = r0.length;
        r2 = 12;
        if (r1 == r2) goto L_0x00d2;
    L_0x00ca:
        r0 = "RunningSyncDataTask";
        r1 = "Wrong data head,return now!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        goto L_0x00ac;
    L_0x00d2:
        r1 = 0;
        r2 = 1;
        r10 = r0[r1];
        r1 = 2;
        r2 = r0[r2];
        r2 = r2 & 255;
        r3 = 3;
        r1 = r0[r1];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r1 = r1 | r2;
        r4 = 4;
        r2 = r0[r3];
        r2 = r2 + -1;
        r5 = 5;
        r3 = r0[r4];
        r6 = 6;
        r4 = r0[r5];
        r11 = 7;
        r5 = r0[r6];
        r12 = 8;
        r6 = r0[r11];
        r11 = 9;
        r12 = r0[r12];
        r13 = 10;
        r11 = r0[r11];
        r14 = 11;
        r13 = r0[r13];
        r14 = r0[r14];
        r0 = new java.util.GregorianCalendar;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r1 = r12 & 255;
        r2 = r11 & 255;
        r2 = r2 << 8;
        r1 = r1 | r2;
        r2 = r13 & 255;
        r2 = r2 << 16;
        r1 = r1 | r2;
        r2 = r14 & 255;
        r2 = r2 << 24;
        r3 = r1 | r2;
        r1 = "RunningSyncDataTask";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "type:";
        r2 = r2.append(r4);
        r2 = r2.append(r10);
        r4 = ",len:";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r4 = ",date:";
        r2 = r2.append(r4);
        r4 = new java.util.Date;
        r10 = r0.getTimeInMillis();
        r4.<init>(r10);
        r4 = r4.toString();
        r2 = r2.append(r4);
        r2 = r2.toString();
        cn.com.smartdevices.bracelet.C0596r.d(r1, r2);
        r4 = new com.xiaomi.hm.health.bt.model.b;
        r4.<init>(r0, r3);
        r0 = 0;
        r15.f = r0;
        r0 = r15.j;	 Catch:{ IOException -> 0x024a }
        if (r0 == 0) goto L_0x0167;
    L_0x015f:
        r0 = r15.j;	 Catch:{ IOException -> 0x024a }
        r0.close();	 Catch:{ IOException -> 0x024a }
        r0 = 0;
        r15.j = r0;	 Catch:{ IOException -> 0x024a }
    L_0x0167:
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x024a }
        r0.<init>();	 Catch:{ IOException -> 0x024a }
        r15.j = r0;	 Catch:{ IOException -> 0x024a }
    L_0x016e:
        r0 = r15.d;
        r1 = 3;
        r0 = r0.a(r1);
        if (r0 == 0) goto L_0x00ac;
    L_0x0177:
        r0 = r15.f;
        if (r0 == 0) goto L_0x0186;
    L_0x017b:
        r0 = r15.f;
        r1 = 0;
        r0 = r0[r1];
        r0 = r0 & 255;
        r1 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        if (r0 == r1) goto L_0x01ab;
    L_0x0186:
        r0 = "RunningSyncDataTask";
        r1 = "mControlObj waiting data transfer~";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r1 = r15.g;	 Catch:{ InterruptedException -> 0x01a8 }
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x01a8 }
        r0 = r15.d;	 Catch:{ all -> 0x01a5 }
        if (r0 == 0) goto L_0x01aa;
    L_0x0194:
        r0 = r15.d;	 Catch:{ all -> 0x01a5 }
        r0 = r0.u();	 Catch:{ all -> 0x01a5 }
        if (r0 == 0) goto L_0x01aa;
    L_0x019c:
        r0 = r15.g;	 Catch:{ all -> 0x01a5 }
        r10 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.wait(r10);	 Catch:{ all -> 0x01a5 }
        monitor-exit(r1);	 Catch:{ all -> 0x01a5 }
        goto L_0x0177;
    L_0x01a5:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01a5 }
        throw r0;	 Catch:{ InterruptedException -> 0x01a8 }
    L_0x01a8:
        r0 = move-exception;
        goto L_0x0177;
    L_0x01aa:
        monitor-exit(r1);	 Catch:{ all -> 0x01a5 }
    L_0x01ab:
        r0 = r15.j;
        r5 = r0.toByteArray();
        r0 = r5.length;
        r1 = "RunningSyncDataTask";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = "bytesOfData:";
        r2 = r2.append(r6);
        r2 = r2.append(r0);
        r6 = ",dataLen:";
        r2 = r2.append(r6);
        r2 = r2.append(r3);
        r2 = r2.toString();
        cn.com.smartdevices.bracelet.C0596r.d(r1, r2);
        if (r0 != r3) goto L_0x01da;
    L_0x01d6:
        r0 = r0 % 3;
        if (r0 == 0) goto L_0x0209;
    L_0x01da:
        r0 = "RunningSyncDataTask";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "dataLen error,try count:";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r0 = 2;
        if (r7 >= r0) goto L_0x0205;
    L_0x01f5:
        r0 = "RunningSyncDataTask";
        r1 = "try sync again!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        r0 = 4;
        r15.a(r0);
        r0 = r7 + 1;
        r7 = r0;
        goto L_0x0091;
    L_0x0205:
        r0 = 0;
        r7 = r0;
        goto L_0x0091;
    L_0x0209:
        r0 = 0;
        r1 = 0;
        r2 = r1;
        r1 = r8;
    L_0x020d:
        if (r2 >= r3) goto L_0x0232;
    L_0x020f:
        r6 = new com.xiaomi.hm.health.bt.model.d;
        r7 = r5[r2];
        r8 = r2 + 1;
        r8 = r5[r8];
        r10 = r2 + 2;
        r10 = r5[r10];
        r6.<init>(r7, r8, r10);
        r4.a(r6);
        r8 = r1 + 3;
        r1 = r15.e;
        r6 = r8 * 100;
        r7 = r15.h;
        r6 = r6 / r7;
        r1.b(r6);
        r1 = r2 + 3;
        r2 = r1;
        r1 = r8;
        goto L_0x020d;
    L_0x0232:
        r9.add(r4);
        r2 = r15.e;
        r2 = r2.e(r4);
        if (r2 != 0) goto L_0x0246;
    L_0x023d:
        r0 = "RunningSyncDataTask";
        r1 = "error happened for app,set clear flag to false and break!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r0, r1);
        goto L_0x00ac;
    L_0x0246:
        r7 = r0;
        r8 = r1;
        goto L_0x0091;
    L_0x024a:
        r0 = move-exception;
        goto L_0x016e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.hm.health.bt.profile.b.n.d():void");
    }
}
