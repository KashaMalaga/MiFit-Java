package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ak implements OnClickListener {
    final /* synthetic */ StepsCountActivity a;

    ak(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
