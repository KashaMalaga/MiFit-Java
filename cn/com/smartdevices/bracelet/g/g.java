package cn.com.smartdevices.bracelet.g;

import android.content.Context;
import android.support.v4.media.h;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.a;

public class g extends a {
    private static final int c = 15;

    public g() {
        super(c);
    }

    protected String a(Context context, String str) {
        a.b(context, "situps");
        return context.getResources().getString(r.sport_ranking_desc_normal, new Object[]{str, context.getResources().getString(r.lab_factory_sport_type_situp)});
    }

    public void a() {
        a.put(Integer.valueOf(0), Double.valueOf(0.0d));
        a.put(Integer.valueOf(10), Double.valueOf(33.0d));
        a.put(Integer.valueOf(20), Double.valueOf(67.0d));
        a.put(Integer.valueOf(30), Double.valueOf(83.0d));
        a.put(Integer.valueOf(40), Double.valueOf(91.0d));
        a.put(Integer.valueOf(50), Double.valueOf(94.0d));
        a.put(Integer.valueOf(60), Double.valueOf(96.0d));
        a.put(Integer.valueOf(70), Double.valueOf(98.0d));
        a.put(Integer.valueOf(90), Double.valueOf(99.0d));
        a.put(Integer.valueOf(110), Double.valueOf(99.4d));
        a.put(Integer.valueOf(120), Double.valueOf(99.5d));
        a.put(Integer.valueOf(h.k), Double.valueOf(99.7d));
        a.put(Integer.valueOf(a.ap), Double.valueOf(99.8d));
        a.put(Integer.valueOf(cn.com.smartdevices.bracelet.gps.c.a.i), Double.valueOf(99.9d));
        a.put(Integer.valueOf(290), Double.valueOf(100.0d));
    }

    public int b() {
        return 10;
    }
}
