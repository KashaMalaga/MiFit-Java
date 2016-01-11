package cn.com.smartdevices.bracelet.lab.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class CircleListScrollView extends HorizontalScrollView {
    private LinearLayout a;
    private int b;
    private int c;
    private Context d = null;

    public CircleListScrollView(Context context) {
        super(context);
        a(context);
    }

    public CircleListScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CircleListScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.d = context;
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(2);
        this.a = new LinearLayout(context);
        this.a.setLayoutParams(new LayoutParams(-1, -1));
        this.a.setGravity(17);
        addView(this.a);
        this.b = -1;
        b(c());
    }

    private void a(View view) {
        if (view != null) {
            int left = view.getLeft();
            int width = view.getWidth() + left;
            int scrollX = getScrollX();
            int width2 = getWidth() + scrollX;
            if (left > scrollX) {
                d(left);
            } else if (width < width2) {
                d((width - width2) + scrollX);
            }
        }
    }

    private void c(int i) {
        View d = d();
        if (d != null) {
            d.setActivated(false);
        }
        this.b = i;
        d = d();
        if (d != null) {
            d.setActivated(true);
        }
        requestLayout();
    }

    private View d() {
        return (this.b < 0 || this.b >= this.a.getChildCount()) ? null : this.a.getChildAt(this.b);
    }

    private void d(int i) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "scroll", new int[]{getScrollX(), i});
        ofInt.setDuration((long) this.c);
        ofInt.start();
    }

    protected void a() {
        a(d());
    }

    public void a(int i) {
        View inflate = View.inflate(this.d, n.activity_lab_sport_group_list_item, null);
        LabCircleView labCircleView = (LabCircleView) inflate.findViewById(l.group_item_member);
        labCircleView.a(String.valueOf(i));
        labCircleView.a(18.0f);
        labCircleView.b(this.d.getResources().getColor(i.lab_group_item_current_round));
        int childCount = this.a.getChildCount();
        if (childCount == 0) {
            inflate.findViewById(l.group_item_linker).setVisibility(8);
        }
        if (childCount >= 1) {
            ((LabCircleView) this.a.getChildAt(childCount - 1).findViewById(l.group_item_member)).b(this.d.getResources().getColor(17170443));
        }
        this.a.addView(inflate);
    }

    public void b() {
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.getChildAt(i);
            if (childAt != null && (childAt instanceof LabCircleView)) {
                ((LabCircleView) childAt).a();
            }
        }
        this.a.removeAllViews();
    }

    public void b(int i) {
        scrollTo(i, getScrollY());
    }

    public int c() {
        return getScrollX();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = this.a.getWidth();
        if (width > i3) {
            d(width);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (isHardwareAccelerated()) {
            int childCount = this.a.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                this.a.getChildAt(i5).invalidate();
            }
        }
    }
}
