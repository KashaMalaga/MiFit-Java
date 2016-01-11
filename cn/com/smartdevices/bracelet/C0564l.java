package cn.com.smartdevices.bracelet;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class C0564l {
    public static int a(byte[] bArr, int i) {
        int i2 = (bArr[i] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        return (i2 | ((bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[i + 3] & HeartRateInfo.HR_EMPTY_VALUE) << 24);
    }

    public static long a(byte[] bArr) {
        long j = ((long) (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE)) | (((long) (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE)) << 8);
        j |= ((long) (bArr[2] & HeartRateInfo.HR_EMPTY_VALUE)) << 16;
        j |= ((long) (bArr[3] & HeartRateInfo.HR_EMPTY_VALUE)) << 24;
        j |= ((long) (bArr[4] & HeartRateInfo.HR_EMPTY_VALUE)) << 32;
        j |= ((long) (bArr[5] & HeartRateInfo.HR_EMPTY_VALUE)) << 40;
        return (j | (((long) (bArr[6] & HeartRateInfo.HR_EMPTY_VALUE)) << 48)) | (((long) (bArr[7] & HeartRateInfo.HR_EMPTY_VALUE)) << 56);
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & HeartRateInfo.HR_EMPTY_VALUE).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static byte[] a(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Integer(r4 & HeartRateInfo.HR_EMPTY_VALUE).byteValue();
            int i2 >>= 8;
        }
        return bArr;
    }

    public static int b(byte[] bArr) {
        int i = (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        return (i | ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[3] & HeartRateInfo.HR_EMPTY_VALUE) << 24);
    }

    public static short b(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 2);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getShort();
    }

    public static int c(byte[] bArr, int i) {
        return bArr[i + 0];
    }

    public static short c(byte[] bArr) {
        return (short) (((short) (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE)) | ((short) (((short) (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE)) << 8)));
    }
}
