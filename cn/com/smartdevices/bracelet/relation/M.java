package cn.com.smartdevices.bracelet.relation;

import android.app.Dialog;
import android.content.Context;

class M extends Dialog {
    final /* synthetic */ J a;

    public M(J j, Context context, int i) {
        this.a = j;
        super(context, i);
    }

    public void cancel() {
        this.a.onCancel(this);
    }
}
