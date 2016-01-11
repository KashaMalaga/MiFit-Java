package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;

public class D {
    private static final String a = "NotifyConfigUtils";

    public static void a(Context context) {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        readPersonInfo.disableInComingCallTime();
        readPersonInfo.miliConfig.incallNotifyEnabled = false;
        readPersonInfo.setNeedSyncServer(2);
        Keeper.keepPersonInfo(readPersonInfo);
    }

    public static void a(Context context, int i) {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        readPersonInfo.enableInComingCallTime();
        readPersonInfo.miliConfig.incallNotifyEnabled = true;
        readPersonInfo.setInComingCallTime(i);
        readPersonInfo.setNeedSyncServer(2);
        Keeper.keepPersonInfo(readPersonInfo);
    }

    public static void a(Context context, boolean z) {
        C0596r.d(a, "changeAlarmNotify setEnable = " + z);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        MiliConfig miliConfig = readPersonInfo.miliConfig;
        if (miliConfig.alarmNotifyEnabled != z) {
            miliConfig.alarmNotifyEnabled = z;
            readPersonInfo.miliConfig = miliConfig;
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
        }
    }

    public static void a(String str) {
        C0596r.d("PersonInfoUtils", "initMiuiNotify  in...");
        B a = B.a();
        if (a.f()) {
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            MiliConfig miliConfig = readPersonInfo.getMiliConfig();
            boolean z = miliConfig.alarmNotifyEnabled;
            if (z) {
                a.a(str, z);
            }
            z = miliConfig.smsNotifyEnabled;
            boolean z2 = miliConfig.smsContactNotifyEnabled;
            if (z && a.c(str, z)) {
                a.g(str, z2);
            }
            if (readPersonInfo.isInComingCallEnabled()) {
                z = miliConfig.incallNotifyEnabled;
                z2 = miliConfig.incallContactNotifyEnabled;
                int i = miliConfig.inComingCallNotifyTime;
                if (z) {
                    a.b(str, z);
                    a.f(str, z2);
                    if (i < 3 || i > 30) {
                        i = 3;
                    }
                    a.a(str, i);
                }
                C0596r.d("PersonInfoUtils", "initMiuiNotify  out...");
            }
        }
    }

    public static void b(Context context, boolean z) {
        C0596r.d(a, "changeSmsNotify setEnable = " + z);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        MiliConfig miliConfig = readPersonInfo.miliConfig;
        if (miliConfig.smsNotifyEnabled != z) {
            miliConfig.smsNotifyEnabled = z;
            if (!z) {
                miliConfig.smsContactNotifyEnabled = false;
            }
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
        }
    }

    public static void c(Context context, boolean z) {
        C0596r.d(a, "changeIncallNotify setEnable = " + z);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        MiliConfig miliConfig = readPersonInfo.miliConfig;
        if (miliConfig.incallNotifyEnabled != z) {
            miliConfig.incallNotifyEnabled = z;
            if (!z) {
                miliConfig.incallContactNotifyEnabled = false;
            }
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
        }
    }

    public static void d(Context context, boolean z) {
        C0596r.d(a, "changeIncallContactNotify setEnable = " + z);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        MiliConfig miliConfig = readPersonInfo.miliConfig;
        boolean z2 = miliConfig.incallContactNotifyEnabled;
        if (miliConfig.incallNotifyEnabled && z2 != z) {
            miliConfig.incallContactNotifyEnabled = z;
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
        }
    }

    public static void e(Context context, boolean z) {
        C0596r.d(a, "changeSmsContactNotify setEnable = " + z);
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        MiliConfig miliConfig = readPersonInfo.miliConfig;
        boolean z2 = miliConfig.smsContactNotifyEnabled;
        if (miliConfig.smsNotifyEnabled && z2 != z) {
            miliConfig.smsContactNotifyEnabled = z;
            readPersonInfo.setNeedSyncServer(2);
            Keeper.keepPersonInfo(readPersonInfo);
        }
    }
}
