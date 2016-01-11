package com.xiaomi.hm.health.bt.profile.Weight;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.support.v4.e.a.a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.c.A;
import com.xiaomi.hm.health.bt.c.C;
import com.xiaomi.hm.health.bt.c.x;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.model.q;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"NewApi"})
public final class f extends x implements a {
    public static final String m = "2.0.5.20141206";
    public static final String n = "WeightProfile";
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;
    public static final int s = 4;
    private BluetoothGattCharacteristic A = null;
    private BluetoothGattCharacteristic B = null;
    private c C = null;
    private b D = null;
    private ExecutorService E = Executors.newSingleThreadExecutor();
    private boolean F = false;
    private byte[] G = null;
    private i H = null;
    private final int I = r;
    private final int J = 259;
    private BluetoothGattService t = null;
    private BluetoothGattCharacteristic u = null;
    private BluetoothGattCharacteristic v = null;
    private BluetoothGattCharacteristic w = null;
    private BluetoothGattCharacteristic x = null;
    private BluetoothGattCharacteristic y = null;
    private BluetoothGattCharacteristic z = null;

    static {
        C0596r.d(f.class.getSimpleName() + ".VERSION: " + m);
    }

    public f(Context context, BluetoothDevice bluetoothDevice, A a) {
        super(context, bluetoothDevice, a);
        C0596r.e();
    }

