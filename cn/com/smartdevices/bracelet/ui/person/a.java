package cn.com.smartdevices.bracelet.ui.person;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.xiaomi.hm.health.p;
import kankan.wheel.widget.WheelView;

public class a {
    private static final String b = "WeightWrapper";
    PersonInfo a;
    private int c;
    private WheelView d;
    private C0763dl e;
    private WheelView f;
    private C0763dl g;
    private int h;
    private int i;
    private int j = 0;
    private int k = 0;
    private Context l;

    public a(int i, Context context) {
        this.c = i;
        this.l = context;
    }

    public a(PersonInfo personInfo, Context context) {
        this.a = personInfo;
        this.l = context;
        this.c = this.a.height;
    }

    public a(UserInfo userInfo, Context context) {
        this.l = context;
        this.c = userInfo.height;
    }

    private void a(WheelView wheelView, int i) {
        String quantityString;
        int f = wheelView.f() + i;
        if (wheelView == this.f) {
            quantityString = this.l.getResources().getQuantityString(p.numberInch, f, new Object[]{com.xiaomi.e.a.f});
        } else {
            quantityString = this.l.getResources().getQuantityString(p.numberFoot, f, new Object[]{com.xiaomi.e.a.f});
        }
        C0596r.e(b, "value = " + f + " unit -= " + quantityString);
        wheelView.a(quantityString);
        wheelView.b(false);
    }

    private void d() {
        this.d.setVisibility(0);
        e();
        a(this.d, 1);
        a(this.f, this.k);
        this.f.a(new b(this));
        this.d.a(new c(this));
    }

    private void e() {
        int f = this.f.f() + this.k;
        if (this.d.f() + 1 == 7) {
            this.k = 0;
            this.j = 6;
        } else if (this.d.f() + 1 == 1) {
            this.k = 4;
            this.j = 11;
        } else {
            this.k = 0;
            this.j = 11;
        }
        if (!(this.j == this.h && this.k == this.i)) {
            this.g.c(this.k);
            this.g.d(this.j);
            C0596r.e(b, "onScrollingFinished : " + this.d.f() + ", invalidate, mInchMin =  " + this.k + ",mInchMax = " + this.j);
            if (f > this.j) {
                f = this.j;
            } else if (f < this.k) {
                f = this.k;
            }
            this.f.a(f - this.k, true);
            this.f.b(true);
        }
        this.h = this.j;
        this.i = this.k;
    }

    public int a() {
        if (this.c < 0) {
            this.c = kankan.wheel.widget.a.aC;
        }
        int a = Utils.a(this.c) % 12;
        if (Utils.a(this.c) / 12 <= 1) {
            this.k = 4;
        } else {
            this.k = 0;
        }
        C0596r.e(b, "inches = " + a + ", min = " + this.k);
        return a - this.k;
    }

    public void a(WheelView wheelView, C0763dl c0763dl, WheelView wheelView2, C0763dl c0763dl2) {
        this.d = wheelView;
        this.e = c0763dl;
        this.f = wheelView2;
        this.g = c0763dl2;
        d();
    }

    public int b() {
        return this.c > 0 ? (Utils.a(this.c) / 12) - 1 : 4;
    }

    public int c() {
        int f = this.d.f() + 1;
        int f2 = this.f.f() + this.k;
        int i = (f * 12) + f2;
        C0596r.e(b, "set height : feet = " + f + "inch = " + f2);
        return (int) Math.round(2.54d * ((double) i));
    }
}
