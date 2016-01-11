package cn.com.smartdevices.bracelet.ui;

import android.app.Dialog;
import android.content.Context;

class bQ extends Dialog {
    final /* synthetic */ bH a;

    public bQ(bH bHVar, Context context, int i) {
        this.a = bHVar;
        super(context, i);
    }

    public void cancel() {
        this.a.onCancel(this);
    }
}
