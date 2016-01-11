package cn.com.smartdevices.bracelet.shoes.b;

import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import java.lang.reflect.Field;

public class l {
    private l() {
    }

    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            Class cls = Class.forName("cn.com.smartdevices.bracelet.ui.StatisticActivity");
            Class cls2 = Class.forName("cn.com.smartdevices.bracelet.chart.util.ChartData");
            Field field = cls2.getField("KEY_MODE");
            Field field2 = cls2.getField("MODE_STEP");
            Field field3 = cls2.getField("KEY_SOURCE");
            Field field4 = cls.getField("EXTRA_SYNC_ACTION");
            String str = (String) field.get(null);
            String str2 = (String) field3.get(null);
            int intValue = ((Integer) field2.get(null)).intValue();
            String str3 = (String) field4.get(null);
            Intent intent = new Intent(context, cls);
            intent.putExtra(str, intValue);
            intent.putExtra(str2, d.a);
            intent.putExtra(str3, "com.xiaomi.hm.health.action.SHOES_SYNC_SERVICE");
            context.startActivity(intent);
        } catch (Exception e) {
            C0596r.a("Statistic", "startMainStatisticActivity " + e);
        }
    }
}
