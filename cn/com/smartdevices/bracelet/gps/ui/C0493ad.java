package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.e.c;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.model.m;
import cn.com.smartdevices.bracelet.gps.services.aa;
import cn.com.smartdevices.bracelet.gps.ui.b.a;
import cn.com.smartdevices.bracelet.shoes.model.d;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

class C0493ad extends BaseExpandableListAdapter {
    static final int a = 0;
    static final int b = 2;
    static final int c = 1;
    private static final String m = "HistoryAdapter";
    private ArrayList<C0497ah> d = null;
    private LayoutInflater e = null;
    private String[] f = null;
    private Resources g = null;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int k = a;
    private int l = a;
    private final h n = c.a();

    public C0493ad(Activity activity) {
        this.e = activity.getLayoutInflater();
        this.g = activity.getResources();
        this.d = new ArrayList();
        this.f = this.g.getStringArray(com.xiaomi.hm.health.b.a.c.running_months);
        Calendar instance = Calendar.getInstance();
        this.h = instance.get(c);
        this.i = instance.get(b) + c;
        this.j = instance.get(5);
    }

    private C0497ah a(long j, aa aaVar) {
        C0497ah c0497ah = new C0497ah(new m(j, aaVar.l(), aaVar.n()));
        if (c0497ah.b == null) {
            c0497ah.b = new ArrayList();
        }
        c0497ah.b.add(aaVar);
        return c0497ah;
    }

    private boolean a(int i, int i2, int i3) {
        return i == this.h && i2 == this.i && i3 == this.j;
    }

    public int a() {
        return this.l;
    }

    public int a(C0497ah c0497ah) {
        if (this.d == null || c0497ah == null || c0497ah.a == null) {
            return -1;
        }
        for (int i = a; i < this.d.size(); i += c) {
            if (((C0497ah) this.d.get(i)).a.f == c0497ah.a.f) {
                this.d.set(i, c0497ah);
                return i;
            }
        }
        this.d.add(c0497ah);
        return this.d.indexOf(c0497ah);
    }

    public m a(int i) {
        return (i < 0 || i >= this.d.size()) ? null : ((C0497ah) this.d.get(i)).a;
    }

    public boolean a(int i, int i2) {
        if (this.d == null) {
            return false;
        }
        if (i < 0 || i >= this.d.size()) {
            return false;
        }
        C0497ah c0497ah = (C0497ah) this.d.get(i);
        if (c0497ah == null) {
            return false;
        }
        List list = c0497ah.b;
        if (list == null) {
            return false;
        }
        if (i2 < 0 || i2 >= list.size()) {
            return false;
        }
        aa aaVar = (aa) list.get(i2);
        m a = c0497ah.a();
        if (a != null) {
            a.d -= aaVar.l();
            a.e -= aaVar.n();
        }
        list.remove(aaVar);
        if (list.size() == 0) {
            this.d.remove(c0497ah);
        }
        return true;
    }

    public boolean a(aa aaVar) {
        boolean z = false;
        if (this.d == null) {
            return false;
        }
        long b = cn.com.smartdevices.bracelet.gps.h.h.b(aaVar.o());
        if (this.d.size() > 0) {
            if (b > ((C0497ah) this.d.get(a)).a.f) {
                this.d.add(a, a(b, aaVar));
                return true;
            } else if (b < ((C0497ah) this.d.get(this.d.size() - 1)).a.f) {
                this.d.add(a(b, aaVar));
                return true;
            }
        }
        Iterator it = this.d.iterator();
        int i = a;
        while (it.hasNext() && b != ((C0497ah) it.next()).a.f) {
            i += c;
        }
        C0497ah c0497ah = (C0497ah) this.d.get(i);
        if (c0497ah == null) {
            return false;
        }
        if (c0497ah.b == null) {
            c0497ah.b = new ArrayList();
        }
        List<aa> list = c0497ah.b;
        i = a;
        for (aa aaVar2 : list) {
            if (aaVar.o() <= aaVar2.o()) {
                if (aaVar.o() == aaVar2.o()) {
                    break;
                }
                i += c;
            } else {
                z = true;
                break;
            }
        }
        z = true;
        if (z) {
            list.add(i, aaVar);
        } else {
            list.set(i, aaVar);
        }
        return true;
    }

    public int b() {
        return this.k;
    }

    public aa b(int i, int i2) {
        if (i < 0 || i2 < 0 || i >= this.d.size()) {
            return null;
        }
        List list = ((C0497ah) this.d.get(i)).b;
        return (list == null || i2 >= list.size()) ? null : (aa) list.get(i2);
    }

    public void b(int i) {
        this.l = i;
    }

    public void c() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    public void c(int i) {
        this.k = i;
    }

