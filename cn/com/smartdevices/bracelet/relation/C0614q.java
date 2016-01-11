package cn.com.smartdevices.bracelet.relation;

import android.app.Dialog;
import android.content.Context;

class C0614q extends Dialog {
    final /* synthetic */ C0611n a;

    public C0614q(C0611n c0611n, Context context, int i) {
        this.a = c0611n;
        super(context, i);
    }

    public void cancel() {
        this.a.onCancel(this);
    }
}
