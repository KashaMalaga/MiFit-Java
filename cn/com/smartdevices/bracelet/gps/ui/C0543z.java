package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.e.c;
import cn.com.smartdevices.bracelet.gps.e.h;
import cn.com.smartdevices.bracelet.gps.e.k;
import cn.com.smartdevices.bracelet.gps.h.i;
import cn.com.smartdevices.bracelet.gps.services.I;
import cn.com.smartdevices.bracelet.gps.services.a.a;
import cn.com.smartdevices.bracelet.gps.services.az;
import cn.com.smartdevices.bracelet.gps.ui.gadget.MaskableLayout;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.b.a.b;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import de.greenrobot.event.EventBus;

public class C0543z extends Fragment implements OnClickListener, a {
    private static final int B = 1;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 17;
    public static final int d = 273;
    public static final String e = "device_statment";
    private static final String f = "GPSMainNormalFragment";
    private boolean A;
    private Handler C = new A(this);
    private MaskableLayout g = null;
    private TextView h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private float l = 0.0f;
    private int m = a;
    private long n = 0;
    private float o = 0.0f;
    private int p = -1;
    private final h q = c.a();
    private boolean r;
    private boolean s;
    private boolean t;
    private int u = c;
    private int v = 2;
    private TextView w;
    private Animation x;
    private ImageView y;
    private d z;

    private String a(float f) {
        return cn.com.smartdevices.bracelet.gps.ui.b.a.b(f);
    }

    private String a(int i, int i2) {
        String string = getString(n.running_pace_empty);
        if (i2 == 2) {
            this.v = 2;
        } else if (i2 == 34) {
            this.v = 34;
            string = getString(n.running_bracelet_not_connect);
        } else if (i2 == I.d) {
            this.v = I.d;
        } else if (i2 == I.e) {
            this.v = I.e;
        } else {
            this.v = a;
            if (i == 0 || !HeartRateInfo.isHRValueValid(i)) {
                i = this.p;
            }
            if (HeartRateInfo.isHRValueValid(i)) {
                string = String.valueOf(i);
            }
        }
        this.p = i;
        return string;
    }

    private void a(int i) {
        if (this.z != null && this.z.p()) {
            int q = this.z.q();
            if (i > q && !this.A) {
                this.y.startAnimation(this.x);
                this.A = true;
            } else if (i < q && this.A) {
                this.y.clearAnimation();
                this.A = false;
            }
        }
    }

    private void a(HwConnStatus hwConnStatus) {
        if (hwConnStatus.b() == com.xiaomi.hm.health.bt.b.c.SHOES && hwConnStatus.a() == 6) {
            this.r = true;
        } else {
            this.r = false;
        }
        this.h.setText(b(this.m));
    }

    private String b(float f) {
        return ((double) f) < 0.01d ? cn.com.smartdevices.bracelet.gps.ui.b.a.a(0) : cn.com.smartdevices.bracelet.gps.ui.b.a.a(i.c(f));
    }

    private String b(int i) {
        this.s = cn.com.smartdevices.bracelet.gps.e.a.f();
        this.t = cn.com.smartdevices.bracelet.gps.e.a.i();
        if (!this.s && !this.t) {
            this.u = b;
            return getString(n.running_pace_empty);
        } else if (this.s && !this.t && !com.xiaomi.hm.health.bt.bleservice.a.c()) {
            this.u = c;
            return getString(n.running_bracelet_not_connect);
        } else if (com.xiaomi.hm.health.bt.bleservice.a.c() || !this.t || this.r) {
            this.u = a;
            return i < 0 ? Constants.VIA_RESULT_SUCCESS : com.xiaomi.e.a.f + i;
        } else {
            this.u = d;
            return getString(n.running_shoes_not_connect);
        }
    }

    private String b(long j) {
        return j <= 0 ? "00:00:00" : cn.com.smartdevices.bracelet.gps.ui.b.a.a(j, true);
    }

    private void c(int i, int i2) {
        int i3 = b;
        if (i2 == 0) {
            Context activity = getActivity();
            if (i != b) {
                i3 = d;
            }
            IllustrateActivity.a(activity, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(aM.a, i);
        bundle.putInt(e, i2);
        aM.a(getActivity(), bundle);
    }

    public MaskableLayout a() {
        return this.g;
    }

    public void a(int i, boolean z) {
    }

    public void a(long j) {
        if (this.j != null) {
            this.n = j;
            this.j.setText(b(this.n));
        }
    }

    public void a(az azVar) {
        if (this.h != null && this.i != null && this.k != null) {
            this.m = azVar.G();
            this.l = azVar.C();
            this.o = azVar.l();
            this.h.setText(b(this.m));
            this.i.setText(b(this.l));
            this.k.setText(a(this.o / 1000.0f));
        }
    }

    public void b(int i, int i2) {
        if (this.w != null) {
            this.w.setText(a(i, i2));
        }
        a(i);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == com.xiaomi.hm.health.b.a.i.hr_value_container) {
            c(c, this.v);
        } else if (id == com.xiaomi.hm.health.b.a.i.pace_freq_container) {
            b(this.m);
            c(b, this.u);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = AnimationUtils.loadAnimation(getActivity(), b.running_hr_remind);
        this.z = p.f(getActivity());
        if (cn.com.smartdevices.bracelet.gps.e.a.g() && this.z != null && this.z.m()) {
            C0401a.a(getActivity(), C0401a.hf, com.xiaomi.hm.health.bt.bleservice.a.c() ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(j.fragment_running_gps_main_normal, viewGroup, false);
        if (cn.com.smartdevices.bracelet.gps.e.b.d()) {
            ((ViewStub) inflate.findViewById(com.xiaomi.hm.health.b.a.i.stub_hr_info)).inflate();
            this.w = (TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.hr_text);
            this.y = (ImageView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.hr_icon);
            inflate.findViewById(com.xiaomi.hm.health.b.a.i.hr_value_container).setOnClickListener(this);
        } else {
            ((ViewStub) inflate.findViewById(com.xiaomi.hm.health.b.a.i.stub_info)).inflate();
        }
        this.g = (MaskableLayout) inflate.findViewById(com.xiaomi.hm.health.b.a.i.root);
        this.j = (TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.total_time_text);
        this.i = (TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.speed_text);
        this.h = (TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.pace_freq_text);
        this.k = (TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.total_distance);
        inflate.findViewById(com.xiaomi.hm.health.b.a.i.pace_freq_container).setOnClickListener(this);
        EventBus.getDefault().register(this);
        if (k.British == this.q.a()) {
            TextView textView = (TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.speed_desc);
            ((TextView) inflate.findViewById(com.xiaomi.hm.health.b.a.i.distance_unit)).setText(n.running_mile);
            textView.setText(n.running_gps_main_statistics_speed_disc_br);
        }
        this.j.setText(b(this.n));
        this.i.setText(b((float) this.q.c((double) this.l).a));
        this.h.setText(b(this.m));
        this.k.setText(a((float) this.q.a((double) (this.o / 1000.0f)).a));
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        if (this.C != null) {
            this.C.removeMessages(b);
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        a(hwConnStatus);
    }

    public void onResume() {
        super.onResume();
        this.z = p.f(getActivity());
    }
}
