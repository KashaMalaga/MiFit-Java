package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.xiaomi.hm.health.c.g;
import com.xiaomi.hm.health.c.h;
import com.xiaomi.hm.health.c.i;
import java.util.ArrayList;
import java.util.List;

class T extends BaseAdapter {
    private final Context a;
    private List<e> b = null;
    private LayoutInflater c = null;

    public T(Context context) {
        this.a = context;
        this.c = (LayoutInflater) this.a.getSystemService("layout_inflater");
        this.b = new ArrayList();
    }

    public e a(int i) {
        return (this.b.size() == 0 || i < 0 || i >= this.b.size()) ? null : (e) this.b.get(i);
    }

    public void a() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void a(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException();
        }
        this.b.add(eVar);
    }

    public void a(List<e> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        } else if (list.size() != 0) {
            this.b.addAll(list);
        }
    }

    public int getCount() {
        return this.b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        V v;
        if (view == null) {
            v = new V();
            view = this.c.inflate(i.shoes_list_item, null);
            v.b = (ImageView) view.findViewById(h.shoes_icon);
            v.a = (TextView) view.findViewById(h.shoes_name);
            v.c = (TextView) view.findViewById(h.shoes_bind);
            view.setTag(v);
        } else {
            v = (V) view.getTag();
        }
        e eVar = (e) this.b.get(i);
        v.b.setImageDrawable(N.a(this.a, eVar, g.shoes_lining_guangsu_color));
        CharSequence d = eVar.d();
        if (TextUtils.isEmpty(d)) {
            d = eVar.h();
        }
        v.a.setText(d);
        v.c.setVisibility(eVar.k() ? 0 : 8);
        return view;
    }
}
