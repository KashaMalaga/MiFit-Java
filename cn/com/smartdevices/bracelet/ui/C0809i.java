package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;

class C0809i implements OnItemClickListener {
    final /* synthetic */ AlarmRepeatActivity a;

    C0809i(AlarmRepeatActivity alarmRepeatActivity) {
        this.a = alarmRepeatActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0596r.e("AlarmRepeatActivity", "onItemClick: " + i);
        int i2 = AlarmClockItem.WEEK_MASK[i];
        int a = ((1 << i) & this.a.c) >> i;
        C0596r.e("AlarmRepeatActivity", "thebit at position: " + i + ", thebit=" + a);
        AlarmRepeatActivity alarmRepeatActivity = this.a;
        if (a == 0) {
            i2 |= this.a.c;
        } else {
            i2 = (i2 ^ -1) & this.a.c;
        }
        alarmRepeatActivity.c = i2;
        this.a.b.a(this.a.c);
        this.a.a();
    }
}
