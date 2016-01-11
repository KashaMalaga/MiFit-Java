package cn.com.smartdevices.bracelet.weight.family;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.e;
import kankan.wheel.widget.g;

class a implements e {
    final /* synthetic */ MemberInfoSetBirthActivity a;

    a(MemberInfoSetBirthActivity memberInfoSetBirthActivity) {
        this.a = memberInfoSetBirthActivity;
    }

    public void a(WheelView wheelView) {
        C0596r.e("MemberInfoBaseActivity", "onScrollingStarted " + wheelView.f());
    }

    public void b(WheelView wheelView) {
        int i = 0;
        C0596r.e("MemberInfoBaseActivity", "onScrollingFinished " + wheelView.f());
        if (100 == wheelView.f()) {
            C0596r.e("MemberInfoBaseActivity", " should refresh month");
            f c0763dl = new C0763dl(this.a, 1, this.a.o + 1, this.a.i, this.a.getResources().getColor(g.title_color), this.a.getResources().getColor(g.content_color), this.a.getResources().getColor(g.content_color_darker), false, 50, 48, 45, 45);
            WheelView b = this.a.i;
            if (this.a.o + 1 < 0) {
                i = this.a.o + 1;
            }
            b.c(i);
            this.a.i.a(c0763dl);
            return;
        }
        this.a.i.a(this.a.n);
    }
}
