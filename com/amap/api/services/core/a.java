package com.amap.api.services.core;

import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class a {
    private static final char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    private a() {
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & HeartRateInfo.HR_EMPTY_VALUE;
            if (i2 == length) {
                stringBuffer.append(a[i3 >>> 2]);
                stringBuffer.append(a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & HeartRateInfo.HR_EMPTY_VALUE;
            if (i4 == length) {
                stringBuffer.append(a[i3 >>> 2]);
                stringBuffer.append(a[((i3 & 3) << 4) | ((i2 & RunningReminderInfo.b) >>> 4)]);
                stringBuffer.append(a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & HeartRateInfo.HR_EMPTY_VALUE;
            stringBuffer.append(a[i3 >>> 2]);
            stringBuffer.append(a[((i3 & 3) << 4) | ((i2 & RunningReminderInfo.b) >>> 4)]);
            stringBuffer.append(a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(a[i4 & 63]);
        }
        return stringBuffer.toString();
    }
}
