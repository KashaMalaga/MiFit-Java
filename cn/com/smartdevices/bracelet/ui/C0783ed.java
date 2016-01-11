package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class C0783ed implements OnCancelListener {
    final /* synthetic */ C0782ec a;

    C0783ed(C0782ec c0782ec) {
        this.a = c0782ec;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.g = true;
    }
}
