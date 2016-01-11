package b.a;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class C0353cn {
    public static final byte a(byte b, int i, boolean z) {
        return (byte) C0353cn.a((int) b, i, z);
    }

    public static final int a(int i, int i2, boolean z) {
        return z ? (1 << i2) | i : C0353cn.b(i, i2);
    }

    public static final int a(byte[] bArr) {
        return C0353cn.a(bArr, 0);
    }

    public static final int a(byte[] bArr, int i) {
        return ((((bArr[i] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[i + 3] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static final long a(long j, int i, boolean z) {
        return z ? (1 << i) | j : C0353cn.b(j, i);
    }

    public static final short a(short s, int i, boolean z) {
        return (short) C0353cn.a((int) s, i, z);
    }

    public static final void a(int i, byte[] bArr) {
        C0353cn.a(i, bArr, 0);
    }

    public static final void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[i2 + 1] = (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[i2 + 2] = (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        bArr[i2 + 3] = (byte) (i & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static final boolean a(byte b, int i) {
        return C0353cn.a((int) b, i);
    }

    public static final boolean a(int i, int i2) {
        return ((1 << i2) & i) != 0;
    }

    public static final boolean a(long j, int i) {
        return ((1 << i) & j) != 0;
    }

    public static final boolean a(short s, int i) {
        return C0353cn.a((int) s, i);
    }

    public static final byte b(byte b, int i) {
        return (byte) C0353cn.b((int) b, i);
    }

    public static final int b(int i, int i2) {
        return ((1 << i2) ^ -1) & i;
    }

    public static final long b(long j, int i) {
        return ((1 << i) ^ -1) & j;
    }

    public static final short b(short s, int i) {
        return (short) C0353cn.b((int) s, i);
    }
}
