package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import kankan.wheel.widget.g;

public class C0828b extends Y {
    private static final String e = "DayRepeatAdapter";

    public C0828b(Context context, String[] strArr, int i) {
        super(context, strArr, i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(n.view_select_days_repeat_item, null);
        }
        TextView textView = (TextView) view.findViewById(l.week_tv);
        textView.setText(this.d[i]);
        textView.setTextColor(this.a.getResources().getColor(g.main_ui_title_color));
        ImageView imageView = (ImageView) view.findViewById(l.day_repeat_select_mark);
        if (((this.b & AlarmClockItem.WEEK_MASK[i]) != 0 ? 1 : null) != null) {
            C0596r.e(e, "mDays =" + this.b + ", checkbox = " + imageView);
            imageView.setImageResource(k.checkbox_checked);
        } else {
            imageView.setImageResource(k.checkbox_unchecked);
        }
        return view;
    }
}
