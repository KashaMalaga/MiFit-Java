package cn.com.smartdevices.bracelet.ui.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.WheelView;

public class PersonInfoSetWeightActivity extends PersonInfoBaseActivity implements OnClickListener {
    private static final String f = PersonInfoSetWeightActivity.class.getSimpleName();
    int c = 3;
    int d = Constant.at;
    int e;
    private Context g = this;
    private WheelView h;

    private void d() {
        float a = aA.a(((float) this.h.f()) + aA.b(3.0f, this.e), this.e);
        this.a.weight = aA.c(a, 1);
        C0596r.e(f, "weight = " + this.a.weight);
    }

    public void b() {
        d();
        C0596r.e(f, "onCancel");
        super.b();
    }

    public void c() {
        d();
        C0596r.e(f, "onNext");
        super.c();
        WeightInfo weightInfo = new WeightInfo();
        weightInfo.uid = -1;
        weightInfo.timestamp = System.currentTimeMillis();
        weightInfo.weight = this.a.weight;
        ah.a().a(weightInfo);
        C0401a.a(this.g, C0409b.P, C0410c.l, this.a.weight + a.f);
        Intent intent = new Intent();
        intent.setClass(this, PersonInfoSetSportGoalActivity.class);
        startActivityForResult(intent, 6);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_person_info_set_weight);
        a();
        this.e = Keeper.readPersonInfo().getMiliConfig().weightUnit;
        this.c = (int) aA.b(3.0f, this.e);
        this.d = (int) aA.b(Utils.k() ? 634.0f : 634.0f, this.e);
        C0596r.e("dwy", "min = " + this.c + ", max = " + this.d + ", weightUnit=" + this.e);
        this.h = (WheelView) findViewById(R.id.person_info_weight_picker);
        this.h.a(5).e(R.drawable.wheel_custom_val_dark_0).a(aA.a(this.g, this.e), R.color.content_color, 12, 40.0f, kankan.wheel.widget.a.bj).a(new C0763dl(this, this.c, this.d, this.h, getResources().getColor(R.color.title_color), getResources().getColor(R.color.content_color), getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45));
        this.h.c(this.a.weight > 0.0f ? (int) aA.b(this.a.weight - 3.0f, this.e) : (int) aA.b(57.0f, this.e));
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.D);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.D);
        C0401a.a((Activity) this);
    }
}
