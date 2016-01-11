package cn.com.smartdevices.bracelet.relation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0544h;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.view.CareButton;
import cn.com.smartdevices.bracelet.relation.view.b;
import com.c.b.b.a.C1009k;
import com.huami.android.ui.ActionBarActivity;
import com.huami.android.ui.a;
import com.huami.android.view.c;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.e;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.o;
import com.xiaomi.hm.health.r;
import com.xiaomi.mistatistic.sdk.d;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DetailActivity extends ActionBarActivity implements OnClickListener, r, b {
    private static final String f = "DetailActivity";
    private static final String g = "friend";
    private static final int h = 1;
    private TextView A;
    private TextView B;
    private C0608k C;
    private C0605h D;
    private String[] E;
    private String F;
    private String G;
    private String H;
    private CareButton I;
    private View J;
    private C0603f K;
    private C0604g L;
    private TextView M;
    private boolean N = false;
    StatisticChartView a;
    StatisticChartView b;
    long c = 0;
    Calendar d = Calendar.getInstance();
    boolean e = false;
    private Friend i = null;
    private A j;
    private h k = null;
    private C0611n l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public DetailActivity() {
        super(C0401a.gJ, C0401a.gz);
    }

    public static Intent a(Context context, Friend friend) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(g, friend);
        return intent;
    }

    public static String a(int i) {
        int i2 = i / 60;
        int i3 = i % 60;
        return BraceletApp.a().getString(r.label_sleep_time, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    private void c() {
        C0544h.a().b(this.i.p, this.m);
        this.n.setText(this.i.c());
        TextView textView = this.p;
        Object[] objArr = new Object[h];
        objArr[0] = Integer.valueOf(this.i.u);
        textView.setText(getString(r.label_care_time_by_me, objArr));
        if (this.i.u <= 0) {
            this.q.setImageResource(k.ic_grey_heart);
        } else {
            this.q.setImageResource(k.ic_red_heart);
        }
        String string = this.i.v == 0 ? getString(r.label_no_update) : DateFormat.format("yyyy-MM-dd HH:mm", this.i.v);
        TextView textView2 = this.o;
        Object[] objArr2 = new Object[h];
        objArr2[0] = string;
        textView2.setText(getString(r.label_update_time, objArr2));
        textView = this.r;
        objArr = new Object[h];
        objArr[0] = Integer.valueOf(this.i.r);
        textView.setText(getString(r.label_step_with_unit, objArr));
        this.s.setText(a(this.i.s));
        this.t.setText(this.i.q + C1009k.a);
    }

    private void d() {
        Bitmap drawingCache;
        C0401a.a((Context) this, C0409b.aQ);
        if (this.l == null) {
            this.l = C0611n.a((Context) this);
            this.l.a((OnClickListener) this);
        }
        View decorView;
        if (a.b(this)) {
            decorView = getWindow().getDecorView();
            decorView.buildDrawingCache();
            drawingCache = decorView.getDrawingCache();
        } else {
            decorView = findViewById(16908290);
            if (decorView != null) {
                decorView.buildDrawingCache();
                drawingCache = decorView.getDrawingCache();
            } else {
                drawingCache = null;
            }
        }
        this.l.a(drawingCache);
        this.l.a((r) this);
        this.l.show(getFragmentManager().beginTransaction(), null);
    }

    public String a(long j) {
        long j2 = j / d.h;
        if (j2 == this.c / 86400) {
            return this.F;
        }
        if (j2 + 1 == this.c / 86400) {
            return this.G;
        }
        this.d.setTimeInMillis(j);
        if (this.d.get(7) == 2) {
            return this.E[0];
        }
        int i = this.d.get(5);
        int i2 = this.d.get(2);
        int i3 = this.d.get(h);
        if (i2 == 0 && i == h) {
            return i3 + com.xiaomi.e.a.f;
        }
        return String.format(this.H, new Object[]{Integer.valueOf(i2 + h), Integer.valueOf(i)});
    }

    public String a(long j, int i) {
        if (j / d.h == this.c / 86400) {
            return this.F;
        }
        this.d.setTimeInMillis(j);
        int i2 = this.d.get(5);
        return getString(i, new Object[]{Integer.valueOf(this.d.get(2) + h), Integer.valueOf(i2)});
    }

    public void a(View view, int i) {
        if (i == 2) {
            this.J.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, e.header_notify_in);
            if (loadAnimation != null) {
                this.J.startAnimation(loadAnimation);
            }
            this.J.postDelayed(new C0601d(this), 1500);
        }
    }

    public void b() {
        if (a.b(this)) {
            getWindow().getDecorView().destroyDrawingCache();
            return;
        }
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            findViewById.destroyDrawingCache();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj = h;
        super.onActivityResult(i, i2, intent);
        if (h == i && i2 == -1) {
            String stringExtra = intent.getStringExtra(Friend.c);
            if (this.i.x != null) {
                if (this.i.x.equals(stringExtra)) {
                    obj = null;
                }
                C0401a.a((Context) this, C0409b.aS, C0410c.v, obj != null ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
            }
            this.i.x = stringExtra;
            c();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.care_button /*2131296371*/:
                if (this.j.a((Context) this)) {
                    C0401a.a((Context) this, C0409b.aZ);
                    this.j.b(this, this.i.n, this.N);
                    this.N = false;
                    return;
                }
                c.showPanel((Activity) this, this.L);
                return;
            case l.action_remark /*2131297565*/:
                C0401a.a((Context) this, C0409b.aR);
                startActivityForResult(RemarkActivity.a(this, this.i), h);
                return;
            case l.action_remove_friend /*2131297566*/:
                C0401a.a((Context) this, C0409b.aT);
                c.showPanel((Activity) this, this.K);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.activity_detail);
        Intent intent = getIntent();
        if (intent != null) {
            this.i = (Friend) intent.getParcelableExtra(g);
        }
        this.k = h.a(getApplicationContext());
        this.k.a((Object) this);
        if (this.i == null) {
            com.huami.android.view.b.a((Context) this, (int) r.toast_user_info_error, 0);
            return;
        }
        this.E = getResources().getStringArray(f.weeks);
        this.F = getString(r.date_today);
        this.G = getString(r.date_yesterday);
        this.H = getString(r.date_month_day_short);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.c = (currentTimeMillis - (currentTimeMillis % 86400)) - ((long) (TimeZone.getDefault().getRawOffset() / com.xiaomi.account.openauth.h.E));
        this.e = Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString());
        int daySportGoalSteps = Keeper.readPersonInfo().getDaySportGoalSteps();
        this.I = (CareButton) findViewById(l.care_button);
        this.I.setOnClickListener(this);
        this.I.a((b) this);
        this.J = findViewById(l.toast_view);
        this.q = (ImageView) findViewById(l.care_icon);
        this.b = (StatisticChartView) findViewById(l.sleep_record);
        this.b.b(true);
        this.a = (StatisticChartView) findViewById(l.ativity_record);
        this.a.b(true);
        this.C = new C0608k(this);
        this.a.a(this.C);
        this.a.a((int) h);
        this.a.h();
        this.a.e(daySportGoalSteps);
        this.a.c(11);
        this.a.c(false);
        this.a.d(true);
        this.D = new C0605h(this);
        this.b.a(this.D);
        this.b.a(16);
        this.b.e(60);
        this.b.h();
        this.b.c(11);
        this.b.c(false);
        this.b.d(true);
        this.m = (ImageView) findViewById(l.icon);
        this.n = (TextView) findViewById(l.username);
        this.o = (TextView) findViewById(l.last_update_time);
        this.p = (TextView) findViewById(l.careByMe);
        this.r = (TextView) findViewById(l.step);
        this.s = (TextView) findViewById(l.sleep);
        this.t = (TextView) findViewById(l.weight);
        this.u = (TextView) findViewById(l.activity_date);
        this.y = (TextView) findViewById(l.sleep_date);
        this.x = (TextView) findViewById(l.day_heat);
        this.v = (TextView) findViewById(l.day_step);
        this.w = (TextView) findViewById(l.day_mileage);
        this.M = (TextView) findViewById(l.label_mileage);
        this.A = (TextView) findViewById(l.day_sleep);
        this.z = (TextView) findViewById(l.get_up_time);
        this.B = (TextView) findViewById(l.day_sleep_start);
        c();
        this.j = A.a();
        boolean z = this.i.w < this.i.v;
        this.j.a(this.i.n, z);
        if (z) {
            Utils.a((Activity) this, (int) r.data_loading, true);
        }
        this.K = new C0603f(this);
        this.K.setOpClickListener(new C0598a(this));
        this.L = new C0604g(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(o.menu_detail, menu);
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.k != null) {
            this.k.b((Object) this);
        }
        if (this.b != null) {
            this.b.i();
        }
        if (this.a != null) {
            this.a.i();
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.c cVar) {
        if (cVar.b == this.i.n) {
            Friend friend = this.i;
            friend.u += h;
            c();
            this.I.a();
            if (cVar.a) {
                com.huami.android.view.b.a((Context) this, (int) r.toast_care_send_success, 0);
            } else {
                com.huami.android.view.b.a((Context) this, (int) r.toast_care_send_failed, 0);
            }
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.d dVar) {
        if (dVar.c == this.i.n) {
            Utils.a((Activity) this);
            if (dVar.a) {
                this.D.b();
                this.C.b();
                List list = dVar.b;
                if (list != null) {
                    Collections.sort(list, new C0599b(this));
                }
                int size = list == null ? 0 : list.size() - 1;
                this.D.a(list);
                this.C.a(list);
                this.a.post(new C0600c(this, size));
            }
        }
    }

    public void onEvent(cn.com.smartdevices.bracelet.relation.b.f fVar) {
        if (fVar.b == this.i.n) {
            if (fVar.a == h) {
                finish();
                com.huami.android.view.b.a((Context) this, (int) r.toast_friend_remove_success, 0);
            } else {
                com.huami.android.view.b.a((Context) this, (int) r.toast_friend_remove_failed, 0);
                this.I.setEnabled(true);
            }
            Utils.a((Activity) this);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != l.action_more) {
            return super.onOptionsItemSelected(menuItem);
        }
        d();
        return true;
    }

    protected void onResume() {
        super.onResume();
        C0401a.a((Context) this, C0409b.aN);
    }
}
