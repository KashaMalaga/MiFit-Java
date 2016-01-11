package com.xiaomi.hm.health.bt.profile.b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.support.v4.e.a.a;
import b.a.C0374dh;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.A;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.x;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.d.d;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.model.m;
import com.xiaomi.hm.health.bt.model.p;
import com.xiaomi.hm.health.bt.model.q;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressLint({"NewApi"})
class f extends x implements a {
    public static final byte u = (byte) 1;
    public static final byte v = (byte) 2;
    public static final byte w = (byte) 3;
    public static final byte x = (byte) 4;
    public static final byte y = (byte) 5;
    private BluetoothGattCharacteristic A = null;
    private BluetoothGattCharacteristic B = null;
    private BluetoothGattCharacteristic C = null;
    private BluetoothGattCharacteristic D = null;
    private BluetoothGattCharacteristic E = null;
    private BluetoothGattCharacteristic F = null;
    private BluetoothGattCharacteristic G = null;
    private BluetoothGattCharacteristic H = null;
    private BluetoothGattCharacteristic I = null;
    private BluetoothGattCharacteristic J = null;
    private BluetoothGattCharacteristic K = null;
    private i L = null;
    private d M = null;
    private m N = new m();
    private byte[] O = null;
    protected int t = 0;
    private String z = "RunningProfile";

    public f(Context context, BluetoothDevice bluetoothDevice, A a) {
        super(context, bluetoothDevice, a);
    }

