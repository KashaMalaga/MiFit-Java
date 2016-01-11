package cn.com.smartdevices.bracelet.gps.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class aE implements OnCancelListener {
    final /* synthetic */ PaceDetailActivity a;

    aE(PaceDetailActivity paceDetailActivity) {
        this.a = paceDetailActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.d = null;
    }
}
