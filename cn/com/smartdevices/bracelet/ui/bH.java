package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.com.smartdevices.bracelet.C0434d;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.f.e;
import cn.com.smartdevices.bracelet.lab.h;
import cn.com.smartdevices.bracelet.model.Birthday;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.huami.android.ui.a;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.R;
import com.xiaomi.mipush.sdk.f;

public class bH extends DialogFragment {
    private static final String a = "MainMenuFragment";
    private static final int b = 250;
    private static final int c = 5;
    private static final int d = 1000;
    private View e;
    private View f;
    private Bitmap g;
    private Bitmap h;
    private Animator i;
    private Animator j;
    private bR k;
    private final b l = b.h();
    private boolean m = false;
    private int n = -1;
    private boolean o = false;
    private float p = 0.0f;

    private void a(Dialog dialog) {
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setGravity(48);
        dialog.setCanceledOnTouchOutside(true);
    }

    private void a(View view) {
        this.e = view.findViewById(R.id.bg_blur);
        this.f = view.findViewById(R.id.menu_content);
        if (a.b(getActivity())) {
            fe feVar = new fe(getActivity());
            View childAt = ((ViewGroup) this.f).getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = feVar.a().b() + layoutParams.topMargin;
            childAt.setLayoutParams(layoutParams);
        }
        View findViewById = view.findViewById(R.id.menu_running);
        a(findViewById, R.id.menu_running_new_sign, "RUNNING");
        if (!this.l.g.ENABLE_RUNNING.booleanValue()) {
            findViewById.setVisibility(8);
            view.findViewById(R.id.v9).setVisibility(8);
        }
        findViewById = view.findViewById(R.id.menu_service);
        a(findViewById, R.id.menu_service_new_sign, "SERVICE");
        if (!this.l.c.b.booleanValue()) {
            findViewById.setVisibility(8);
            view.findViewById(R.id.v5).setVisibility(8);
        }
        if (!this.l.l.a.booleanValue()) {
            view.findViewById(R.id.menu_weight).setVisibility(8);
            view.findViewById(R.id.v6).setVisibility(8);
        }
        findViewById = view.findViewById(R.id.menu_relation);
        a(findViewById, R.id.menu_relation_new_sign, "RELATION");
        if (!this.l.p.ENABLE_RELATION.booleanValue()) {
            findViewById.setVisibility(8);
            view.findViewById(R.id.line).setVisibility(8);
        }
        findViewById = view.findViewById(R.id.menu_smart_alarms);
        if (e.a().b() && !DeviceSource.hasBindBracelet()) {
            findViewById.setVisibility(8);
            view.findViewById(R.id.v2).setVisibility(8);
        }
        if (e.a().b() && DeviceSource.hasBindBracelet()) {
            view.findViewById(R.id.menu_sensorhub).setVisibility(0);
            view.findViewById(R.id.menu_sensorhub_split).setVisibility(0);
            return;
        }
        view.findViewById(R.id.menu_sensorhub).setVisibility(8);
        view.findViewById(R.id.menu_sensorhub_split).setVisibility(8);
    }

    public static void a(View view, int i, String str) {
        if (("LAB".equals(str) && h.a(b.h().e)) || ("SERVICE".equals(str) && h.a(b.h().f))) {
            view.findViewById(i).setVisibility(0);
        } else if (h.a(str)) {
            view.findViewById(i).setVisibility(0);
        } else {
            view.findViewById(i).setVisibility(8);
        }
    }

