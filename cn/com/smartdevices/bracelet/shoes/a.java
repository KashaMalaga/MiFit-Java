package cn.com.smartdevices.bracelet.shoes;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.sync.C0635l;

public class a {
    private a() {
    }

    public static void a(Context context) {
    }

    public static void b(Context context) {
        if (context != null) {
            C0635l.a(context).i();
            t.a(context);
            cn.com.smartdevices.bracelet.shoes.data.a.a(context);
            c.f(context);
            C0596r.d("ShoesApp", "logout");
        }
    }
}
