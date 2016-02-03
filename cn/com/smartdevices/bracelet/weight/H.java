package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.e;

class H implements e {
    final /* synthetic */ G a;

    H(G g) {
        this.a = g;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        C0596r.e(G.c, "item " + wheelView.f());
        if (wheelView.f() == 631) {
            C0596r.e(G.c, " should refresh month");
            f c0763dl = new C0763dl(this.a.getActivity(), 0, this.a.b(), this.a.b, this.a.getResources().getColor(R.color.highlight), this.a.getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
            c0763dl.a(19);
            this.a.b.e(R.drawable.wheel_custom_val_white_1).a(aA.a(this.a.getActivity().getApplicationContext(), Keeper.readPersonInfo().miliConfig.weightUnit), 25.123f).a(c0763dl).c(0);
            return;
        }
        this.a.b.a(this.a.i);
    }
}
