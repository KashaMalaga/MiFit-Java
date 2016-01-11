package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.eventbus.weight.EventScaleStatus;

class C0808h implements OnClickListener {
    final /* synthetic */ C0778e a;

    C0808h(C0778e c0778e) {
        this.a = c0778e;
    }

    public void onClick(View view) {
        this.a.a.v = ((Integer) view.getTag()).intValue();
        Intent intent = new Intent();
        intent.setClass(this.a.a.p, NewAlarmActivity.class);
        intent.putExtra(AlarmActivity.b, this.a.a.v);
        this.a.a.p.startActivityForResult(intent, EventScaleStatus.SCALE_FOUNDED);
    }
}
