package cn.com.smartdevices.bracelet.weight.family;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;

public class MemberInfoSetGenderActivity extends MemberInfoBaseActivity implements OnClickListener {
    private ImageView h;
    private ImageView i;
    private TextView j;
    private View k;
    private DimPanelBottomBar l;
    private int m = -1;
    private boolean n = false;

    private void a(int i) {
        if (i == 1) {
            this.h.setImageResource(R.drawable.male_enable);
            this.i.setImageResource(R.drawable.female_disable);
            this.k.setBackgroundResource(R.color.bg_color_blue_dark);
            applyStatusBarTintRes(R.color.bg_color_blue_dark);
            this.l.a(getResources().getColor(R.color.content_color));
            this.l.b(getResources().getColor(R.color.title_color));
            this.l.b().setClickable(true);
        } else if (i == 0) {
            this.i.setImageResource(R.drawable.female_enable);
            this.h.setImageResource(R.drawable.male_disable);
            this.k.setBackgroundResource(R.color.bg_color_red);
            applyStatusBarTintRes(R.color.bg_color_red);
            this.l.a(getResources().getColor(R.color.content_color));
            this.l.b(getResources().getColor(R.color.title_color));
            this.l.b().setClickable(true);
        } else {
            this.l.a(getResources().getColor(R.color.content_color));
            this.l.b(getResources().getColor(R.color.disable_text_color_dark));
            this.l.b().setClickable(false);
        }
    }

    public void d() {
        C0596r.e("MemberInfoBaseActivity", "set gender " + this.m);
        if (!this.e) {
            super.d();
        }
        if (this.m == 1 || this.m == 0) {
            Keeper.saveCurrentUser(Keeper.CURRENT_USER_GENDER, this.m + a.f);
            Intent intent = new Intent();
            intent.setClass(this, MemberInfoSetBirthActivity.class);
            intent.putExtra(MemberInfoBaseActivity.c, this.e);
            intent.putExtra(MemberInfoBaseActivity.d, this.f);
            intent.putExtra("FROM_BABY_WEIGHT", this.n);
            intent.putExtra(e.d, this.g == null ? a.f : this.g.n());
            startActivityForResult(intent, 6);
            return;
        }
        b.a((Context) this, (int) R.string.please_input_gender, 0).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_gender_male:
                this.m = 1;
                a(this.m);
                break;
            case R.id.info_gender_female:
                this.m = 0;
                a(this.m);
                break;
        }
        super.onClick(view);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = getIntent().getBooleanExtra(MemberInfoBaseActivity.c, false);
        this.f = getIntent().getBooleanExtra(MemberInfoBaseActivity.d, false);
        this.n = getIntent().getBooleanExtra("FROM_BABY_WEIGHT", false);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.g = e.b(getIntent().getStringExtra(e.d));
        }
        setContentView((int) R.layout.activity_person_info_set_gender);
        b();
        this.h = (ImageView) findViewById(R.id.info_gender_male);
        this.h.setOnClickListener(this);
        this.i = (ImageView) findViewById(R.id.info_gender_female);
        this.i.setOnClickListener(this);
        this.j = (TextView) findViewById(R.id.bracelet_login_title_info);
        this.j.setText(getString(R.string.input_precise_user_info));
        this.l = (DimPanelBottomBar) findViewById(R.id.bottom_bar);
        this.k = findViewById(R.id.info_gender_bg);
        String currentUserInfoByTag = Keeper.getCurrentUserInfoByTag(Keeper.CURRENT_USER_GENDER);
        if (!currentUserInfoByTag.isEmpty()) {
            this.m = Integer.parseInt(currentUserInfoByTag);
        }
        a(this.m);
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.aN);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.aN);
        C0401a.a((Activity) this);
    }
}
