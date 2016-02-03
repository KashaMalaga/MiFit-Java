package cn.com.smartdevices.bracelet.weight;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0434d;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.config.b;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.a;

public class as extends DialogFragment {
    public static final String a = "WEIGHTTIPSACTIVITY_BMI";
    public static final String b = "WEIGHTTIPSACTIVITY_AGE";
    public static final String c = "WEIGHTTIPSACTIITY_GENDER";
    public static final String d = "WEIGHTTIPSACTIVITY_HEIGHT";
    public static final String e = "WeightTipsFragment";
    private static final int p = 250;
    private WeightGoalSetView f;
    private TextView g;
    private ImageButton h;
    private RelativeLayout i;
    private TextView j;
    private RelativeLayout k;
    private float l = aA.h;
    private int m = -1;
    private int n = 1;
    private int o = 0;
    private RelativeLayout q;
    private Bitmap r;
    private Bitmap s;
    private Animator t;
    private Animator u;
    private az v;

    private void a(View view) {
        this.q = (RelativeLayout) view.findViewById(R.id.tips_bg);
        this.k = (RelativeLayout) view.findViewById(R.id.other_tips_layout);
        this.f = (WeightGoalSetView) view.findViewById(R.id.weight_tip_bmi_img);
        this.j = (TextView) view.findViewById(R.id.weight_tip_weight_ref_content);
        this.g = (TextView) view.findViewById(R.id.tips_notice);
        View findViewById = view.findViewById(R.id.weight_tip_weight_ref_title);
        View findViewById2 = view.findViewById(R.id.weight_tip_divider4);
        if (b.h().w.booleanValue()) {
            findViewById.setVisibility(4);
            findViewById2.setVisibility(4);
            this.j.setVisibility(4);
        }
        if (this.m < 7 || this.o < 100) {
            this.f.setVisibility(8);
            this.k.setVisibility(0);
            if (this.m < 7) {
                this.g.setText(getString(R.string.cannot_figure_bmi_causedby_age));
            } else if (this.o < 100) {
                this.g.setText(getString(R.string.cannot_figure_bmi_causedby_height));
            }
        } else {
            this.f.setVisibility(0);
            this.k.setVisibility(8);
        }
        if (this.m < 7 || this.m > 18) {
            this.f.b(1);
            this.j.setText(getString(R.string.china_adult_overweight_ref));
            this.f.a(0.0f, aA.g, aA.h, a.bf, BitmapDescriptorFactory.HUE_MAGENTA);
        } else {
            float a = aA.a(this.m, this.n);
            C0596r.e(e, "child min " + a + " max " + aA.b(this.m, this.n));
            this.j.setText(getString(R.string.china_child_overweight_ref));
            this.f.b(1);
            this.f.a(0.0f, a, r1, BitmapDescriptorFactory.HUE_MAGENTA);
        }
        if (this.l <= 0.0f) {
            this.l = aA.h;
        }
        this.f.a(this.l);
        this.h = (ImageButton) view.findViewById(R.id.bmi_view_cancel);
        this.h.setOnClickListener(new at(this));
    }

    @SuppressLint({"NewApi"})
    private Bitmap c() {
        if (this.r == null || this.r.isRecycled()) {
            return null;
        }
        int width = this.q.getWidth();
        int height = this.q.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(0.14285715f, 0.14285715f);
        Bitmap createBitmap = Bitmap.createBitmap(this.r, 0, 0, width, height, matrix, true);
        this.r.recycle();
        this.r = null;
        Bitmap a = C0434d.a(getActivity(), createBitmap, 25);
        if (a != createBitmap) {
            createBitmap.recycle();
        }
        this.q.setBackground(new BitmapDrawable(getResources(), a));
        return a;
    }

    public void a() {
        a(250);
    }

    public void a(long j) {
        if (this.t == null || !this.t.isRunning()) {
            this.q.getHeight();
            Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new av(this));
            q.a(ofFloat);
            ofFloat = q.a();
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(j);
            ofFloat.start();
            this.t = ofFloat;
        }
    }

    public void a(long j, AnimatorListener animatorListener) {
        if (this.u == null || !this.u.isRunning()) {
            this.q.getHeight();
            Animator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.addUpdateListener(new aw(this));
            q.a(ofFloat);
            ofFloat = q.a();
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(j);
            ofFloat.addListener(animatorListener);
            ofFloat.start();
            this.u = ofFloat;
        }
    }

    public void a(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        new BitmapDrawable(bitmap).draw(canvas);
        this.r = bitmap;
    }

    public void a(az azVar) {
        this.v = azVar;
    }

    public void b() {
        a(250, new ax(this));
    }

    public void dismiss() {
        if (getActivity() != null) {
            super.dismiss();
            b();
        }
    }

    public void dismissAllowingStateLoss() {
        if (getActivity() != null) {
            super.dismissAllowingStateLoss();
            b();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.q.post(new au(this));
    }

    public void onCancel(DialogInterface dialogInterface) {
        b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = R.style.MenuPanel;
        if (com.huami.android.ui.a.b(getActivity())) {
            i = R.style.MenuPanelTint;
        }
        setStyle(0, i);
        if (getArguments() != null) {
            this.l = getArguments().getFloat(a);
            this.m = getArguments().getInt(b);
            this.n = getArguments().getInt(c);
            this.o = getArguments().getInt(d);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_weight_tips, viewGroup, false);
        a(inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.s != null) {
            this.s.recycle();
            this.s = null;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.v != null) {
            this.v.a();
        }
    }

    public void onPause() {
        super.onPause();
        C0401a.b(C0401a.aS);
    }

    public void onResume() {
        super.onResume();
        C0401a.a(C0401a.aS);
    }
}
