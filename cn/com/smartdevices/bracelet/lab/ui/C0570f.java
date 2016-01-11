package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.view.View.OnClickListener;

class C0570f implements OnClickListener {
    final /* synthetic */ LabFactoryConnectedAdvActivity a;

    C0570f(LabFactoryConnectedAdvActivity labFactoryConnectedAdvActivity) {
        this.a = labFactoryConnectedAdvActivity;
    }

    public void onClick(View view) {
        this.a.b.toggle();
    }
}
