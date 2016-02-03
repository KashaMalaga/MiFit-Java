package cn.com.smartdevices.bracelet.weight;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;

public class C0882t extends c {
    public static final int a = -11;
    public static final int b = -10;
    private static final String j = "SettingDateFragment";
    private WheelView c;
    private WheelView d;
    private WheelView e;
    private WheelView f;
    private WheelView g;
    private View h;
    private TextView i;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p = 0;
    private C0763dl q;
    private boolean r = false;
    private Calendar s;
    private DecimalFormat t;
    private E u;
    private F v;

    private long a(int i, int i2, int i3, int i4, int i5, int i6) {
        C0596r.e(j, "year " + i + " month " + i2 + " day " + i3 + " hour " + i4 + " minute " + i5 + " second " + i6);
        this.s.clear();
        this.s.set(i, i2 - 1, i3, i4, i5, i6);
        long timeInMillis = this.s.getTimeInMillis();
        C0596r.e(j, "time in mill " + timeInMillis);
        C0596r.e(j, "time in str " + new Date(timeInMillis).toLocaleString());
        return timeInMillis;
    }

    private void a() {
        if (!isAdded()) {
            return;
        }
        if (Utils.y(getActivity().getApplicationContext())) {
            this.i.setText(getString(R.string.date) + "\t\t" + this.m + "-" + this.t.format((long) this.k) + "-" + this.t.format((long) this.l) + " " + this.t.format((long) this.n) + a.ci + this.t.format((long) this.o));
        } else if (this.n >= 12) {
            this.i.setText(getString(R.string.date) + "\t\t" + this.m + "-" + this.t.format((long) this.k) + "-" + this.t.format((long) this.l) + " " + this.t.format((long) (this.n - 12)) + a.ci + this.t.format((long) this.o) + " " + getString(R.string.pm));
        } else {
            this.i.setText(getString(R.string.date) + "\t\t" + this.m + "-" + this.t.format((long) this.k) + "-" + this.t.format((long) this.l) + " " + this.t.format((long) this.n) + a.ci + this.t.format((long) this.o) + " " + getString(R.string.am));
        }
    }

    static /* synthetic */ int d(C0882t c0882t, int i) {
        int i2 = c0882t.n + i;
        c0882t.n = i2;
        return i2;
    }

    static /* synthetic */ int g(C0882t c0882t, int i) {
        int i2 = c0882t.n - i;
        c0882t.n = i2;
        return i2;
    }

    public int a(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2 - 1);
        instance.set(5, 1);
        return instance.getActualMaximum(5);
    }

    public void a(E e) {
        this.u = e;
    }

    public void a(F f) {
        this.v = f;
    }

    protected int inflateLayout() {
        return R.layout.fragment_setting_date;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = Calendar.getInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.t = new DecimalFormat("00");
        this.c = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_month);
        this.d = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_day);
        this.e = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_hour);
        this.f = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_minute);
        this.g = (WheelView) onCreateView.findViewById(R.id.setting_birth_wheel_ampm);
        this.h = onCreateView.findViewById(R.id.wheel_ampm_divider);
        this.i = (TextView) onCreateView.findViewById(R.id.setting_date_title);
        this.k = Calendar.getInstance().get(2) + 1;
        this.l = Calendar.getInstance().get(5);
        this.m = Calendar.getInstance().get(1);
        this.n = new Date().getHours();
        this.o = new Date().getMinutes();
        this.r = Utils.y(getActivity().getApplicationContext());
        if (!this.r) {
            if (this.n >= 12) {
                this.p = 1;
            } else {
                this.p = 0;
            }
        }
        a();
        f c0763dl = new C0763dl(getActivity(), 1, 12, this.c, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        f c0763dl2 = new C0763dl(getActivity(), 1, a(this.m, this.k), this.d, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        f c0763dl3 = new C0763dl(getActivity(), 0, 59, this.f, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        f c0763dl4 = new C0763dl(getActivity(), a, b, this.g, getResources().getColor(R.color.bg_color_blue), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 18, 15, 21, 1);
        c0763dl4.a(C0763dl.c);
        c0763dl4.a(17);
        if (Utils.y(getActivity().getApplicationContext())) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            this.q = new C0763dl(getActivity(), 0, 23, this.e, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        } else {
            this.h.setVisibility(0);
            this.g.setVisibility(0);
            this.q = new C0763dl(getActivity(), 0, 11, this.e, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, 24, 21, 21, 1);
        }
        this.c.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.month), (float) aA.h).a(c0763dl).c(this.k - 1).a(true);
        this.d.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.day_ri), (float) aA.h).a(c0763dl2).c(this.l - 1).a(true);
        this.f.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.minute), (float) aA.h).a(c0763dl3).c(this.o).a(true);
        this.g.a(2).e(R.drawable.wheel_custom_val_white_1).a(com.xiaomi.e.a.f, (float) aA.h).a(c0763dl4).c(0).a(false);
        if (Utils.y(getActivity().getApplicationContext())) {
            this.e.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.hour_1), (float) aA.h).a(this.q).c(this.n).a(true);
        } else if (this.n >= 12) {
            this.e.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.hour_1), (float) aA.h).a(this.q).c(this.n - 12).a(true);
            this.g.c(1);
        } else {
            this.e.a(5).e(R.drawable.wheel_custom_val_white_1).a(getString(R.string.hour_1), (float) aA.h).a(this.q).c(this.n).a(true);
            this.g.c(0);
        }
        this.c.a(new C0883u(this));
        this.d.a(new C0885w(this));
        this.e.a(new C0886x(this));
        this.c.a(new C0887y(this));
        this.d.a(new C0888z(this));
        this.e.a(new A(this));
        this.f.a(new B(this));
        this.f.a(new C(this));
        this.g.a(new D(this));
        this.g.a(new C0884v(this));
        return onCreateView;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.v != null) {
            this.v.a();
        }
    }

    protected void onRightButtonClicked() {
        if (this.u != null) {
            long a = a(this.m, this.k, this.l, this.n, this.o, 0);
            if (a != 0 && a <= System.currentTimeMillis()) {
                this.u.a(this.m, this.k, this.l, this.n, this.o);
            } else {
                return;
            }
        }
        dismiss();
    }
}
