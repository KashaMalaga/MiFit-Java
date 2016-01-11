package com.xiaomi.push.service;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.channel.a.e.a;

public class C1149o {
    private static int a = 8;
    private byte[] b = new byte[PersonInfo.INCOMING_CALL_DISABLE_BIT];
    private int c = 0;
    private int d = 0;
    private int e = -666;

    public static int a(byte b) {
        return b >= (byte) 0 ? b : b + PersonInfo.INCOMING_CALL_DISABLE_BIT;
    }

    public static String a(byte[] bArr, String str) {
        return String.valueOf(a.a(C1149o.a(bArr, str.getBytes())));
    }

    private void a(int i, byte[] bArr, boolean z) {
        int i2 = 0;
        int length = bArr.length;
        for (int i3 = 0; i3 < PersonInfo.INCOMING_CALL_DISABLE_BIT; i3++) {
            this.b[i3] = (byte) i3;
        }
        this.d = 0;
        this.c = 0;
        while (this.c < i) {
            this.d = ((this.d + C1149o.a(this.b[this.c])) + C1149o.a(bArr[this.c % length])) % PersonInfo.INCOMING_CALL_DISABLE_BIT;
            C1149o.a(this.b, this.c, this.d);
            this.c++;
        }
        if (i != PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.e = ((this.d + C1149o.a(this.b[i])) + C1149o.a(bArr[i % length])) % PersonInfo.INCOMING_CALL_DISABLE_BIT;
        }
        if (z) {
            System.out.print("S_" + (i - 1) + kankan.wheel.widget.a.ci);
            while (i2 <= i) {
                System.out.print(" " + C1149o.a(this.b[i2]));
                i2++;
            }
            System.out.print("   j_" + (i - 1) + "=" + this.d);
            System.out.print("   j_" + i + "=" + this.e);
            System.out.print("   S_" + (i - 1) + "[j_" + (i - 1) + "]=" + C1149o.a(this.b[this.d]));
            System.out.print("   S_" + (i - 1) + "[j_" + i + "]=" + C1149o.a(this.b[this.e]));
            if (this.b[1] != (byte) 0) {
                System.out.print("   S[1]!=0");
            }
            System.out.println();
        }
    }

    private void a(byte[] bArr) {
        a((int) PersonInfo.INCOMING_CALL_DISABLE_BIT, bArr, false);
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] a(String str, String str2) {
        int i = 0;
        byte[] a = a.a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[((a.length + 1) + bytes.length)];
        for (int i2 = 0; i2 < a.length; i2++) {
            bArr[i2] = a[i2];
        }
        bArr[a.length] = (byte) 95;
        while (i < bytes.length) {
            bArr[(a.length + 1) + i] = bytes[i];
            i++;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        C1149o c1149o = new C1149o();
        c1149o.a(bArr);
        c1149o.b();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ c1149o.a());
        }
        return bArr3;
    }

    private void b() {
        this.d = 0;
        this.c = 0;
    }

    public static byte[] b(byte[] bArr, String str) {
        return C1149o.a(bArr, a.a(str));
    }

    byte a() {
        this.c = (this.c + 1) % PersonInfo.INCOMING_CALL_DISABLE_BIT;
        this.d = (this.d + C1149o.a(this.b[this.c])) % PersonInfo.INCOMING_CALL_DISABLE_BIT;
        C1149o.a(this.b, this.c, this.d);
        return this.b[(C1149o.a(this.b[this.c]) + C1149o.a(this.b[this.d])) % PersonInfo.INCOMING_CALL_DISABLE_BIT];
    }
}
