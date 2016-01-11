package cn.com.smartdevices.bracelet.lab.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.lab.b;
import cn.com.smartdevices.bracelet.lab.b.f;
import cn.com.smartdevices.bracelet.lab.d;
import cn.com.smartdevices.bracelet.lab.i;
import cn.com.smartdevices.bracelet.lab.k;
import cn.com.smartdevices.bracelet.lab.sportmode.DynamicGroupItemInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.lab.ui.view.CircleListScrollView;
import cn.com.smartdevices.bracelet.lab.ui.view.LabCircleView;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.e;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kankan.wheel.widget.g;
import org.json.JSONObject;

public class SportAnalyserActivity extends SystemBarTintActivity implements i {
    private static final int F = 0;
    public static final int a = 2000;
    private static final int b = 520;
    private static final String j = "Lab";
    private static final int p = 300000;
    private static final int q = 3000;
    private static final int r = 6000;
    private Animation A = null;
    private final Animation B = null;
    private boolean C = false;
    private SportBaseInfo D = null;
    private CircleListScrollView E = null;
    private boolean G = false;
    private int H = F;
    private ShareData I = null;
    private TextView J = null;
    private TextView K = null;
    private String L = null;
    private long c = -1;
    private af d = null;
    private DynamicGroupItemInfo e = null;
    private K f = null;
    private G g = null;
    private int h = F;
    private final SimpleDateFormat i = new SimpleDateFormat("mm:ss");
    private TextView k = null;
    private TextView l = null;
    private List<Integer> m = null;
    private TextView n = null;
    private String o = null;
    private C0565b s = null;
    private C0565b t = null;
    private int u = 5;
    private LabCircleView v = null;
    private TextView w = null;
    private View x = null;
    private TextView y = null;
    private String z = a.f;

    private int a(long j, long j2) {
        return j2 == 0 ? F : (int) ((60 * j) / j2);
    }

    private int a(String str) {
        return (!k.b.equals(str) && k.a.equals(str)) ? com.xiaomi.hm.health.i.lab_situp_bg : com.xiaomi.hm.health.i.lab_ropeskipping_bg;
    }

    private ShareData a(Context context) {
        long j = this.D.getGroupSumInfo()[1];
        int i = this.h;
        if (!this.e.isMarkedInGroup()) {
            i += this.e.getCount();
        }
        if (!(this.m == null || this.e.isMarkedInGroup())) {
            this.m.add(Integer.valueOf(this.e.getCount()));
        }
        C0590z c0590z = new C0590z(context, this.D.getSportType());
        return c0590z.a(this.D.getSavedRoundCountOfPB(), this.m, c0590z.a(i, j));
    }

    private String a() {
        if (k.b.equals(this.o)) {
            return getString(r.lab_factory_sport_pb_desc, new Object[]{getString(r.lab_factory_sport_pb_ropeskipping)});
        } else if (!k.a.equals(this.o)) {
            return a.f;
        } else {
            return getString(r.lab_factory_sport_pb_desc, new Object[]{getString(r.lab_factory_sport_pb_situp)});
        }
    }

    private JSONObject a(Context context, String str) {
        int i;
        if (k.b.equals(str)) {
            i = 1;
        } else if (k.a.equals(str)) {
            i = 2;
        } else {
            throw new IllegalArgumentException();
        }
        return b.a(context, new SportDay().getKey(), new C0595q(i));
    }

    private void a(DynamicGroupItemInfo dynamicGroupItemInfo) {
        if (dynamicGroupItemInfo.isNewPBPoint()) {
            f(getResources().getColor(com.xiaomi.hm.health.i.lab_record_broken_bg));
        }
        if (this.D.getRoundCountOfPB() == 0) {
            this.K.setText(getString(r.lab_factory_sport_come_on));
            this.k.setVisibility(4);
            return;
        }
        this.K.setText(this.L);
        this.k.setVisibility(F);
        this.k.setText(String.valueOf(dynamicGroupItemInfo.getCount()));
    }

    private void a(boolean z) {
        if (this.s != null) {
            if (z) {
                this.s.start();
            } else {
                this.s.a();
            }
        }
    }

    private int b(int i) {
        return i == 2 ? 4 : i == 0 ? 6 : (i == 1 || i == -1) ? 5 : -1;
    }

    private String b(String str) {
        return k.b.equals(this.o) ? getString(r.lab_factory_sport_type_ropeskipping) : k.a.equals(this.o) ? getString(r.lab_factory_sport_type_situp) : a.f;
    }

