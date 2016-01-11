package cn.com.smartdevices.bracelet.lab.ui;

import android.view.View;
import android.view.View.OnClickListener;

class aj implements OnClickListener {
    final /* synthetic */ StepsCountActivity a;

    aj(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void onClick(View view) {
        this.a.on_start_button_click_count();
    }
}
