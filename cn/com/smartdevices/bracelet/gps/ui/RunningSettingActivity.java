package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.v;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.e.b;
import cn.com.smartdevices.bracelet.gps.e.c;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.j;
import cn.com.smartdevices.bracelet.gps.e.n;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.huami.android.ui.CustomActionBarActivity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.f;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.HashMap;

public class RunningSettingActivity extends CustomActionBarActivity implements OnClickListener, S {
    private static final boolean i = true;
    private Resources a = null;
    private SeekBar b = null;
    private TextView c = null;
    private Switch d = null;
    private d f = null;
    private Switch g = null;
    private RelativeLayout h = null;
    private TextView j = null;
    private final h k = c.a();
    private Switch l;
    private boolean m;
    private Switch n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private int s;
    private int t;
    private View u;
    private int v;

    public RunningSettingActivity() {
        super(a.f, a.f);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, RunningSettingActivity.class));
    }

    private void a(SeekBar seekBar, boolean z) {
        if (z) {
            seekBar.setProgressDrawable(this.a.getDrawable(com.xiaomi.hm.health.b.a.h.running_seekbar_enabled));
            seekBar.setThumb(this.a.getDrawable(com.xiaomi.hm.health.b.a.h.running_seekbar_thumb_enabled));
        } else {
            seekBar.setProgressDrawable(this.a.getDrawable(com.xiaomi.hm.health.b.a.h.running_seekbar_disabled));
            seekBar.setThumb(this.a.getDrawable(com.xiaomi.hm.health.b.a.h.running_seekbar_thumb_disabled));
        }
        seekBar.setEnabled(z);
    }

    private void a(boolean z) {
        this.n.setClickable(z);
        this.u.setClickable(z);
        if (z) {
            this.o.setTextColor(this.s);
            this.p.setTextColor(this.s);
            this.q.setTextColor(this.s);
            this.r.setTextColor(this.s);
            if (this.f.p()) {
                this.n.setThumbDrawable(this.a.getDrawable(com.xiaomi.hm.health.b.a.h.switch_thumb_enable));
                return;
            }
            return;
        }
        this.o.setTextColor(this.t);
        this.p.setTextColor(this.t);
        this.q.setTextColor(this.t);
        this.r.setTextColor(this.t);
        this.n.setThumbDrawable(this.a.getDrawable(com.xiaomi.hm.health.b.a.h.switch_thumb_disable));
    }

    private void d(int i) {
        if (i >= 0) {
            j b = this.k.b((double) i);
            int i2 = ((int) b.a) % 60;
            String str = a.f + (((int) b.a) / 60) + "'" + i2 + "\"";
            if (n.MinPerMile == b.b) {
                this.c.setText(getResources().getString(com.xiaomi.hm.health.b.a.n.running_settings_speed_br, new Object[]{str}));
                return;
            }
            this.c.setText(getResources().getString(com.xiaomi.hm.health.b.a.n.running_settings_speed, new Object[]{str}));
        }
    }

    private void f() {
        this.f = p.f(this);
        if (this.f == null) {
            this.f = new d(4);
        }
    }

    private void g() {
        boolean z = i;
        this.a = getResources();
        this.t = getResources().getColor(f.running_light_text);
        this.s = getResources().getColor(f.running_settings_title);
        f();
        this.c = (TextView) findViewById(i.pace_desc);
        int h = this.f.h();
        if (h > 0) {
            d(h);
        } else {
            d((int) RunningReminderInfo.b);
        }
        int h2 = this.f.h() <= 0 ? 0 : (this.f.h() - 240) / 15;
        this.b = (SeekBar) findViewById(i.set_low_pace);
        this.b.setProgress(h2);
        this.b.setOnSeekBarChangeListener(new C0517bc(this));
        boolean f = cn.com.smartdevices.bracelet.gps.e.a.f();
        this.d = (Switch) findViewById(i.pace_notify_switcher);
        Switch switchR = this.d;
        boolean z2 = (this.f.l() && f) ? i : false;
        switchR.setChecked(z2);
        this.d.setEnabled(f);
        this.d.setOnCheckedChangeListener(new C0518bd(this));
        SeekBar seekBar = this.b;
        if (!(this.f.l() && f)) {
            z = false;
        }
        a(seekBar, z);
        this.h = (RelativeLayout) findViewById(i.auto_pause_enabled);
        this.h.setVisibility(0);
        this.g = (Switch) findViewById(i.auto_pause_switcher);
        this.g.setChecked(this.f.j());
        this.g.setOnCheckedChangeListener(new C0519be(this));
        com.xiaomi.hm.health.bt.model.h f2 = com.xiaomi.hm.health.bt.bleservice.a.f();
        if (cn.com.smartdevices.bracelet.gps.e.a.g() || (f2 != null && f2.a())) {
            findViewById(i.hr_container).setVisibility(0);
            this.u = findViewById(i.max_hr_container);
            this.u.setVisibility(0);
            findViewById(i.hr_remind_container).setVisibility(0);
            this.u.setOnClickListener(this);
            this.l = (Switch) findViewById(i.hr_switch);
            this.n = (Switch) findViewById(i.hr_remind_switcher);
            this.o = (TextView) findViewById(i.max_hr);
            this.r = (TextView) findViewById(i.label_instruct);
            this.p = (TextView) findViewById(i.label_max_hr);
            this.q = (TextView) findViewById(i.label_hr_remind);
            this.m = this.f.m();
            this.l.setOnCheckedChangeListener(new bf(this));
            this.l.setChecked(this.m);
            this.n.setChecked(this.f.p());
            this.n.setOnCheckedChangeListener(new bg(this));
            this.v = h();
            this.o.setText(String.valueOf(this.v));
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            ImageSpan imageSpan = new ImageSpan(this, com.xiaomi.hm.health.b.a.h.run_set_help);
            CharSequence spannableString = new SpannableString(getString(com.xiaomi.hm.health.b.a.n.run_hr_instruct));
            spannableString.setSpan(imageSpan, spannableString.length() - 2, spannableString.length() - 1, 34);
            spannableStringBuilder.append(spannableString);
            this.r.setText(spannableStringBuilder);
            this.r.setOnClickListener(this);
            a(this.m);
        }
        this.j = (TextView) findViewById(i.slow_speed_remide_text);
        if (!f) {
            this.j.setText(getResources().getString(com.xiaomi.hm.health.b.a.n.running_no_bracelet_tips));
        }
    }

    private int h() {
        int q = this.f.q();
        if (HeartRateInfo.isHRValueValid(q)) {
            return q;
        }
        q = b.b();
        return q > 0 ? (int) (((double) (220 - q)) * 0.8d) : kankan.wheel.widget.a.ap;
    }

    public void a(int i) {
        this.f.g(i);
        this.o.setText(String.valueOf(i));
        d();
    }

    protected String b() {
        return getString(com.xiaomi.hm.health.b.a.n.sport_setting);
    }

    void d() {
        p.a((Context) this, this.f);
        HashMap hashMap = new HashMap();
        hashMap.put("pace_remind", String.valueOf(this.f.l()));
        hashMap.put("auto_pause", String.valueOf(this.f.j()));
        hashMap.put("low_pace", String.valueOf(this.f.h()));
        hashMap.put("high_pace", String.valueOf(this.f.e()));
        v.a((Context) this).a(new Intent(d.a));
        C0401a.a((Context) this, C0401a.bj, hashMap);
        if (this.m != this.f.m()) {
            C0401a.a((Context) this, this.f.m() ? C0401a.hd : C0401a.he);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == i.label_instruct) {
            IllustrateActivity.a(this, cn.com.smartdevices.bracelet.weight.family.h.d);
        } else if (id == i.max_hr_container) {
            DialogFragment a = R.a();
            a.a(this);
            this.v = h();
            Bundle bundle = new Bundle();
            bundle.putInt(cn.com.smartdevices.bracelet.gps.c.a.g, this.v);
            com.huami.android.view.c.showPanel((Activity) this, a, bundle);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.xiaomi.hm.health.b.a.j.fragment_running_speed_settings);
        g();
    }

    protected void onDestroy() {
        super.onDestroy();
        d();
    }
}
