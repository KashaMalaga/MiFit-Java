package com.xiaomi.hm.health.dataprocess;

public class DataAnalysis {
    static {
        try {
            System.loadLibrary("dataProcess");
        } catch (Exception e) {
        }
    }

    public static void dataPostProcess(UserInfo userInfo, DaySportData daySportData, DaySportData daySportData2, DaySportData daySportData3, UserSleepModify userSleepModify, UserSleepModify userSleepModify2, byte[] bArr, byte[] bArr2) {
        dataPostProcessNative(userInfo, daySportData, daySportData2, daySportData3, userSleepModify, userSleepModify2, bArr, bArr2);
    }

    public static void dataPostProcessNative(UserInfo userInfo, DaySportData daySportData, DaySportData daySportData2, DaySportData daySportData3, UserSleepModify userSleepModify, UserSleepModify userSleepModify2, byte[] bArr, byte[] bArr2) {
        processData(userInfo, daySportData, daySportData2, daySportData3, userSleepModify, userSleepModify2, bArr, bArr2);
    }

    public static native void processData(UserInfo userInfo, DaySportData daySportData, DaySportData daySportData2, DaySportData daySportData3, UserSleepModify userSleepModify, UserSleepModify userSleepModify2, byte[] bArr, byte[] bArr2);
}
