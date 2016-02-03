package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.a;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.DynamicDetailActivity;
import cn.com.smartdevices.bracelet.ui.widget.c;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.P;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightReportActivity;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.family.WeightChooseUserActivity;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import java.util.List;
import kankan.wheel.widget.l;

public class DynamicView extends FrameLayout implements ViewFactory {
    private static final String a = "Chart.DynamicView";
    private Animator A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private int F;
    private Boolean G;
    private P H;
    private int I;
    private c J;
    private ValueAnimator K;
    private ValueAnimator L;
    private ValueAnimator M;
    private ValueAnimator N;
    private ValueAnimator O;
    private ValueAnimator P;
    private final View b;
    private final DynamicPieChartView c;
    private View d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private View u;
    private View v;
    private float w;
    private float x;
    private int y;
    private int z;

    public class FlowBgView extends View {
        private final Paint a;
        private float b;
        private float c;
        private float d;
        private float e;

        public FlowBgView(Context context) {
            this(context, null, 0);
        }

        public FlowBgView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public FlowBgView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = new Paint();
            this.a.setColor(-14057287);
        }

        public Animator a() {
            return a.a(new C0843q(this));
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(this.c, this.d, this.e, this.a);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = i3 - i;
            int i6 = i4 - i2;
            this.b = (float) i6;
            this.e = this.b;
            this.c = ((float) i5) / 2.0f;
            this.d = ((float) i6) * 0.42037186f;
        }
    }

    public DynamicView(Context context) {
        this(context, null, 0);
    }

    public DynamicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = Boolean.valueOf(false);
        this.I = 0;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        inflate(context, R.layout.view_dynamic, this);
        this.I = (int) Utils.b(106.0f, context);
        this.b = findViewById(R.id.center_host);
        this.c = (DynamicPieChartView) findViewById(R.id.active_step_chart);
        this.G = Keeper.readIsPlayEnterAnimation();
        if (this.G.booleanValue()) {
        }
        if (t.a()) {
            int a = (int) t.a(getContext(), 265.0f);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.b.getLayoutParams();
            marginLayoutParams.width = a;
            marginLayoutParams.height = a;
            marginLayoutParams.topMargin = (int) t.a(getContext(), 70.0f);
            this.b.setLayoutParams(marginLayoutParams);
        }
    }

    private void a(Context context) {
        C0596r.e(a, "click mWeightContainer");
        if (this.H == null || this.H.a == null) {
            C0596r.e(a, "data or advData is null");
        } else {
            C0596r.e(a, "data.advData " + this.H.a.toString() + " timestamp " + this.H.a.e());
        }
        if (this.H == null) {
            return;
        }
        if (this.H.e) {
            b.a(context, (int) R.string.weight_no_tips, 0).show();
        } else if (!this.H.a.f()) {
        } else {
            if (this.H.c == 0) {
                a(context, this.H.a, this.H.f);
                return;
            }
            C0596r.e(a, this.H.c + " " + this.H.a);
            Intent intent = new Intent(context, WeightReportActivity.class);
            intent.putExtra(UserInfo.USERINFO_KEY, J.a().a(this.H.c) == null ? com.xiaomi.e.a.f : J.a().a(this.H.c).toJsonString());
            intent.putExtra(e.d, this.H.a.n());
            context.startActivity(intent);
            C0401a.a(context, C0401a.fB, C0401a.fC);
        }
    }

    private void a(Context context, int i) {
        Intent intent = new Intent(context, DynamicDetailActivity.class);
        intent.putExtra(ChartData.KEY_MODE, i);
        if (!DeviceSource.hasBindPeripheralDevice() && Utils.n(getContext())) {
            intent.putExtra(ChartData.KEY_SOURCE, com.xiaomi.hm.health.bt.b.c.SENSORHUB.b());
        }
        context.startActivity(intent);
    }

    private void a(Context context, e eVar, List<UserInfo> list) {
        if (Utils.c((Activity) context)) {
            int[] iArr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                iArr[i] = ((UserInfo) list.get(i)).uid;
            }
            Intent intent = new Intent(context, WeightChooseUserActivity.class);
            intent.putExtra(e.d, eVar.n());
            intent.putExtra("USER_LIST", iArr);
            context.startActivity(intent);
            C0401a.a(context, C0401a.fQ);
        }
    }

    private void a(View view) {
        this.e = (TextView) view.findViewById(R.id.step);
        this.f = (TextView) view.findViewById(R.id.step_distance);
        this.g = (TextView) view.findViewById(R.id.step_calorie);
        this.h = (TextView) view.findViewById(R.id.step_tip);
        this.i = (TextView) view.findViewById(R.id.step_unit);
        this.j = (TextView) view.findViewById(R.id.shoes_distance);
        this.v = view.findViewById(R.id.shoes_distance_view);
        this.E = (ImageView) view.findViewById(R.id.lining_logo_top);
        if (DeviceSource.hasBindBracelet() || !DeviceSource.hasBindShoesDevice()) {
            this.E.setVisibility(4);
        } else {
            this.E.setVisibility(0);
        }
        if (t.a()) {
            this.e.setTextSize(43.0f);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.h.getLayoutParams();
            marginLayoutParams.topMargin = (int) t.a(getContext(), 45.0f);
            this.h.setTextSize((float) 11);
            this.h.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) ((View) this.f.getParent()).getLayoutParams();
            marginLayoutParams.bottomMargin = (int) t.a(getContext(), 45.0f);
            this.f.setTextSize((float) 11);
            this.g.setTextSize((float) 11);
            ((View) this.f.getParent()).setLayoutParams(marginLayoutParams);
        }
    }

    private void b(View view) {
        this.k = (TextView) view.findViewById(R.id.sleep_hour);
        this.l = (TextView) view.findViewById(R.id.sleep_hour_unit);
        this.m = (TextView) view.findViewById(R.id.sleep_min);
        this.n = (TextView) view.findViewById(R.id.sleep_min_unit);
        this.o = (TextView) view.findViewById(R.id.sleep_deep_time);
        this.p = (TextView) view.findViewById(R.id.sleep_tip);
        if (t.a()) {
            this.k.setTextSize(32.0f);
            this.l.setTextSize(24.5f);
            this.m.setTextSize(32.0f);
            this.n.setTextSize(24.5f);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.p.getLayoutParams();
            marginLayoutParams.topMargin = (int) t.a(getContext(), 45.0f);
            this.p.setTextSize((float) 11);
            this.p.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) this.o.getLayoutParams();
            marginLayoutParams.bottomMargin = (int) t.a(getContext(), 45.0f);
            this.o.setTextSize((float) 11);
            this.o.setLayoutParams(marginLayoutParams);
        }
    }

    private void c(View view) {
        this.q = (TextView) view.findViewById(R.id.weight);
        this.r = (TextView) view.findViewById(R.id.weight_unit);
        this.s = (TextView) view.findViewById(R.id.weight_bmi);
        this.t = (TextView) view.findViewById(R.id.weight_tip);
        if (t.a()) {
            this.q.setTextSize(43.0f);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.t.getLayoutParams();
            marginLayoutParams.topMargin = (int) t.a(getContext(), 140.0f);
            this.t.setTextSize(16.0f);
            this.t.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) this.s.getLayoutParams();
            marginLayoutParams.bottomMargin = (int) t.a(getContext(), 45.0f);
            this.s.setTextSize((float) 11);
            this.s.setLayoutParams(marginLayoutParams);
        }
    }

    private void d() {
        this.K = ValueAnimator.ofFloat(new float[]{0.0f, CropOverlayView.a});
        this.K.setDuration(800);
        this.K.setInterpolator(new DecelerateInterpolator(3.0f));
        this.K.addUpdateListener(new C0837k(this));
        this.K.start();
    }

    private void e() {
        if (this.L == null || !this.L.isRunning()) {
            this.L = ValueAnimator.ofFloat(new float[]{1.0f, 1.03f, 1.07f, 1.1f, 1.1f, 1.07f, 1.03f, 1.0f, 0.95f, 0.9f, 0.95f, 1.0f, 1.05f, 1.0f});
            this.L.setDuration(1000);
            this.L.setInterpolator(new DecelerateInterpolator());
            this.L.addListener(new C0838l(this));
            this.L.addUpdateListener(new C0839m(this));
            this.L.start();
        }
    }

    private void f() {
        this.M = ValueAnimator.ofFloat(new float[]{0.0f, 10.0f, 0.0f});
        this.M.setDuration(500);
        this.M.setInterpolator(new DecelerateInterpolator());
        this.M.addListener(new C0840n(this));
        this.M.addUpdateListener(new C0841o(this));
        this.M.start();
    }

    private void g() {
        if (this.M != null) {
            this.M.end();
        }
        if (this.K != null) {
            this.K.end();
        }
        this.N = ValueAnimator.ofFloat(new float[]{0.0f, CropOverlayView.a});
        this.N.setDuration(800);
        this.N.setInterpolator(new LinearInterpolator());
        this.N.addListener(new C0842p(this));
        this.N.addUpdateListener(new C0830d(this));
        this.N.start();
    }

    private Animator h(int i) {
        q.a(this.c.a());
        if (i == 1) {
            q.b(a.a(this.y, this.z, this.e));
        } else if (i == PersonInfo.INCOMING_CALL_DISABLE_BIT && this.w == GroundOverlayOptions.NO_DIMENSION && this.x > GroundOverlayOptions.NO_DIMENSION) {
            Animator a = a.a(0.0f, this.x, 1, this.q);
            a.setDuration(this.c.l() / 2);
            q.b(a);
        }
        return q.a();
    }

    private void h() {
        if (this.N != null) {
            this.N.end();
        }
        if (this.M != null) {
            this.M.end();
        }
        if (this.K != null) {
            this.K.end();
        }
        this.O = ValueAnimator.ofFloat(new float[]{0.0f, CropOverlayView.a});
        this.O.setDuration(600);
        this.O.setInterpolator(new LinearInterpolator());
        this.O.addListener(new C0831e(this));
        this.O.addUpdateListener(new C0832f(this));
        this.O.start();
    }

    private void i() {
        if (this.M != null) {
            this.M.end();
        }
        if (this.K != null) {
            this.K.end();
        }
        this.P = ValueAnimator.ofFloat(new float[]{0.0f, 600.0f});
        this.P.setDuration(800);
        this.P.setInterpolator(new LinearInterpolator());
        this.P.addListener(new C0833g(this));
        this.P.addUpdateListener(new C0834h(this));
        this.P.start();
    }

    public void a() {
        c(false);
    }

    public void a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.c.setRotationX(90.0f - (f * 90.0f));
            this.c.setAlpha(f);
            this.b.setTranslationY(((float) (-this.I)) * (1.0f - f));
            if (this.J != null) {
                if (((double) f) > 0.93d && f <= 1.0f) {
                    ((View) this.J).setTranslationY(0.0f);
                    ((View) this.J).setAlpha(1.0f - ((1.0f - f) / 0.07f));
                } else if (f < 0.0f || ((double) f) >= 0.07d) {
                    ((View) this.J).setTranslationY(0.0f);
                    ((View) this.J).setAlpha(0.0f);
                } else {
                    ((View) this.J).setTranslationY(-(((float) this.I) + t.a(getContext(), 115.0f)));
                    ((View) this.J).setAlpha(1.0f - (f / 0.07f));
                }
            }
            if (this.h != null) {
                this.h.setAlpha(f);
                ((View) this.f.getParent()).setAlpha(f);
                this.i.setAlpha(1.0f - f);
            }
            if (this.p != null) {
                this.p.setAlpha(f);
                this.o.setAlpha(f);
            }
            if (this.t != null) {
                this.t.setAlpha(f);
                this.s.setAlpha(f);
            }
            if (this.E != null) {
                this.E.setAlpha(f);
            }
            if (this.v != null) {
                this.v.setAlpha(f);
            }
        }
    }

    public void a(float f, float f2, float f3) {
        if (f == e.c) {
            this.q.setText("OL");
            this.w = 0.0f;
            this.x = GroundOverlayOptions.NO_DIMENSION;
        } else {
            this.w = this.x;
            this.x = f;
            this.q.setText(String.valueOf(aA.c(f)));
            if (this.H == null || !this.H.e) {
                this.q.setAlpha(1.0f);
            } else {
                this.q.setAlpha(0.6f);
            }
        }
        this.c.a(150.0f);
        this.c.d(f3);
        this.c.c(f2);
    }

    public void a(float f, int i, int i2) {
        if (f <= 0.0f) {
            this.s.setText("BMI " + aA.b(f));
        } else {
            this.s.setText("BMI " + aA.b(f) + " " + aA.a(getContext(), f, i, i2));
        }
    }

    public void a(int i) {
        this.c.a((float) i);
    }

    public void a(long j) {
        if (this.A != null) {
            a.a((View) this, (AnimatorSet) this.A, j);
        }
    }

    public void a(c cVar) {
        this.J = cVar;
    }

    public void a(P p) {
        this.H = p;
    }

    public void a(Boolean bool) {
        if (this.b != null) {
            if (bool.booleanValue()) {
                this.b.setAlpha(0.3f);
                return;
            }
            this.b.setAlpha(1.0f);
            e();
        }
    }

    public void a(String str) {
        this.h.setText(str);
    }

    public void a(boolean z) {
        if (this.F == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            if (this.u == null) {
                this.u = ((ViewStub) this.d.findViewById(R.id.info_weight_low_battery)).inflate();
            }
            if (z) {
                this.d.findViewById(R.id.weight_container).setVisibility(4);
                this.u.setVisibility(0);
                return;
            }
            this.d.findViewById(R.id.weight_container).setVisibility(0);
            this.u.setVisibility(8);
        }
    }

    public void a(String[] strArr) {
        this.f.setText(strArr[0] + strArr[1]);
    }

    public long b() {
        return a.a((AnimatorSet) this.A);
    }

    public void b(float f) {
        this.w = f;
    }

    public void b(int i) {
        this.z = i;
        this.c.c((float) i);
    }

    public void b(String str) {
        this.p.setText(str);
    }

    public void b(boolean z) {
        if (!z) {
            c(false);
        }
    }

    public void b(String[] strArr) {
        this.j.setText(strArr[0] + strArr[1]);
    }

    public DynamicPieChartView c() {
        return this.c;
    }

    public void c(int i) {
        if (this.v != null) {
            this.v.setVisibility(i);
        }
    }

    public void c(String str) {
        this.r.setText(str);
    }

    public void c(boolean z) {
        if (this.A != null && this.A.isStarted()) {
            this.A.end();
        }
        if (z) {
            this.A = h(this.F);
            this.A.start();
            return;
        }
        if (this.F == 1) {
            this.e.setText(a.b(this.z));
            this.i.setText(R.string.unit_step);
        } else if (this.F == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.q.setText(String.valueOf(aA.c(this.x)));
        }
        this.c.a(false);
    }

    public void d(int i) {
        this.g.setText(String.valueOf(i) + getContext().getString(R.string.unit_calorie));
    }

    public void d(String str) {
        this.t.setText(str);
    }

    public void e(int i) {
        String[] d = f.d(i);
        this.k.setText(d[0]);
        this.l.setText(R.string.unit_hour);
        this.m.setText(d[1]);
        this.n.setText(R.string.unit_min_short);
    }

    public void f(int i) {
        this.o.setText(getContext().getString(R.string.dynamic_sleep_deep_title, new Object[]{f.b(getContext(), i)}));
    }

    public void g(int i) {
        this.F = i;
        switch (i) {
            case l.a /*1*/:
                this.d = ((ViewStub) findViewById(R.id.info_step)).inflate();
                this.d.setOnClickListener(new C0829c(this));
                a(this.d);
                break;
            case kankan.wheel.widget.a.bp /*16*/:
                this.d = ((ViewStub) findViewById(R.id.info_sleep)).inflate();
                this.d.setOnClickListener(new C0835i(this));
                b(this.d);
                break;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                this.d = ((ViewStub) findViewById(R.id.info_weight)).inflate();
                this.d.setOnClickListener(new C0836j(this));
                c(this.d);
                break;
        }
        this.c.a(i);
    }

    public View makeView() {
        return inflate(getContext(), R.layout.view_dynamic_textswitcher, null);
    }

    protected void onAttachedToWindow() {
        boolean z = true;
        super.onAttachedToWindow();
        b(false);
        if (this.G.booleanValue()) {
        }
        if (DeviceSource.hasBindDevice()) {
            z = false;
        }
        a(Boolean.valueOf(z));
    }
}
