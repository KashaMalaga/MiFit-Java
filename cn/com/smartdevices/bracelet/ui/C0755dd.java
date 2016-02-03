package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventUserInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;

public class C0755dd extends c {
    private static final String a = "Height";
    private static int o;
    private PersonInfo b;
    private UserInfo c;
    private WheelView d;
    private WheelView e;
    private C0763dl f;
    private C0763dl g;
    private int h;
    private int i;
    private int j = 0;
    private int k = 0;
    private View l;
    private int m;
    private int n;

    public static Fragment a(int i) {
        C0596r.e(a, "receive the uid " + i);
        o = i;
        return new C0755dd();
    }

    private void a() {
        this.e.setVisibility(0);
        this.l.setVisibility(0);
        this.f = new C0763dl(getActivity(), 1, 7, this.e, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        this.e.e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.unit_foot), (float) a.bf).a(this.f).c(d());
        b();
        a(this.e, 1);
        a(this.d, this.k);
        this.d.a(new C0756de(this));
        this.e.a(new C0757df(this));
    }

    private void a(WheelView wheelView, int i) {
        if (isAdded()) {
            String quantityString;
            int f = wheelView.f() + i;
            if (wheelView == this.d) {
                quantityString = getResources().getQuantityString(R.plurals.numberInch, f, new Object[]{com.xiaomi.e.a.f});
            } else {
                quantityString = getResources().getQuantityString(R.plurals.numberFoot, f, new Object[]{com.xiaomi.e.a.f});
            }
            C0596r.e(a, "value = " + f + " unit -= " + quantityString);
            wheelView.a(quantityString);
            wheelView.b(false);
        }
    }

    private void b() {
        int f = this.d.f() + this.k;
        if (this.e.f() + 1 == 7) {
            this.k = 0;
            this.j = 6;
        } else if (this.e.f() + 1 == 1) {
            this.k = 4;
            this.j = 11;
        } else {
            this.k = 0;
            this.j = 11;
        }
        if (!(this.j == this.h && this.k == this.i)) {
            this.g.c(this.k);
            this.g.d(this.j);
            C0596r.e(a, "onScrollingFinished : " + this.e.f() + ", invalidate, mInchMin =  " + this.k + ",mInchMax = " + this.j);
            if (f > this.j) {
                f = this.j;
            } else if (f < this.k) {
                f = this.k;
            }
            this.d.a(f - this.k, true);
            this.d.b(true);
        }
        this.h = this.j;
        this.i = this.k;
    }

    private int c() {
        if (this.m != 1) {
            return this.n - 40;
        }
        int a = Utils.a(this.n) % 12;
        if (Utils.a(this.n) / 12 <= 1) {
            this.k = 4;
        } else {
            this.k = 0;
        }
        C0596r.e(a, "inches = " + a + ", min = " + this.k);
        return a - this.k;
    }

    private int d() {
        return (Utils.a(this.n) / 12) - 1;
    }

    protected int inflateLayout() {
        return R.layout.fragment_person_info_setting_height;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o == -1) {
            this.b = Keeper.readPersonInfo();
            this.n = this.b.height;
        } else {
            this.c = J.a().a(o);
            this.n = this.c.height;
        }
        this.m = Keeper.readPersonInfo().getUnit();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d = (WheelView) onCreateView.findViewById(R.id.info_height_wheel);
        this.g = new C0763dl(getActivity(), this.m == 0 ? 40 : 0, this.m == 0 ? a.an : 11, this.d, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        this.d.e(R.drawable.wheel_custom_val_white_1).a(this.m == 0 ? getString(R.string.cm) : getString(R.string.unit_inch), (float) a.bf).a(this.g).c(c());
        this.e = (WheelView) onCreateView.findViewById(R.id.info_height_foot_wheel);
        this.l = onCreateView.findViewById(R.id.wheel_split_line);
        if (this.m == 0) {
            this.e.setVisibility(8);
            this.l.setVisibility(8);
        } else {
            a();
        }
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        C0401a.a(getActivity(), C0401a.dX, this.n);
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.j);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.j);
    }

    protected void onRightButtonClicked() {
        int i = this.n;
        if (this.m == 1) {
            int f = this.e.f() + 1;
            int f2 = this.d.f() + this.k;
            int i2 = (f * 12) + f2;
            C0596r.e(a, "set height : feet = " + f + "inch = " + f2);
            f = (int) Math.round(((double) i2) * 2.54d);
            if (this.b != null) {
                this.b.height = f;
            } else {
                this.c.height = f;
            }
        } else if (this.b != null) {
            this.b.height = this.d.f() + 40;
        } else {
            this.c.height = this.d.f() + 40;
        }
        if (this.b != null) {
            if (i == this.b.height) {
                dismiss();
                return;
            }
            this.b.setNeedSyncServer(2);
            Keeper.keepPersonInfo(this.b);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
            dismiss();
        } else if (i == this.c.height) {
            dismiss();
        } else {
            EventBus.getDefault().post(new EventUserInfoUpdate(this.c));
            dismiss();
        }
    }
}
