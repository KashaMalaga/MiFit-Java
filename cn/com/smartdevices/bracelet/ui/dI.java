package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class dI implements OnClickListener {
    final /* synthetic */ dE a;

    dI(dE dEVar) {
        this.a = dEVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a(this.a.c.getApplicationContext());
        dialogInterface.dismiss();
    }
}
