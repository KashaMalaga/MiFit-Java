package b.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.market.sdk.o;
import java.security.MessageDigest;
import java.util.Locale;

public class C0356cr {
    private final byte[] a = new byte[8];
    private String b = "1.0";
    private String c = null;
    private byte[] d = null;
    private byte[] e = null;
    private byte[] f = null;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private byte[] j = null;
    private byte[] k = null;

    private C0356cr(byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.c = str;
        this.i = bArr.length;
        this.j = C0351cl.a(bArr);
        this.h = (int) (System.currentTimeMillis() / 1000);
        this.k = bArr2;
    }

    public static C0356cr a(Context context, String str, byte[] bArr) {
        try {
            String p = bW.p(context);
            String f = bW.f(context);
            SharedPreferences a = C0366dK.a(context);
            String string = a.getString(o.g, null);
            int i = a.getInt("serial", 1);
            C0356cr c0356cr = new C0356cr(bArr, str, new StringBuilder(String.valueOf(f)).append(p).toString().getBytes());
            c0356cr.a(string);
            c0356cr.a(i);
            c0356cr.b();
            a.edit().putInt("serial", i + 1).putString(o.g, c0356cr.a()).commit();
            return c0356cr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        byte[] a = C0356cr.a(this.k);
        byte[] a2 = C0356cr.a(this.j);
        int length = a.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (i2 = 0; i2 < length; i2++) {
            bArr2[i2 * 2] = a2[i2];
            bArr2[(i2 * 2) + 1] = a[i2];
        }
        for (i2 = 0; i2 < 2; i2++) {
            bArr2[i2] = bArr[i2];
            bArr2[(bArr2.length - i2) - 1] = bArr[(bArr.length - i2) - 1];
        }
        byte[] bArr3 = new byte[]{(byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i >>> 24)};
        while (i3 < bArr2.length) {
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr3[i3 % 4]);
            i3++;
        }
        return bArr2;
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static byte[] b(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 == 0) {
                bArr = new byte[(length / 2)];
                for (int i = 0; i < length; i += 2) {
                    bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i + 2), 16).intValue();
                }
            }
        }
        return bArr;
    }

    private byte[] d() {
        return a(this.a, (int) (System.currentTimeMillis() / 1000));
    }

    private byte[] e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0356cr.b(this.d));
        stringBuilder.append(this.g);
        stringBuilder.append(this.h);
        stringBuilder.append(this.i);
        stringBuilder.append(C0356cr.b(this.e));
        return C0356cr.a(stringBuilder.toString().getBytes());
    }

    public String a() {
        return C0356cr.b(this.d);
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(String str) {
        this.d = C0356cr.b(str);
    }

    public void b() {
        if (this.d == null) {
            this.d = d();
        }
        this.e = a(this.d, this.h);
        this.f = e();
    }

    public byte[] c() {
        cq bQVar = new bQ();
        bQVar.a(this.b);
        bQVar.b(this.c);
        bQVar.c(C0356cr.b(this.d));
        bQVar.a(this.g);
        bQVar.c(this.h);
        bQVar.d(this.i);
        bQVar.a(this.j);
        bQVar.d(C0356cr.b(this.e));
        bQVar.e(C0356cr.b(this.f));
        try {
            return new cB().a(bQVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("version : %s\n", new Object[]{this.b}));
        stringBuilder.append(String.format("address : %s\n", new Object[]{this.c}));
        stringBuilder.append(String.format("signature : %s\n", new Object[]{C0356cr.b(this.d)}));
        stringBuilder.append(String.format("serial : %s\n", new Object[]{Integer.valueOf(this.g)}));
        stringBuilder.append(String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.h)}));
        stringBuilder.append(String.format("length : %d\n", new Object[]{Integer.valueOf(this.i)}));
        stringBuilder.append(String.format("guid : %s\n", new Object[]{C0356cr.b(this.e)}));
        stringBuilder.append(String.format("checksum : %s ", new Object[]{C0356cr.b(this.f)}));
        return stringBuilder.toString();
    }
}
