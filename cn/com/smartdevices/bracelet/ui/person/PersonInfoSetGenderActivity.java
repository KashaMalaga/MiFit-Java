package cn.com.smartdevices.bracelet.ui.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import com.huami.android.view.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class PersonInfoSetGenderActivity extends PersonInfoBaseActivity implements OnClickListener {
    private static final String c = "PersonInfoSetGenderActivity";
    private ImageView d;
    private ImageView e;
    private TextView f;
    private View g;
    private DimPanelBottomBar h;

    private void d() {
        int i = this.a.gender;
        if (i == 1) {
            this.d.setImageResource(R.drawable.male_enable);
            this.e.setImageResource(R.drawable.female_disable);
            this.g.setBackgroundResource(R.color.bg_color_blue_dark);
            applyStatusBarTintRes(R.color.bg_color_blue_dark);
            this.h.a(getResources().getColor(R.color.content_color));
            this.h.b(getResources().getColor(R.color.title_color));
        } else if (i == 0) {
            this.e.setImageResource(R.drawable.female_enable);
            this.d.setImageResource(R.drawable.male_disable);
            this.g.setBackgroundResource(R.color.bg_color_red);
            applyStatusBarTintRes(R.color.bg_color_red);
            this.h.a(getResources().getColor(R.color.content_color));
            this.h.b(getResources().getColor(R.color.title_color));
        } else {
            this.h.a(getResources().getColor(R.color.content_color));
            this.h.b(getResources().getColor(R.color.disable_text_color_dark));
        }
    }

    public void c() {
        super.c();
        if (this.a.gender == 1 || this.a.gender == 0) {
            C0401a.a(this.b, C0409b.Q, C0410c.l, this.a.gender + a.f);
            Intent intent = new Intent();
            intent.setClass(this, PersonInfoSetBirthActivity.class);
            startActivityForResult(intent, 6);
            return;
        }
        b.a((Context) this, (int) R.string.please_input_gender, 0).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_gender_male:
                this.a.gender = 1;
                d();
                break;
            case R.id.info_gender_female:
                this.a.gender = 0;
                d();
                break;
        }
        super.onClick(view);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_person_info_set_gender);
        a();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(kankan.wheel.widget.a.N);
        if (stringExtra != null && stringExtra.length() > 0) {
            this.a.avatarUrl = stringExtra;
        }
        stringExtra = intent.getStringExtra(kankan.wheel.widget.a.O);
        if (stringExtra != null && stringExtra.length() > 0) {
            this.a.nickname = intent.getStringExtra(kankan.wheel.widget.a.O);
        }
        this.f = (TextView) findViewById(R.id.bracelet_login_title_info);
        this.f.setText(getString(R.string.input_precise_person_info));
        this.d = (ImageView) findViewById(R.id.info_gender_male);
        this.d.setOnClickListener(this);
        this.e = (ImageView) findViewById(R.id.info_gender_female);
        this.e.setOnClickListener(this);
        this.h = (DimPanelBottomBar) findViewById(R.id.bottom_bar);
        this.g = findViewById(R.id.info_gender_bg);
        d();
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.A);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.A);
        C0401a.a((Activity) this);
    }
}
