package cn.com.smartdevices.bracelet.gps.a;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;

public class c {
    private c() {
    }

    public static void a(Context context) {
        if (context != null) {
            C0401a.a(context.getApplicationContext(), C0409b.g);
        }
    }
}
