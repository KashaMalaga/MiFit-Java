package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import com.xiaomi.hm.health.j;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import java.util.Iterator;
import java.util.List;

public class WeightUserQuickPicker extends FrameLayout {
    private static final int a = 6;
    private RecyclerView b;
    private ac c;
    private LinearLayoutManager d;
    private int e;
    private ab f;
    private int g;
    private boolean h;

    public WeightUserQuickPicker(Context context) {
        this(context, null, 0);
    }

    public WeightUserQuickPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeightUserQuickPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(context, n.view_weight_user_picker, this);
        this.b = (RecyclerView) findViewById(l.user_list);
        this.b.a(true);
        this.d = new LinearLayoutManager(context, 0, false);
        this.b.a(this.d);
        this.e = getResources().getDimensionPixelSize(j.statistic_weight_user_picker_item_padding);
        this.b.a(new aa(this));
        this.b.setHorizontalFadingEdgeEnabled(true);
        this.b.setFadingEdgeLength(this.e * 3);
    }

    public void a(int i) {
        this.g = i;
        this.c.d();
    }

    public void a(int i, int i2) {
        this.g = i;
        this.c.c(i2);
        this.c.c(this.g);
    }

    public void a(ab abVar) {
        this.f = abVar;
    }

    public void a(List<UserInfo> list) {
        this.c = new ac(this, list);
        this.b.a(this.c);
    }

    public boolean a() {
        return this.h;
    }

    public void b() {
        if (this.c.a() > 1) {
            int childCount = this.b.getChildCount();
            float f = -t.a(getContext(), 50.0f);
            for (int i = 0; i < childCount; i++) {
                View childAt = this.b.getChildAt(i);
                childAt.setTranslationX(((float) i) * f);
                if (i != childCount - 1) {
                    childAt.setAlpha((((float) i) * 0.08f) + 0.3f);
                }
            }
            this.h = true;
        }
    }

    public void b(int i) {
        Iterator it = this.c.b.iterator();
        int i2 = 0;
        while (it.hasNext() && ((UserInfo) it.next()).uid != i) {
            i2++;
        }
        a(i2);
        if (i2 >= a) {
            this.d.e(i2);
        }
    }

    public void c() {
        if (this.c.a() > 1) {
            int childCount = this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.b.getChildAt(i);
                childAt.setTranslationX(0.0f);
                childAt.setAlpha(1.0f);
            }
            this.h = false;
        }
    }
}
