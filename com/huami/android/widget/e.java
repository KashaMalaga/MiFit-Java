package com.huami.android.widget;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.a.r;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.a.i;
import kankan.wheel.widget.l;

public abstract class e extends DialogFragment implements OnTouchListener {
    private Dialog a;
    private View b;
    private int c;
    private boolean d = true;
    private boolean e = true;
    public OnDismissListener f;
    public OnCancelListener g;
    float h = 0.0f;
    private int i = 0;

    public e(int i) {
        this.i = i;
    }

    public void a(OnCancelListener onCancelListener) {
        this.g = onCancelListener;
    }

    public void a(OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    protected abstract void a(View view);

    public void a(boolean z) {
        this.e = z;
        if (this.d) {
            this.a.setCanceledOnTouchOutside(z);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.g != null) {
            this.g.onCancel(dialogInterface);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, i.BottomDialog);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = super.onCreateDialog(bundle);
        this.a.setCancelable(this.d);
        this.a.setCanceledOnTouchOutside(this.e);
        return this.a;
    }

    @r
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = layoutInflater.getContext();
        Log.d("Dialog", viewGroup + a.f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.c = displayMetrics.heightPixels;
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, CropOverlayView.a, displayMetrics);
        View linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(0);
        linearLayout.setOrientation(1);
        linearLayout.setOnTouchListener(this);
        linearLayout.setGravity(80);
        this.b = layoutInflater.inflate(this.i, null, false);
        linearLayout.addView(this.b, layoutParams);
        a(this.b);
        return linearLayout;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f != null) {
            this.f.onDismiss(dialogInterface);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int height = this.c - (this.b == null ? 0 : this.b.getHeight());
        switch (motionEvent.getAction()) {
            case kankan.wheel.widget.a.i /*0*/:
                this.h = motionEvent.getY();
                return this.h < ((float) height);
            case l.a /*1*/:
                float y = motionEvent.getY();
                if (this.h < ((float) height) && y < ((float) height) && this.d && this.e) {
                    dismiss();
                    return true;
                }
            case kankan.wheel.widget.a.k /*2*/:
                break;
            default:
                return false;
        }
        return true;
    }

    public void setCancelable(boolean z) {
        this.d = z;
        this.a.setCancelable(z);
        this.a.setCanceledOnTouchOutside(this.e);
    }
}
