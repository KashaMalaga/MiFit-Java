package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.a.s;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.gps.e.c;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.h.g;
import cn.com.smartdevices.bracelet.gps.model.l;
import cn.com.smartdevices.bracelet.gps.model.m;
import cn.com.smartdevices.bracelet.gps.services.aa;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.huami.android.ui.CustomActionBarActivity;
import com.huami.android.view.b;
import com.huami.android.widget.f;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends CustomActionBarActivity implements OnClickListener {
    private static final String B = "parent_id";
    private static final String C = "child_id";
    private static final int u = 100;
    private static final int v = 200;
    private static final String x = "HistoryActivity";
    private boolean A = false;
    private final h D = c.a();
    private int E = -1;
    private View a;
    private TextView b;
    private int c;
    private C0500ak d = null;
    private C0491ab f = null;
    private C0493ad g = null;
    private View h = null;
    private TextView i = null;
    private PullToRefreshExpandableListView j = null;
    private long k = -2;
    private Context l = null;
    private View m = null;
    private ProgressBar n = null;
    private Z o = null;
    private TextView p = null;
    private TextView q = null;
    private TextView r = null;
    private C0498ai s = null;
    private int t = 0;
    private ValueAnimator w = null;
    private l y = null;
    private s z = null;

    public HistoryActivity() {
        super(C0401a.bu, C0401a.al);
    }

    public HistoryActivity(String str, String str2) {
        super(C0401a.bu, C0401a.al);
    }

    private C0497ah a(m mVar, int i, List<Long> list) {
        C0497ah c0497ah = new C0497ah(mVar);
        List b = p.b((Context) this, 4, mVar.f, i, (List) list);
        if (b == null || b.size() <= 0) {
            return null;
        }
        c0497ah.a(b);
        b.clear();
        return c0497ah;
    }

    private String a(m mVar) {
        if (mVar == null) {
            return a.f;
        }
        String a = cn.com.smartdevices.bracelet.gps.ui.b.a.a(mVar.f, getString(n.running_history_group_time_format), false);
        String str = a.f;
        if (cn.com.smartdevices.bracelet.gps.e.n.Mile == this.D.a((double) (mVar.d / 1000.0f)).b) {
            str = getResources().getString(n.running_history_group_distance_br, new Object[]{Double.valueOf(r0.a)});
        } else {
            str = getResources().getString(n.running_history_group_distance, new Object[]{Double.valueOf(r0.a)});
        }
        return a + " " + str;
    }

    private void a(int i) {
        if (!this.A && i >= this.t && i <= u) {
            if (4 == this.n.getVisibility()) {
                this.n.setVisibility(0);
            }
            if (this.t != i) {
                if (this.w != null && this.w.isRunning()) {
                    this.w.cancel();
                }
                this.w = ValueAnimator.ofInt(new int[]{this.t, i});
                this.w.setDuration(200);
                this.w.addUpdateListener(new Y(this));
                this.w.start();
            }
        }
    }

    private void a(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString(f.a, getResources().getString(n.running_delete_track_item_confirm));
        bundle.putString(cn.com.smartdevices.bracelet.tag.a.a, getResources().getString(n.running_btn_continue));
        bundle.putString(cn.com.smartdevices.bracelet.tag.a.b, getResources().getString(n.running_btn_confirm));
        bundle.putInt(B, i);
        bundle.putInt(C, i2);
        C0487a.a(this, bundle).setOpClickListener(new C0490aa(this, i, i2));
    }

    private boolean a(long j) {
        aa b = p.b(this.l, j, 4);
        return (b == null || t.STATE_TO_BE_DELETED.a() == b.k()) ? false : p.a(this.l, j, t.STATE_TO_BE_DELETED);
    }

    private boolean a(long j, long j2) {
        return a(p.a(this.l, 4, j, j2, 3));
    }

    private boolean a(List<m> list) {
        if (list == null) {
            return false;
        }
        int size = list.size();
        if (size <= 0) {
            return false;
        }
        List<Integer> arrayList = new ArrayList(size);
        l a = this.z.a((Context) this, 4);
        long b = a != null ? a.b() : -1;
        for (size--; size > -1; size--) {
            List list2 = a((m) list.get(size), -1, null).b;
            for (int size2 = list2.size() - 1; size2 > -1; size2--) {
                aa aaVar = (aa) list2.get(size2);
                if (aaVar.o() > b) {
                    this.z.a((Context) this, aaVar);
                }
            }
        }
        for (m a2 : list) {
            int a3 = this.g.a(a(a2, -1, null));
            if (a3 >= 0) {
                arrayList.add(Integer.valueOf(a3));
            }
        }
        for (Integer intValue : arrayList) {
            ((ExpandableListView) this.j.getRefreshableView()).expandGroup(intValue.intValue());
        }
        arrayList.clear();
        if (this.g.getGroupCount() == 0) {
            b(this.k == -1);
        }
        this.g.notifyDataSetChanged();
        this.f.sendEmptyMessage(1);
        return true;
    }

    private boolean a(boolean z) {
        if (this.k == -1) {
            b.a(this.l, n.running_get_history_no_more_data, 0).show();
            if (!z) {
                return false;
            }
            this.j.onRefreshComplete();
            return false;
        } else if (g.f(this.l)) {
            this.d.a(this.k);
            return true;
        } else {
            b.a(this.l, n.running_failed_to_get_history_neterror, 0).show();
            if (!z) {
                return false;
            }
            this.j.onRefreshComplete();
            return false;
        }
    }

    private void b(boolean z) {
        Message obtainMessage = this.f.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.arg1 = z ? 1 : 0;
        this.f.sendMessage(obtainMessage);
    }

    private void c(boolean z) {
        this.i.setVisibility(z ? 4 : 0);
    }

    private void d() {
        this.j = (PullToRefreshExpandableListView) findViewById(i.history_list);
        this.j.setScrollingWhileRefreshingEnabled(true);
        ExpandableListView expandableListView = (ExpandableListView) this.j.getRefreshableView();
        this.m = getLayoutInflater().inflate(j.running_history_list_header, null);
        expandableListView.addHeaderView(this.m);
        this.p = (TextView) this.m.findViewById(i.total_distance_value);
        this.q = (TextView) this.m.findViewById(i.total_times_value);
        this.r = (TextView) this.m.findViewById(i.total_calorie_cost_value);
        if (k.British == this.D.a()) {
            ((TextView) this.m.findViewById(i.total_distance_title)).setText(n.running_history_total_distance_br);
        }
        this.s = new C0498ai();
        this.s.a(this.l, this.p);
        expandableListView.setAdapter(this.g);
        this.j.setOnRefreshListener(new T(this));
        expandableListView.setOnGroupClickListener(new U(this));
        expandableListView.setOnItemLongClickListener(new V(this));
        expandableListView.setOnChildClickListener(new W(this));
        expandableListView.setOnScrollListener(new X(this, expandableListView));
    }

    private void f() {
        a((OnClickListener) this);
        this.a = findViewById(i.float_title);
        this.b = (TextView) this.a.findViewById(i.month);
        d();
        this.h = findViewById(i.no_data);
        this.i = (TextView) findViewById(i.no_data_refresh);
        this.n = (ProgressBar) findViewById(i.sync_progress);
        i();
    }

    private boolean g() {
        if (this.k == -1) {
            return false;
        }
        List b = p.b(this.l, 4, this.k, 0, 3);
        if (b == null) {
            return false;
        }
        int size = b.size();
        C0596r.e("UI", "getSummaryListByGroup size = " + size);
        if (size > 0) {
            this.k = ((m) b.get(size - 1)).f - 1;
            a(b);
        }
        return size > 0;
    }

    private void h() {
        if (this.g.getGroupCount() <= 0) {
            b(false);
        } else {
            this.f.sendEmptyMessage(1);
        }
    }

    private void i() {
        this.t = 0;
        if (this.w != null && this.w.isRunning()) {
            this.w.cancel();
        }
        this.n.setVisibility(4);
    }

    private void j() {
        if (g.f(this.l)) {
            this.A = false;
            i();
            a(5);
            this.d.a(this.k + 1, System.currentTimeMillis() / 1000);
            return;
        }
        b.a(this.l, n.running_failed_to_get_history_neterror, 0).show();
    }

    private void k() {
        if (this.y != null) {
            this.p.setText(cn.com.smartdevices.bracelet.gps.ui.b.a.b((float) this.D.a((double) (this.y.a / 1000.0f)).a));
            this.q.setText(a.f + this.y.b);
            this.r.setText(a.f + this.y.c);
            return;
        }
        this.p.setText(Constants.VIA_RESULT_SUCCESS);
        this.q.setText(Constants.VIA_RESULT_SUCCESS);
        this.r.setText(Constants.VIA_RESULT_SUCCESS);
    }

    protected String b() {
        return getResources().getString(n.running_history_title);
    }

    protected String g_() {
        return getResources().getString(n.running_synchronous);
    }

    protected void h_() {
        cn.com.smartdevices.bracelet.gps.a.b.l(this);
        j();
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(j.activity_running_history);
        this.l = getApplicationContext();
        this.z = s.a();
        this.f = new C0491ab();
        this.g = new C0493ad(this);
        this.d = new C0500ak(this.l);
        this.o = new Z();
        this.d.a(this.o);
        f();
        g();
        C0401a.a((Context) this, C0401a.bu);
        List a = p.a((Context) this, 4);
        List h = p.h(this);
        int i = 0;
        if (a != null) {
            i = 0 + a.size();
        }
        if (h != null) {
            i += h.size();
        }
        cn.com.smartdevices.bracelet.gps.a.b.a((Context) this, i);
    }

    public void onDestroy() {
        if (this.d != null) {
            this.d.a();
        }
        if (this.f != null) {
            this.f.removeCallbacksAndMessages(null);
        }
        if (this.g != null) {
            this.g.c();
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.y != null) {
            s.a().a((Context) this, this.y);
        }
        C0401a.b(C0401a.al);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        this.y = s.a().a((Context) this, 4);
        k();
        h();
        C0401a.a(C0401a.al);
        C0401a.a((Activity) this);
    }
}
