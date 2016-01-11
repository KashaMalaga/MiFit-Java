package cn.com.smartdevices.bracelet.weight;

import android.app.Dialog;
import android.content.Context;

class ay extends Dialog {
    final /* synthetic */ as a;

    public ay(as asVar, Context context, int i) {
        this.a = asVar;
        super(context, i);
    }

    public void cancel() {
        this.a.onCancel(this);
    }
}
