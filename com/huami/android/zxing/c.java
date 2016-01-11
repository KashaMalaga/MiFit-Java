package com.huami.android.zxing;

import android.content.DialogInterface;
import com.huami.android.view.a;

class c extends a {
    final /* synthetic */ CaptureActivity a;

    c(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        dismiss();
        this.a.finish();
    }

    protected void onRightButtonClicked() {
        dismiss();
        this.a.finish();
    }
}
