package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.weight.aA;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.e;
import kankan.wheel.widget.g;
import kankan.wheel.widget.h;

class C0761dj implements e {
    final /* synthetic */ C0760di a;

    C0761dj(C0760di c0760di) {
        this.a = c0760di;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        C0596r.e(C0760di.e, "item " + wheelView.f());
        if (wheelView.f() == 631) {
            C0596r.e(C0760di.e, " should refresh month");
            f c0763dl = new C0763dl(this.a.getActivity(), 0, this.a.b(), this.a.d, this.a.getResources().getColor(g.highlight), this.a.getResources().getColor(g.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
            c0763dl.a(19);
            this.a.d.e(h.wheel_custom_val_white_1).a(aA.a(this.a.getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit), 25.123f).a(c0763dl).c(0);
            return;
        }
        this.a.d.a(this.a.j);
    }
}
