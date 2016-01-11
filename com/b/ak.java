package com.b;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ak {
    private static ak a = null;

    private ak() {
    }

    static String a(Object obj, String str) {
        DecimalFormat decimalFormat = new DecimalFormat("#", new DecimalFormatSymbols(Locale.US));
        decimalFormat.applyPattern(str);
        return decimalFormat.format(obj);
    }

    static byte[] a(int i) {
        return new byte[]{(byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 16) & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 24) & HeartRateInfo.HR_EMPTY_VALUE)};
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    static byte[] a(String str) {
        return a(Integer.parseInt(str));
    }

    static byte[] b(int i) {
        return new byte[]{(byte) (i & HeartRateInfo.HR_EMPTY_VALUE), (byte) ((i >> 8) & HeartRateInfo.HR_EMPTY_VALUE)};
    }

    static byte[] b(String str) {
        return b(Integer.parseInt(str));
    }
}
