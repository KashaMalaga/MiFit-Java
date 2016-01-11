package com.tencent.wxop.stat.b;

import android.util.Base64;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class g {
    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[PersonInfo.INCOMING_CALL_DISABLE_BIT];
        int[] iArr2 = new int[PersonInfo.INCOMING_CALL_DISABLE_BIT];
        int length = bArr2.length;
        if (length <= 0 || length > PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < PersonInfo.INCOMING_CALL_DISABLE_BIT; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < PersonInfo.INCOMING_CALL_DISABLE_BIT; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & HeartRateInfo.HR_EMPTY_VALUE;
            int i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & HeartRateInfo.HR_EMPTY_VALUE;
            length = (length + iArr[i2]) & HeartRateInfo.HR_EMPTY_VALUE;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & HeartRateInfo.HR_EMPTY_VALUE] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    public static byte[] b(byte[] bArr) {
        return a(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }
}
