package com.c.b.d.c;

import a.a.a.B;
import android.support.v4.media.h;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.a;

public final class i {
    private static final int[] a = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] b = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, RunningReminderInfo.b, 92, HeartRateInfo.NO_HR_VALUE}, new int[]{28, 24, 185, 166, 223, 248, 116, HeartRateInfo.HR_EMPTY_VALUE, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, HeartRateInfo.NO_HR_VALUE, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, HeartRateInfo.NO_HR_VALUE, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE, 174, 37, 151, a.aC, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, HeartRateInfo.HR_EMPTY_VALUE}, new int[]{245, h.j, 242, 218, h.k, 250, 162, 181, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, 120, 84, 179, cn.com.smartdevices.bracelet.gps.c.a.f, 251, 80, 182, 229, 18, 2, 4, 68, 33, ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, B.n, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, B.n, 214, 111, 57, 121, 21, 1, 253, 57, 54, ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE, 248, 202, 69, 50, a.ap, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, B.o, 16, 147, 118, 23, 37, 90, a.aC, 205, 131, 88, 120, 100, 66, 138, 186, RunningReminderInfo.b, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, cn.com.smartdevices.bracelet.gps.c.a.f, 208, 100, 29, 175, a.aC, a.an, 192, 215, 235, a.ap, 159, 36, 223, 38, v.C, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, a.ap, v.D, 117, 62, 207, 164, 13, 137, 245, h.j, 67, 247, 28, 155, 43, 203, B.p, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, v.D, 189, 143, 108, 196, 37, 185, 112, 134, a.an, 245, 63, 197, 190, 250, B.o, 185, HeartRateInfo.MAX_HR_VALUE, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, h.k, 188, 17, 163, 31, 176, a.aC, 4, B.p, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{cn.com.smartdevices.bracelet.gps.c.a.f, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, h.j, 213, 136, 248, cn.com.smartdevices.bracelet.gps.c.a.i, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, cn.com.smartdevices.bracelet.gps.c.a.f, 232, 96, 210, 231, 136, 223, com.xiaomi.hm.health.bt.profile.a.a.ac, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE, 82, 186}};
    private static final int c = 301;
    private static final int[] d = new int[PersonInfo.INCOMING_CALL_DISABLE_BIT];
    private static final int[] e = new int[HeartRateInfo.HR_EMPTY_VALUE];

    static {
        int i = 1;
        for (int i2 = 0; i2 < HeartRateInfo.HR_EMPTY_VALUE; i2++) {
            e[i2] = i;
            d[i] = i2;
            i *= 2;
            if (i >= PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                i ^= c;
            }
        }
    }

    private i() {
    }

    private static String a(CharSequence charSequence, int i) {
        return a(charSequence, 0, charSequence.length(), i);
    }

    private static String a(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i5 < a.length) {
            if (a[i5] == i3) {
                break;
            }
            i5++;
        }
        i5 = -1;
        if (i5 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr = b[i5];
        char[] cArr = new char[i3];
        for (i5 = 0; i5 < i3; i5++) {
            cArr[i5] = '\u0000';
        }
        for (int i6 = i; i6 < i + i2; i6++) {
            int charAt = charSequence.charAt(i6) ^ cArr[i3 - 1];
            i5 = i3 - 1;
            while (i5 > 0) {
                if (charAt == 0 || iArr[i5] == 0) {
                    cArr[i5] = cArr[i5 - 1];
                } else {
                    cArr[i5] = (char) (cArr[i5 - 1] ^ e[(d[charAt] + d[iArr[i5]]) % HeartRateInfo.HR_EMPTY_VALUE]);
                }
                i5--;
            }
            if (charAt == 0 || iArr[0] == 0) {
                cArr[0] = '\u0000';
            } else {
                cArr[0] = (char) e[(d[charAt] + d[iArr[0]]) % HeartRateInfo.HR_EMPTY_VALUE];
            }
        }
        char[] cArr2 = new char[i3];
        while (i4 < i3) {
            cArr2[i4] = cArr[(i3 - i4) - 1];
            i4++;
        }
        return String.valueOf(cArr2);
    }

    public static String a(String str, k kVar) {
        if (str.length() != kVar.i()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder stringBuilder = new StringBuilder(kVar.i() + kVar.j());
        stringBuilder.append(str);
        int a = kVar.a();
        if (a == 1) {
            stringBuilder.append(a((CharSequence) str, kVar.j()));
        } else {
            int i;
            stringBuilder.setLength(stringBuilder.capacity());
            int[] iArr = new int[a];
            int[] iArr2 = new int[a];
            int[] iArr3 = new int[a];
            for (i = 0; i < a; i++) {
                iArr[i] = kVar.a(i + 1);
                iArr2[i] = kVar.c(i + 1);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
            }
            for (int i2 = 0; i2 < a; i2++) {
                StringBuilder stringBuilder2 = new StringBuilder(iArr[i2]);
                for (i = i2; i < kVar.i(); i += a) {
                    stringBuilder2.append(str.charAt(i));
                }
                String a2 = a(stringBuilder2.toString(), iArr2[i2]);
                i = i2;
                int i3 = 0;
                while (i < iArr2[i2] * a) {
                    int i4 = i3 + 1;
                    stringBuilder.setCharAt(kVar.i() + i, a2.charAt(i3));
                    i += a;
                    i3 = i4;
                }
            }
        }
        return stringBuilder.toString();
    }
}
