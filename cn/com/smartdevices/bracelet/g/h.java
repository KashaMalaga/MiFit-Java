package cn.com.smartdevices.bracelet.g;

import android.content.Context;
import com.d.a.a.C1012a;
import com.f.a.b.d.a;
import com.xiaomi.hm.health.R;

public class h extends a {
    private static final int c = 21;

    public h() {
        super(c);
    }

    protected String a(Context context, String str) {
        a.b(context, "weeklywalk");
        return context.getString(R.string.share_step_ranking, new Object[]{str});
    }

    public void a() {
        a.put(Integer.valueOf(0), Double.valueOf(0.0d));
        a.put(Integer.valueOf(a.a), Double.valueOf(7.0d));
        a.put(Integer.valueOf(C1012a.b), Double.valueOf(11.0d));
        a.put(Integer.valueOf(cn.com.smartdevices.bracelet.gps.c.a.k), Double.valueOf(16.0d));
        a.put(Integer.valueOf(a.b), Double.valueOf(20.0d));
        a.put(Integer.valueOf(25000), Double.valueOf(25.0d));
        a.put(Integer.valueOf(kankan.wheel.widget.a.as), Double.valueOf(30.0d));
        a.put(Integer.valueOf(35000), Double.valueOf(36.0d));
        a.put(Integer.valueOf(40000), Double.valueOf(43.0d));
        a.put(Integer.valueOf(45000), Double.valueOf(49.0d));
        a.put(Integer.valueOf(50000), Double.valueOf(56.0d));
        a.put(Integer.valueOf(55000), Double.valueOf(62.0d));
        a.put(Integer.valueOf(60000), Double.valueOf(68.0d));
        a.put(Integer.valueOf(65000), Double.valueOf(74.0d));
        a.put(Integer.valueOf(70000), Double.valueOf(79.0d));
        a.put(Integer.valueOf(75000), Double.valueOf(83.0d));
        a.put(Integer.valueOf(80000), Double.valueOf(87.0d));
        a.put(Integer.valueOf(85000), Double.valueOf(89.0d));
        a.put(Integer.valueOf(90000), Double.valueOf(91.9d));
        a.put(Integer.valueOf(95000), Double.valueOf(93.7d));
        a.put(Integer.valueOf(100000), Double.valueOf(95.19d));
    }

    public int b() {
        return a.a;
    }
}
