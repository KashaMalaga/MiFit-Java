package com.huami.android.widget.share;

import cn.com.smartdevices.bracelet.C0596r;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

class n implements IUiListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public void onCancel() {
    }

    public void onComplete(Object obj) {
        C0596r.e("ShareManager", "share_qq_selector");
    }

    public void onError(UiError uiError) {
        C0596r.b("ShareManager", uiError.errorMessage + "|" + uiError.errorCode);
    }
}
