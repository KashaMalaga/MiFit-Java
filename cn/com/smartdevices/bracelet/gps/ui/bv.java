package cn.com.smartdevices.bracelet.gps.ui;

import android.view.View;
import android.view.View.OnClickListener;

class bv implements OnClickListener {
    final /* synthetic */ bu a;

    bv(bu buVar) {
        this.a = buVar;
    }

    public void onClick(View view) {
        if (this.a.e != null) {
            this.a.e.h();
        }
    }
}
