package cn.com.smartdevices.bracelet.ui.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.h;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.g;

public class PersonInfoSetHeightActivity extends PersonInfoBaseActivity implements OnClickListener {
    private static final String c = "PersonInfoSetHeightActivity";
    private WheelView d;
    private a e;
    private C0763dl f;
    private TextView g;
    private WheelView h;
    private C0763dl i;
    private int j;
    private boolean k = false;

    private void d() {
        if (this.k) {
            this.a.height = this.e.c();
        } else {
            this.a.height = this.d.f() + 40;
        }
        C0596r.e(c, "height = " + this.a.height);
    }

    private int e() {
        return this.k ? this.e.a() : this.a.height > 0 ? this.a.height - 40 : h.k;
    }

    public void b() {
        d();
        C0596r.e(c, "onCancel");
        super.b();
    }

    public void c() {
        d();
        C0596r.e(c, "onNext");
        super.c();
        C0401a.a(this.b, C0409b.O, C0410c.l, this.a.height + a.f);
        Intent intent = new Intent();
        intent.setClass(this, PersonInfoSetWeightActivity.class);
        startActivityForResult(intent, 6);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_person_info_set_height);
        a();
        this.g = (TextView) findViewById(l.bracelet_login_title_info);
        this.g.setText(getString(r.input_precise_person_info));
        this.k = Keeper.readPersonInfo().getUnit() == 1;
        this.j = this.a.height;
        C0596r.e(c, "personInfo Height = " + this.j);
        this.d = (WheelView) findViewById(l.person_info_height_picker);
        this.i = new C0763dl(this, 40, kankan.wheel.widget.a.an, this.d, getResources().getColor(g.title_color), getResources().getColor(g.content_color), getResources().getColor(g.content_color_darker), false, 50, 48, 45, 45);
        this.d.a(5).e(kankan.wheel.widget.h.wheel_custom_val_dark_0).a(getString(r.cm), g.content_color, 12, 35.0f, kankan.wheel.widget.a.bj).a(this.i);
        if (this.k) {
            this.e = new a(this.a, (Context) this);
            this.h = (WheelView) findViewById(l.info_height_foot_wheel);
            this.h.setVisibility(0);
            this.f = new C0763dl(this, 1, 7, this.h, getResources().getColor(g.title_color), getResources().getColor(g.content_color), getResources().getColor(g.content_color_darker), false, 50, 48, 45, 45);
            this.h.a(5).e(kankan.wheel.widget.h.wheel_custom_val_dark_0).a(getString(r.cm), g.content_color, 12, 36.0f, kankan.wheel.widget.a.bj).a(this.f);
            this.h.c(this.e.b());
            this.e.a(this.h, this.f, this.d, this.i);
        }
        this.d.c(e());
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.C);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.C);
        C0401a.a((Activity) this);
    }
}
