package cn.com.smartdevices.bracelet.ui.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.hm.health.R;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;

public class PersonInfoSetBirthActivity extends PersonInfoBaseActivity implements OnClickListener {
    private static final String c = "PersonInfoSetBirthActivity";
    private WheelView d;
    private WheelView e;
    private TextView f;
    private Birthday g;
    private int h;
    private C0763dl i;
    private int j;

    private void d() {
        this.g.setYear(this.d.f() + this.h);
        this.g.setMonth(this.e.f() + 1);
        this.a.setBirthday(this.g.toStringData());
        this.a.setAge(this.g.getAge());
        Keeper.keepPersonInfo(this.a);
        C0596r.e(c, "get birthday:" + this.g);
    }

    public void b() {
        d();
        super.b();
    }

    public void c() {
        d();
        super.c();
        C0401a.a(this.b, C0409b.Q, C0410c.l, this.a.birthday);
        Intent intent = new Intent();
        intent.setClass(this, PersonInfoSetHeightActivity.class);
        startActivityForResult(intent, 6);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_person_info_set_age);
        a();
        this.f = (TextView) findViewById(R.id.bracelet_login_title_info);
        this.f.setText(getString(R.string.input_precise_person_info));
        this.g = Birthday.fromStr(this.a.getBirthday());
        C0596r.e(c, "onCreate, birthday:" + this.g);
        int i = Calendar.getInstance().get(1);
        this.j = Calendar.getInstance().get(2);
        this.h = i - 100;
        int i2 = i + 0;
        this.d = (WheelView) findViewById(R.id.person_info_year_picker);
        this.d.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.year), R.color.content_color, 12, a.bh, a.bj).a(new C0763dl(this, this.h, i2, this.d, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45));
        this.e = (WheelView) findViewById(R.id.person_info_month_picker);
        this.i = new C0763dl(this, 1, 12, this.e, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), true, 50, 48, 45, 45);
        if (!this.g.isValid() || this.g.getYear() - this.h < 100) {
            this.e.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.month), R.color.content_color, 12, a.bi, a.bj).a(this.i);
        } else {
            this.e.a(5).e(R.drawable.wheel_custom_val_dark_0).a(getString(R.string.month), R.color.content_color, 12, a.bi, a.bj).a(new C0763dl(this, 1, this.j + 1, this.e, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45));
        }
        if (this.g.isValid()) {
            this.d.c(this.g.getYear() - this.h);
            this.e.d(this.g.getMonth() - 1);
        } else {
            this.d.c(1990 - this.h);
            this.e.d(0);
        }
        this.d.a(new d(this));
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.B);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.B);
        C0401a.a((Activity) this);
    }
}
