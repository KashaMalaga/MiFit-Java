package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.widget.c;
import cn.com.smartdevices.bracelet.view.RippleBackground;
import com.xiaomi.hm.health.e;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.util.ArrayList;

public class InstructionWeightActivity extends SystemBarTintActivity {
    private static String O = "InstructionWeightActivity";
    private static bF P = null;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 3;
    private static final int m = 4;
    private static final int n = 5;
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private View I;
    private ImageView J;
    private View K;
    private View L;
    private View M;
    private View N;
    private int Q = -1;
    public ImageView a;
    public LayoutParams b;
    private ViewPager o;
    private c p;
    private C0722bx q;
    private ArrayList<Fragment> r;
    private int s;
    private RippleBackground t;
    private View u;
    private View v;
    private View w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    private void a(int i) {
        if (i > j) {
            this.t.b();
            this.t.a(false);
            this.D.clearAnimation();
            this.E.clearAnimation();
            this.x.setVisibility(m);
            this.v.setVisibility(m);
            this.w.setVisibility(m);
            return;
        }
        this.t.a(true);
        this.t.a();
        this.x.setVisibility(i);
        this.v.setVisibility(i);
        if (i == j) {
            findViewById(l.instruction_weight_img_phone).setVisibility(m);
            this.w.setVisibility(i);
            d();
        } else {
            this.w.setVisibility(m);
            findViewById(l.instruction_weight_img_phone).setVisibility(i);
        }
        if (i == 0) {
            findViewById(l.instruction_weight_line).setVisibility(i);
            a(this.D, (int) e.instruction_weight_left_arrow);
            a(this.E, (int) e.instruction_weight_right_arrow);
            return;
        }
        this.D.clearAnimation();
        this.E.clearAnimation();
        findViewById(l.instruction_weight_line).setVisibility(m);
    }

    private void a(int i, float f) {
        if (f != 0.0f) {
            switch (i) {
            }
        }
    }

    private void a(int i, Float f) {
        if (f.floatValue() != 0.0f) {
            ((by) this.r.get(i)).a.setAlpha(1.0f - f.floatValue());
            ((by) this.r.get(i + j)).a.setAlpha(f.floatValue());
            return;
        }
        ((by) this.r.get(i)).a.setAlpha(1.0f);
    }

    private void a(View view) {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatMode(j);
        alphaAnimation.setRepeatCount(-1);
        view.startAnimation(alphaAnimation);
    }

