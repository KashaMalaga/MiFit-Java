package cn.com.smartdevices.bracelet.gps.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.huami.android.view.c;
import com.xiaomi.hm.health.b.a.f;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import kankan.wheel.widget.WheelView;

public class R extends c {
    private aP a;
    private int b;
    private S c;
    private WheelView d;
    private Resources e;

    public static R a() {
        return new R();
    }

    public void a(S s) {
        this.c = s;
    }

    protected int inflateLayout() {
        return j.fragment_running_hr_setting;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.b = arguments.getInt(a.g);
        }
        this.e = getResources();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d = (WheelView) onCreateView.findViewById(i.hr_wheel);
        this.a = new aP(getActivity(), 80, a.i, this.d, this.e.getColor(f.highlight), this.e.getColor(f.main_ui_content_color), kankan.wheel.widget.a.bm, false, 46, 24, 21, 21, 1);
        this.a.a(16);
        this.d.a(5).a(getString(n.hr_unit), f.highlight, kankan.wheel.widget.a.bf).e(h.wheel_custom_val_white_1).a(this.a).c(this.b - 80);
        return onCreateView;
    }

    protected void onRightButtonClicked() {
        int f = this.d.f();
        if (!(f == this.b || this.c == null)) {
            this.c.a(f + 80);
        }
        dismiss();
    }
}
