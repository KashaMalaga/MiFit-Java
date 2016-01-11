package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.B;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.D;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventNotifyStatusClosed;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.f;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.g;

public class SettingPhoneNotifyActivity extends SystemBarTintActivity implements OnClickListener {
    public static final String a = "phone_notify_type";
    public static final int b = 1;
    public static final int c = 2;
    private int d = b;
    private TextView e = null;
    private TextView f = null;
    private TextView g = null;
    private Switch h = null;
    private LinearLayout i = null;
    private ImageView j = null;
    private TextView k = null;
    private B l = B.a();
    private Context m = this;
    private LinearLayout n;
    private LinearLayout o;
    private Switch p;
    private TextView q;
    private String r = a.f;

    private void a() {
        String[] stringArray = getResources().getStringArray(f.phone_notify_tips);
        String[] stringArray2 = getResources().getStringArray(f.contacts_notify_title);
        TextView textView = (TextView) findViewById(l.tips_tv);
        LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        switch (this.d) {
            case b /*1*/:
                layoutParams.topMargin = Utils.a(this.m, 144.0f);
                this.e.setText(r.alarm_notify);
                this.f.setText(r.alarm_notify);
                this.g.setText(stringArray[b]);
                this.j.setBackgroundResource(k.alarm_notify_icon);
                this.k.setText(r.alarm_notify_tips2);
                if (!this.l.b(this.r)) {
                    this.h.setChecked(false);
                    break;
                } else {
                    this.h.setChecked(true);
                    break;
                }
            case c /*2*/:
                layoutParams.topMargin = Utils.a(this.m, 117.0f);
                this.e.setText(r.sms_notify);
                this.f.setText(r.sms_notify);
                this.g.setText(stringArray[c]);
                this.j.setBackgroundResource(k.sms_notify_icon);
                this.k.setText(r.sms_notify_tips2);
                if (this.l.d(this.r)) {
                    this.h.setChecked(true);
                    b(true);
                } else {
                    this.h.setChecked(false);
                    b(false);
                }
                this.n.setVisibility(0);
                this.n.setOnClickListener(this);
                this.q.setText(stringArray2[b]);
                if (!this.l.g(this.r)) {
                    this.p.setChecked(false);
                    break;
                } else {
                    this.p.setChecked(true);
                    break;
                }
        }
        textView.setLayoutParams(layoutParams);
    }

    private void a(boolean z) {
        switch (this.d) {
            case b /*1*/:
                if (this.l.a(this.r, z)) {
                    D.a(this.m, z);
                    if (!z) {
                        EventBus.getDefault().post(new EventNotifyStatusClosed());
                        return;
                    }
                    return;
                }
                b.a((Context) this, (int) r.notify_set_failed, 0).show();
                return;
            case c /*2*/:
                C0401a.a(this.m, C0401a.gw, z + a.f);
                if (this.l.e(this.r, z)) {
                    D.b(this.m, z);
                    if (!z) {
                        EventBus.getDefault().post(new EventNotifyStatusClosed());
                    }
                    b(z);
                    return;
                }
                b(false);
                b.a((Context) this, (int) r.notify_set_failed, 0).show();
                return;
            default:
                return;
        }
    }

    private void b(boolean z) {
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        this.p.setChecked(false);
        this.p.setEnabled(z);
        if (z) {
            this.q.setTextColor(getResources().getColor(g.main_ui_title_color));
        } else {
            this.q.setTextColor(getResources().getColor(g.disabled_text_color));
        }
    }

    private void c(boolean z) {
        if (this.l.g(this.r, z)) {
            D.e(getApplicationContext(), z);
            this.p.setChecked(z);
            return;
        }
        this.p.setChecked(false);
        b.a((Context) this, (int) r.notify_set_failed, 0).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case l.phone_notify_home_back /*2131296431*/:
                finish();
                return;
            case l.phone_notify_ll /*2131296433*/:
                this.h.toggle();
                return;
            case l.contacts_notify_ll /*2131296439*/:
                this.p.toggle();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_phone_notify);
        this.r = Keeper.readBraceletBtInfo().b;
        this.d = getIntent().getIntExtra(a, b);
        this.e = (TextView) findViewById(l.phone_notify_home_back);
        this.e.setOnClickListener(this);
        this.h = (Switch) findViewById(l.phone_notify_switch);
        this.h.setOnCheckedChangeListener(new C0802ew(this));
        this.i = (LinearLayout) findViewById(l.phone_notify_ll);
        this.i.setOnClickListener(this);
        this.f = (TextView) findViewById(l.phone_notify_switch_title);
        this.g = (TextView) findViewById(l.phone_notify_tips);
        this.j = (ImageView) findViewById(l.phone_notify_help_iv);
        this.k = (TextView) findViewById(l.phone_notify_tips2_tv);
        this.n = (LinearLayout) findViewById(l.contacts_ll);
        this.o = (LinearLayout) findViewById(l.contacts_notify_ll);
        this.o.setOnClickListener(this);
        this.q = (TextView) findViewById(l.contacts_notify_switch_title);
        this.p = (Switch) findViewById(l.contacts_notify_switch);
        this.p.setOnCheckedChangeListener(new C0803ex(this));
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
