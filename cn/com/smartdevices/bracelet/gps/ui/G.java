package cn.com.smartdevices.bracelet.gps.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

class G implements OnLongClickListener {
    final /* synthetic */ GPSResultActivity a;

    G(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    public boolean onLongClick(View view) {
        this.a.f();
        return true;
    }
}
