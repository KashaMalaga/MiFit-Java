package com.xiaomi.hm.health.bt.profile;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class a {
    private static final String a = "ProfileUtils";

    public static int a(InputStream inputStream) {
        byte[] bArr = new byte[4];
        inputStream.skip(1056);
        inputStream.read(bArr, 0, 4);
        return (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((((bArr[3] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8));
    }

    public static int a(String str) {
        String substring = str.substring(1);
        C0596r.e(a, "weight fw version:" + substring);
        String[] split = substring.split("\\.");
        if (split.length != 3) {
            return -1;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        return (Integer.parseInt(split[2]) & HeartRateInfo.HR_EMPTY_VALUE) | ((parseInt & 16711680) | ((parseInt2 & HeartRateInfo.HR_EMPTY_VALUE) << 8));
    }

    public static int a(byte[] bArr) {
        return ((((bArr[1059] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[1058] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[1057] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[1056] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static e a(byte[] bArr, boolean z, boolean z2) {
        C0596r.d(a, "value:" + y.b(bArr));
        if (bArr.length != 10 || (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) == 0) {
            C0596r.d(a, "wrong weight data,ignore!!!");
            return null;
        }
        int i;
        float f = (float) (((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE));
        if ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) == HeartRateInfo.HR_EMPTY_VALUE && (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) == RunningReminderInfo.b) {
            i = 0;
        } else {
            i = bArr[0] & e.m;
            f = i == 0 ? f / 200.0f : f / CropOverlayView.a;
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.clear();
        boolean z3 = (bArr[0] & e.n) != 0;
        boolean z4 = (bArr[0] & e.p) != 0;
        gregorianCalendar.set(1, ((bArr[4] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (bArr[3] & HeartRateInfo.HR_EMPTY_VALUE));
        gregorianCalendar.set(2, bArr[5] - 1);
        gregorianCalendar.set(5, bArr[6]);
        gregorianCalendar.set(11, bArr[7]);
        gregorianCalendar.set(12, bArr[8]);
        gregorianCalendar.set(13, bArr[9]);
        e eVar = new e(i, f, gregorianCalendar.getTimeInMillis(), z3, z, z2, z4);
        C0596r.d(a, "WeightAdvData:" + eVar);
        return eVar;
    }

    public static boolean b(byte[] bArr) {
        long j = (((((long) (bArr[26] & HeartRateInfo.HR_EMPTY_VALUE)) << 24) | (((long) (bArr[27] & HeartRateInfo.HR_EMPTY_VALUE)) << 16)) | (((long) (bArr[28] & HeartRateInfo.HR_EMPTY_VALUE)) << 8)) | ((long) (bArr[29] & HeartRateInfo.HR_EMPTY_VALUE));
        return ((((((long) (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE)) << 24) | (((long) (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE)) << 16)) | (((long) (bArr[2] & HeartRateInfo.HR_EMPTY_VALUE)) << 8)) | ((long) (bArr[3] & HeartRateInfo.HR_EMPTY_VALUE))) == 2020959083 && ((((((long) (bArr[12] & HeartRateInfo.HR_EMPTY_VALUE)) << 24) | (((long) (bArr[13] & HeartRateInfo.HR_EMPTY_VALUE)) << 16)) | (((long) (bArr[14] & HeartRateInfo.HR_EMPTY_VALUE)) << 8)) | ((long) (bArr[15] & HeartRateInfo.HR_EMPTY_VALUE))) + ((((((long) (bArr[16] & HeartRateInfo.HR_EMPTY_VALUE)) << 24) | (((long) (bArr[17] & HeartRateInfo.HR_EMPTY_VALUE)) << 16)) | (((long) (bArr[18] & HeartRateInfo.HR_EMPTY_VALUE)) << 8)) | ((long) (bArr[19] & HeartRateInfo.HR_EMPTY_VALUE))) <= j && j + ((((((long) (bArr[30] & HeartRateInfo.HR_EMPTY_VALUE)) << 24) | (((long) (bArr[31] & HeartRateInfo.HR_EMPTY_VALUE)) << 16)) | (((long) (bArr[32] & HeartRateInfo.HR_EMPTY_VALUE)) << 8)) | ((long) (bArr[33] & HeartRateInfo.HR_EMPTY_VALUE))) <= ((long) bArr.length);
    }

    public static boolean c(byte[] bArr) {
        return (bArr[7] & HeartRateInfo.HR_EMPTY_VALUE) == 1;
    }

    public static int d(byte[] bArr) {
        return ((((bArr[8] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[9] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[10] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[11] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static int e(byte[] bArr) {
        return ((((bArr[22] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[23] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[24] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[25] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static int f(byte[] bArr) {
        return ((((bArr[12] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[13] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[14] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[15] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static int g(byte[] bArr) {
        return ((((bArr[16] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[17] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[18] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[19] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static boolean h(byte[] bArr) {
        return g(bArr) + f(bArr) <= bArr.length && g(bArr) > 0;
    }

    public static int i(byte[] bArr) {
        return ((((bArr[26] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[27] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[28] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[29] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static int j(byte[] bArr) {
        return ((((bArr[30] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[31] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[32] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[33] & HeartRateInfo.HR_EMPTY_VALUE);
    }

    public static boolean k(byte[] bArr) {
        return j(bArr) + i(bArr) <= bArr.length && j(bArr) > 0;
    }
}