    private void a(byte[] bArr) {
        C0596r.d(this.z, "realtime steps:" + y.b(bArr));
        if (bArr == null) {
            C0596r.d(this.z, "bytes of realtime step is null!!");
        } else if (bArr.length == 4) {
            this.N.a(((((bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[3] & HeartRateInfo.HR_EMPTY_VALUE) << 24)) * 2, -2);
        } else if (bArr.length != 9) {
            C0596r.d(this.z, "length of realtime step byte is wrong:" + bArr.length);
        } else if (bArr[0] == u) {
            this.N.a(((((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((bArr[3] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[4] & HeartRateInfo.HR_EMPTY_VALUE) << 24)) * 2, ((((bArr[5] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[6] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((bArr[7] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[8] & HeartRateInfo.HR_EMPTY_VALUE) << 24)) * 2);
        } else {
            C0596r.d(this.z, "wrong type current!!!");
        }
        if (this.M != null) {
            this.M.a(this.N);
        }
    }

    private void b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        byte[] bArr = new byte[3];
        bArr[0] = x;
        y.a(bArr, 1, (short) (a.a & i));
        b(bluetoothGattCharacteristic, bArr);
    }

    public int A() {
        if (this.J == null) {
            return -1;
        }
        byte[] g = g(this.J);
        return (g == null || g.length != 1) ? -1 : g[0] & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public boolean B() {
        return c(this.I);
    }

    public i C() {
        i iVar = new i();
        Object g = g(this.E);
        if (g != null && g.length >= 6) {
            Object obj = new byte[6];
            System.arraycopy(g, 0, obj, 0, 6);
            iVar.c = new String(obj);
        }
        byte[] g2 = g(this.G);
        if (g2 != null && g2.length == 8) {
            iVar.a = String.format("%02X%02X%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(g2[0]), Byte.valueOf(g2[1]), Byte.valueOf(g2[2]), Byte.valueOf(g2[3]), Byte.valueOf(g2[4]), Byte.valueOf(g2[5]), Byte.valueOf(g2[6]), Byte.valueOf(g2[7])});
        }
        if (this.F != null) {
            g2 = g(this.F);
            if (g2 != null && g2.length > 0) {
                iVar.b = new String(g2);
            }
        }
        if (this.H != null) {
            g2 = g(this.H);
            if (g2 != null && g2.length == 7) {
                C0596r.e(this.z, "pnp id:" + y.b(g2));
                q qVar = new q();
                qVar.d = g2[0] & HeartRateInfo.HR_EMPTY_VALUE;
                qVar.a = ((g2[2] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (g2[1] & HeartRateInfo.HR_EMPTY_VALUE);
                qVar.b = ((g2[4] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (g2[3] & HeartRateInfo.HR_EMPTY_VALUE);
                qVar.c = (g2[5] & HeartRateInfo.HR_EMPTY_VALUE) | ((g2[6] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
                iVar.d = qVar;
            }
        }
        C0596r.d(this.z, "device info:" + iVar);
        return iVar;
    }

    public i D() {
        return this.L;
    }

    public boolean E() {
        return c(this.C);
    }

    public boolean F() {
        return c(this.D);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r21, com.xiaomi.hm.health.bt.d.b r22) {
        /*
        r20 = this;
        r2 = 0;
        r11 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r4 = 0;
        r3 = k;
        r0 = r20;
        r3 = r0.a(r3);
        if (r3 != 0) goto L_0x0019;
    L_0x000e:
        r0 = r20;
        r2 = r0.z;
        r3 = "service dfu is null!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = 1;
    L_0x0018:
        return r2;
    L_0x0019:
        r5 = l;
        r12 = r3.getCharacteristic(r5);
        r5 = m;
        r13 = r3.getCharacteristic(r5);
        if (r12 == 0) goto L_0x0029;
    L_0x0027:
        if (r13 != 0) goto L_0x0034;
    L_0x0029:
        r0 = r20;
        r2 = r0.z;
        r3 = "BluetoothGattCharacteristic cpt or pkt is null!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = 1;
        goto L_0x0018;
    L_0x0034:
        r3 = new com.xiaomi.hm.health.bt.profile.b.h;
        r0 = r20;
        r3.<init>(r0, r12);
        r0 = r20;
        r3 = r0.b(r12, r3);
        if (r3 != 0) goto L_0x004e;
    L_0x0043:
        r0 = r20;
        r2 = r0.z;
        r3 = "Fail subscribe to DFU control point!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = 1;
        goto L_0x0018;
    L_0x004e:
        r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0449, all -> 0x046e }
        r0 = r21;
        r5.<init>(r0);	 Catch:{ Exception -> 0x0449, all -> 0x046e }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0449, all -> 0x046e }
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0449, all -> 0x046e }
        r6.<init>(r5);	 Catch:{ Exception -> 0x0449, all -> 0x046e }
        r3.<init>(r6);	 Catch:{ Exception -> 0x0449, all -> 0x046e }
        r4 = r5.length();	 Catch:{ Exception -> 0x0485 }
        r4 = (int) r4;	 Catch:{ Exception -> 0x0485 }
        r4 = r4 << 8;
        r4 = r4 | 1;
        r5 = 4;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0485 }
        r6 = 0;
        com.xiaomi.hm.health.bt.c.y.a(r5, r6, r4);	 Catch:{ Exception -> 0x0485 }
        r14 = r4 >> 8;
        r4 = 0;
        r0 = r20;
        r0.O = r4;	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r0.b(r12, r5);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 != 0) goto L_0x0089;
    L_0x0084:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0485 }
    L_0x0089:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 == 0) goto L_0x00b6;
    L_0x008f:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0485 }
        r5 = 3;
        if (r4 < r5) goto L_0x00b6;
    L_0x0097:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 16;
        if (r4 != r5) goto L_0x00b6;
    L_0x00a2:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        if (r4 != r5) goto L_0x00b6;
    L_0x00ac:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        if (r4 == r5) goto L_0x0101;
    L_0x00b6:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0485 }
        r4.<init>();	 Catch:{ Exception -> 0x0485 }
        r5 = "Invalid response: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r5 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = com.xiaomi.hm.health.bt.c.y.b(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r5 = ",lenght:";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r5 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = r5.length;	 Catch:{ Exception -> 0x0485 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x00ed;
    L_0x00ea:
        r3.close();	 Catch:{ IOException -> 0x00f6 }
    L_0x00ed:
        if (r12 == 0) goto L_0x0018;
    L_0x00ef:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x00f6:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x00ed;
    L_0x0101:
        r4 = 0;
        r0 = r20;
        r0.O = r4;	 Catch:{ Exception -> 0x0485 }
        r4 = 1;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r6 = 3;
        r4[r5] = r6;	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r4 = r0.b(r12, r4);	 Catch:{ Exception -> 0x0485 }
        if (r4 != 0) goto L_0x0138;
    L_0x0115:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = "write DFU_OPCODE_TRANSFER failed!!!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x0124;
    L_0x0121:
        r3.close();	 Catch:{ IOException -> 0x012d }
    L_0x0124:
        if (r12 == 0) goto L_0x0018;
    L_0x0126:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x012d:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0124;
    L_0x0138:
        r4 = 20;
        r9 = new byte[r4];	 Catch:{ Exception -> 0x0485 }
        if (r22 == 0) goto L_0x0143;
    L_0x013e:
        r0 = r22;
        r0.setMax(r14);	 Catch:{ Exception -> 0x0485 }
    L_0x0143:
        r7 = 0;
        r5 = 0;
        r6 = 0;
        r4 = 0;
        r0 = r20;
        r10 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0485 }
        r15.<init>();	 Catch:{ Exception -> 0x0485 }
        r16 = "Device firmware: ";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0485 }
        r0 = r21;
        r15 = r15.append(r0);	 Catch:{ Exception -> 0x0485 }
        r16 = ", ";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0485 }
        r15 = r15.append(r14);	 Catch:{ Exception -> 0x0485 }
        r16 = " bytes";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x0485 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.d(r10, r15);	 Catch:{ Exception -> 0x0485 }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0485 }
        r10 = r8;
        r8 = r5;
        r5 = r9;
        r19 = r4;
        r4 = r7;
        r7 = r19;
    L_0x017f:
        r9 = 1999; // 0x7cf float:2.801E-42 double:9.876E-321;
        r4 = r4 + r6;
        if (r9 >= r4) goto L_0x01c5;
    L_0x0184:
        r4 = 0;
        r0 = r20;
        r6 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r9 = "Insert write request to clear GKI buffer!";
        cn.com.smartdevices.bracelet.C0596r.e(r6, r9);	 Catch:{ Exception -> 0x0485 }
        r6 = 1;
        r6 = new byte[r6];	 Catch:{ Exception -> 0x0485 }
        r9 = 0;
        r15 = 0;
        r6[r9] = r15;	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r6 = r0.b(r12, r6);	 Catch:{ Exception -> 0x0485 }
        if (r6 != 0) goto L_0x01c5;
    L_0x019d:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = "write DFU_OPCODE_DUMMY failed!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r0.b(r12, r10);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x01b1;
    L_0x01ae:
        r3.close();	 Catch:{ IOException -> 0x01ba }
    L_0x01b1:
        if (r12 == 0) goto L_0x0018;
    L_0x01b3:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x01ba:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x01b1;
    L_0x01c5:
        r6 = r4;
        r4 = 0;
        r9 = r5.length;	 Catch:{ Exception -> 0x0485 }
        r9 = r3.read(r5, r4, r9);	 Catch:{ Exception -> 0x0485 }
        r4 = 1;
        if (r9 >= r4) goto L_0x023d;
    L_0x01cf:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 != 0) goto L_0x01da;
    L_0x01d5:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0485 }
    L_0x01da:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 == 0) goto L_0x0207;
    L_0x01e0:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0485 }
        r5 = 3;
        if (r4 < r5) goto L_0x0207;
    L_0x01e8:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 16;
        if (r4 != r5) goto L_0x0207;
    L_0x01f3:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 3;
        if (r4 != r5) goto L_0x0207;
    L_0x01fd:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        if (r4 == r5) goto L_0x02bf;
    L_0x0207:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0485 }
        r4.<init>();	 Catch:{ Exception -> 0x0485 }
        r5 = "Invalid response: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r5 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = com.xiaomi.hm.health.bt.c.y.b(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r0.b(r12, r10);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x0234;
    L_0x0231:
        r3.close();	 Catch:{ IOException -> 0x02b3 }
    L_0x0234:
        if (r12 == 0) goto L_0x0018;
    L_0x0236:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x023d:
        r4 = 0;
        r10 = com.xiaomi.hm.health.bt.c.y.a(r10, r5, r4, r9);	 Catch:{ Exception -> 0x0485 }
        r4 = r5.length;	 Catch:{ Exception -> 0x0485 }
        if (r9 >= r4) goto L_0x0492;
    L_0x0245:
        r4 = new byte[r9];	 Catch:{ Exception -> 0x0485 }
        r15 = 0;
        r18 = 0;
        r0 = r18;
        java.lang.System.arraycopy(r5, r15, r4, r0, r9);	 Catch:{ Exception -> 0x0485 }
    L_0x024f:
        r0 = r20;
        r5 = r0.b(r13, r4);	 Catch:{ Exception -> 0x0485 }
        if (r5 != 0) goto L_0x027f;
    L_0x0257:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = "write firmware data failed!!!";
        cn.com.smartdevices.bracelet.C0596r.e(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r0.b(r12, r10);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x026b;
    L_0x0268:
        r3.close();	 Catch:{ IOException -> 0x0274 }
    L_0x026b:
        if (r12 == 0) goto L_0x0018;
    L_0x026d:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x0274:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x026b;
    L_0x027f:
        r15 = r8 * r14;
        r5 = r7 + r9;
        r7 = r5 * 100;
        if (r15 >= r7) goto L_0x048d;
    L_0x0287:
        r7 = r5 * 100;
        r7 = r7 / r14;
        r0 = r20;
        r8 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0485 }
        r15.<init>();	 Catch:{ Exception -> 0x0485 }
        r18 = "transfer sum:";
        r0 = r18;
        r15 = r15.append(r0);	 Catch:{ Exception -> 0x0485 }
        r15 = r15.append(r5);	 Catch:{ Exception -> 0x0485 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.e(r8, r15);	 Catch:{ Exception -> 0x0485 }
        if (r22 == 0) goto L_0x0487;
    L_0x02a8:
        r0 = r22;
        r0.report(r5);	 Catch:{ Exception -> 0x0485 }
        r8 = r7;
        r7 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x017f;
    L_0x02b3:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0234;
    L_0x02bf:
        r0 = r20;
        r4 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r5 = "DFU transfer rate: %.1f KBps";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0485 }
        r7 = 0;
        r8 = (float) r14;	 Catch:{ Exception -> 0x0485 }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0485 }
        r14 = r14 - r16;
        r9 = (float) r14;	 Catch:{ Exception -> 0x0485 }
        r8 = r8 / r9;
        r8 = java.lang.Float.valueOf(r8);	 Catch:{ Exception -> 0x0485 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0485 }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.d(r4, r5);	 Catch:{ Exception -> 0x0485 }
        r4 = 3;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r6 = 4;
        r4[r5] = r6;	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        r6 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r10;
        r6 = (short) r6;	 Catch:{ Exception -> 0x0485 }
        com.xiaomi.hm.health.bt.c.y.a(r4, r5, r6);	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r0 = r20;
        r0.O = r5;	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r0.b(r12, r4);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 != 0) goto L_0x0304;
    L_0x02ff:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0485 }
    L_0x0304:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 == 0) goto L_0x0331;
    L_0x030a:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0485 }
        r5 = 3;
        if (r4 < r5) goto L_0x0331;
    L_0x0312:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 16;
        if (r4 != r5) goto L_0x0331;
    L_0x031d:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 4;
        if (r4 != r5) goto L_0x0331;
    L_0x0327:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        if (r4 == r5) goto L_0x0397;
    L_0x0331:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0485 }
        r4.<init>();	 Catch:{ Exception -> 0x0485 }
        r5 = "Invalid response: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r5 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = com.xiaomi.hm.health.bt.c.y.b(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0485 }
        r4.<init>();	 Catch:{ Exception -> 0x0485 }
        r5 = "Firmware CRC: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r5 = "%04X";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0485 }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0485 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0485 }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0485 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0485 }
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x0383;
    L_0x0380:
        r3.close();	 Catch:{ IOException -> 0x038c }
    L_0x0383:
        if (r12 == 0) goto L_0x0018;
    L_0x0385:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x038c:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0383;
    L_0x0397:
        r0 = r20;
        r4 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r5 = "reboot..................";
        cn.com.smartdevices.bracelet.C0596r.d(r4, r5);	 Catch:{ Exception -> 0x0485 }
        r4 = 0;
        r0 = r20;
        r0.O = r4;	 Catch:{ Exception -> 0x0485 }
        r4 = 1;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r6 = 5;
        r4[r5] = r6;	 Catch:{ Exception -> 0x0485 }
        r0 = r20;
        r4 = r0.b(r12, r4);	 Catch:{ Exception -> 0x0485 }
        if (r4 != 0) goto L_0x03d7;
    L_0x03b4:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = "Fail to issue restart command!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x03c3;
    L_0x03c0:
        r3.close();	 Catch:{ IOException -> 0x03cc }
    L_0x03c3:
        if (r12 == 0) goto L_0x0018;
    L_0x03c5:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x03cc:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x03c3;
    L_0x03d7:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 != 0) goto L_0x03e2;
    L_0x03dd:
        r0 = r20;
        r0.a(r12, r11);	 Catch:{ Exception -> 0x0485 }
    L_0x03e2:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        if (r4 == 0) goto L_0x040f;
    L_0x03e8:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r4 = r4.length;	 Catch:{ Exception -> 0x0485 }
        r5 = 3;
        if (r4 < r5) goto L_0x040f;
    L_0x03f0:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 16;
        if (r4 != r5) goto L_0x040f;
    L_0x03fb:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 5;
        if (r4 != r5) goto L_0x040f;
    L_0x0405:
        r0 = r20;
        r4 = r0.O;	 Catch:{ Exception -> 0x0485 }
        r5 = 2;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0485 }
        r5 = 1;
        if (r4 == r5) goto L_0x0432;
    L_0x040f:
        r0 = r20;
        r2 = r0.z;	 Catch:{ Exception -> 0x0485 }
        r4 = "Fail to wait restart command response!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ Exception -> 0x0485 }
        r2 = 1;
        if (r3 == 0) goto L_0x041e;
    L_0x041b:
        r3.close();	 Catch:{ IOException -> 0x0427 }
    L_0x041e:
        if (r12 == 0) goto L_0x0018;
    L_0x0420:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x0427:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x041e;
    L_0x0432:
        r20.c();	 Catch:{ Exception -> 0x0485 }
        if (r3 == 0) goto L_0x043a;
    L_0x0437:
        r3.close();	 Catch:{ IOException -> 0x043e }
    L_0x043a:
        if (r12 == 0) goto L_0x0018;
    L_0x043c:
        goto L_0x0018;
    L_0x043e:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x043a;
    L_0x0449:
        r2 = move-exception;
        r3 = r4;
    L_0x044b:
        r0 = r20;
        r2 = r0.z;	 Catch:{ all -> 0x0483 }
        r4 = "exception happend!!";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r4);	 Catch:{ all -> 0x0483 }
        r2 = 1;
        if (r3 == 0) goto L_0x045a;
    L_0x0457:
        r3.close();	 Catch:{ IOException -> 0x0463 }
    L_0x045a:
        if (r12 == 0) goto L_0x0018;
    L_0x045c:
        r0 = r20;
        r0.c(r12);
        goto L_0x0018;
    L_0x0463:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x045a;
    L_0x046e:
        r2 = move-exception;
        r3 = r4;
    L_0x0470:
        if (r3 == 0) goto L_0x0475;
    L_0x0472:
        r3.close();	 Catch:{ IOException -> 0x0478 }
    L_0x0475:
        if (r12 == 0) goto L_0x0477;
    L_0x0477:
        throw r2;
    L_0x0478:
        r3 = move-exception;
        r0 = r20;
        r3 = r0.z;
        r4 = "Fail to operate on the firmware file";
        cn.com.smartdevices.bracelet.C0596r.d(r3, r4);
        goto L_0x0475;
    L_0x0483:
        r2 = move-exception;
        goto L_0x0470;
    L_0x0485:
        r2 = move-exception;
        goto L_0x044b;
    L_0x0487:
        r8 = r7;
        r7 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x017f;
    L_0x048d:
        r7 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x017f;
    L_0x0492:
        r4 = r5;
        goto L_0x024f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.hm.health.bt.profile.b.f.a(java.lang.String, com.xiaomi.hm.health.bt.d.b):int");
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

    public void a(d dVar) {
        this.M = dVar;
    }

    public boolean a(byte b) {
        return b(this.C, new byte[]{b});
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        C0596r.e();
        if (this.K == null) {
            BluetoothGattService a = a(k);
            if (a == null) {
                return false;
            }
            BluetoothGattCharacteristic characteristic = a.getCharacteristic(s);
            this.K = characteristic;
            if (characteristic == null) {
                return false;
            }
        }
        byte[] bArr = new byte[]{(byte) -1, (byte) -1};
        if (!b(this.K, new i(this, bArr))) {
            return false;
        }
        boolean b = b(this.K, new byte[]{(byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i2 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i2 >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i3 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i3 >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i4 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i4 >> 8) & HeartRateInfo.HR_EMPTY_VALUE)});
        if (b && bArr[0] == (byte) -1) {
            synchronized (this.K) {
                try {
                    this.K.wait(8000);
                } catch (Exception e) {
                }
            }
        }
        c(this.K);
        int i6 = (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        if (!b || i6 < i || i6 > i2) {
            z = false;
        }
        return z;
    }

    public boolean a(B b) {
        return b(this.I, b);
    }

    public boolean a(Calendar calendar) {
        C0596r.e();
        short s = (short) calendar.get(1);
        byte b = (byte) (calendar.get(2) + 1);
        byte b2 = (byte) calendar.get(5);
        byte b3 = (byte) calendar.get(11);
        byte b4 = (byte) calendar.get(12);
        byte b5 = (byte) calendar.get(13);
        y.a(new byte[2], 0, s);
        byte b6 = (byte) calendar.get(7);
        C0596r.d(this.z, "set date:" + calendar.getTime().toString());
        C0596r.d(this.z, "year:" + s + ",month:" + b + ",day:" + b2 + ",hour:" + b3 + ",min:" + b4 + ",sec:" + b5);
        return b(this.A, new byte[]{r6[0], r6[1], b, b2, b3, b4, b5, b6, (byte) 0, (byte) 0});
    }

    public boolean b(B b) {
        return b(this.C, b);
    }

    public boolean b(boolean z) {
        int i = 1;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.I;
        byte[] bArr = new byte[1];
        if (!z) {
            i = 0;
        }
        bArr[0] = (byte) i;
        return b(bluetoothGattCharacteristic, bArr);
    }

    public boolean c(B b) {
        return b(this.D, b);
    }

    public boolean c(boolean z) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.C;
        byte[] bArr = new byte[1];
        bArr[0] = z ? C0374dh.n : (byte) 17;
        return b(bluetoothGattCharacteristic, bArr);
    }

    @SuppressLint({"NewApi"})
    protected boolean t() {
        boolean z = false;
        Object a = a(q_);
        C0596r.a(a);
        if (a == null) {
            C0596r.d(this.z, "UUID_SERVICE_MILI_SERVICE is null!!!");
        } else {
            this.A = a.getCharacteristic(v_);
            C0596r.a(this.A);
            if (this.A == null) {
                C0596r.d(this.z, "UUID_CHARACTERISTIC_DATE_TIME is null!!!");
            } else {
                this.B = a.getCharacteristic(r_);
                C0596r.a(this.B);
                if (this.B == null) {
                    C0596r.d(this.z, "UUID_CHARACTERISTIC_REALTIME_STEPS is null!!!");
                } else {
                    this.C = a.getCharacteristic(f);
                    C0596r.a(this.C);
                    if (this.C == null) {
                        C0596r.d(this.z, "UUID_CHARACTERISTIC_ACTIVITY_DATA_CONTROL_POINT is null!!!");
                    } else {
                        this.D = a.getCharacteristic(s_);
                        C0596r.a(this.D);
                        if (this.D == null) {
                            C0596r.d(this.z, "UUID_CHARACTERISTIC_ACTIVITY_DATA is null!!!");
                        } else {
                            this.I = a.getCharacteristic(t_);
                            C0596r.a(this.I);
                            if (this.I == null) {
                                C0596r.d(this.z, "UUID_CHARACTERISTIC_SENSOR_DATA is null!!!");
                            } else {
                                this.J = a.getCharacteristic(u_);
                                if (this.J == null) {
                                    C0596r.d(this.z, "UUID_CHARACTERISTIC_BATTERY_INFO is null!!!");
                                }
                                a = a(n);
                                C0596r.a(a);
                                if (a == null) {
                                    C0596r.d(this.z, "UUID_SERVICE_DEVICE_SERVICE is null!!!");
                                } else {
                                    this.E = a.getCharacteristic(p);
                                    C0596r.a(this.E);
                                    if (this.E == null) {
                                        C0596r.d(this.z, "UUID_CHARACTERISTIC_DEVICE_SOFTWARE_REVISION is null!!!");
                                    } else {
                                        this.G = a.getCharacteristic(q);
                                        C0596r.a(this.G);
                                        if (this.G == null) {
                                            C0596r.d(this.z, "UUID_CHARACTERISTIC_DEVICE_SYSTEM_ID is null!!!");
                                        } else {
                                            this.F = a.getCharacteristic(o);
                                            C0596r.a(this.F);
                                            this.H = a.getCharacteristic(r);
                                            C0596r.a(this.H);
                                            C0596r.d(this.z, "before set deviceTime:" + new Date(z().getTimeInMillis()).toString());
                                            this.L = C();
                                            C0596r.d(this.z, "deviceInfo:" + this.L);
                                            if (!a(Calendar.getInstance())) {
                                                C0596r.d(this.z, "setDateTime failed!!!");
                                            }
                                            C0596r.d(this.z, "after set deviceTime:" + new Date(z().getTimeInMillis()).toString());
                                            a(g(this.B));
                                            z = b(this.B, new g(this));
                                            if (!z) {
                                                C0596r.d(this.z, "registerNotification  UUID_CHARACTERISTIC_REALTIME_STEPS failed!!!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public p x() {
        C0596r.e();
        if (this.K == null) {
            BluetoothGattService a = a(k);
            if (a == null) {
                return null;
            }
            BluetoothGattCharacteristic characteristic = a.getCharacteristic(s);
            this.K = characteristic;
            if (characteristic == null) {
                return null;
            }
        }
        byte[] g = g(this.K);
        if (g == null || g.length == 0) {
            return null;
        }
        C0596r.a(g.length == 8);
        return new p(((g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & a.a, ((g[2] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[3] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & a.a, ((g[4] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[5] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & a.a, ((g[6] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[7] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & a.a, -1, -1);
    }

    public m y() {
        return this.N;
    }

    public Calendar z() {
        C0596r.e();
        byte[] g = g(this.A);
        if (g == null || g.length != 10) {
            return null;
        }
        C0596r.a(g.length == 10);
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, (g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8));
        gregorianCalendar.set(2, g[2] - 1);
        gregorianCalendar.set(5, g[3]);
        gregorianCalendar.set(11, g[4]);
        gregorianCalendar.set(12, g[5]);
        gregorianCalendar.set(13, g[6]);
        return gregorianCalendar;
    }
}
