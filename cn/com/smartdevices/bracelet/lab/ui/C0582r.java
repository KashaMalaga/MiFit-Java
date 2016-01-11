package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.io.IOException;

class C0582r implements OnClickListener {
    final /* synthetic */ LabFactoryTestActivity a;

    C0582r(LabFactoryTestActivity labFactoryTestActivity) {
        this.a = labFactoryTestActivity;
    }

    public void onClick(View view) {
        try {
            this.a.d();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
