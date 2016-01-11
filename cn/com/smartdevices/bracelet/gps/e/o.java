package cn.com.smartdevices.bracelet.gps.e;

import android.content.Context;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import java.util.List;
import kankan.wheel.widget.a;

public class o {
    private o() {
    }

    public static e a(Context context) {
        List<e> d = t.d(context);
        if (d == null || d.size() == 0) {
            return null;
        }
        for (e eVar : d) {
            if (eVar.k()) {
                return eVar;
            }
        }
        return (e) d.get(0);
    }

    public static String[] b(Context context) {
        if (t.e(context) == null) {
            return null;
        }
        return new String[]{t.e(context).j(), t.e(context).c() + a.ci + t.e(context).o()};
    }
}