    private int A() {
        byte[] g = g(this.B);
        if (g == null || g.length < q) {
            C0596r.d(n, "getSandglassMode failed!!!");
            return -1;
        }
        C0596r.d(n, "Sandglass mode : " + y.b(g));
        return (g[o] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[p] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
    }

    private boolean B() {
        C0596r.d(n, "setSandglassToUserMode");
        return b(this.B, new byte[]{(byte) 3, (byte) 1, (byte) 0, (byte) 0, (byte) 0});
    }

    private i C() {
        i iVar = new i();
        Object g = g(this.v);
        if (g != null && g.length >= 6) {
            Object obj = new byte[6];
            System.arraycopy(g, o, obj, o, 6);
            iVar.c = new String(obj);
        }
        byte[] g2 = g(this.x);
        if (g2 != null && g2.length == 8) {
            iVar.a = String.format("%02X%02X%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(g2[o]), Byte.valueOf(g2[p]), Byte.valueOf(g2[q]), Byte.valueOf(g2[r]), Byte.valueOf(g2[s]), Byte.valueOf(g2[5]), Byte.valueOf(g2[6]), Byte.valueOf(g2[7])});
        }
        if (this.w != null) {
            g2 = g(this.w);
            if (g2 != null && g2.length > 0) {
                iVar.b = new String(g2);
            }
        }
        if (this.y != null) {
            g2 = g(this.y);
            if (g2 != null && g2.length == 7) {
                C0596r.e(n, "pnp id:" + y.b(g2));
                q qVar = new q();
                qVar.d = g2[o] & HeartRateInfo.HR_EMPTY_VALUE;
                qVar.a = ((g2[q] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (g2[p] & HeartRateInfo.HR_EMPTY_VALUE);
                qVar.b = ((g2[s] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (g2[r] & HeartRateInfo.HR_EMPTY_VALUE);
                qVar.c = (g2[5] & HeartRateInfo.HR_EMPTY_VALUE) | ((g2[6] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
                iVar.d = qVar;
            }
        }
        C0596r.d(n, "device info:" + iVar);
        return iVar;
    }

    private boolean a(Calendar calendar) {
        C0596r.e();
        short s = (short) calendar.get(p);
        byte b = (byte) (calendar.get(q) + p);
        byte b2 = (byte) calendar.get(5);
        byte b3 = (byte) calendar.get(11);
        byte b4 = (byte) calendar.get(12);
        byte b5 = (byte) calendar.get(13);
        y.a(new byte[q], (int) o, s);
        byte b6 = (byte) calendar.get(7);
        C0596r.d(n, "set date:" + calendar.getTime().toString());
        C0596r.d(n, "year:" + s + ",month:" + b + ",day:" + b2 + ",hour:" + b3 + ",min:" + b4 + ",sec:" + b5);
        return b(this.z, new byte[]{r6[o], r6[p], b, b2, b3, b4, b5, b6, (byte) 0, (byte) 0});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b(java.lang.String r21, com.xiaomi.hm.health.bt.d.b r22) {
        /*
        r20 = this;
        r2 = 0;
        r11 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r4 = 0;
        r3 = new java.util.UUID;
        r6 = 13586; // 0x3512 float:1.9038E-41 double:6.7124E-320;
        r8 = 2384656044284446464; // 0x21180009af100700 float:-1.309921E-10 double:2.932756965301042E-149;
        r3.<init>(r6, r8);
        r5 = 5424; // 0x1530 float:7.6E-42 double:2.68E-320;
        r5 = com.xiaomi.hm.health.bt.c.y.a(r3, r5);
        r0 = r20;
        r5 = r0.a(r5);
        if (r5 != 0) goto L_0x0027;
    L_0x001e:
        r2 = "WeightProfile";
        r3 = "service dfu is null!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = 1;
    L_0x0026:
        return r2;
    L_0x0027:
        r6 = 5425; // 0x1531 float:7.602E-42 double:2.6803E-320;
        r6 = com.xiaomi.hm.health.bt.c.y.a(r3, r6);
        r12 = r5.getCharacteristic(r6);
        r6 = 5426; // 0x1532 float:7.603E-42 double:2.681E-320;
        r3 = com.xiaomi.hm.health.bt.c.y.a(r3, r6);
        r13 = r5.getCharacteristic(r3);
        if (r12 == 0) goto L_0x003f;
    L_0x003d:
        if (r13 != 0) goto L_0x0048;
    L_0x003f:
        r2 = "WeightProfile";
        r3 = "BluetoothGattCharacteristic cpt or pkt is null!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = 1;
        goto L_0x0026;
    L_0x0048:
        r3 = new com.xiaomi.hm.health.bt.profile.Weight.i;
        r0 = r20;
        r3.<init>(r0, r12);
        r0 = r20;
        r3 = r0.b(r12, r3);
        if (r3 != 0) goto L_0x0060;
    L_0x0057:
        r2 = "WeightProfile";
        r3 = "Fail subscribe to DFU control point!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = 1;
        goto L_0x0026;
    L_0x0060:
        r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0432, all -> 0x0453 }
        r0 = r21;
        r5.<init>(r0);	 Catch:{ Exception -> 0x0432, all -> 0x0453 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0432, all -> 0x0453 }
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0432, all -> 0x0453 }
        r6.<init>(r5);	 Catch:{ Exception -> 0x0432, all -> 0x0453 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x0432, all -> 0x0453 }
        r4 = r5.length();	 Catch:{ Exception -> 0x0468 }
        r4 = (int) r4;	 Catch:{ Exception -> 0x0468 }
        r4 = r4 << 8;
        r4 = r4 | 1;
        r5 = 4;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0468 }
        r6 = 0;
        com.xiaomi.hm.health.bt.c.y.a(r5, r6, r4);	 Catch:{ Exception -> 0x0468 }
        r14 = r4 >> 8;
        r4 = 0;
        r0 = r20;
        r0.G = r4;	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r0.b(r12, r5);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 != 0) goto L_0x009b;
    L_0x0096:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0468 }
    L_0x009b:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 == 0) goto L_0x00c8;
    L_0x00a1:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0468 }
        r5 = 3;
        if (r4 < r5) goto L_0x00c8;
    L_0x00a9:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 16;
        if (r4 != r5) goto L_0x00c8;
    L_0x00b4:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        if (r4 != r5) goto L_0x00c8;
    L_0x00be:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        if (r4 == r5) goto L_0x010f;
    L_0x00c8:
        r2 = "WeightProfile";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0468 }
        r4.<init>();	 Catch:{ Exception -> 0x0468 }
        r5 = "Invalid response: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r5 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = com.xiaomi.hm.health.bt.c.y.b(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r5 = ",lenght:";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r5 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = r5.length;	 Catch:{ Exception -> 0x0468 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x00fd;
    L_0x00fa:
        r3.close();	 Catch:{ IOException -> 0x0106 }
    L_0x00fd:
        if (r12 == 0) goto L_0x0026;
    L_0x00ff:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x0106:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x00fd;
    L_0x010f:
        r4 = 0;
        r0 = r20;
        r0.G = r4;	 Catch:{ Exception -> 0x0468 }
        r4 = 1;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r6 = 3;
        r4[r5] = r6;	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r4 = r0.b(r12, r4);	 Catch:{ Exception -> 0x0468 }
        if (r4 != 0) goto L_0x0142;
    L_0x0123:
        r2 = "WeightProfile";
        r4 = "write DFU_OPCODE_TRANSFER failed!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x0130;
    L_0x012d:
        r3.close();	 Catch:{ IOException -> 0x0139 }
    L_0x0130:
        if (r12 == 0) goto L_0x0026;
    L_0x0132:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x0139:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0130;
    L_0x0142:
        r4 = 20;
        r9 = new byte[r4];	 Catch:{ Exception -> 0x0468 }
        if (r22 == 0) goto L_0x014d;
    L_0x0148:
        r0 = r22;
        r0.setMax(r14);	 Catch:{ Exception -> 0x0468 }
    L_0x014d:
        r7 = 0;
        r5 = 0;
        r6 = 0;
        r4 = 0;
        r10 = "WeightProfile";
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0468 }
        r15.<init>();	 Catch:{ Exception -> 0x0468 }
        r16 = "Device firmware: ";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0468 }
        r0 = r21;
        r15 = r15.append(r0);	 Catch:{ Exception -> 0x0468 }
        r16 = ", ";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0468 }
        r15 = r15.append(r14);	 Catch:{ Exception -> 0x0468 }
        r16 = " bytes";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0468 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.d(r10, r15);	 Catch:{ Exception -> 0x0468 }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0468 }
        r10 = r8;
        r8 = r5;
        r5 = r9;
        r19 = r4;
        r4 = r7;
        r7 = r19;
    L_0x0187:
        r9 = 1999; // 0x7cf float:2.801E-42 double:9.876E-321;
        r4 = r4 + r6;
        if (r9 >= r4) goto L_0x01c7;
    L_0x018c:
        r4 = 0;
        r6 = "WeightProfile";
        r9 = "Insert write request to clear GKI buffer!";
        cn.com.smartdevices.bracelet.C0596r.e(r6, r9);	 Catch:{ Exception -> 0x0468 }
        r6 = 1;
        r6 = new byte[r6];	 Catch:{ Exception -> 0x0468 }
        r9 = 0;
        r15 = 0;
        r6[r9] = r15;	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r6 = r0.b(r12, r6);	 Catch:{ Exception -> 0x0468 }
        if (r6 != 0) goto L_0x01c7;
    L_0x01a3:
        r2 = "WeightProfile";
        r4 = "write DFU_OPCODE_DUMMY failed!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r0.b(r12, r10);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x01b5;
    L_0x01b2:
        r3.close();	 Catch:{ IOException -> 0x01be }
    L_0x01b5:
        if (r12 == 0) goto L_0x0026;
    L_0x01b7:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x01be:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x01b5;
    L_0x01c7:
        r6 = r4;
        r4 = 0;
        r9 = r5.length;	 Catch:{ Exception -> 0x0468 }
        r9 = r3.read(r5, r4, r9);	 Catch:{ Exception -> 0x0468 }
        r4 = 1;
        if (r9 >= r4) goto L_0x023d;
    L_0x01d1:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 != 0) goto L_0x01dc;
    L_0x01d7:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0468 }
    L_0x01dc:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 == 0) goto L_0x0209;
    L_0x01e2:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0468 }
        r5 = 3;
        if (r4 < r5) goto L_0x0209;
    L_0x01ea:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 16;
        if (r4 != r5) goto L_0x0209;
    L_0x01f5:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 3;
        if (r4 != r5) goto L_0x0209;
    L_0x01ff:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        if (r4 == r5) goto L_0x02b7;
    L_0x0209:
        r2 = "WeightProfile";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0468 }
        r4.<init>();	 Catch:{ Exception -> 0x0468 }
        r5 = "Invalid response: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r5 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = com.xiaomi.hm.health.bt.c.y.b(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r0.b(r12, r10);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x0234;
    L_0x0231:
        r3.close();	 Catch:{ IOException -> 0x02ad }
    L_0x0234:
        if (r12 == 0) goto L_0x0026;
    L_0x0236:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x023d:
        r4 = 0;
        r10 = com.xiaomi.hm.health.bt.c.y.a(r10, r5, r4, r9);	 Catch:{ Exception -> 0x0468 }
        r4 = r5.length;	 Catch:{ Exception -> 0x0468 }
        if (r9 >= r4) goto L_0x0475;
    L_0x0245:
        r4 = new byte[r9];	 Catch:{ Exception -> 0x0468 }
        r15 = 0;
        r18 = 0;
        r0 = r18;
        java.lang.System.arraycopy(r5, r15, r4, r0, r9);	 Catch:{ Exception -> 0x0468 }
    L_0x024f:
        r0 = r20;
        r5 = r0.b(r13, r4);	 Catch:{ Exception -> 0x0468 }
        if (r5 != 0) goto L_0x027b;
    L_0x0257:
        r2 = "WeightProfile";
        r4 = "write firmware data failed!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r0.b(r12, r10);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x0269;
    L_0x0266:
        r3.close();	 Catch:{ IOException -> 0x0272 }
    L_0x0269:
        if (r12 == 0) goto L_0x0026;
    L_0x026b:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x0272:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0269;
    L_0x027b:
        r15 = r8 * r14;
        r5 = r7 + r9;
        r7 = r5 * 100;
        if (r15 >= r7) goto L_0x0470;
    L_0x0283:
        r7 = r5 * 100;
        r7 = r7 / r14;
        r8 = "WeightProfile";
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0468 }
        r15.<init>();	 Catch:{ Exception -> 0x0468 }
        r18 = "transfer sum:";
        r0 = r18;
        r15 = r15.append(r0);	 Catch:{ Exception -> 0x0468 }
        r15 = r15.append(r5);	 Catch:{ Exception -> 0x0468 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.e(r8, r15);	 Catch:{ Exception -> 0x0468 }
        if (r22 == 0) goto L_0x046a;
    L_0x02a2:
        r0 = r22;
        r0.report(r5);	 Catch:{ Exception -> 0x0468 }
        r8 = r7;
        r7 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x0187;
    L_0x02ad:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0234;
    L_0x02b7:
        r4 = "WeightProfile";
        r5 = "DFU transfer rate: %.1f KBps";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0468 }
        r7 = 0;
        r8 = (float) r14;	 Catch:{ Exception -> 0x0468 }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0468 }
        r14 = r14 - r16;
        r9 = (float) r14;	 Catch:{ Exception -> 0x0468 }
        r8 = r8 / r9;
        r8 = java.lang.Float.valueOf(r8);	 Catch:{ Exception -> 0x0468 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0468 }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.d(r4, r5);	 Catch:{ Exception -> 0x0468 }
        r4 = 3;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r6 = 4;
        r4[r5] = r6;	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        r6 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r10;
        r6 = (short) r6;	 Catch:{ Exception -> 0x0468 }
        com.xiaomi.hm.health.bt.c.y.a(r4, r5, r6);	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r0 = r20;
        r0.G = r5;	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r0.b(r12, r4);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 != 0) goto L_0x02fa;
    L_0x02f5:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0468 }
    L_0x02fa:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 == 0) goto L_0x0327;
    L_0x0300:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0468 }
        r5 = 3;
        if (r4 < r5) goto L_0x0327;
    L_0x0308:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 16;
        if (r4 != r5) goto L_0x0327;
    L_0x0313:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 4;
        if (r4 != r5) goto L_0x0327;
    L_0x031d:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        if (r4 == r5) goto L_0x0387;
    L_0x0327:
        r2 = "WeightProfile";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0468 }
        r4.<init>();	 Catch:{ Exception -> 0x0468 }
        r5 = "Invalid response: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r5 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = com.xiaomi.hm.health.bt.c.y.b(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r2 = "WeightProfile";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0468 }
        r4.<init>();	 Catch:{ Exception -> 0x0468 }
        r5 = "Firmware CRC: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r5 = "%04X";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0468 }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0468 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0468 }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0468 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0468 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x0375;
    L_0x0372:
        r3.close();	 Catch:{ IOException -> 0x037e }
    L_0x0375:
        if (r12 == 0) goto L_0x0026;
    L_0x0377:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x037e:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0375;
    L_0x0387:
        r4 = "WeightProfile";
        r5 = "reboot..................";
        cn.com.smartdevices.bracelet.C0596r.d(r4, r5);	 Catch:{ Exception -> 0x0468 }
        r4 = 0;
        r0 = r20;
        r0.G = r4;	 Catch:{ Exception -> 0x0468 }
        r4 = 1;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r6 = 5;
        r4[r5] = r6;	 Catch:{ Exception -> 0x0468 }
        r0 = r20;
        r4 = r0.b(r12, r4);	 Catch:{ Exception -> 0x0468 }
        if (r4 != 0) goto L_0x03c1;
    L_0x03a2:
        r2 = "WeightProfile";
        r4 = "Fail to issue restart command!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x03af;
    L_0x03ac:
        r3.close();	 Catch:{ IOException -> 0x03b8 }
    L_0x03af:
        if (r12 == 0) goto L_0x0026;
    L_0x03b1:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x03b8:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x03af;
    L_0x03c1:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 != 0) goto L_0x03cc;
    L_0x03c7:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0468 }
    L_0x03cc:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        if (r4 == 0) goto L_0x03f9;
    L_0x03d2:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0468 }
        r5 = 3;
        if (r4 < r5) goto L_0x03f9;
    L_0x03da:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 16;
        if (r4 != r5) goto L_0x03f9;
    L_0x03e5:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 5;
        if (r4 != r5) goto L_0x03f9;
    L_0x03ef:
        r0 = r20;
        r4 = r0.G;	 Catch:{ Exception -> 0x0468 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0468 }
        r5 = 1;
        if (r4 == r5) goto L_0x0418;
    L_0x03f9:
        r2 = "WeightProfile";
        r4 = "Fail to wait restart command response!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0468 }
        r2 = 1;
        if (r3 == 0) goto L_0x0406;
    L_0x0403:
        r3.close();	 Catch:{ IOException -> 0x040f }
    L_0x0406:
        if (r12 == 0) goto L_0x0026;
    L_0x0408:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x040f:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0406;
    L_0x0418:
        r4 = 0;
        r0 = r20;
        r0.F = r4;	 Catch:{ Exception -> 0x0468 }
        r20.c();	 Catch:{ Exception -> 0x0468 }
        if (r3 == 0) goto L_0x0425;
    L_0x0422:
        r3.close();	 Catch:{ IOException -> 0x0429 }
    L_0x0425:
        if (r12 == 0) goto L_0x0026;
    L_0x0427:
        goto L_0x0026;
    L_0x0429:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0425;
    L_0x0432:
        r2 = move-exception;
        r3 = r4;
    L_0x0434:
        r2 = "WeightProfile";
        r4 = "exception happend!!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ all -> 0x0466 }
        r2 = 1;
        if (r3 == 0) goto L_0x0441;
    L_0x043e:
        r3.close();	 Catch:{ IOException -> 0x044a }
    L_0x0441:
        if (r12 == 0) goto L_0x0026;
    L_0x0443:
        r0 = r20;
        r0.c(r12);
        goto L_0x0026;
    L_0x044a:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0441;
    L_0x0453:
        r2 = move-exception;
        r3 = r4;
    L_0x0455:
        if (r3 == 0) goto L_0x045a;
    L_0x0457:
        r3.close();	 Catch:{ IOException -> 0x045d }
    L_0x045a:
        if (r12 == 0) goto L_0x045c;
    L_0x045c:
        throw r2;
    L_0x045d:
        r3 = move-exception;
        r3 = "WeightProfile";
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x045a;
    L_0x0466:
        r2 = move-exception;
        goto L_0x0455;
    L_0x0468:
        r2 = move-exception;
        goto L_0x0434;
    L_0x046a:
        r8 = r7;
        r7 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x0187;
    L_0x0470:
        r7 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x0187;
    L_0x0475:
        r4 = r5;
        goto L_0x024f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.hm.health.bt.profile.Weight.f.b(java.lang.String, com.xiaomi.hm.health.bt.d.b):int");
    }

    private void b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        byte[] bArr = new byte[r];
        bArr[o] = (byte) 4;
        y.a(bArr, (int) p, (short) (a.a & i));
        b(bluetoothGattCharacteristic, bArr);
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        synchronized (bluetoothGattCharacteristic) {
            try {
                bluetoothGattCharacteristic.wait((long) i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(d dVar, long j) {
        C0596r.e(n, "runSyncDataTask");
        if (j == -1) {
            C0596r.d(n, "invalid uid!!!");
        } else {
            this.E.execute(new k(this, dVar, j));
        }
    }

    public void a(b bVar) {
        this.D = bVar;
    }

    public void a(c cVar) {
        this.C = cVar;
    }

    public void a(String str, b bVar) {
        C0596r.e(n, "runFwUpgradeTask");
        this.E.execute(new j(this, bVar, str));
    }

    public boolean b(boolean z) {
        if (this.B == null) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.B;
        byte[] bArr = new byte[5];
        bArr[o] = (byte) 2;
        bArr[p] = (byte) (z ? p : o);
        bArr[q] = (byte) 0;
        bArr[r] = (byte) 0;
        bArr[s] = (byte) 0;
        return b(bluetoothGattCharacteristic, bArr);
    }

    public void r() {
        super.r();
        this.C = null;
    }

    protected boolean t() {
        C0596r.e();
        this.F = false;
        Object a = a(w_);
        C0596r.a(a);
        if (a != null) {
            this.B = a.getCharacteristic(x_);
            if (this.B != null) {
                b(this.B, new g(this));
            }
        }
        this.t = a(y_);
        C0596r.a(this.t);
        if (this.t == null) {
            return false;
        }
        this.u = this.t.getCharacteristic(z_);
        C0596r.a(this.u);
        if (this.u == null) {
            return false;
        }
        this.z = this.t.getCharacteristic(f);
        C0596r.a(this.z);
        if (this.z == null) {
            return false;
        }
        C0596r.a((this.z.getProperties() & q) > 0);
        C0596r.a((this.z.getProperties() & 8) > 0);
        a = a(C_);
        C0596r.a(a);
        if (a == null) {
            return false;
        }
        this.v = a.getCharacteristic(E_);
        C0596r.a(this.v);
        if (this.v == null) {
            return false;
        }
        this.x = a.getCharacteristic(k);
        C0596r.a(this.x);
        if (this.x == null) {
            return false;
        }
        this.w = a.getCharacteristic(D_);
        C0596r.a(this.w);
        this.y = a.getCharacteristic(l);
        C0596r.a(this.y);
        boolean b = b(this.u, new h(this));
        C0596r.a(b);
        if (!b) {
            return false;
        }
        b = a(GregorianCalendar.getInstance());
        C0596r.a(b);
        if (b) {
            Calendar y = y();
            if (y != null) {
                C0596r.d(n, "old ble rtc date:" + y.getTime().toString());
            }
            this.H = C();
            if (this.H == null || !this.H.a()) {
                return false;
            }
            this.F = true;
            return true;
        }
        C0596r.d(n, "setDateTime failed!!!");
        return false;
    }

    public boolean u() {
        C0596r.e(n, "state:" + g() + ",connect:" + this.F);
        return g() == C.CONNECTED && this.F;
    }

    public final void w() {
        C0596r.e();
        super.w();
    }

    public Calendar y() {
        C0596r.e();
        byte[] g = g(this.z);
        if (g == null || g.length != 10) {
            return null;
        }
        C0596r.a(g.length == 10);
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(p, (g[o] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[p] & HeartRateInfo.HR_EMPTY_VALUE) << 8));
        gregorianCalendar.set(q, g[q] - 1);
        gregorianCalendar.set(5, g[r]);
        gregorianCalendar.set(11, g[s]);
        gregorianCalendar.set(12, g[5]);
        gregorianCalendar.set(13, g[6]);
        gregorianCalendar.set(7, g[7]);
        return gregorianCalendar;
    }

    public i z() {
        return this.H;
    }
}