    @SuppressLint({"NewApi"})
    private Bitmap c() {
        if (this.g == null || this.g.isRecycled()) {
            return null;
        }
        int width = this.f.getWidth();
        int height = this.f.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(0.14285715f, 0.14285715f);
        Bitmap createBitmap = Bitmap.createBitmap(this.g, 0, 0, width, height, matrix, true);
        this.g.recycle();
        this.g = null;
        Bitmap a = C0434d.a(getActivity(), createBitmap, 25);
        if (a != createBitmap) {
            createBitmap.recycle();
        }
        this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, height));
        this.e.setBackground(new BitmapDrawable(getResources(), a));
        return a;
    }

    private void d() {
        Parcelable e = e();
        if (e != null) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), ShareActivity.class);
            intent.putExtra("share_data", e);
            startActivity(intent);
        }
    }

    private ShareData e() {
        int i;
        String str = com.xiaomi.e.a.f;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt(ChartData.l);
            str = arguments.getString(ChartData.m);
        } else {
            i = 0;
        }
        ShareData shareData = new ShareData();
        shareData.type = v.C;
        com.xiaomi.hm.health.bt.profile.Weight.e b = com.xiaomi.hm.health.bt.profile.Weight.e.b(str);
        if (b == null) {
            C0596r.e(a, "mWeightAdvData is null");
            return null;
        } else if (i == 0) {
            shareData.fuid = 0;
            shareData.weightTips = com.xiaomi.e.a.f;
            shareData.weightFigure = "- -";
            shareData.weightBMI = "- -";
            shareData.weightValue = aA.c(b.j()) + com.xiaomi.e.a.f;
            shareData.weightTitle = getString(R.string.current_weight) + "(" + aA.a(getActivity().getApplicationContext(), b.h()) + ")";
            i = Birthday.fromStr(Keeper.readPersonInfo().getBirthday()).getAgeInMonths();
            shareData.babyMonthsStr = Utils.d(getActivity().getApplicationContext(), i) + getString(R.string.weight_ref) + "(" + aA.a(getActivity().getApplicationContext(), b.h()) + ")";
            str = com.xiaomi.e.a.f;
            r1 = str;
            for (String str2 : Utils.a(i, Keeper.readPersonInfo().gender, b.h())) {
                r1 = r1 + str2 + f.i;
            }
            if (r1.isEmpty()) {
                shareData.babyRefWeights = com.xiaomi.e.a.f;
            } else {
                shareData.babyRefWeights = r1.substring(0, r1.length() - 1);
            }
            return shareData;
        } else {
            UserInfo a = J.a().a(i);
            if (a == null) {
                C0596r.e(a, "nowUserInfo is null or uid is 0");
                return null;
            }
            shareData.fuid = a.uid;
            shareData.weightTitle = com.xiaomi.e.a.f;
            shareData.weightValue = com.xiaomi.e.a.f;
            shareData.weightTips = com.xiaomi.e.a.f;
            shareData.weightFigure = "- -";
            shareData.weightBMI = "- -";
            shareData.weightValue = aA.c(b.j()) + com.xiaomi.e.a.f;
            shareData.weightTitle = getString(R.string.current_weight) + "(" + aA.a(getActivity().getApplicationContext(), b.h()) + ")";
            i = Birthday.fromStr(a.birthday).getAgeInMonths();
            shareData.babyMonthsStr = Utils.d(getActivity().getApplicationContext(), i) + getString(R.string.weight_ref) + "(" + aA.a(getActivity().getApplicationContext(), b.h()) + ")";
            str = com.xiaomi.e.a.f;
            String[] a2 = Utils.a(i, a.gender, b.h());
            r1 = str;
            for (String i2 : a2) {
                r1 = r1 + Utils.i(i2) + f.i;
            }
            if (r1.isEmpty()) {
                shareData.babyRefWeights = com.xiaomi.e.a.f;
            } else {
                shareData.babyRefWeights = r1.substring(0, r1.length() - 1);
            }
            i = Birthday.fromStr(a.birthday).getAge();
            this.m = a.targetWeight > 0.0f;
            this.p = aA.a(a.height, Birthday.fromStr(a.birthday).getAge(), aA.a(b.j(), b.h()));
            if (i > 6 && a.height >= 100) {
                shareData.weightBMI = aA.b(this.p);
                shareData.weightFigure = aA.a(getActivity().getApplicationContext(), this.p, Birthday.fromStr(a.birthday).getAge(), a.gender);
            }
            float c;
            if (this.m) {
                c = aA.c(((float) ((int) aA.b(a.targetWeight, b.h()))) - b.j(), 1);
                if (c > 0.0f) {
                    shareData.weightTips = getString(R.string.lighter_than_goal, new Object[]{Math.abs(c) + aA.a(getActivity().getApplicationContext(), b.h())});
                } else if (c < 0.0f) {
                    shareData.weightTips = getString(R.string.heavier_than_goal, new Object[]{Math.abs(c) + aA.a(getActivity().getApplicationContext(), b.h())});
                } else {
                    shareData.weightTips = getString(R.string.weight_reach_goal);
                }
            } else {
                WeightInfo a3 = ah.a().a(a.uid, b.e());
                if (a3 != null) {
                    c = aA.c(b.j() - aA.b(a3.weight, b.h()), 1);
                    if (c > 0.0f) {
                        shareData.weightTips = getString(R.string.add_than_last_time, new Object[]{c + aA.a(getActivity().getApplicationContext(), b.h())});
                    } else if (c < 0.0f) {
                        c = Math.abs(c);
                        shareData.weightTips = getString(R.string.less_than_last_time, new Object[]{c + aA.a(getActivity().getApplicationContext(), b.h())});
                    }
                }
            }
            return shareData;
        }
    }

    public void a() {
        a(250);
    }

    public void a(long j) {
        if (this.i == null || !this.i.isRunning()) {
            Animator ofInt = ValueAnimator.ofInt(new int[]{0, this.f.getHeight()});
            ofInt.addUpdateListener(new bJ(this));
            q.a(ofInt);
            ViewGroup viewGroup = (ViewGroup) this.f;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            for (int i2 = 0; i2 <= childCount - 1; i2++) {
                View childAt = viewGroup.getChildAt((childCount - 1) - i2);
                if (childAt.isShown()) {
                    childAt.setTranslationY((float) (-r4));
                    Animator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{(float) (-r4), 0.0f});
                    ofFloat.setStartDelay((long) (c * i));
                    q.b(ofFloat);
                    i++;
                }
            }
            ofInt = q.a();
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(j);
            ofInt.start();
            this.i = ofInt;
        }
    }

    public void a(long j, AnimatorListener animatorListener) {
        if (this.j == null || !this.j.isRunning()) {
            int height = this.f.getHeight();
            Animator ofInt = ValueAnimator.ofInt(new int[]{height, 0});
            ofInt.addUpdateListener(new bK(this));
            ViewGroup viewGroup = (ViewGroup) this.f;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            for (int i2 = 0; i2 <= childCount - 1; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.isShown()) {
                    childAt.setTranslationY(0.0f);
                    Animator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{0.0f, (float) (-height)});
                    ofFloat.setStartDelay((long) (c * i));
                    if (i2 == 0) {
                        q.a(ofFloat);
                    } else {
                        q.b(ofFloat);
                    }
                    i++;
                }
            }
            ofInt.setStartDelay((long) (c * i));
            q.b(ofInt);
            Animator a = q.a();
            a.setInterpolator(new AccelerateInterpolator());
            a.setDuration(j);
            a.addListener(animatorListener);
            a.start();
            this.j = a;
        }
    }

    public void a(Bitmap bitmap) {
        this.g = bitmap;
    }

    public void a(bR bRVar) {
        this.k = bRVar;
    }

    public void b() {
        a(250, new bL(this));
    }

    public void dismiss() {
        if (getActivity() != null) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (getActivity() != null) {
            super.dismissAllowingStateLoss();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f.post(new bI(this));
    }

    public void onCancel(DialogInterface dialogInterface) {
        b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = R.style.MenuPanel;
        if (a.b(getActivity())) {
            i = R.style.MenuPanelTint;
        }
        setStyle(0, i);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog bQVar = new bQ(this, getActivity(), getTheme());
        a(bQVar);
        return bQVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context bMVar = new bM(this, getActivity(), getTheme());
        if (t.a()) {
            t.a(bMVar, (int) kankan.wheel.widget.a.ax);
        }
        View inflate = layoutInflater.cloneInContext(bMVar).inflate(R.layout.view_main_menu, viewGroup, false);
        a(inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.k != null) {
            this.k.a();
        }
    }
}
