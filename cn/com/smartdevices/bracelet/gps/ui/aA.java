package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import java.util.List;

final class aA extends BaseAdapter {
    final /* synthetic */ C0510aw a;
    private List<String> b = null;
    private LayoutInflater c = null;

    public aA(C0510aw c0510aw, Context context, List<String> list) {
        this.a = c0510aw;
        this.b = list;
        this.c = LayoutInflater.from(context);
    }

    public String a(int i) {
        return (this.b == null || i < 0 || i >= this.b.size()) ? null : (String) this.b.get(i);
    }

    public int getCount() {
        return this.b == null ? 0 : this.b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0512ay c0512ay;
        if (view == null) {
            c0512ay = new C0512ay(this.a);
            view = this.c.inflate(j.running_label_input_list_item, null);
            c0512ay.a = (TextView) view.findViewById(i.label);
            view.setTag(c0512ay);
        } else {
            c0512ay = (C0512ay) view.getTag();
        }
        c0512ay.a.setText((String) this.b.get(i));
        return view;
    }
}
