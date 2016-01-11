package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.NewAlarmActivity;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import kankan.wheel.widget.g;

public class J extends Y {
    private static final int e = 3;
    private static final String f = "SimpleAlarmWeekAdapter";

    public J(Context context, String[] strArr, int i) {
        super(context, strArr, i);
    }

    private boolean b() {
        for (int i : NewAlarmActivity.a) {
            if (this.b == i) {
                return false;
            }
        }
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(n.view_select_days_item, null);
        }
        View findViewById = view.findViewById(l.select_marker);
        findViewById.setVisibility(4);
        TextView textView = (TextView) view.findViewById(l.week_tv);
        textView.setText(this.d[i]);
        textView.setTextColor(this.a.getResources().getColor(g.main_ui_title_color));
        C0596r.e(f, "Get view : mdays:" + this.b + ", pos:" + i + ", day:" + NewAlarmActivity.a[i]);
        if (i == e) {
            if (b()) {
                textView.setTextColor(this.a.getResources().getColor(g.bg_color_blue));
                findViewById.setVisibility(0);
            }
        } else if (this.b == NewAlarmActivity.a[i]) {
            textView.setTextColor(this.a.getResources().getColor(g.bg_color_blue));
            findViewById.setVisibility(0);
        }
        return view;
    }
}