    private void b() {
        this.x = findViewById(l.lab_main_sport);
        this.w = (TextView) findViewById(l.title_back);
        f(getResources().getColor(a(this.o)));
        this.k = (TextView) findViewById(l.value_personal_record);
        this.y = (TextView) findViewById(l.sport_average_rating);
        this.l = (TextView) findViewById(l.sport_progress_time);
        this.v = (LabCircleView) findViewById(l.sport_progress_state);
        this.E = (CircleListScrollView) findViewById(l.horizontal_scroll_view);
        this.y.setText(Html.fromHtml(getString(r.lab_factory_sport_average_rate_per_minute, new Object[]{Integer.valueOf(F)})));
        this.w.setText(this.z);
        this.k.setOnLongClickListener(new B(this));
        this.n = (TextView) findViewById(l.operation_bn);
        this.n.setEnabled(false);
        this.n.setOnClickListener(new C(this));
        this.A = AnimationUtils.loadAnimation(this, e.lab_sport_group_count_rest);
        this.A.setAnimationListener(new F());
        this.J = (TextView) findViewById(l.sport_finish_desc);
        this.K = (TextView) findViewById(l.key_personal_best_record);
        this.v.c(5);
    }

    private void b(DynamicGroupItemInfo dynamicGroupItemInfo) {
        if (this.D.getRoundCountOfPB() <= dynamicGroupItemInfo.getCount()) {
            this.D.setRoundCountOfPB(dynamicGroupItemInfo.getCount());
            this.D.setRoundCostTimeOfPB(dynamicGroupItemInfo.getCostTime());
        }
    }

    private void b(boolean z) {
        if (this.t != null) {
            if (z) {
                this.t.start();
            } else {
                this.t.a();
            }
        }
    }

    static /* synthetic */ int c(SportAnalyserActivity sportAnalyserActivity, int i) {
        int i2 = sportAnalyserActivity.h + i;
        sportAnalyserActivity.h = i2;
        return i2;
    }

    private void c() {
        if (this.D.getRoundCountOfPB() == 0) {
            this.K.setText(getString(r.lab_factory_sport_come_on));
            this.k.setVisibility(4);
            return;
        }
        this.K.setText(this.L);
        this.k.setVisibility(F);
        this.k.setText(String.valueOf(this.D.getRoundCountOfPB()));
    }

    private void c(int i) {
        if (i == 2) {
            this.v.a((int) r.lab_factory_exercise_state_stopped);
            this.f.c();
            h();
        } else if (i == 6) {
            this.v.a(true);
            f(getResources().getColor(g.bg_color_grey));
            if (this.h > 0) {
                r0 = this.g.obtainMessage();
                r0.what = 1;
                r0.arg1 = 2;
                r0.arg2 = this.e.getCount();
                this.g.sendMessage(r0);
            }
            e();
            h();
        } else if (i == 4) {
            this.n.setEnabled(true);
            this.v.a((int) r.lab_factory_exercise_state_ready);
            this.v.a(false);
            d.a((Context) this).b((i) this, this.o);
            b(true);
            this.l.setText(this.i.format(Integer.valueOf(F)));
            this.f.b();
            if (this.H > 0) {
                r0 = this.g.obtainMessage();
                r0.what = 1;
                r0.arg1 = 2;
                r0.arg2 = this.H;
                this.g.sendMessage(r0);
                a(true);
            }
        } else if (i == 5) {
            this.n.setEnabled(false);
            this.v.a((int) r.lab_factory_sport_device_preparing);
        } else if (i == 3) {
            this.v.a((int) r.lab_factory_exercise_state_paused);
        }
    }

    private void c(boolean z) {
        if (z) {
            String a = f.a((Context) this, this.e.getCostTime());
            this.J.setText(getString(r.lab_factory_sport_group_time_cost, new Object[]{this.z, a}));
            this.J.setVisibility(F);
            return;
        }
        this.J.setVisibility(4);
    }

    private void d() {
        if (this.d != null) {
            this.d.stop();
        }
        h();
        if (this.A != null) {
            this.A.cancel();
        }
        if (this.B != null) {
            this.B.cancel();
        }
        if (this.e != null) {
            this.H = this.e.isMarkedInGroup() ? F : this.e.getCount();
        }
        d.a((Context) this).c(this, this.o);
        d.a((Context) this).c(this);
    }

