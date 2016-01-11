package com.tencent.open.b;

import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;

public class e {
    public static int a() {
        int i = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_HttpRetryCount");
        return i == 0 ? 2 : i;
    }

    public static int a(String str) {
        int i = OpenConfig.getInstance(Global.getContext(), str).getInt("Common_BusinessReportFrequency");
        return i == 0 ? 100 : i;
    }
}
