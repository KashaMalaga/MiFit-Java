package cn.com.smartdevices.bracelet.gps.h;

import android.support.v4.e.a.a;
import android.support.v4.view.C0151az;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class b {
    private b() {
    }

    public static double a(byte[] bArr, int i) {
        return Double.longBitsToDouble((((((((((((((((long) bArr[i + 0]) & 255) | (((long) bArr[i + 1]) << 8)) & 65535) | (((long) bArr[i + 2]) << 16)) & 16777215) | (((long) bArr[i + 3]) << 24)) & 4294967295L) | (((long) bArr[i + 4]) << 32)) & 1099511627775L) | (((long) bArr[i + 5]) << 40)) & 281474976710655L) | (((long) bArr[i + 6]) << 48)) & 72057594037927935L) | (((long) bArr[i + 7]) << 56));
    }

    public static long a(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | ((((long) bArr[7]) & 255) << 0);
    }

    public static void a(long j, byte[] bArr, int i) {
        bArr[i + 7] = (byte) ((int) (j & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 0] = (byte) ((int) ((j >> 56) & 255));
    }

    public static void a(byte[] bArr, double d, int i) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i + i2] = new Long(doubleToLongBits).byteValue();
            doubleToLongBits >>= 8;
        }
    }

    public static void a(byte[] bArr, float f, int i) {
        int floatToIntBits = Float.floatToIntBits(f);
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i + i2] = new Integer(floatToIntBits).byteValue();
            floatToIntBits >>= 8;
        }
    }

    public static void a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i2 + i3] = (byte) ((i >> (24 - (i3 * 8))) & HeartRateInfo.HR_EMPTY_VALUE);
        }
    }

    public static void a(byte[] bArr, long j, int i) {
        bArr[i + 7] = (byte) ((int) (j >> 56));
        bArr[i + 6] = (byte) ((int) (j >> 48));
        bArr[i + 5] = (byte) ((int) (j >> 40));
        bArr[i + 4] = (byte) ((int) (j >> 32));
        bArr[i + 3] = (byte) ((int) (j >> 24));
        bArr[i + 2] = (byte) ((int) (j >> 16));
        bArr[i + 1] = (byte) ((int) (j >> 8));
        bArr[i + 0] = (byte) ((int) (j >> null));
    }

    public static void a(byte[] bArr, short s, int i) {
        bArr[i + 1] = (byte) (s >> 8);
        bArr[i + 0] = (byte) (s >> 0);
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) (i & HeartRateInfo.HR_EMPTY_VALUE)};
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 56) & 255))};
    }

    public static byte[] a(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Integer(r4 & HeartRateInfo.HR_EMPTY_VALUE).byteValue();
            int i2 >>= 8;
        }
        return bArr;
    }

    public static double b(byte[] bArr) {
        return Double.longBitsToDouble(((((((((((((((long) bArr[0]) & 255) | (((long) bArr[1]) << 8)) & 65535) | (((long) bArr[2]) << 16)) & 16777215) | (((long) bArr[3]) << 24)) & 4294967295L) | (((long) bArr[4]) << 32)) & 1099511627775L) | (((long) bArr[5]) << 40)) & 281474976710655L) | (((long) bArr[6]) << 48)) | (((long) bArr[7]) << 56));
    }

    public static float b(byte[] bArr, int i) {
        return Float.intBitsToFloat((int) (((long) (((int) (((long) (((int) (((long) (bArr[i + 0] & HeartRateInfo.HR_EMPTY_VALUE)) | (((long) bArr[i + 1]) << 8))) & a.a)) | (((long) bArr[i + 2]) << 16))) & C0151az.r)) | (((long) bArr[i + 3]) << 24)));
    }

    public static int c(byte[] bArr, int i) {
        return (((bArr[i + 3] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[i + 0] & HeartRateInfo.HR_EMPTY_VALUE) << 24);
    }

    public static long[] c(byte[] bArr) {
        long[] jArr = new long[(bArr.length / 8)];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = ((((((((((long) bArr[(i * 8) + 0]) & 255) << 56) | ((((long) bArr[(i * 8) + 1]) & 255) << 48)) | ((((long) bArr[(i * 8) + 2]) & 255) << 40)) | ((((long) bArr[(i * 8) + 3]) & 255) << 32)) | ((((long) bArr[(i * 8) + 4]) & 255) << 24)) | ((((long) bArr[(i * 8) + 5]) & 255) << 16)) | ((((long) bArr[(i * 8) + 6]) & 255) << 8)) | ((((long) bArr[(i * 8) + 7]) & 255) << 0);
        }
        return jArr;
    }

    public static long d(byte[] bArr, int i) {
        return (((((((255 & ((long) bArr[i + 0])) | (65280 & (((long) bArr[i + 1]) << 8))) | (16711680 & (((long) bArr[i + 2]) << 16))) | (4278190080L & (((long) bArr[i + 3]) << 24))) | (1095216660480L & (((long) bArr[i + 4]) << 32))) | (280375465082880L & (((long) bArr[i + 5]) << 40))) | (71776119061217280L & (((long) bArr[i + 6]) << 48))) | (-72057594037927936L & (((long) bArr[i + 7]) << 56));
    }

    public static short e(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] << 8) | (bArr[i + 0] & HeartRateInfo.HR_EMPTY_VALUE));
    }
}
