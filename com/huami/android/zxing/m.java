package com.huami.android.zxing;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class m implements OnCancelListener, OnClickListener {
    private final Activity a;

    public m(Activity activity) {
        this.a = activity;
    }

    private void a() {
        this.a.finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        a();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        a();
    }
}
