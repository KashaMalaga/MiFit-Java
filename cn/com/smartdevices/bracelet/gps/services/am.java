package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.e.a;
import cn.com.smartdevices.bracelet.shoes.data.b;

public class am {
    private am() {
    }

    public static StepProvider a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (b.b(context)) {
            return new R(context);
        } else {
            if (a.h() || a.f()) {
                return new ad(context);
            }
            C0596r.d("Step", "getStepProvider got none");
            return null;
        }
    }
}
