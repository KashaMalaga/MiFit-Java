package cn.com.smartdevices.bracelet.g;

import android.content.Context;
import android.support.v4.media.h;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.xiaomi.hm.health.r;

public class f extends a {
    private static final int c = 33;

    public f() {
        super(c);
    }

    protected String a(Context context, String str) {
        a.b(context, "ropeskipping");
        return context.getResources().getString(r.sport_ranking_desc_normal, new Object[]{str, context.getResources().getString(r.lab_factory_sport_type_ropeskipping)});
    }

    public void a() {
        a.put(Integer.valueOf(0), Double.valueOf(0.0d));
        a.put(Integer.valueOf(10), Double.valueOf(18.0d));
        a.put(Integer.valueOf(20), Double.valueOf(55.0d));
        a.put(Integer.valueOf(30), Double.valueOf(67.0d));
        a.put(Integer.valueOf(40), Double.valueOf(73.0d));
        a.put(Integer.valueOf(50), Double.valueOf(78.0d));
        a.put(Integer.valueOf(60), Double.valueOf(81.0d));
        a.put(Integer.valueOf(70), Double.valueOf(85.0d));
        a.put(Integer.valueOf(80), Double.valueOf(87.0d));
        a.put(Integer.valueOf(90), Double.valueOf(88.0d));
        a.put(Integer.valueOf(100), Double.valueOf(90.0d));
        a.put(Integer.valueOf(110), Double.valueOf(92.0d));
        a.put(Integer.valueOf(120), Double.valueOf(93.0d));
        a.put(Integer.valueOf(h.k), Double.valueOf(94.0d));
        a.put(Integer.valueOf(140), Double.valueOf(95.0d));
        a.put(Integer.valueOf(160), Double.valueOf(96.0d));
        a.put(Integer.valueOf(a.i), Double.valueOf(97.0d));
        a.put(Integer.valueOf(210), Double.valueOf(98.0d));
        a.put(Integer.valueOf(250), Double.valueOf(99.0d));
        a.put(Integer.valueOf(310), Double.valueOf(99.1d));
        a.put(Integer.valueOf(kankan.wheel.widget.a.by), Double.valueOf(99.2d));
        a.put(Integer.valueOf(340), Double.valueOf(99.3d));
        a.put(Integer.valueOf(370), Double.valueOf(99.4d));
        a.put(Integer.valueOf(410), Double.valueOf(99.5d));
        a.put(Integer.valueOf(kankan.wheel.widget.a.aA), Double.valueOf(99.6d));
        a.put(Integer.valueOf(510), Double.valueOf(99.7d));
        a.put(Integer.valueOf(610), Double.valueOf(99.8d));
        a.put(Integer.valueOf(710), Double.valueOf(99.85d));
        a.put(Integer.valueOf(760), Double.valueOf(99.86d));
        a.put(Integer.valueOf(810), Double.valueOf(99.87d));
        a.put(Integer.valueOf(940), Double.valueOf(99.88d));
        a.put(Integer.valueOf(com.xiaomi.account.openauth.h.E), Double.valueOf(99.89d));
    }

    public int b() {
        return 10;
    }
}
