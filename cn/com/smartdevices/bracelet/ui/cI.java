package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;

class cI implements OnItemClickListener {
    final /* synthetic */ cH a;

    cI(cH cHVar) {
        this.a = cHVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0596r.e("NewAlarmActivity", "onItemClick: " + i);
        int i2 = AlarmClockItem.WEEK_MASK[i];
        int a = ((1 << i) & this.a.b) >> i;
        C0596r.e("NewAlarmActivity", "thebit at position: " + i + ", thebit=" + a);
        cH cHVar = this.a;
        if (a == 0) {
            i2 |= this.a.b;
        } else {
            i2 = (i2 ^ -1) & this.a.b;
        }
        cHVar.b = i2;
        this.a.a.a(this.a.b);
    }
}
