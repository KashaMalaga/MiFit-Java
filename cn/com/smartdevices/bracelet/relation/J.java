package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.com.smartdevices.bracelet.C0434d;
import cn.com.smartdevices.bracelet.chart.util.q;
import cn.com.smartdevices.bracelet.push.h;
import cn.com.smartdevices.bracelet.ui.fe;
import com.huami.android.ui.a;
import com.xiaomi.hm.health.R;

public class J extends DialogFragment implements OnClickListener {
    private static final String c = "MainMenuFragment";
    private static final int d = 250;
    private static final int e = 5;
    AnimatorListener a = new L(this);
    N b;
    private Bitmap f;
    private Bitmap g;
    private LinearLayout h;
    private View i;
    private Animator j;
    private Animator k;
    private OnClickListener l;

    public static J a(Context context) {
        return (J) instantiate(context, J.class.getName(), new Bundle());
    }

    private void a(Dialog dialog) {
        dialog.getWindow().setLayout(-1, -2);
        dialog.getWindow().setGravity(48);
        dialog.setCanceledOnTouchOutside(true);
    }

    @SuppressLint({"NewApi"})
    private Bitmap c() {
        if (this.f == null || this.f.isRecycled()) {
            return null;
        }
        int width = this.h.getWidth();
        int height = this.h.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(0.14285715f, 0.14285715f);
        Bitmap createBitmap = Bitmap.createBitmap(this.f, 0, 0, width, height, matrix, true);
        this.f.recycle();
        this.f = null;
        Bitmap a = C0434d.a(getActivity(), createBitmap, 25);
        if (a != createBitmap) {
            createBitmap.recycle();
        }
        Canvas canvas = new Canvas(a);
        canvas.save();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#80000000"));
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
        canvas.restore();
        this.h.setBackground(new BitmapDrawable(getResources(), a));
        return a;
    }

    public void a() {
        if (this.j == null || !this.j.isRunning()) {
            q.a(ValueAnimator.ofInt(new int[]{0, this.h.getHeight()}));
            int childCount = this.h.getChildCount();
            int i = 0;
            for (int i2 = 0; i2 <= childCount - 1; i2++) {
                View childAt = this.h.getChildAt((childCount - 1) - i2);
                if (childAt.isShown()) {
                    childAt.setTranslationY((float) (-r3));
                    Animator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{(float) (-r3), 0.0f});
                    ofFloat.setStartDelay((long) (e * i));
                    q.b(ofFloat);
                    i++;
                }
            }
            Animator a = q.a();
            a.setInterpolator(new DecelerateInterpolator());
            a.setDuration(250);
            a.start();
            this.j = a;
        }
    }

    public void a(Bitmap bitmap) {
        this.f = bitmap;
    }

    public void a(OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(N n) {
        this.b = n;
    }

    public void a(boolean z) {
        if (this.i != null) {
            if (z) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void b() {
        if (this.k == null || !this.k.isRunning()) {
            int height = this.h.getHeight();
            Animator ofInt = ValueAnimator.ofInt(new int[]{height, 0});
            int childCount = this.h.getChildCount();
            int i = 0;
            for (int i2 = 0; i2 <= childCount - 1; i2++) {
                View childAt = this.h.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    childAt.setTranslationY(0.0f);
                    Animator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{0.0f, (float) (-height)});
                    ofFloat.setStartDelay((long) (e * i));
                    if (i2 == 0) {
                        q.a(ofFloat);
                    } else {
                        q.b(ofFloat);
                    }
                    i++;
                }
            }
            ofInt.setStartDelay((long) (i * e));
            q.b(ofInt);
            Animator a = q.a();
            a.setInterpolator(new AccelerateInterpolator());
            a.setDuration(250);
            a.addListener(this.a);
            a.start();
            this.k = a;
        }
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
        this.h.post(new K(this));
    }

    public void onCancel(DialogInterface dialogInterface) {
        b();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.menu_dismiss) {
            b();
            return;
        }
        if (this.l != null) {
            this.l.onClick(view);
        }
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
        Dialog m = new M(this, getActivity(), getTheme());
        a(m);
        return m;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_friend_menu, viewGroup, false);
        this.h = (LinearLayout) inflate.findViewById(R.id.menu_content);
        inflate.findViewById(R.id.menu_dismiss).setOnClickListener(this);
        if (a.b(getActivity())) {
            fe feVar = new fe(getActivity());
            View childAt = this.h.getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = feVar.a().a(false) + layoutParams.topMargin;
            childAt.setLayoutParams(layoutParams);
        }
        this.h.findViewById(R.id.message_button).setOnClickListener(this);
        this.i = this.h.findViewById(R.id.new_flag);
        this.h.findViewById(R.id.action_add_friend).setOnClickListener(this);
        this.h.findViewById(R.id.action_my_qrcode).setOnClickListener(this);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.b != null) {
            this.b.c();
        }
    }

    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            a(h.a(getActivity()).a());
        }
    }
}
