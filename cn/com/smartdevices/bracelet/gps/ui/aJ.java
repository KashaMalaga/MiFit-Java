package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.com.smartdevices.bracelet.gps.model.i;
import com.xiaomi.hm.health.b.a.j;
import java.util.List;

class aJ extends BaseAdapter {
    final /* synthetic */ aH a;
    private final List<i> b;
    private final LayoutInflater c;

    public aJ(aH aHVar, Context context, List<i> list) {
        this.a = aHVar;
        this.b = list;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.b != null ? this.b.size() : 0;
    }

    public Object getItem(int i) {
        return this.b != null ? (i) this.b.get(i) : null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        aK aKVar;
        if (view == null) {
            view = this.c.inflate(j.fragment_running_pace_item, viewGroup, false);
            aK aKVar2 = new aK(this, view);
            view.setTag(aKVar2);
            aKVar = aKVar2;
        } else {
            aKVar = (aK) view.getTag();
        }
        if (this.b != null) {
            aKVar.a((i) this.b.get(i));
        }
        return view;
    }
}
