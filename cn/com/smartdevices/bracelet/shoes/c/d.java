package cn.com.smartdevices.bracelet.shoes.c;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;

public class d {
    public static double a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    public static String a(double d) {
        if (d <= 0.0d) {
            return "0.00";
        }
        if (d < 100.0d) {
            return String.format("%.2f", new Object[]{Double.valueOf(d)});
        } else if (d >= 1000.0d) {
            return a.f + ((int) d);
        } else {
            return String.format("%.1f", new Object[]{Double.valueOf(d)});
        }
    }

    public static void a(Activity activity, int i, int i2, f fVar) {
        Activity activity2 = (Activity) new WeakReference(activity).get();
        if (activity2 != null) {
            com.huami.android.view.a eVar = new e(activity2, fVar);
            Bundle bundle = new Bundle();
            bundle.putInt(SocialConstants.PARAM_TITLE, i);
            bundle.putInt(SocialConstants.PARAM_SEND_MSG, i2);
            eVar.setArguments(bundle);
            eVar.setCanceledOnTouchOutside(false);
            eVar.showPanel(activity2.getFragmentManager());
        }
    }

    public static String b(double d) {
        return a.f + ((int) d);
    }

    public static double c(double d) {
        return a(d, 2);
    }
}
