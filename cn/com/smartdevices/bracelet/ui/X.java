package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.util.ArrayList;
import java.util.List;

public class X extends BaseAdapter {
    private final Context a;
    private final LayoutInflater b = ((LayoutInflater) this.a.getSystemService("layout_inflater"));
    private final List<Z> c = new ArrayList();

    public X(Context context) {
        this.a = context;
    }

    public void a() {
        this.c.clear();
        Z z = new Z(this);
        Resources resources = this.a.getResources();
        z.a = C0671aa.BRACELET;
        z.b = resources.getDrawable(k.ic_devices_bind_band);
        z.c = resources.getString(r.mi_band);
        z.d = DeviceSource.hasBindBracelet();
        this.c.add(z);
        if (b.h().l.a.booleanValue()) {
            z = new Z(this);
            z.a = C0671aa.WEIGHT;
            z.b = resources.getDrawable(k.ic_devices_bind_weight);
            z.c = resources.getString(r.weight_scale);
            z.d = DeviceSource.hasBindWeight();
            this.c.add(z);
        }
        List<e> d = t.d(this.a);
        if (d != null) {
            for (e eVar : d) {
                Z z2 = new Z(this);
                z2.a = C0671aa.SHOES;
                z2.b = this.a.getResources().getDrawable(k.ic_devices_bind_shoes_lj);
                String d2 = eVar.d();
                if (TextUtils.isEmpty(d2)) {
                    d2 = eVar.h();
                }
                z2.c = d2;
                z2.d = eVar.k();
                z2.e = eVar;
                this.c.add(z2);
            }
        }
    }

    public int getCount() {
        return this.c.size();
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0672ab c0672ab;
        if (view == null) {
            view = this.b.inflate(n.device_list_item, null);
            c0672ab = new C0672ab();
            c0672ab.a = (ImageView) view.findViewById(l.device_icon);
            c0672ab.b = (TextView) view.findViewById(l.device_name);
            c0672ab.c = (TextView) view.findViewById(l.bind_state);
            view.setTag(c0672ab);
        } else {
            c0672ab = (C0672ab) view.getTag();
        }
        Z z = (Z) this.c.get(i);
        c0672ab.a.setImageDrawable(z.b);
        c0672ab.b.setText(z.c);
        Resources resources = this.a.getResources();
        if (z.d) {
            c0672ab.c.setText(resources.getString(r.state_binded));
            c0672ab.b.setTextColor(resources.getColor(i.font_color_c8));
            c0672ab.c.setTextColor(resources.getColor(i.font_color_c8));
            c0672ab.a.setAlpha(1.0f);
        } else {
            c0672ab.c.setText(resources.getString(r.state_unbinded));
            c0672ab.b.setTextColor(resources.getColor(i.font_color_c8_transparent));
            c0672ab.c.setTextColor(resources.getColor(i.font_color_c8_transparent));
            c0672ab.a.setAlpha(0.5f);
        }
        return view;
    }
}
