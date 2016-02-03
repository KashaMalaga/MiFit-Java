package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.h;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightReportActivity;
import cn.com.smartdevices.bracelet.weight.aA;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;

public class MemberInfoSetHeightActivity extends MemberInfoBaseActivity implements OnClickListener {
    private static final long t = 1000;
    private Context h = this;
    private WheelView i;
    private WheelView j;
    private TextView k;
    private C0763dl l;
    private int m = a.aC;
    private float n;
    private cn.com.smartdevices.bracelet.ui.person.a o;
    private C0763dl p;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private long u = 0;

    private void a() {
        if (this.q) {
            this.m = this.o.c();
        } else {
            this.m = this.i.f() + 40;
        }
        C0596r.e("MemberInfoBaseActivity", "mHeight = " + this.m);
    }

    private int e() {
        return this.q ? this.o.a() : this.m > 0 ? this.m - 40 : h.k;
    }

    public void c() {
        a();
        C0596r.e("MemberInfoBaseActivity", "onCancel");
        super.c();
    }

    public void d() {
        C0596r.e("TIME", "now " + System.currentTimeMillis() + " last time " + this.u);
        if (System.currentTimeMillis() - this.u <= t) {
            C0596r.e("TIME", "click too fast, unable to go to next page");
            return;
        }
        C0596r.e("TIME", "able to go next");
        this.u = System.currentTimeMillis();
        super.d();
        a();
        Keeper.saveCurrentUser(Keeper.CURRENT_USER_HEIGHT, this.m + com.xiaomi.e.a.f);
        if (this.e || this.f) {
            if ((this.e || this.f) && this.g != null) {
                this.n = aA.c(this.g.j(), this.g.h(), 0);
            } else {
                this.n = getIntent().getFloatExtra(Constant.aJ, 70.0f);
            }
            UserInfo userInfo = new UserInfo();
            String currentUserInfoByTag;
            if (this.e) {
                userInfo.name = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_NAME);
                currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_GENDER);
                if (currentUserInfoByTag.isEmpty()) {
                    userInfo.gender = 1;
                } else {
                    userInfo.gender = Integer.parseInt(currentUserInfoByTag);
                }
                userInfo.birthday = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_BIRTH);
                currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_HEIGHT);
                if (currentUserInfoByTag.isEmpty()) {
                    userInfo.height = a.aC;
                } else {
                    userInfo.height = Integer.parseInt(currentUserInfoByTag);
                }
                userInfo.weight = this.n;
                userInfo.uid = 0;
                Keeper.saveCurrentUser(Keeper.CURRENT_USER_NAME, com.xiaomi.e.a.f);
                Keeper.saveCurrentUser(Keeper.CURRENT_USER_GENDER, com.xiaomi.e.a.f);
                Keeper.saveCurrentUser(Keeper.CURRENT_USER_BIRTH, com.xiaomi.e.a.f);
                Keeper.saveCurrentUser(Keeper.CURRENT_USER_HEIGHT, com.xiaomi.e.a.f);
                if (this.g != null) {
                    this.g.a(aA.a(this.m, Birthday.fromStr(userInfo.birthday).getAge(), this.n));
                }
                Intent intent = new Intent(this, WeightReportActivity.class);
                intent.putExtra(e.d, this.g == null ? com.xiaomi.e.a.f : this.g.n());
                intent.putExtra(UserInfo.USERINFO_KEY, userInfo.toJsonString());
                intent.putExtra("NEW_USER", true);
                startActivityForResult(intent, 6);
                return;
            }
            userInfo.name = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_NAME);
            currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_GENDER);
            if (currentUserInfoByTag.isEmpty()) {
                userInfo.gender = 1;
            } else {
                userInfo.gender = Integer.parseInt(currentUserInfoByTag);
            }
            userInfo.birthday = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_BIRTH);
            currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_HEIGHT);
            if (currentUserInfoByTag.isEmpty()) {
                userInfo.height = this.m;
            } else {
                userInfo.height = Integer.parseInt(currentUserInfoByTag);
            }
            userInfo.weight = this.n;
            C0596r.e("MemberInfoBaseActivity", "set weight to : " + this.n + ", info.birthday = " + userInfo.birthday);
            new b(this, userInfo).execute(new Void[0]);
            return;
        }
        Intent intent2 = new Intent(this, MemberInfoSetWeightActivity.class);
        intent2.putExtra(e.d, this.g == null ? com.xiaomi.e.a.f : this.g.n());
        intent2.putExtra(MemberInfoBaseActivity.c, this.e);
        intent2.putExtra(MemberInfoBaseActivity.d, this.f);
        intent2.putExtra("FROM_BABY_WEIGHT", this.r);
        startActivityForResult(intent2, 6);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = getIntent().getBooleanExtra(MemberInfoBaseActivity.c, false);
        this.f = getIntent().getBooleanExtra(MemberInfoBaseActivity.d, false);
        this.r = getIntent().getBooleanExtra("FROM_BABY_WEIGHT", false);
        if (this.r) {
            this.m = 60;
        }
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.g = e.b(getIntent().getStringExtra(e.d));
        }
        setContentView((int) R.layout.activity_person_info_set_height);
        b();
        this.q = Keeper.readPersonInfo().getUnit() != 0;
        this.k = (TextView) findViewById(R.id.bracelet_login_title_info);
        this.k.setText(getString(R.string.input_precise_user_info));
        this.i = (WheelView) findViewById(R.id.person_info_height_picker);
        this.p = new C0763dl(this, 40, a.an, this.i, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45);
        this.i.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.cm), R.color.content_color, 12, 40.0f, a.bj).a(this.p);
        String currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_HEIGHT);
        if (!currentUserInfoByTag.isEmpty()) {
            this.m = Integer.parseInt(currentUserInfoByTag);
        }
        if (this.q) {
            this.o = new cn.com.smartdevices.bracelet.ui.person.a(this.m, this.h);
            this.j = (WheelView) findViewById(R.id.info_height_foot_wheel);
            this.j.setVisibility(0);
            this.l = new C0763dl(this, 1, 7, this.j, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45);
            this.j.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.cm), R.color.content_color, 12, 38.0f, a.bj).a(this.l);
            this.j.c(this.o.b());
            this.o.a(this.j, this.l, this.i, this.p);
        }
        this.i.c(e());
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.aP);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.aP);
        C0401a.a((Activity) this);
    }
}
