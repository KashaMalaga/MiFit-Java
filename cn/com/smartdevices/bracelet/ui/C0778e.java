package cn.com.smartdevices.bracelet.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.f.f;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.g;

class C0778e extends BaseAdapter {
    private static final String b = "AlarmAdapter";
    final /* synthetic */ AlarmActivity a;
    private final String c;

    public C0778e(AlarmActivity alarmActivity) {
        this.a = alarmActivity;
        this.c = alarmActivity.p.getResources().getString(r.clock_closed);
    }

    public int getCount() {
        C0596r.e(b, "getCount");
        return this.a.u.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AlarmClockItem alarmClockItem = (AlarmClockItem) this.a.u.get(i);
        View inflate = LayoutInflater.from(this.a.p).inflate(n.view_alarm_clock_item, null);
        TextView textView = (TextView) inflate.findViewById(l.alarm_time_txt);
        TextView textView2 = (TextView) inflate.findViewById(l.alarm_week_txt);
        TextView textView3 = (TextView) inflate.findViewById(l.alarm_ampm_txt);
        TextView textView4 = (TextView) inflate.findViewById(l.alarm_smart_wakeup_txt);
        if (this.a.D) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            if (alarmClockItem.getCalendar().get(9) != 0) {
                textView3.setText(r.pm);
            } else if (f.c(alarmClockItem.getCalendar().getTime())) {
                textView3.setText(this.a.getString(r.wee_hour));
            } else {
                textView3.setText(r.am);
            }
        }
        textView.setText(Utils.a(alarmClockItem, this.a.D));
        if (alarmClockItem.isEnabled()) {
            textView.setTextColor(this.a.p.getResources().getColor(g.main_ui_title_color));
            if (alarmClockItem.isSmartWakeup()) {
                textView2.setText(Utils.a(this.a.p, alarmClockItem));
                textView4.setVisibility(0);
            } else {
                textView2.setText(Utils.a(this.a.p, alarmClockItem));
                textView4.setVisibility(8);
            }
        } else {
            textView.setTextColor(this.a.p.getResources().getColor(g.main_ui_content_color));
            textView.setText(Utils.a(alarmClockItem, this.a.D));
            textView2.setText(this.c);
        }
        Switch switchR = (Switch) inflate.findViewById(l.alarm_switch_cb);
        this.a.B.add(switchR);
        this.a.C.add((ImageView) inflate.findViewById(l.alarm_right_arrow));
        switchR.setChecked(alarmClockItem.isEnabled());
        switchR.setOnCheckedChangeListener(new C0806f(this, alarmClockItem));
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(l.item);
        relativeLayout.setTag(Integer.valueOf(i));
        relativeLayout.setOnClickListener(new C0808h(this));
        return inflate;
    }
}