    private void d(int i) {
        if (i <= 5 && i > 0) {
            float f = ((float) (i - 1)) / 5.0f;
            float f2 = ((float) i) / 5.0f;
            Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, (float) (this.v.getWidth() / 2), (float) (this.v.getHeight() / 2));
            scaleAnimation.setDuration(10);
            scaleAnimation.setFillAfter(true);
            this.v.a(scaleAnimation);
        }
    }

    private void d(boolean z) {
        int i = this.h;
        if (!this.e.isMarkedInGroup()) {
            i += this.e.getCount();
        }
        if (i > 0) {
            j();
            this.I = a(getApplicationContext());
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), SportResultActivity.class);
            intent.putExtra("share_data", this.I);
            if (z) {
                intent.putExtra("timeout", true);
            }
            intent.putExtra(k.h, this.o);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "Failed to start share activity", F).show();
            }
        }
    }

    private void e() {
        Bundle bundle = new Bundle();
        bundle.putString(ae.a, getString(r.confirm));
        bundle.putString(ae.b, getString(r.lab_factory_sport_monitor_bracelet_offline_notice, new Object[]{this.z}));
        bundle.putString(ae.c, getString(r.lab_factory_sport_monitor_bracelet_offline));
        ae.a(this, ae.class, bundle, new D(this));
    }

    private void e(int i) {
        if (this.D.getSavedGroupCountOfPB() <= i) {
            this.D.setGroupCountOfPB(i);
            this.D.updateGroupCostTimeOfPB();
        }
    }

    private void e(boolean z) {
        if (z && !this.C) {
            this.C = true;
        }
        if (!z && this.C) {
            this.C = false;
        }
    }

    private void f() {
        d();
        this.H = F;
        this.e.setMarkedOneRoundFinished();
        this.D.clear();
        this.m.clear();
    }

    private void f(int i) {
        this.x.setBackgroundColor(i);
        applyStatusBarTint(i);
    }

    private void g() {
        this.J.setText(getString(r.lab_factory_cheat_toast));
        this.J.setVisibility(F);
    }

    private void h() {
        b(false);
        a(false);
        if (this.g != null) {
            this.g.a();
        }
        if (this.f != null) {
            this.f.a();
        }
    }

    private void i() {
        int nextInt;
        long costTime = this.e.getCostTime();
        int i = costTime < 1 ? 1 : (int) costTime;
        if (i <= 3) {
            nextInt = new Random().nextInt(2);
            if (nextInt == 0) {
                nextInt++;
            }
            nextInt += i;
        } else {
            nextInt = i;
        }
        nextInt = a((long) this.e.getCount(), (long) nextInt);
        this.y.setText(Html.fromHtml(getString(r.lab_factory_sport_average_rate_per_minute, new Object[]{Integer.valueOf(nextInt)})));
    }

    private void j() {
        if (this.D != null && this.e != null) {
            this.D.setEndTime();
            if (this.e != null && !this.e.isMarkedInGroup()) {
                this.D.addGroupItem(this.e);
                b(this.e);
                e(this.h + this.e.getCount());
            }
        }
    }

    public void a(int i) {
        if (this.g != null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = b(i);
            this.g.sendMessage(obtainMessage);
        }
    }

    public void a(i iVar, int i, boolean z) {
        if (this.g != null && this.u != 2 && i > 0 && i != this.e.getCount()) {
            Message obtainMessage;
            e(z);
            if (this.C) {
                this.g.removeMessages(100);
                obtainMessage = this.g.obtainMessage(100);
            } else {
                obtainMessage = this.g.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = 2;
                obtainMessage.arg2 = this.H + i;
            }
            this.g.sendMessage(obtainMessage);
            b(true);
            a(true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 0 && i == 0) {
            this.d.a(intent.getData());
        }
    }

    public void onBackPressed() {
        if (this.D == null) {
            super.onBackPressed();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.c == -1) {
            com.huami.android.view.b.a((Context) this, (int) r.lab_factory_exit_press_again, (int) F).show();
            this.c = currentTimeMillis;
            this.f.sendEmptyMessageDelayed(b, 2000);
        } else if (currentTimeMillis - this.c < 2000) {
            this.c = -1;
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_lab_factory_sport_analyser_offical);
        this.o = getIntent().getStringExtra(k.h);
        if (TextUtils.isEmpty(this.o)) {
            setResult(F);
            finish();
            return;
        }
        this.z = b(this.o);
        this.D = new k(this.o).a();
        this.d = new af(this);
        this.g = new G();
        this.f = new K();
        this.D.loadPBInfo(a((Context) this, this.o));
        this.e = new DynamicGroupItemInfo(this.D.getSportType(), this.D.getRoundCountOfPB());
        this.e.setMarkedOneRoundFinished();
        this.L = a();
        b();
        c();
        C0401a.a((Context) this, C0401a.bc, this.o);
    }

    public void onDestroy() {
        if (!this.G) {
            j();
        }
        if (this.D != null && this.D.getGroupSize() > 0) {
            cn.com.smartdevices.bracelet.lab.sync.b.a(getApplicationContext(), this.D, this.G ? this.I : a(getApplicationContext()));
        }
        if (this.d != null) {
            this.d.a();
        }
        if (this.E != null) {
            this.E.b();
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onResume();
        C0401a.b(C0401a.aa);
        C0401a.b((Activity) this);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.aa);
        C0401a.a((Activity) this);
    }

    public void onStart() {
        super.onStart();
        d.a((Context) this).b((i) this);
        this.t = new H(this, H.a, F.a, F.a);
        if (this.D.getSportType() == 1) {
            this.s = new H(this, H.b, kankan.wheel.widget.a.bX, kankan.wheel.widget.a.bX);
        } else if (this.D.getSportType() == 2) {
            this.s = new H(this, H.b, 6000, 6000);
        }
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.u = b(d.a((Context) this).a());
        c(this.u);
    }

    public void onStop() {
        if (this.d != null) {
            this.d.stop();
        }
        h();
        if (this.A != null) {
            this.A.cancel();
        }
        if (this.B != null) {
            this.B.cancel();
        }
        if (this.e != null) {
            this.H = this.e.isMarkedInGroup() ? F : this.e.getCount();
        }
        d.a((Context) this).c(this, this.o);
        d.a((Context) this).c(this);
        super.onStop();
    }
}
