package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.lab.ui.view.LabCircleView;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.util.ArrayList;
import java.util.List;

public class T extends BaseAdapter {
    private List<Bundle> a;
    private LayoutInflater b;

    public T(Context context) {
        this.a = null;
        this.b = null;
        this.a = new ArrayList();
        this.b = LayoutInflater.from(context);
    }

    public Bundle a(int i) {
        return (Bundle) this.a.get(i);
    }

    public void a() {
        if (this.a != null) {
            this.a.clear();
        }
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException();
        }
        this.a.add(bundle);
    }

    public int getCount() {
        return this.a.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        U u;
        if (view == null) {
            u = new U();
            view = this.b.inflate(n.activity_lab_sport_group_list_item, null, false);
            u.b = (LabCircleView) view.findViewById(l.group_item_member);
            u.a = (TextView) view.findViewById(l.group_item_linker);
            view.setTag(u);
        } else {
            u = (U) view.getTag();
        }
        u.a.setText(((Bundle) this.a.get(i)).getInt(C0568d.b));
        u.b.setVisibility(0);
        return view;
    }
}
