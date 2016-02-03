package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;

public class MemberInfoSetBirthActivity extends MemberInfoBaseActivity implements OnClickListener {
    private WheelView h;
    private WheelView i;
    private TextView j;
    private Birthday k;
    private int l;
    private String m = "2000-10-10";
    private C0763dl n;
    private int o;
    private boolean p = false;

    private void a() {
        this.k.setYear(this.h.f() + this.l);
        this.k.setMonth(this.i.f() + 1);
        this.m = this.k.toStringData();
        C0596r.e("MemberInfoBaseActivity", "get birthday:" + this.k);
    }

    public void c() {
        a();
        super.c();
    }

    public void d() {
        a();
        if (!this.e) {
            super.d();
        }
        Keeper.saveCurrentUser(Keeper.CURRENT_USER_BIRTH, this.m);
        Intent intent = new Intent();
        intent.setClass(this, MemberInfoSetHeightActivity.class);
        intent.putExtra(MemberInfoBaseActivity.c, this.e);
        intent.putExtra(MemberInfoBaseActivity.d, this.f);
        intent.putExtra("FROM_BABY_WEIGHT", this.p);
        intent.putExtra(e.d, this.g == null ? a.f : this.g.n());
        startActivityForResult(intent, 6);
    }

    protected void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        this.e = getIntent().getBooleanExtra(MemberInfoBaseActivity.c, false);
        this.f = getIntent().getBooleanExtra(MemberInfoBaseActivity.d, false);
        this.p = getIntent().getBooleanExtra("FROM_BABY_WEIGHT", false);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.g = e.b(getIntent().getStringExtra(e.d));
        }
        setContentView((int) R.layout.activity_person_info_set_age);
        b();
        this.j = (TextView) findViewById(R.id.bracelet_login_title_info);
        this.j.setText(getString(R.string.input_precise_user_info));
        String currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_BIRTH);
        if (currentUserInfoByTag.isEmpty()) {
            i = Calendar.getInstance().get(1);
            int i2 = Calendar.getInstance().get(2) + 1;
            int i3 = Calendar.getInstance().get(5);
            if (!this.p) {
                this.m = (i - 24) + "-7-15";
            } else if (i2 >= 7) {
                this.m = i + "-" + (i2 - 6) + "-" + i3;
            } else {
                this.m = (i - 1) + "-" + (i2 + 6) + "-" + i3;
            }
        } else {
            this.m = currentUserInfoByTag;
        }
        this.k = Birthday.fromStr(this.m);
        C0596r.e("MemberInfoBaseActivity", "onCreate, birthday:" + this.k);
        i = Calendar.getInstance().get(1);
        this.o = Calendar.getInstance().get(2);
        this.l = i - 100;
        int i4 = i + 0;
        this.h = (WheelView) findViewById(R.id.person_info_year_picker);
        this.h.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.year), R.color.content_color, 12, kankan.wheel.widget.a.bh, kankan.wheel.widget.a.bj).a(new C0763dl(this, this.l, i4, this.h, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45));
        this.i = (WheelView) findViewById(R.id.person_info_month_picker);
        this.n = new C0763dl(this, 1, 12, this.i, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), true, 50, 48, 45, 45);
        if (!this.k.isValid() || this.k.getYear() - this.l < 100) {
            this.i.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.month), R.color.content_color, 12, kankan.wheel.widget.a.bi, kankan.wheel.widget.a.bj).a(this.n);
        } else {
            this.i.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.month), R.color.content_color, 12, kankan.wheel.widget.a.bi, kankan.wheel.widget.a.bj).a(new C0763dl(this, 1, this.o + 1, this.i, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45));
        }
        if (this.k.isValid()) {
            this.h.c(this.k.getYear() - this.l);
            this.i.d(this.k.getMonth() - 1);
        } else {
            this.h.c(1990 - this.l);
            this.i.d(0);
        }
        this.h.a(new a(this));
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.aO);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.aO);
        C0401a.a((Activity) this);
    }
}
