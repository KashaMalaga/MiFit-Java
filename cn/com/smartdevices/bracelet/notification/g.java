package cn.com.smartdevices.bracelet.notification;

import android.content.res.Configuration;
import android.content.res.Resources;

public class g {
    final Configuration a = new Configuration();
    int b;

    boolean a(Resources resources) {
        int updateFrom = this.a.updateFrom(resources.getConfiguration());
        if (!(this.b != resources.getDisplayMetrics().densityDpi) && (updateFrom & 772) == 0) {
            return false;
        }
        this.b = resources.getDisplayMetrics().densityDpi;
        return true;
    }
}
