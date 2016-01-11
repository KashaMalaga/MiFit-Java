package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.e;
import kankan.wheel.widget.g;

class C0753db implements e {
    final /* synthetic */ C0752da a;

    C0753db(C0752da c0752da) {
        this.a = c0752da;
    }

    public void a(WheelView wheelView) {
        C0596r.e(C0752da.h, "onScrollingStarted " + wheelView.f());
    }

    public void b(WheelView wheelView) {
        int i = 0;
        C0596r.e(C0752da.h, "onScrollingFinished " + wheelView.f());
        if (100 == wheelView.f()) {
            C0596r.e(C0752da.h, " should refresh month");
            if (this.a.isAdded()) {
                f c0763dl = new C0763dl(this.a.getActivity(), 1, this.a.g + 1, this.a.d, this.a.getResources().getColor(g.highlight), this.a.getResources().getColor(g.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
                WheelView b = this.a.d;
                if (this.a.g + 1 < 0) {
                    i = this.a.g + 1;
                }
                b.c(i);
                this.a.d.a(c0763dl);
                return;
            }
            return;
        }
        this.a.d.a(this.a.i);
    }
}
