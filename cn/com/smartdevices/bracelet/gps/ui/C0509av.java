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

final class C0509av extends BaseAdapter {
    final /* synthetic */ LabelInputActivity a;
    private List<String> b = null;
    private LayoutInflater c = null;

    public C0509av(LabelInputActivity labelInputActivity, Context context, List<String> list) {
        this.a = labelInputActivity;
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
        C0507at c0507at;
        if (view == null) {
            c0507at = new C0507at(this.a);
            view = this.c.inflate(j.running_label_input_list_item, null);
            c0507at.a = (TextView) view.findViewById(i.label);
            view.setTag(c0507at);
        } else {
            c0507at = (C0507at) view.getTag();
        }
        c0507at.a.setText((String) this.b.get(i));
        return view;
    }
}
