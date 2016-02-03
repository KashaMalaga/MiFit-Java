package cn.com.smartdevices.bracelet.g;

import android.content.Context;
import com.f.a.b.d.a;
import com.xiaomi.hm.health.R;

public class e extends a {
    private static final int c = 21;

    public e() {
        super(c);
    }

    protected String a(Context context, String str) {
        a.b(context, "weeklywalk");
        return context.getString(R.string.share_step_ranking, new Object[]{str});
    }

    public void a() {
        a.put(Integer.valueOf(0), Double.valueOf(0.0d));
        a.put(Integer.valueOf(a.b), Double.valueOf(16.0d));
        a.put(Integer.valueOf(40000), Double.valueOf(25.0d));
        a.put(Integer.valueOf(60000), Double.valueOf(33.0d));
        a.put(Integer.valueOf(80000), Double.valueOf(40.0d));
        a.put(Integer.valueOf(100000), Double.valueOf(47.0d));
        a.put(Integer.valueOf(kankan.wheel.widget.a.bw), Double.valueOf(53.0d));
        a.put(Integer.valueOf(140000), Double.valueOf(58.0d));
        a.put(Integer.valueOf(160000), Double.valueOf(63.0d));
        a.put(Integer.valueOf(180000), Double.valueOf(68.0d));
        a.put(Integer.valueOf(200000), Double.valueOf(72.0d));
        a.put(Integer.valueOf(220000), Double.valueOf(76.0d));
        a.put(Integer.valueOf(240000), Double.valueOf(80.0d));
        a.put(Integer.valueOf(260000), Double.valueOf(83.0d));
        a.put(Integer.valueOf(280000), Double.valueOf(86.0d));
        a.put(Integer.valueOf(300000), Double.valueOf(89.0d));
        a.put(Integer.valueOf(320000), Double.valueOf(90.9d));
        a.put(Integer.valueOf(340000), Double.valueOf(92.7d));
        a.put(Integer.valueOf(360000), Double.valueOf(94.6d));
        a.put(Integer.valueOf(380000), Double.valueOf(96.11d));
        a.put(Integer.valueOf(400000), Double.valueOf(97.02d));
    }

    public int b() {
        return a.b;
    }
}
