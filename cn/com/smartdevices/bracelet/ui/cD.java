package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.huami.android.view.c;
import kankan.wheel.widget.a;

class cD implements OnClickListener {
    final /* synthetic */ NewAlarmActivity a;

    cD(NewAlarmActivity newAlarmActivity) {
        this.a = newAlarmActivity;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(a.bv, this.a.k.getCoded());
        c.showPanel(this.a, cJ.class, bundle);
    }
}
