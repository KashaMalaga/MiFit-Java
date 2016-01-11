package cn.com.smartdevices.bracelet.g;

import android.content.Context;
import com.d.a.a.C1012a;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.a;

public class b extends a {
    private static final int c = 13;

    public b() {
        super(c);
    }

    protected String a(Context context, String str) {
        a.b(context, "dailywalk");
        return context.getString(r.share_step_ranking, new Object[]{str});
    }

    public void a() {
        a.put(Integer.valueOf(0), Double.valueOf(0.0d));
        a.put(Integer.valueOf(a.bZ), Double.valueOf(11.0d));
        a.put(Integer.valueOf(4000), Double.valueOf(20.0d));
        a.put(Integer.valueOf(6000), Double.valueOf(33.0d));
        a.put(Integer.valueOf(a.bS), Double.valueOf(49.0d));
        a.put(Integer.valueOf(C1012a.b), Double.valueOf(64.0d));
        a.put(Integer.valueOf(a.bT), Double.valueOf(77.0d));
        a.put(Integer.valueOf(14000), Double.valueOf(86.0d));
        a.put(Integer.valueOf(16000), Double.valueOf(91.6d));
        a.put(Integer.valueOf(18000), Double.valueOf(95.01d));
        a.put(Integer.valueOf(com.f.a.b.d.a.b), Double.valueOf(97.06d));
        a.put(Integer.valueOf(22000), Double.valueOf(98.23d));
        a.put(Integer.valueOf(24000), Double.valueOf(98.98d));
    }

    public int b() {
        return a.bZ;
    }
}
