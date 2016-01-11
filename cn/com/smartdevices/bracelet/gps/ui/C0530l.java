package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.gps.ui.gadget.CustomRoundProgressBar;
import com.xiaomi.hm.health.b.a.b;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;

public class C0530l extends Fragment {
    private static final int j = 100;
    private static final int k = 1000;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 3;
    private AnimatorSet a = null;
    private boolean b = false;
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private View f = null;
    private ValueAnimator g = null;
    private ValueAnimator h = null;
    private ValueAnimator i = null;
    private View l = null;
    private View m = null;
    private CustomRoundProgressBar n = null;
    private C0522v o = null;
    private Handler s = null;
    private Message t = null;
    private boolean u = false;

    private void h() {
        int[] iArr = new int[p];
        iArr[0] = 1100;
        this.g = ValueAnimator.ofInt(iArr);
        this.g.setDuration(800);
        this.g.addListener(new C0535q(this));
        this.g.addUpdateListener(new C0536r(this));
        this.h = (ValueAnimator) AnimatorInflater.loadAnimator(getActivity(), b.running_main_button_split_animator);
        this.h.addUpdateListener(new C0537s(this));
        this.i = (ValueAnimator) AnimatorInflater.loadAnimator(getActivity(), b.running_main_button_split_animator);
        this.i.addUpdateListener(new C0538t(this));
        this.i.addListener(new C0539u(this));
        this.a = new AnimatorSet();
        AnimatorSet animatorSet = this.a;
        Animator[] animatorArr = new Animator[q];
        animatorArr[0] = this.g;
        animatorArr[p] = this.h;
        animatorSet.playSequentially(animatorArr);
    }

    public synchronized void a() {
        this.c = this.l.getX();
        this.d = this.m.getX();
        this.e = this.f.getX() - (((float) this.l.getLayoutParams().width) / 2.0f);
        if (this.t != null) {
            this.t.sendToTarget();
            this.t = null;
        }
        this.u = true;
    }

    public void a(C0522v c0522v) {
        this.o = c0522v;
    }

    public void b() {
        this.o = null;
    }

    synchronized void c() {
        Message obtainMessage = this.s.obtainMessage(q);
        if (!this.u) {
            this.t = obtainMessage;
        } else if (obtainMessage != null) {
            obtainMessage.sendToTarget();
        }
    }

    synchronized void d() {
        Message obtainMessage = this.s.obtainMessage(r);
        if (!this.u) {
            this.t = obtainMessage;
        } else if (obtainMessage != null) {
            obtainMessage.sendToTarget();
        }
    }

    CustomRoundProgressBar e() {
        return this.n;
    }

    void f() {
        this.n.setVisibility(4);
        this.m.setVisibility(0);
        this.l.setVisibility(0);
    }

    void g() {
        this.n.a(0);
        this.n.setVisibility(0);
        this.m.setVisibility(4);
        this.l.setVisibility(4);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = new C0540w(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(j.running_button_container_gps_main, null);
        this.l = inflate.findViewById(i.continue_button);
        this.m = inflate.findViewById(i.finish_button);
        this.n = (CustomRoundProgressBar) inflate.findViewById(i.pause_button);
        this.m.setOnClickListener(new C0531m(this));
        this.l.setOnClickListener(new C0532n(this));
        this.f = inflate.findViewById(i.start_pos);
        g();
        this.n.setOnTouchListener(new C0533o(this));
        h();
        inflate.post(new C0534p(this));
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.s.removeCallbacksAndMessages(null);
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }
}
