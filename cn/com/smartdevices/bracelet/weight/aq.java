package cn.com.smartdevices.bracelet.weight;

import android.view.View;
import com.huami.android.ui.a;

class aq implements az {
    final /* synthetic */ WeightReportActivity a;

    aq(WeightReportActivity weightReportActivity) {
        this.a = weightReportActivity;
    }

    public void a() {
        this.a.K = false;
        if (a.b(this.a.b)) {
            this.a.getWindow().getDecorView().destroyDrawingCache();
            return;
        }
        View findViewById = this.a.findViewById(16908290);
        if (findViewById != null) {
            findViewById.destroyDrawingCache();
        }
    }
}