    private void a(View view, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, i);
        loadAnimation.setRepeatMode(j);
        loadAnimation.setRepeatCount(-1);
        loadAnimation.setAnimationListener(new C0716br(this, view, loadAnimation));
        view.startAnimation(loadAnimation);
    }

    private void b(int i) {
        if (i == k || i == l) {
            this.N.setVisibility(i);
            if (i == k) {
                this.z.setVisibility(m);
                this.A.clearAnimation();
                this.A.setVisibility(m);
                this.z.clearAnimation();
                this.z.setVisibility(m);
                if (this.Q == j) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this, e.instruction_weight_big_weight_out);
                    loadAnimation.setAnimationListener(new C0717bs(this));
                    this.B.startAnimation(loadAnimation);
                    return;
                }
                this.A.clearAnimation();
                this.A.setVisibility(m);
                this.B.setVisibility(i);
                a(this.z);
                return;
            }
            this.z.setVisibility(m);
            this.A.setVisibility(i);
            this.B.clearAnimation();
            this.B.setVisibility(i);
            this.z.clearAnimation();
            a(this.A);
            return;
        }
        this.N.setVisibility(m);
    }

    private void c() {
        this.t = (RippleBackground) findViewById(l.content);
        this.t.a();
        this.x = (ImageView) findViewById(l.instruction_weight_img_weight);
        this.v = findViewById(l.in_weight_page1_phone_and_dot);
        this.y = (ImageView) findViewById(l.instruction_weight_img_weight_overturn);
        this.y.setVisibility(m);
        this.y.setBackgroundResource(k.instruction_weight_overturn);
        this.N = findViewById(l.instruction_weight_bg_34);
        this.N.setVisibility(m);
        this.A = (ImageView) findViewById(l.instruction_weight_overMax);
        this.A.setVisibility(m);
        this.z = (ImageView) findViewById(l.instruction_weight_low);
        this.z.setVisibility(m);
        this.B = (ImageView) findViewById(l.instruction_weight_big_weight);
        this.B.setVisibility(m);
        this.u = findViewById(l.instruction_weight_img_weight_magnify);
        this.C = (ImageView) findViewById(l.instruction_weight_img_swipe);
        this.D = (ImageView) findViewById(l.weight_left_arrow);
        this.E = (ImageView) findViewById(l.weight_right_arrow);
        this.F = (ImageView) findViewById(l.instruction_weight_img_phone1);
        this.G = (ImageView) findViewById(l.instruction_weight_img_phone_back1);
        this.H = (ImageView) findViewById(l.instruction_weight_img_phone_back2);
        this.w = findViewById(l.instruction_weight_phones);
        this.I = findViewById(l.instruction_weight_page_6);
        this.a = (ImageView) findViewById(l.instruction_weight_foot);
        this.J = (ImageView) findViewById(l.instruction_weight_flatwise);
        this.K = findViewById(l.instruction_weight_page6_tips1);
        this.L = findViewById(l.instruction_weight_page6_tips2);
        this.M = findViewById(l.instruction_weight_page6_tips3);
        this.I.setVisibility(m);
    }

    private void c(int i) {
        int i2 = i;
        if (i == m) {
            this.y.setVisibility(i);
            AnimationDrawable animationDrawable = (AnimationDrawable) this.y.getBackground();
            animationDrawable.start();
            C0596r.e(O, "OverturnAnim is running-- : " + animationDrawable.isRunning());
            int i3 = i;
            while (i2 < animationDrawable.getNumberOfFrames()) {
                i3 += animationDrawable.getDuration(i2);
                i2 += j;
            }
            P.sendEmptyMessageDelayed(l, (long) i3);
            return;
        }
        this.u.clearAnimation();
        this.C.clearAnimation();
        this.y.clearAnimation();
        this.y.setVisibility(m);
        this.u.setVisibility(m);
        P.removeMessages(k);
        P.removeMessages(j);
        P.removeMessages(l);
    }

    private void d() {
        Animation translateAnimation = new TranslateAnimation(j, 0.0f, j, 0.0f, j, 0.125f, j, 0.0f);
        translateAnimation.setDuration(400);
        translateAnimation.setFillBefore(true);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.F.startAnimation(translateAnimation);
        Animation translateAnimation2 = new TranslateAnimation(j, 0.14f, j, 0.0f, j, 0.0f, j, 0.0f);
        translateAnimation2.setDuration(400);
        translateAnimation2.setStartOffset(200);
        translateAnimation2.setFillBefore(true);
        translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.G.startAnimation(translateAnimation2);
        translateAnimation2 = new TranslateAnimation(j, -0.14f, j, 0.0f, j, -0.07f, j, 0.0f);
        translateAnimation2.setDuration(400);
        translateAnimation2.setStartOffset(400);
        translateAnimation2.setFillBefore(true);
        translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.H.startAnimation(translateAnimation2);
    }

    private void d(int i) {
        if (i == n) {
            this.u.clearAnimation();
            this.u.setVisibility(m);
            this.I.setVisibility(i);
            this.K.clearAnimation();
            this.L.clearAnimation();
            this.M.clearAnimation();
            Animation translateAnimation = new TranslateAnimation(j, 0.0f, j, 0.0f, j, 0.0f, j, 0.38f);
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation.setAnimationListener(new C0720bv(this));
            this.J.setVisibility(m);
            this.J.startAnimation(translateAnimation);
        } else if (i == m) {
            this.I.setVisibility(m);
            P.removeMessages(n);
        }
    }

    private void e() {
        c();
        a(this.D, (int) e.instruction_weight_left_arrow);
        a(this.E, (int) e.instruction_weight_right_arrow);
    }

    private void f() {
        this.y.clearAnimation();
        Animation translateAnimation = new TranslateAnimation(j, 0.0f, j, 0.37f, j, 0.0f, j, 0.0f);
        translateAnimation.setDuration(700);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new C0718bt(this));
        this.y.startAnimation(translateAnimation);
    }

    private void g() {
        this.u.clearAnimation();
        this.u.setVisibility(i);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new C0719bu(this));
        this.u.startAnimation(alphaAnimation);
    }

    private void h() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);
        this.K.startAnimation(alphaAnimation);
        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setStartOffset(1000);
        alphaAnimation.setFillAfter(true);
        this.L.startAnimation(alphaAnimation);
        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setStartOffset(2000);
        this.M.startAnimation(alphaAnimation);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_instruction_weight);
        e();
        P = new C0714bp(this, this);
        this.o = (ViewPager) findViewById(l.view_pager);
        this.p = (c) findViewById(l.indicator);
        this.r = new ArrayList(6);
        this.r.add(Fragment.instantiate(this, C0723bz.class.getName()));
        this.r.add(Fragment.instantiate(this, bA.class.getName()));
        this.r.add(Fragment.instantiate(this, bB.class.getName()));
        this.r.add(Fragment.instantiate(this, bC.class.getName()));
        this.r.add(Fragment.instantiate(this, bD.class.getName()));
        this.r.add(Fragment.instantiate(this, bE.class.getName()));
        this.q = new C0722bx(this, getFragmentManager());
        this.o.a(this.q);
        this.o.b(6);
        this.p.a(this.o);
        this.p.a(new C0715bq(this));
    }

    protected void onPause() {
        super.onPause();
        C0401a.b(C0401a.z);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        C0401a.a(C0401a.z);
        C0401a.a((Activity) this);
    }
}
