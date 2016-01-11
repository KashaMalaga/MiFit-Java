package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class SelectDaysView extends LinearLayout {
    private ListView a;
    private Context b;
    private int c;
    private String[] d;
    private Y e;

    public SelectDaysView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectDaysView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.b = context;
        View inflate = LayoutInflater.from(this.b).inflate(n.view_alarm_select_days, null);
        this.a = (ListView) inflate.findViewById(l.alarm_select_days_lv);
        addView(inflate);
    }

    public int a() {
        return this.e.a();
    }

    public void a(int i) {
        this.e.a(i);
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.a.setOnItemClickListener(onItemClickListener);
    }

    public void a(Y y) {
        this.e = y;
        this.a.setAdapter(y);
    }
}
