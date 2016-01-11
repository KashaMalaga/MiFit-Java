package cn.com.smartdevices.bracelet.gps.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class E implements OnDismissListener {
    final /* synthetic */ GPSResultActivity a;

    E(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a.d();
    }
}
