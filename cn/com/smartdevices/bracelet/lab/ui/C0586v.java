package cn.com.smartdevices.bracelet.lab.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.com.smartdevices.bracelet.lab.a.a;

class C0586v implements OnClickListener {
    final /* synthetic */ LabFactoryTestActivity a;

    C0586v(LabFactoryTestActivity labFactoryTestActivity) {
        this.a = labFactoryTestActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.t.a();
        a.b();
        this.a.a();
    }
}
