package cn.com.smartdevices.bracelet.weight;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventWeightWithUser;
import cn.com.smartdevices.bracelet.eventbus.weight.EventUserSelected;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.weight.family.WeightChooseUserActivity;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import de.greenrobot.event.EventBus;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import kankan.wheel.widget.a;

public class RecordWeightActivity extends SystemBarTintActivity {
    private static final String b = "RecordWeightActivity";
    private Context a = this;
    private EditText c;
    private TextView d;
    private TextView e;
    private TextView f;
    private RelativeLayout g;
    private RelativeLayout h;
    private RelativeLayout i;
    private Button j;
    private Button k;
    private String l;
    private DecimalFormat m;
    private int n = -1;
    private boolean o = false;

    private void a() {
        this.c = (EditText) findViewById(R.id.manual_weight_edittext);
        this.c.addTextChangedListener(new C0881s(this, this.c));
        this.c.setFocusable(true);
        this.c.setFocusableInTouchMode(true);
        this.c.requestFocus();
        ((InputMethodManager) this.c.getContext().getSystemService("input_method")).showSoftInput(this.c, 0);
        this.d = (TextView) findViewById(R.id.manual_weight_date);
        this.e = (TextView) findViewById(R.id.manual_weight_name);
        this.e.setText(J.a().a(this.n).name);
        this.f = (TextView) findViewById(R.id.manual_weight_unit);
        this.f.setText(aA.a(this.a, Keeper.readPersonInfo().miliConfig.weightUnit));
        this.g = (RelativeLayout) findViewById(R.id.weight_layout);
        this.h = (RelativeLayout) findViewById(R.id.date_layout);
        this.i = (RelativeLayout) findViewById(R.id.user_layout);
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.m = new DecimalFormat("00");
        int hours = new Date().getHours();
        int minutes = new Date().getMinutes();
        if (Utils.y(this.a)) {
            this.d.setText(simpleDateFormat.format(new Date()) + " " + this.m.format((long) hours) + a.ci + this.m.format((long) minutes));
        } else if (hours >= 12) {
            this.d.setText(simpleDateFormat.format(new Date()) + " " + this.m.format((long) (hours - 12)) + a.ci + this.m.format((long) minutes) + " " + getString(R.string.pm));
        } else {
            this.d.setText(simpleDateFormat.format(new Date()) + " " + this.m.format((long) hours) + a.ci + this.m.format((long) minutes) + " " + getString(R.string.am));
        }
        this.g.setOnClickListener(new C0874l(this));
        this.h.setOnClickListener(new C0875m(this));
        this.i.setOnClickListener(new C0876n(this));
        this.j = (Button) findViewById(R.id.confirm);
        this.j.setOnClickListener(new C0877o(this));
        this.k = (Button) findViewById(R.id.cancel);
        this.k.setOnClickListener(new C0878p(this));
        String obj = this.c.getText().toString();
        if (obj == null || obj.isEmpty()) {
            this.j.setClickable(false);
            this.j.setTextColor(this.a.getResources().getColor(R.color.disable_text_color_dark));
        }
    }

    private void b() {
        if (!this.o) {
            this.o = true;
            C0882t c0882t = (C0882t) Fragment.instantiate(this.a, C0882t.class.getName());
            c0882t.a(new C0879q(this));
            c0882t.a(new C0880r(this));
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.addToBackStack(null);
            c0882t.show(beginTransaction, null);
        }
    }

    private void c() {
        if (Utils.c((Activity) this.a)) {
            this.a.startActivity(new Intent(this.a, WeightChooseUserActivity.class));
        }
    }

    private void d() {
        float f = BitmapDescriptorFactory.HUE_YELLOW;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.l == null || this.l.isEmpty())) {
            currentTimeMillis = Long.parseLong(this.l);
        }
        String obj = this.c.getText().toString();
        if (!(obj == null || obj.isEmpty())) {
            try {
                f = aA.a(aA.c(Float.parseFloat(obj), 1), Keeper.readPersonInfo().miliConfig.weightUnit);
                if (f < 3.0f || f > 634.9f) {
                    b.a(this.a, getString(R.string.weight_not_in_range), 0).show();
                    return;
                }
            } catch (Exception e) {
                C0596r.e(b, "weight is invalid");
                b.a(this.a, getString(R.string.please_input_correct_weight), 0).show();
                return;
            }
        }
        UserInfo a = J.a().a(this.n);
        e eVar = new e();
        eVar.b(aA.b(f, Keeper.readPersonInfo().miliConfig.weightUnit));
        eVar.a(Keeper.readPersonInfo().miliConfig.weightUnit);
        eVar.a(true);
        eVar.b(false);
        eVar.a(currentTimeMillis);
        eVar.c(f);
        eVar.a(aA.a(a.height, Birthday.fromStr(a.birthday).getAge(), f));
        WeightInfo weightInfo = new WeightInfo();
        weightInfo.uid = a.uid;
        weightInfo.timestamp = eVar.e();
        weightInfo.weight = f;
        weightInfo.type = 1;
        long e2 = eVar.e();
        while (ah.a().a(e2)) {
            C0596r.e(b, "time exists " + e2);
            e2++;
        }
        C0596r.e(b, "save time is " + e2);
        weightInfo.timestamp = e2;
        eVar.a(e2);
        ah.a().a(weightInfo);
        EventBus.getDefault().post(new EventWeightWithUser(eVar, a.uid));
        EventBus.getDefault().post(new EventUserInfoUpdate(a));
        C0401a.a(this.a, C0401a.gv, com.xiaomi.e.a.f + currentTimeMillis);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_record_weight);
        if (getIntent() != null) {
            this.n = getIntent().getIntExtra(WeightGoalSetActivity.a, -1);
            if (this.n == 0) {
                this.n = -1;
            }
        }
        a();
        EventBus.getDefault().register(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventUserSelected eventUserSelected) {
        this.n = eventUserSelected.uid;
        this.e.setText(J.a().a(this.n).name);
    }
}
