package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a.f;

public class C0760di extends c {
    private static final String e = C0760di.class.getSimpleName();
    private static int k;
    private PersonInfo a;
    private UserInfo b;
    private WheelView c;
    private WheelView d;
    private int f = 3;
    private int g = Constant.at;
    private int h;
    private float i;
    private C0763dl j;

    public static Fragment a(int i) {
        k = i;
        return new C0760di();
    }

    private int b() {
        return aA.c(getActivity()) > Constant.at ? 9 : 0;
    }

    protected int inflateLayout() {
        return R.layout.fragment_person_info_setting_weight;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (k == -1) {
            this.a = Keeper.readPersonInfo();
            this.i = this.a.weight;
            return;
        }
        this.b = J.a().a(k);
        this.i = this.b.weight;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.h = Keeper.readPersonInfo().miliConfig.weightUnit;
        this.f = (int) aA.b(3.0f, this.h);
        this.g = (int) aA.b((float) aA.c(getActivity()), this.h);
        this.c = (WheelView) onCreateView.findViewById(R.id.info_weight_int_wheel);
        this.d = (WheelView) onCreateView.findViewById(R.id.info_weight_decimal_wheel);
        this.c.e(R.drawable.wheel_custom_val_white_1).a(a.f, 25.123f).a(new C0763dl(getActivity(), this.f, this.g, this.c, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1)).c(((int) aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit)) - ((int) aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit)));
        this.j = new C0763dl(getActivity(), 0, 9, this.c, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1);
        this.j.a(19);
        if (aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit) < ((float) this.g)) {
            C0596r.e(e, " < max");
            C0596r.e(e, " max weight: " + this.g);
            this.d.e(R.drawable.wheel_custom_val_white_1).a(aA.a(getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit), 25.123f).a(this.j).c(((int) (aA.c(aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit), 1) * 10.0f)) - (((int) aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit)) * 10));
            C0596r.e(e, "raw " + this.i);
            C0596r.e(e, "to unit" + aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit));
            C0596r.e(e, "raw*10 -> int " + ((int) (aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit) * 10.0f)));
            C0596r.e(e, "raw -> int * 10" + (((int) aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit)) * 10));
        } else {
            C0596r.e(e, " >= max");
            f c0763dl = new C0763dl(getActivity(), 0, b(), this.d, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1);
            c0763dl.a(19);
            this.d.e(R.drawable.wheel_custom_val_white_1).a(aA.a(getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit), 25.123f).a(c0763dl).c(((int) (aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit) * 10.0f)) - (((int) aA.b(this.i, Keeper.readPersonInfo().miliConfig.weightUnit)) * 10));
        }
        this.c.a(new C0761dj(this));
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        C0401a.a(getActivity(), C0401a.dY, a.f + this.i);
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.k);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.k);
    }

    protected void onRightButtonClicked() {
        this.mRightButton.setEnabled(false);
        float f;
        if (this.a != null) {
            f = this.a.weight;
            float f2 = (((float) this.c.f()) + (((float) this.d.f()) / 10.0f)) + ((float) ((int) aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit)));
            C0596r.e(e, "currentItem " + this.c.f() + " float " + (((float) this.d.f()) / 10.0f) + " min " + ((int) aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit)));
            this.a.weight = aA.a(f2, Keeper.readPersonInfo().miliConfig.weightUnit);
            C0596r.e(e, "weight_KG :" + f2 + ", setperson weight " + this.a.weight + ", original weight:" + f + ", miliConfig.weight :" + Keeper.readPersonInfo().miliConfig.weightUnit);
            if (f == this.a.weight) {
                dismiss();
                return;
            }
            this.a.setNeedSyncServer(2);
            Keeper.keepPersonInfo(this.a);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        } else {
            f = this.b.weight;
            this.b.weight = aA.a((((float) this.c.f()) + (((float) this.d.f()) / 10.0f)) + 3.0f, Keeper.readPersonInfo().miliConfig.weightUnit);
            if (f == this.b.weight) {
                dismiss();
                return;
            }
            EventBus.getDefault().post(new EventUserInfoUpdate(this.b));
        }
        dismiss();
    }
}
