package cn.com.smartdevices.bracelet.lab.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

class C0578n implements OnClickListener {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ LabFactoryTestActivity b;

    C0578n(LabFactoryTestActivity labFactoryTestActivity, ArrayList arrayList) {
        this.b = labFactoryTestActivity;
        this.a = arrayList;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.u.a(this.a);
    }
}
