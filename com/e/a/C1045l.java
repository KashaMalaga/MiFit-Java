package com.e.a;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class C1045l implements Q {
    public Object a(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i = intValue >> 24;
        int i2 = (intValue >> 16) & HeartRateInfo.HR_EMPTY_VALUE;
        int i3 = (intValue >> 8) & HeartRateInfo.HR_EMPTY_VALUE;
        intValue &= HeartRateInfo.HR_EMPTY_VALUE;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf((intValue + ((int) (((float) ((intValue2 & HeartRateInfo.HR_EMPTY_VALUE) - intValue)) * f))) | ((((i + ((int) (((float) ((intValue2 >> 24) - i)) * f))) << 24) | ((i2 + ((int) (((float) (((intValue2 >> 16) & HeartRateInfo.HR_EMPTY_VALUE) - i2)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & HeartRateInfo.HR_EMPTY_VALUE) - i3)) * f)) + i3) << 8)));
    }
}