    public /* synthetic */ Object getChild(int i, int i2) {
        return b(i, i2);
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0496ag c0496ag;
        if (view == null) {
            view = this.e.inflate(j.running_history_list_item, null);
            ((TextView) view.findViewById(i.total_distance_unit)).setText(k.British == this.n.a() ? this.g.getString(n.running_mile) : this.g.getString(n.running_kilometers));
            C0496ag c0496ag2 = new C0496ag();
            c0496ag2.b = (TextView) view.findViewById(i.date_time);
            c0496ag2.e = (TextView) view.findViewById(i.start_time);
            c0496ag2.c = (TextView) view.findViewById(i.total_distance);
            c0496ag2.d = (TextView) view.findViewById(i.total_used_time_value);
            c0496ag2.a = (TextView) view.findViewById(i.avg_pace_value);
            c0496ag2.f = view.findViewById(i.sync_state_container);
            c0496ag2.g = (ImageView) view.findViewById(i.shoes_logo);
            c0496ag2.h = (TextView) view.findViewById(i.shoes_type);
            c0496ag2.i = view.findViewById(i.split_line);
            view.setTag(c0496ag2);
            c0496ag = c0496ag2;
        } else {
            c0496ag = (C0496ag) view.getTag();
        }
        view.setTag(i.groupId, Integer.valueOf(i));
        view.setTag(i.childId, Integer.valueOf(i2));
        aa b = b(i, i2);
        if (b != null) {
            try {
                long longValue = Long.valueOf(b.o()).longValue();
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(1000 * longValue);
                int i3 = instance.get(5);
                instance.add(5, c);
                TextView textView = c0496ag.b;
                Resources resources = this.g;
                int i4 = n.running_history_child_date_format;
                Object[] objArr = new Object[c];
                objArr[a] = Integer.valueOf(i3);
                textView.setText(resources.getString(i4, objArr));
                c0496ag.e.setText(a.a(longValue, false));
            } catch (Exception e) {
                e.printStackTrace();
                c0496ag.b.setText(b.f());
            }
            c0496ag.c.setText(String.valueOf(cn.com.smartdevices.bracelet.gps.h.h.b(this.n.a((double) (b.l() / 1000.0f)).a, (int) b)));
            c0496ag.d.setText(a.a(b.n(), true));
            if (((double) cn.com.smartdevices.bracelet.gps.h.i.b(b.b())) < 0.01d) {
                c0496ag.a.setText(a.a(0));
            } else {
                c0496ag.a.setText(a.a((long) this.n.b((double) cn.com.smartdevices.bracelet.gps.h.i.c(b.c())).a));
            }
            c0496ag.f.setVisibility(b.u() ? 8 : a);
            if (b.g().contains(d.k)) {
                c0496ag.g.setVisibility(a);
                c0496ag.h.setVisibility(a);
            } else {
                c0496ag.g.setVisibility(8);
                c0496ag.h.setVisibility(8);
            }
            if (i2 == 0) {
                c0496ag.i.setVisibility(8);
            } else {
                c0496ag.i.setVisibility(a);
            }
        }
        return view;
    }

    public int getChildrenCount(int i) {
        if (i < 0 || i >= this.d.size()) {
            return a;
        }
        C0497ah c0497ah = (C0497ah) this.d.get(i);
        if (c0497ah == null) {
            return a;
        }
        List list = c0497ah.b;
        return list == null ? a : list.size();
    }

    public /* synthetic */ Object getGroup(int i) {
        return a(i);
    }

    public int getGroupCount() {
        return this.d == null ? a : this.d.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0495af c0495af;
        if (view == null) {
            view = this.e.inflate(j.running_history_list_category, null);
            C0495af c0495af2 = new C0495af();
            c0495af2.a = (TextView) view.findViewById(i.month);
            view.setTag(c0495af2);
            c0495af = c0495af2;
        } else {
            c0495af = (C0495af) view.getTag();
        }
        view.setTag(i.groupId, Integer.valueOf(i));
        view.setTag(i.childId, Integer.valueOf(-1));
        m a = a(i);
        if (a != null) {
            try {
                String string;
                String a2 = a.a(a.f, this.g.getString(n.running_history_group_time_format), false);
                String str = com.xiaomi.e.a.f;
                cn.com.smartdevices.bracelet.gps.e.j a3 = this.n.a((double) (a.d / 1000.0f));
                Resources resources;
                int i2;
                Object[] objArr;
                if (cn.com.smartdevices.bracelet.gps.e.n.Mile == a3.b) {
                    resources = this.g;
                    i2 = n.running_history_group_distance_br;
                    objArr = new Object[c];
                    objArr[a] = Double.valueOf(a3.a);
                    string = resources.getString(i2, objArr);
                } else {
                    resources = this.g;
                    i2 = n.running_history_group_distance;
                    objArr = new Object[c];
                    objArr[a] = Double.valueOf(a3.a);
                    string = resources.getString(i2, objArr);
                }
                c0495af.a.setText(a2 + " " + string);
            } catch (Exception e) {
                C0596r.b(m, e.getLocalizedMessage());
            }
        }
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
