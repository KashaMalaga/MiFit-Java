package cn.com.smartdevices.bracelet.gps.ui;

import android.view.View;
import android.view.View.OnClickListener;

class br implements OnClickListener {
    final /* synthetic */ WatermarkBar a;

    br(WatermarkBar watermarkBar) {
        this.a = watermarkBar;
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            int parseInt = Integer.parseInt(view.getTag().toString());
            this.a.a(parseInt);
            if (this.a.d != null) {
                this.a.d.a(parseInt);
            }
        }
    }
}
