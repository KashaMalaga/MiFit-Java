package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;

class F extends I {
    final /* synthetic */ BindQQHealthActivity a;

    F(BindQQHealthActivity bindQQHealthActivity) {
        this.a = bindQQHealthActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.a.setNeedLogin(false);
        this.a.a.setNeedSwitchLogin(false);
        this.a.a.setLoginCanceled(true);
    }

    protected void onRightButtonClicked() {
        this.a.c();
        dismiss();
    }
}
