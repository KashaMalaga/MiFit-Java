package cn.com.smartdevices.bracelet.weight;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huami.android.view.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a.f;

public class G extends c {
    private static final String c = G.class.getSimpleName();
    private static float g = BitmapDescriptorFactory.HUE_YELLOW;
    private WheelView a;
    private WheelView b;
    private int d = 3;
    private int e = Constant.at;
    private int f;
    private I h;
    private C0763dl i;

    public static Fragment a(float f) {
        Fragment g = new G();
        g = f;
        return g;
    }

    private int b() {
        return aA.c(getActivity()) > Constant.at ? 9 : 0;
    }

    public void a(I i) {
        this.h = i;
    }

    protected int inflateLayout() {
        return R.layout.fragment_person_info_setting_weight;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.h = (I) activity;
        } catch (Exception e) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f = Keeper.readPersonInfo().miliConfig.weightUnit;
        this.d = (int) aA.b(3.0f, this.f);
        this.e = (int) aA.b((float) aA.c(getActivity()), this.f);
        this.a = (WheelView) onCreateView.findViewById(R.id.info_weight_int_wheel);
        this.b = (WheelView) onCreateView.findViewById(R.id.info_weight_decimal_wheel);
        this.a.e(R.drawable.wheel_custom_val_white_1).a(a.f, 25.123f).a(new C0763dl(getActivity(), this.d, this.e, this.a, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1)).c(((int) aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit)) - ((int) aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit)));
        this.i = new C0763dl(getActivity(), 0, 9, this.a, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1);
        this.i.a(19);
        if (aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit) < ((float) this.e)) {
            C0596r.e(c, " < max");
            C0596r.e(c, " max weight: " + this.e);
            this.b.e(R.drawable.wheel_custom_val_white_1).a(aA.a(getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit), 25.123f).a(this.i).c(((int) (aA.c(aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit), 1) * 10.0f)) - (((int) aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit)) * 10));
            C0596r.e(c, "raw " + g);
            C0596r.e(c, "to unit" + aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit));
            C0596r.e(c, "raw*10 -> int " + ((int) (aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit) * 10.0f)));
            C0596r.e(c, "raw -> int * 10" + (((int) aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit)) * 10));
        } else {
            C0596r.e(c, " >= max");
            f c0763dl = new C0763dl(getActivity(), 0, b(), this.b, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1);
            c0763dl.a(19);
            this.b.e(R.drawable.wheel_custom_val_white_1).a(aA.a(getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit), 25.123f).a(c0763dl).c(((int) (aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit) * 10.0f)) - (((int) aA.b(g, Keeper.readPersonInfo().miliConfig.weightUnit)) * 10));
        }
        this.a.a(new H(this));
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        C0401a.a(getActivity(), C0401a.dY, a.f + g);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.h != null) {
            this.h.a();
        }
    }

    protected void onLeftButtonClicked() {
        super.onLeftButtonClicked();
        if (this.h != null) {
            this.h.a();
        }
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
        float a = aA.a((((float) this.a.f()) + (((float) this.b.f()) / 10.0f)) + ((float) ((int) aA.b(3.0f, Keeper.readPersonInfo().miliConfig.weightUnit))), Keeper.readPersonInfo().miliConfig.weightUnit);
        if (this.h != null) {
            this.h.a(a);
        }
        dismiss();
    }
}
