package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.lab.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.util.ArrayList;
import java.util.List;

class N extends BaseExpandableListAdapter {
    private SparseArray<ArrayList<a>> a;
    private LayoutInflater b = null;

    public N(Context context, SparseArray<ArrayList<a>> sparseArray) {
        if (sparseArray != null) {
            this.a = sparseArray;
        } else {
            this.a = new SparseArray();
        }
        this.b = LayoutInflater.from(context);
    }

    public a a(int i, int i2) {
        List list = (List) this.a.get(this.a.keyAt(i));
        return list == null ? null : (a) list.get(i2);
    }

    public Integer a(int i) {
        return Integer.valueOf(this.a.keyAt(i));
    }

    public void a(SparseArray<ArrayList<a>> sparseArray) {
        this.a = sparseArray;
        notifyDataSetChanged();
    }

    public /* synthetic */ Object getChild(int i, int i2) {
        return a(i, i2);
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        M m;
        if (view == null) {
            view = this.b.inflate(n.activity_service_list_item, null);
            M m2 = new M();
            m2.a = (TextView) view.findViewById(l.service_name);
            m2.b = view.findViewById(l.divider);
            view.setTag(m2);
            m = m2;
        } else {
            m = (M) view.getTag();
        }
        a a = a(i, i2);
        if (a != null) {
            m.a.setText(a.a);
        }
        if (z) {
            m.b.setVisibility(8);
        } else {
            m.b.setVisibility(0);
        }
        return view;
    }

    public int getChildrenCount(int i) {
        List list = (List) this.a.get(this.a.keyAt(i));
        return list == null ? 0 : list.size();
    }

    public /* synthetic */ Object getGroup(int i) {
        return a(i);
    }

    public int getGroupCount() {
        return this.a == null ? 0 : this.a.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        return view == null ? this.b.inflate(n.activity_service_list_item_category, null) : view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
