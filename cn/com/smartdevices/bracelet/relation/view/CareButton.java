package cn.com.smartdevices.bracelet.relation.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.relation.A;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.r;

public class CareButton extends RelativeLayout implements OnClickListener {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final int d = 10;
    private static final int e = 10;
    private final TextView f;
    private final ProgressBar g;
    private final String h;
    private int i;
    private boolean j;
    private A k;
    private OnClickListener l;
    private int m;
    private b n;

    public CareButton(Context context) {
        this(context, null);
    }

    public CareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a);
    }

    public CareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = a;
        this.j = true;
        this.k = A.a();
        this.m = a;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setGravity(16);
        this.f = new TextView(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) TypedValue.applyDimension(b, 10.0f, displayMetrics);
        layoutParams.addRule(13);
        this.h = context.getString(r.button_send_care);
        this.f.setText(this.h);
        this.f.setTextColor(Color.parseColor("#d3ffffff"));
        this.f.setTextSize(c, 13.3f);
        addView(this.f, layoutParams);
        this.f.setEnabled(false);
        this.f.setId(l.care_button_label);
        int applyDimension = (int) TypedValue.applyDimension(b, 18.0f, displayMetrics);
        this.g = new ProgressBar(context);
        layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(a, l.care_button_label);
        layoutParams.addRule(15);
        addView(this.g, layoutParams);
        this.g.setIndeterminateDrawable(context.getResources().getDrawable(k.button_progress));
        this.g.setEnabled(false);
        this.g.setVisibility(8);
        super.setOnClickListener(this);
    }

    private void a(int i) {
        if (i == 0) {
            this.i = a;
            if (this.n != null) {
                this.n.a(this, a);
            }
            this.f.setText(this.h);
            this.m = a;
            setEnabled(true);
            return;
        }
        this.f.setText(this.h + " (" + i + "s)");
        postDelayed(new a(this, i), 1000);
    }

    public void a() {
        this.g.setVisibility(8);
        if (this.m <= e) {
            setEnabled(true);
        }
        this.i = a;
    }

    public void a(b bVar) {
        this.n = bVar;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void onClick(View view) {
        if (A.a().a(getContext())) {
            if (this.i != b) {
                this.m += b;
                if (this.m > e) {
                    setEnabled(false);
                    this.i = c;
                    if (this.n != null) {
                        this.n.a(this, c);
                    }
                    a((int) e);
                    return;
                }
                if (this.l != null) {
                    this.l.onClick(view);
                }
                if (this.j) {
                    this.g.setVisibility(a);
                    this.i = b;
                }
                if (this.n != null) {
                    this.n.a(this, b);
                }
            }
        } else if (this.l != null) {
            this.l.onClick(view);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.l = onClickListener;
    }
}
