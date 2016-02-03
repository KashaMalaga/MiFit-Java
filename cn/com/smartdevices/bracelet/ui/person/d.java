package cn.com.smartdevices.bracelet.ui.person;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a.f;
import kankan.wheel.widget.e;

class d implements e {
    final /* synthetic */ PersonInfoSetBirthActivity a;

    d(PersonInfoSetBirthActivity personInfoSetBirthActivity) {
        this.a = personInfoSetBirthActivity;
    }

    public void a(WheelView wheelView) {
        C0596r.e("PersonInfoSetBirthActivity", "onScrollingStarted " + wheelView.f());
    }

    public void b(WheelView wheelView) {
        int i = 0;
        C0596r.e("PersonInfoSetBirthActivity", "onScrollingFinished " + wheelView.f());
        if (100 == wheelView.f()) {
            C0596r.e("PersonInfoSetBirthActivity", " should refresh month");
            f c0763dl = new C0763dl(this.a, 1, this.a.j + 1, this.a.e, this.a.getResources().getColor(R.color.title_color), this.a.getResources().getColor(R.color.content_color), this.a.getResources().getColor(R.color.content_color_darker), false, 50, 48, 45, 45);
            WheelView b = this.a.e;
            if (this.a.j + 1 < 0) {
                i = this.a.j + 1;
            }
            b.c(i);
            this.a.e.a(c0763dl);
            return;
        }
        this.a.e.a(this.a.i);
    }
}
