package cn.com.smartdevices.bracelet.gps.ui;

import android.content.DialogInterface;
import com.huami.android.view.a;

class bi extends a {
    final /* synthetic */ WatermarkActivity a;

    bi(WatermarkActivity watermarkActivity) {
        this.a = watermarkActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
    }

    protected void onRightButtonClicked() {
        this.a.finish();
    }
}
