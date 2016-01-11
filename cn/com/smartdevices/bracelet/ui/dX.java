package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.com.smartdevices.bracelet.Keeper;

class dX implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ dW b;

    dX(dW dWVar, String str) {
        this.b = dWVar;
        this.a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a(Keeper.readBraceletBtInfo().b, this.a);
        dialogInterface.dismiss();
    }
}
