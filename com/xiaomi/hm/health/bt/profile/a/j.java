package com.xiaomi.hm.health.bt.profile.a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Pair;
import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.C1012a;
import com.xiaomi.hm.health.bt.c.A;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.C;
import com.xiaomi.hm.health.bt.c.x;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.d.c;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.UserInfo;
import com.xiaomi.hm.health.bt.model.f;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.model.p;
import com.xiaomi.hm.health.bt.model.q;
import com.xiaomi.hm.health.bt.model.s;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class j extends x implements a {
    private static final byte aA = (byte) 8;
    private static final byte aB = (byte) 9;
    private static final byte aC = (byte) 10;
    private static final byte aD = (byte) 11;
    private static final byte aE = (byte) 12;
    private static final byte aF = (byte) 14;
    private static final byte aG = (byte) 15;
    private static final byte aH = (byte) 20;
    private static final byte aI = (byte) 17;
    private static final byte aJ = (byte) 18;
    private static final byte aK = (byte) 19;
    private static final byte aL = (byte) 1;
    private static final byte aM = (byte) 2;
    private static final byte aN = (byte) 3;
    private static final byte aO = (byte) 5;
    public static final String af = "2.0.0.20140514";
    public static final String ag = (au + ".INTENT_ACTION_INITIALIZATION_SUCCESS");
    public static final String ah = (au + ".INTENT_ACTION_INITIALIZATION_FAILED");
    public static final String ai = (au + ".INTENT_ACTION_AUTHENTICATION_SUCCESS");
    public static final String aj = (au + ".INTENT_ACTION_AUTHENTICATION_FAILED");
    public static final String ak = (au + ".INTENT_ACTION_DEVICE_STATUS_CHANGED");
    public static final String al = (au + ".INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED");
    public static final byte am = (byte) 0;
    public static final byte an = (byte) 1;
    public static final byte ao = (byte) 2;
    public static final byte ap = (byte) 20;
    public static final byte aq = (byte) 21;
    private static final String ar = "MiLiProfile";
    private static final String as = j.class.getPackage().getName();
    private static final String at = j.class.getSimpleName();
    private static final String au = (as + "." + at);
    private static final byte av = (byte) 3;
    private static final byte aw = (byte) 4;
    private static final byte ax = (byte) 5;
    private static final byte ay = (byte) 6;
    private static final byte az = (byte) 7;
    private BluetoothGattCharacteristic aP = null;
    private BluetoothGattCharacteristic aQ = null;
    private BluetoothGattCharacteristic aR = null;
    private BluetoothGattCharacteristic aS = null;
    private BluetoothGattCharacteristic aT = null;
    private BluetoothGattCharacteristic aU = null;
    private BluetoothGattCharacteristic aV = null;
    private BluetoothGattCharacteristic aW = null;
    private BluetoothGattCharacteristic aX = null;
    private BluetoothGattCharacteristic aY = null;
    private BluetoothGattCharacteristic aZ = null;
    private BluetoothGattCharacteristic ba = null;
    private BluetoothGattCharacteristic bb = null;
    private BluetoothGattCharacteristic bc = null;
    private BluetoothGattCharacteristic bd = null;
    private BluetoothGattCharacteristic be = null;
    private BluetoothGattCharacteristic bf = null;
    private BluetoothGattCharacteristic bg = null;
    private BluetoothGattCharacteristic bh = null;
    private BluetoothGattCharacteristic bi = null;
    private BluetoothGattCharacteristic bj = null;
    private BluetoothGattCharacteristic bk = null;
    private h bl = null;
    private f bm = null;
    private b bn = null;
    private c bo = null;
    private int bp = -1;
    private e bq = null;
    private boolean br = false;
    private Integer bs = Integer.valueOf(-1);
    private Integer bt = Integer.valueOf(-1);
    private Integer bu = Integer.valueOf(-1);

    static {
        C0596r.d(j.class.getSimpleName() + ".VERSION: " + af);
    }

    public j(Context context, BluetoothDevice bluetoothDevice, A a) {
        super(context, bluetoothDevice, a);
        C0596r.e();
    }

    private static void X() {
    }

    private static void Y() {
    }

    private boolean e(int i) {
        switch (i) {
            case l.a /*1*/:
            case a.k /*2*/:
            case a.aW /*11*/:
            case a.be /*12*/:
                this.bs = Integer.valueOf(i);
                a((Object) this.aW);
                return true;
            case a.X /*5*/:
            case a.bt /*6*/:
            case a.bo /*9*/:
            case a.bd /*10*/:
                this.bt = Integer.valueOf(i);
                a((Object) this.aS);
                return true;
            case a.ba /*8*/:
                this.bu = Integer.valueOf(i);
                a((Object) this.aX);
                return true;
            default:
                return false;
        }
    }

    public i A() {
        byte[] g;
        i iVar = new i();
        if (this.bg != null) {
            Object g2 = g(this.bg);
            if (g2 != null && g2.length >= 6) {
                Object obj = new byte[6];
                System.arraycopy(g2, 0, obj, 0, 6);
                iVar.c = new String(obj);
            }
        }
        if (this.bi != null) {
            g = g(this.bi);
            if (g != null && g.length == 8) {
                iVar.a = String.format("%02X%02X%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(g[0]), Byte.valueOf(g[1]), Byte.valueOf(g[2]), Byte.valueOf(g[3]), Byte.valueOf(g[4]), Byte.valueOf(g[5]), Byte.valueOf(g[6]), Byte.valueOf(g[7])});
            }
        }
        if (this.bh != null) {
            g = g(this.bh);
            if (g != null && g.length > 0) {
                iVar.b = new String(g);
            }
        }
        if (this.bj != null) {
            g = g(this.bj);
            if (g != null && g.length == 7) {
                C0596r.e(ar, "pnp id:" + y.b(g));
                q qVar = new q();
                qVar.d = g[0] & HeartRateInfo.HR_EMPTY_VALUE;
                qVar.a = ((g[2] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (g[1] & HeartRateInfo.HR_EMPTY_VALUE);
                qVar.b = ((g[4] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (g[3] & HeartRateInfo.HR_EMPTY_VALUE);
                qVar.c = (g[5] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[6] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
                iVar.d = qVar;
            }
        }
        C0596r.d(ar, "general device info:" + iVar);
        return iVar;
    }

    public h B() {
        C0596r.e();
        return this.bl;
    }

    public void C() {
        this.bt = Integer.valueOf(a.ac);
        if (this.aS != null) {
            a((Object) this.aS);
        }
    }

    public boolean D() {
        C0596r.e();
        return b(this.aT, new byte[]{aI});
    }

    public boolean E() {
        C0596r.e();
        return b(this.aT, new byte[]{aD});
    }

    public boolean F() {
        C0596r.e();
        if (this.bd == null) {
            return false;
        }
        return b(this.bd, new byte[]{ao});
    }

    public UserInfo G() {
        int i = 0;
        C0596r.e();
        byte[] g = g(this.aS);
        C0596r.a((Object) g);
        if (g == null || g.length == 0) {
            return null;
        }
        int i2;
        C0596r.a(g.length == 20);
        byte[] bArr = new byte[19];
        for (i2 = 0; i2 < 19; i2++) {
            bArr[i2] = g[i2];
        }
        i2 = y.d(bArr);
        String address = f().getAddress();
        if (g[19] != ((byte) (i2 ^ Integer.decode("0x" + address.substring(address.length() - 2)).intValue()))) {
            return null;
        }
        int a = y.a(g, 0);
        byte b = g[4];
        byte b2 = g[5];
        byte b3 = g[6];
        byte b4 = g[7];
        byte[] bArr2 = new byte[11];
        while (i < bArr2.length) {
            bArr2[i] = g[i + 8];
            i++;
        }
        return new UserInfo(a, b, b2, b3, b4, bArr2);
    }

    public String H() {
        C0596r.e();
        byte[] g = g(this.aQ);
        return g == null ? null : new String(g);
    }

    public Pair<Calendar, Calendar> I() {
        C0596r.e();
        byte[] g = g(this.aY);
        if (g == null || g.length == 0) {
            return null;
        }
        C0596r.a(g.length == 12);
        Calendar gregorianCalendar = new GregorianCalendar();
        Calendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar.set(1, g[0] + a.bZ);
        gregorianCalendar.set(2, g[1]);
        gregorianCalendar.set(5, g[2]);
        gregorianCalendar.set(11, g[3]);
        gregorianCalendar.set(12, g[4]);
        gregorianCalendar.set(13, g[5]);
        gregorianCalendar2.set(1, g[6] + a.bZ);
        gregorianCalendar2.set(2, g[7]);
        gregorianCalendar2.set(5, g[8]);
        gregorianCalendar2.set(11, g[9]);
        gregorianCalendar2.set(12, g[10]);
        gregorianCalendar2.set(13, g[11]);
        return new Pair(gregorianCalendar, gregorianCalendar2);
    }

    public s J() {
        C0596r.e();
        if (this.aZ == null) {
            return null;
        }
        byte[] g = g(this.aZ);
        if (g == null) {
            return null;
        }
        C0596r.a(g.length == 20);
        return new s((int) (((double) y.a(g, 0)) / 1.6d), y.a(g, 4), y.a(g, 8), y.a(g, 12), y.a(g, 16));
    }

    public boolean K() {
        C0596r.e();
        return true;
    }

    public f L() {
        C0596r.e();
        byte[] g = g(this.ba);
        if (g == null || g.length == 0) {
            return null;
        }
        C0596r.a(g.length == 10);
        byte b = g[0];
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, g[1] + a.bZ);
        gregorianCalendar.set(2, g[2]);
        gregorianCalendar.set(5, g[3]);
        gregorianCalendar.set(11, g[4]);
        gregorianCalendar.set(12, g[5]);
        gregorianCalendar.set(13, g[6]);
        this.bm = new f(b, gregorianCalendar, ((g[7] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[8] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a, g[9]);
        return this.bm;
    }

    public boolean M() {
        C0596r.e();
        return true;
    }

    public f N() {
        return this.bm;
    }

    public int O() {
        byte[] g = g(this.bb);
        if (g == null || g.length != 4) {
            return -1;
        }
        return ((g[3] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | (((g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((g[2] & HeartRateInfo.HR_EMPTY_VALUE) << 16));
    }

    @Deprecated
    public boolean P() {
        C0596r.e();
        return b(this.aT, new byte[]{aK});
    }

    public boolean Q() {
        C0596r.e();
        return b(this.aT, new byte[]{aB});
    }

    public boolean R() {
        C0596r.e();
        return b(this.aT, new byte[]{aE});
    }

    public boolean S() {
        C0596r.e();
        return b(this.bb, new byte[]{an});
    }

    public boolean T() {
        C0596r.e();
        return b(this.bb, new byte[]{ao});
    }

    public boolean U() {
        return b(this.aT, new byte[]{ay});
    }

    public void V() {
        b(this.aV);
    }

    public com.xiaomi.hm.health.bt.model.j W() {
        boolean z = false;
        C0596r.e();
        if (this.bf == null) {
            return null;
        }
        byte[] g = g(this.bf);
        if (g == null || g.length < 2) {
            return null;
        }
        if ((g[0] & HeartRateInfo.HR_EMPTY_VALUE) == 1) {
            z = true;
        }
        return new com.xiaomi.hm.health.bt.model.j(z, g[1] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public void a(B b) {
        a(this.aV, b);
    }

    public void a(c cVar) {
        this.bo = cVar;
    }

    public void a(b bVar) {
        this.bn = bVar;
    }

    @Deprecated
    public boolean a(byte b) {
        C0596r.e();
        return b(this.aT, new byte[]{aA, b});
    }

    public boolean a(byte b, byte b2) {
        C0596r.e();
        if (this.bf == null) {
            return false;
        }
        return b(this.bf, new byte[]{aq, b, b2});
    }

    public boolean a(byte b, byte b2, byte b3, byte b4) {
        return b(this.aT, new byte[]{aF, b, b2, b3, b4});
    }

    public boolean a(byte b, byte b2, Calendar calendar, byte b3, byte b4) {
        C0596r.e();
        byte b5 = (byte) (calendar.get(1) - 2000);
        byte b6 = (byte) calendar.get(2);
        byte b7 = (byte) calendar.get(5);
        byte b8 = (byte) calendar.get(11);
        byte b9 = (byte) calendar.get(12);
        byte b10 = (byte) calendar.get(13);
        return b(this.aT, new byte[]{aw, b, b2, b5, b6, b7, b8, b9, b10, b3, b4});
    }

    public boolean a(byte b, int i) {
        C0596r.e();
        return b(this.aT, new byte[]{ax, b, (byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE)});
    }

    public boolean a(int i, int i2, int i3, int i4) {
        boolean z = true;
        C0596r.e();
        this.bs = Integer.valueOf(-1);
        if (!b(this.aT, new byte[]{az, (byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24), (byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24), (byte) i3, (byte) (i3 >> 8), (byte) i4, (byte) (i4 >> 8)})) {
            return false;
        }
        if (this.bs.intValue() == -1) {
            a(this.aT, com.f.a.b.d.a.a);
        }
        if (this.bs.intValue() != 12) {
            z = false;
        }
        return z;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        C0596r.e();
        this.bu = Integer.valueOf(-1);
        if (!b(this.aX, new byte[]{(byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i2 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i2 >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i3 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i3 >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i4 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i4 >> 8) & HeartRateInfo.HR_EMPTY_VALUE), am, am, (byte) (i5 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i5 >> 8) & HeartRateInfo.HR_EMPTY_VALUE)})) {
            return false;
        }
        if (this.bu.intValue() == -1) {
            a(this.aX, a.bS);
        }
        if (this.bu.intValue() != 8) {
            z = false;
        }
        return z;
    }

    public boolean a(UserInfo userInfo) {
        C0596r.e();
        boolean b = b(userInfo);
        C0596r.a(b);
        if (!b) {
            return false;
        }
        b = a(Calendar.getInstance());
        C0596r.a(b);
        return b;
    }

    public boolean a(UserInfo userInfo, com.xiaomi.hm.health.bt.d.a aVar) {
        this.bt = Integer.valueOf(-1);
        if (b(userInfo)) {
            if (this.bt.intValue() == -1) {
                a(this.aS, C1012a.b);
            }
            if (this.bt.intValue() == -1) {
                aVar.f();
                return false;
            } else if (this.bt.intValue() == 6) {
                aVar.c();
                this.bt = Integer.valueOf(-1);
                a(this.aS, a.as);
                if (this.bt.intValue() == -1) {
                    aVar.f();
                    return false;
                } else if (this.bt.intValue() == 9) {
                    aVar.d();
                    return false;
                } else if (this.bt.intValue() == 10) {
                    aVar.e();
                    return true;
                } else {
                    aVar.g();
                    return false;
                }
            } else if (this.bt.intValue() == 5) {
                aVar.b();
                return true;
            } else {
                aVar.g();
                return false;
            }
        }
        aVar.a();
        return false;
    }

    public boolean a(String str) {
        C0596r.e();
        return b(this.aQ, str.getBytes());
    }

    public boolean a(Calendar calendar) {
        C0596r.e();
        byte b = (byte) (calendar.get(1) - 2000);
        byte b2 = (byte) calendar.get(2);
        byte b3 = (byte) calendar.get(5);
        byte b4 = (byte) calendar.get(11);
        byte b5 = (byte) calendar.get(12);
        byte b6 = (byte) calendar.get(13);
        return b(this.aY, new byte[]{b, b2, b3, b4, b5, b6, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1});
    }

    public boolean a(Calendar calendar, int i) {
        C0596r.e();
        byte b = (byte) (calendar.get(1) - 2000);
        byte b2 = (byte) calendar.get(2);
        byte b3 = (byte) calendar.get(5);
        byte b4 = (byte) calendar.get(11);
        byte b5 = (byte) calendar.get(12);
        byte b6 = (byte) calendar.get(13);
        return b(this.aT, new byte[]{aC, b, b2, b3, b4, b5, b6, (byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE)});
    }

    public boolean a(short s, short s2, byte b) {
        if (this.bk == null) {
            return false;
        }
        return b(this.bk, new byte[]{(byte) -1, (byte) (s & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((s >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (s2 & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((s2 >> 8) & HeartRateInfo.HR_EMPTY_VALUE), b});
    }

    public boolean a(boolean z, e eVar) {
        C0596r.e();
        this.bq = eVar;
        return true;
    }

    public boolean a(byte[] bArr) {
        int i = 0;
        C0596r.a(bArr.length == 16);
        byte[] bArr2 = new byte[17];
        bArr2[0] = aw;
        while (i < 16) {
            bArr2[i + 1] = bArr[i];
            i++;
        }
        return b(this.bb, bArr2);
    }

    public boolean a(byte[] bArr, b bVar) {
        C0596r.e();
        int length = bArr.length;
        int i = length / 20;
        C0596r.a("totalPackets = " + i);
        if (bVar != null) {
            bVar.setMax(length);
        }
        this.bs = Integer.valueOf(-1);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5;
            byte[] bArr2 = new byte[20];
            for (i5 = 0; i5 < 20; i5++) {
                bArr2[i5] = bArr[(i2 * 20) + i5];
            }
            boolean b = b(this.aW, bArr2);
            C0596r.a(b);
            if (!b) {
                return false;
            }
            i3 += 20;
            if (bVar != null) {
                bVar.report(i3);
            }
            i5 = i4 + 20;
            C0596r.a("transferedPackets = " + i5);
            if (i5 >= com.xiaomi.account.openauth.h.E) {
                E();
                i5 = 0;
            }
            i2++;
            i4 = i5;
        }
        if (length % 20 == 0) {
            E();
            C0596r.a("transferFirmwareData: complete");
            return true;
        }
        byte[] bArr3 = new byte[(length % 20)];
        for (i5 = 0; i5 < length % 20; i5++) {
            bArr3[i5] = bArr[(i * 20) + i5];
        }
        b = b(this.aW, bArr3);
        C0596r.a(b);
        if (!b) {
            return false;
        }
        i5 = (length % 20) + i3;
        if (bVar != null) {
            bVar.report(i5);
        }
        C0596r.a("transferedPackets = " + ((length % 20) + i4));
        E();
        C0596r.a("transferFirmwareData: complete");
        if (this.bs.intValue() == -1) {
            a(this.aW, com.f.a.b.d.a.b);
        }
        return this.bs.intValue() == 2;
    }

    public void b(int i) {
        this.d_ = i;
    }

    public void b(boolean z) {
        a(z);
        b();
    }

    public boolean b(byte b) {
        if (this.bk == null) {
            return false;
        }
        return b(this.bk, new byte[]{b});
    }

    public boolean b(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        C0596r.e();
        this.bs = Integer.valueOf(-1);
        if (!b(this.aT, new byte[]{az, (byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24), (byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24), (byte) i3, (byte) (i3 >> 8), (byte) i4, (byte) (i4 >> 8), (byte) i5})) {
            return false;
        }
        if (this.bs.intValue() == -1) {
            a(this.aW, com.f.a.b.d.a.a);
        }
        if (this.bs.intValue() != 12) {
            z = false;
        }
        return z;
    }

    public boolean b(UserInfo userInfo) {
        int i = 9;
        int i2 = 0;
        C0596r.e();
        byte[] bArr = new byte[20];
        bArr[0] = (byte) (userInfo.d & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[1] = (byte) ((userInfo.d >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[2] = (byte) ((userInfo.d >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[3] = (byte) ((userInfo.d >> 24) & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[4] = userInfo.e;
        bArr[5] = userInfo.f;
        bArr[6] = userInfo.g;
        bArr[7] = userInfo.h;
        h j_ = j_();
        if (j_ == null) {
            C0596r.d(ar, "getDeviceInfo return null in setUserInfo function!!!");
            return false;
        }
        C0596r.d(ar, "device info:" + j_);
        if (j_.b() || j_.a() || j_.f >= 16779599) {
            bArr[8] = userInfo.j;
        } else {
            bArr[8] = am;
        }
        bArr[9] = (byte) (j_.b & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[10] = (byte) (j_.c & HeartRateInfo.HR_EMPTY_VALUE);
        if (userInfo.i.length <= 9) {
            i = userInfo.i.length;
        }
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3 + 11] = userInfo.i[i3];
        }
        byte[] bArr2 = new byte[19];
        while (i2 < 19) {
            bArr2[i2] = bArr[i2];
            i2++;
        }
        i = y.d(bArr2);
        String address = f().getAddress();
        bArr[19] = (byte) (i ^ Integer.decode("0x" + address.substring(address.length() - 2)).intValue());
        return b(this.aS, bArr);
    }

    public boolean c(byte b) {
        return b(this.aT, new byte[]{aG, b});
    }

    public boolean c(int i) {
        byte[] bArr = new byte[]{(byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 24) & HeartRateInfo.HR_EMPTY_VALUE)};
        return b(this.aT, new byte[]{ap, bArr[0], bArr[1], bArr[2], bArr[3]});
    }

    public boolean c(boolean z) {
        this.br = z;
        this.bp = -1;
        if (z) {
            return b(this.bc, new byte[]{an});
        }
        return b(this.bc, new byte[]{am});
    }

    public boolean d(byte b) {
        C0596r.e();
        return b(this.bb, new byte[]{av, b});
    }

    public boolean d(int i) {
        C0596r.e();
        if (this.bf == null) {
            return false;
        }
        return b(this.bf, new byte[]{ap, (byte) i});
    }

    public boolean d(boolean z) {
        int i = 1;
        C0596r.e();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.aQ;
        byte[] bArr = new byte[1];
        if (!z) {
            i = 0;
        }
        bArr[0] = (byte) i;
        return b(bluetoothGattCharacteristic, bArr);
    }

    public boolean e(byte b) {
        C0596r.e();
        return b(this.bb, new byte[]{ax, b});
    }

    public h j_() {
        C0596r.e();
        if (this.bl != null) {
            return this.bl;
        }
        byte[] g = g(this.aP);
        C0596r.a((Object) g);
        if (g == null || (g.length != 16 && g.length != 20)) {
            return null;
        }
        C0596r.a("device info ret len:" + g.length);
        int d = (g[3] & HeartRateInfo.HR_EMPTY_VALUE) ^ y.d(new byte[]{g[0], g[1], g[2], g[3], g[4], g[5], g[6]});
        C0596r.a(d == (g[7] & HeartRateInfo.HR_EMPTY_VALUE));
        if (d != (g[7] & HeartRateInfo.HR_EMPTY_VALUE)) {
            C0596r.f("DeviceInfo CRC verification failed");
            return null;
        }
        String format = String.format("%02X%02X%02X%02X%02X%02X%02X%02X", new Object[]{Byte.valueOf(g[0]), Byte.valueOf(g[1]), Byte.valueOf(g[2]), Byte.valueOf(g[3]), Byte.valueOf(g[4]), Byte.valueOf(g[5]), Byte.valueOf(g[6]), Byte.valueOf(g[7])});
        int a = y.a(g, 8);
        int a2 = y.a(g, 12);
        if (g.length == 20) {
            this.bl = new h(format, a, a2, y.a(g, 16));
        } else {
            this.bl = new h(format, a, a2);
        }
        return this.bl;
    }

    public int k_() {
        C0596r.e();
        byte[] g = g(this.aU);
        if (g == null) {
            C0596r.d(ar, "getRealtimeSteps return null!!!");
            return -1;
        }
        int length = g.length;
        if (length == 2) {
            return (g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        }
        if (length == 3) {
            return (g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        }
        if (length == 4) {
            return (((g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((g[2] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((g[3] & HeartRateInfo.HR_EMPTY_VALUE) << 24);
        }
        C0596r.d(ar, "getRealtimeSteps data length<" + length + "> error!!!");
        return -1;
    }

    @SuppressLint({"NewApi"})
    protected boolean t() {
        C0596r.e();
        Object a = a(h_);
        C0596r.a(a);
        if (a == null) {
            return false;
        }
        this.aP = a.getCharacteristic(i_);
        C0596r.a(this.aP);
        if (this.aP == null) {
            return false;
        }
        C0596r.a((this.aP.getProperties() & 2) > 0);
        this.aQ = a.getCharacteristic(f);
        C0596r.a(this.aQ);
        if (this.aQ == null) {
            return false;
        }
        C0596r.a((this.aQ.getProperties() & 2) > 0);
        C0596r.a((this.aQ.getProperties() & 8) > 0);
        this.aR = a.getCharacteristic(j_);
        C0596r.a(this.aR);
        if (this.aR == null) {
            return false;
        }
        C0596r.a((this.aR.getProperties() & 16) > 0);
        this.aS = a.getCharacteristic(k_);
        C0596r.a(this.aS);
        if (this.aS == null) {
            return false;
        }
        C0596r.a((this.aS.getProperties() & 2) > 0);
        C0596r.a((this.aS.getProperties() & 8) > 0);
        this.aT = a.getCharacteristic(l_);
        C0596r.a(this.aT);
        if (this.aT == null) {
            return false;
        }
        C0596r.a((this.aT.getProperties() & 8) > 0);
        this.aU = a.getCharacteristic(m_);
        C0596r.a(this.aU);
        if (this.aU == null) {
            return false;
        }
        C0596r.a((this.aU.getProperties() & 2) > 0);
        C0596r.a((this.aU.getProperties() & 16) > 0);
        this.aV = a.getCharacteristic(k);
        C0596r.a(this.aV);
        if (this.aV == null) {
            return false;
        }
        C0596r.a((this.aV.getProperties() & 16) > 0);
        this.aW = a.getCharacteristic(l);
        C0596r.a(this.aW);
        if (this.aW == null) {
            return false;
        }
        C0596r.a((this.aW.getProperties() & 4) > 0);
        this.aX = a.getCharacteristic(m);
        C0596r.a(this.aX);
        if (this.aX == null) {
            return false;
        }
        C0596r.a((this.aX.getProperties() & 2) > 0);
        C0596r.a((this.aX.getProperties() & 8) > 0);
        this.aY = a.getCharacteristic(n);
        C0596r.a(this.aY);
        if (this.aY == null) {
            return false;
        }
        C0596r.a((this.aY.getProperties() & 2) > 0);
        C0596r.a((this.aY.getProperties() & 8) > 0);
        this.ba = a.getCharacteristic(p);
        C0596r.a(this.ba);
        if (this.ba == null) {
            return false;
        }
        C0596r.a((this.ba.getProperties() & 2) > 0);
        C0596r.a((this.ba.getProperties() & 16) > 0);
        this.bb = a.getCharacteristic(q);
        C0596r.a(this.bb);
        if (this.bb == null) {
            return false;
        }
        C0596r.a((this.bb.getProperties() & 8) > 0);
        boolean b = b(this.aR, new k(this));
        C0596r.a(b);
        if (!b) {
            return false;
        }
        b = b(this.aU, new l(this));
        C0596r.a(b);
        if (!b) {
            return false;
        }
        b = b(this.aV, null);
        C0596r.a(b);
        if (!b) {
            return false;
        }
        b = b(this.ba, new m(this));
        C0596r.a(b);
        if (!b) {
            return false;
        }
        this.bc = a.getCharacteristic(r);
        this.bd = a.getCharacteristic(s);
        C0596r.a(this.bd);
        if (this.bd == null) {
            C0596r.d(ar, "m_CharPair is null!!!");
        }
        BluetoothGattService a2 = a(a.t);
        if (a2 != null) {
            this.be = a2.getCharacteristic(a.v);
            b(this.be, new n(this));
            this.bf = a2.getCharacteristic(u);
        }
        a2 = a(w);
        if (a2 != null) {
            this.bg = a2.getCharacteristic(y);
            C0596r.a(this.bg);
            this.bi = a2.getCharacteristic(z);
            C0596r.a(this.bi);
            this.bh = a2.getCharacteristic(x);
            C0596r.a(this.bh);
            this.bj = a2.getCharacteristic(A);
            C0596r.a(this.bj);
            A();
        }
        a2 = a(B);
        if (a2 != null) {
            this.bk = a2.getCharacteristic(C);
        }
        return true;
    }

    public boolean u() {
        return this.d_ == 3 && g() == C.CONNECTED;
    }

    public boolean v() {
        return (this.d_ == 1 || this.d_ == 3) && g() == C.CONNECTED;
    }

    public void w() {
        C0596r.e();
        if (this.aR != null) {
            c(this.aR);
        }
        if (this.aU != null) {
            c(this.aU);
        }
        if (this.aV != null) {
            c(this.aV);
        }
        if (this.ba != null) {
            c(this.ba);
        }
        this.d_ = 0;
        this.bl = null;
    }

    public p x() {
        C0596r.e();
        byte[] g = g(this.aX);
        if (g == null || g.length == 0) {
            return null;
        }
        C0596r.a(g.length == 12);
        return new p(((g[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a, ((g[2] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[3] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a, ((g[4] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[5] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a, ((g[6] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[7] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a, ((g[8] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[9] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a, ((g[10] & HeartRateInfo.HR_EMPTY_VALUE) | ((g[11] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) & android.support.v4.e.a.a.a);
    }

    public int y() {
        return this.d_;
    }

    public void z() {
        D();
    }
}
