package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Bundle;
import cn.com.smartdevices.bracelet.lab.k;

public final class ad {
    public static final String a = (ad.class.getPackage().getName() + ".extra.SHARED_SUB_TITLE");
    public static final String b = (ad.class.getPackage().getName() + ".extra.SHARED_SPORT_COUNT");
    public static final String c = (ad.class.getPackage().getName() + ".extra.SHARED_GROUP_DES");
    public static final String d = (ad.class.getPackage().getName() + ".extra.SHARED_HISTORY_BEST_RECORD");
    public static final String e = (ad.class.getPackage().getName() + ".extra.SHARED_ACCUMULATED_TIME");
    public static final String f = k.h;

    private ad() {
    }

    public static Bundle a(String str, int i, String str2, String str3, long j, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString(a, str);
        bundle.putInt(b, i);
        bundle.putString(f, str2);
        bundle.putString(c, str3);
        bundle.putInt(d, i2);
        bundle.putLong(e, j);
        return bundle;
    }
}
