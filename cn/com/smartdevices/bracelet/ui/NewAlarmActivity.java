package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.Event12HourUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventAmPmUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.huami.android.view.c;
import com.xiaomi.hm.health.bt.a.p;
import com.xiaomi.hm.health.bt.model.AlarmClockItem;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.g;
import kankan.wheel.widget.h;

public class NewAlarmActivity extends SystemBarTintActivity implements OnClickListener {
    public static final int[] a = new int[]{AlarmClockItem.ALARM_ONCE, AlarmClockItem.ALARM_EVERY_DAY, AlarmClockItem.ALARM_MON_2_FRI, -1};
    public static final int b = -11;
    public static final int c = -10;
    private static final String d = "NewAlarmActivity";
    private static final int e = 1;
    private static final int f = 30;
    private static final int g = 0;
    private static final int h = 23;
    private static final int i = 1;
    private static final int j = 0;
    private AlarmClockItem k = null;
    private WheelView l;
    private WheelView m;
    private View n;
    private Context o = null;
    private TextView p;
    private PersonInfo q;
    private ArrayList<AlarmClockItem> r;
    private Switch s;
    private WheelView t;
    private boolean u;
    private C0763dl v;
    private String w;

    private void a() {
        b();
        C0596r.e(d, "mItem = " + this.k.toJson());
        if (this.k.toJson().equals(this.w)) {
            setResult(g);
            finish();
            return;
        }
        aL aLVar = (aL) c.instantiate(this, aL.class.getName());
        aLVar.setOpClickListener(new cG(this));
        aLVar.show(getFragmentManager(), aL.class.getName());
    }

    private void a(int i) {
        C0596r.e(d, "updateHourByAmPm : " + i);
        if (!this.u) {
            int f = this.l.f();
            C0596r.e(d, "cur hour =" + f);
            if (i == 0) {
                if (f >= 12) {
                    f -= 12;
                }
            } else if (f < 12) {
                f += 12;
            }
            C0596r.e(d, "after hour =" + f);
            this.l.d(f);
        }
    }

    private void b() {
        this.k.set(this.l.f(), this.m.f(), this.k.isEnabled());
    }

    private void b(int i) {
        C0596r.e(d, "updateAmPmByHour hour=" + i);
        if (this.t != null && !this.u) {
            this.t.c(i >= 12 ? i : g);
        }
    }

    private void c(int i) {
        this.k.setDays(i);
        this.p.setText(Utils.a(this.o, this.k));
    }

    protected boolean isExceptForMiNote() {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0596r.e(d, "onActivityResult : " + i + ", result:" + i2 + " data=" + intent);
        if (i == i && i2 == -1) {
            c(intent.getIntExtra(a.bv, g));
        }
    }

    public void onBackPressed() {
        a();
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case l.confirm /*2131296545*/:
                b();
                if (this.k.toJson().equals(this.w)) {
                    finish();
                    return;
                }
                this.k.setEnabled(true);
                AlarmActivity.a(this.k, this.o);
                new p(this.r, new cF(this)).f();
                Intent intent = new Intent();
                intent.putExtra(a.al, this.k.toJson().toString());
                setResult(-1, intent);
                finish();
                return;
            case l.cancel /*2131296581*/:
                a();
                return;
            case l.new_alarm_smart_wakeup_area /*2131296584*/:
                Switch switchR = this.s;
                if (this.s.isChecked()) {
                    z = false;
                }
                switchR.setChecked(z);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_new_alarm);
        this.o = this;
        EventBus.getDefault().register(this);
        this.n = findViewById(l.new_alarm_cycle_area);
        this.n.setOnClickListener(new cD(this));
        this.p = (TextView) findViewById(l.alarm_days_txt);
        this.t = (WheelView) findViewById(l.setting_alarm_wheel_ampm);
        f c0763dl = new C0763dl(this, b, c, this.t, getResources().getColor(g.bg_color_blue), getResources().getColor(g.main_ui_content_color), a.bm, false, 46, 18, 15, 21, i);
        c0763dl.a(C0763dl.c);
        c0763dl.a(17);
        this.t.a(5).e(h.wheel_custom_val_white_1).a(com.xiaomi.e.a.f, 18.0f).a(c0763dl);
        this.l = (WheelView) findViewById(l.setting_alarm_wheel_hour);
        this.v = new C0763dl(this, g, h, this.l, getResources().getColor(g.bg_color_blue), getResources().getColor(g.main_ui_content_color), a.bm, true, 46, 24, 21, 21, i);
        this.v.a(16);
        this.l.a(5).e(h.wheel_custom_val_white_1).a(getString(r.hour_1), g.bg_color_blue, 18.0f).a(this.v);
        this.m = (WheelView) findViewById(l.setting_alarm_wheel_minute);
        this.m.a(5).e(h.wheel_custom_val_white_1).a(getString(r.minute), g.bg_color_blue, 18.0f).a(new C0763dl(this, g, 59, this.m, getResources().getColor(g.bg_color_blue), getResources().getColor(g.main_ui_content_color), a.bm, true, 46, 24, 21, 21, i));
        int intExtra = getIntent().getIntExtra(AlarmActivity.b, g);
        this.q = Keeper.readPersonInfo();
        this.r = this.q.getAlarmClockItems();
        this.k = (AlarmClockItem) this.r.get(intExtra);
        this.w = this.k.toJson();
        C0596r.e(d, "mClockItemKey = " + this.w);
        this.s = (Switch) findViewById(l.new_alarm_smart_wakeup_switch);
        boolean z = this.k.getDuration() > 0;
        C0596r.e(d, "smartSwitch: " + z + ", mItem duration=" + this.k.getDuration());
        this.s.setChecked(z);
        this.s.setOnCheckedChangeListener(new cE(this));
        findViewById(l.new_alarm_smart_wakeup_area).setOnClickListener(this);
        this.p.setText(Utils.a(this.o, this.k));
        this.l.d(this.k.getHour());
        this.m.d(this.k.getMinute());
        findViewById(l.confirm).setOnClickListener(this);
        findViewById(l.cancel).setOnClickListener(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(Event12HourUpdate event12HourUpdate) {
        b(event12HourUpdate.getHour());
    }

    public void onEvent(EventAmPmUpdate eventAmPmUpdate) {
        a(eventAmPmUpdate.getAmPm());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.H);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        this.u = DateFormat.is24HourFormat(this);
        if (this.u) {
            this.t.setVisibility(8);
            this.v.a(9);
            this.l.a(this.v);
        } else {
            this.t.setVisibility(g);
            this.v.a(16);
            this.l.a(this.v);
            b(this.k.getHour());
        }
        C0401a.a(C0401a.H);
        C0401a.a((Activity) this);
    }
}
