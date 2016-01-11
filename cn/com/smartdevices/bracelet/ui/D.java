package cn.com.smartdevices.bracelet.ui;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

class D implements IUiListener {
    final /* synthetic */ BindQQHealthActivity a;

    D(BindQQHealthActivity bindQQHealthActivity) {
        this.a = bindQQHealthActivity;
    }

    public void onCancel() {
    }

    public void onComplete(Object obj) {
        this.a.a(this.a.f, this.a.g);
    }

    public void onError(UiError uiError) {
    }
}
