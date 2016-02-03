package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;

public class HoriRulerView extends FrameLayout {
    private static final String a = "HoriRulerView";
    private RulerScrollView b;
    private View c;
    private LayoutInflater d;
    private String e;
    private int f = 50;
    private int g = 80;

    public HoriRulerView(Context context) {
        super(context);
    }

    public HoriRulerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = LayoutInflater.from(context);
        this.d.inflate(R.layout.ruler_frame, this);
        this.b = (RulerScrollView) findViewById(R.id.ruler_scroller_view);
        this.c = findViewById(R.id.ruler_indicator);
        this.b.a(this.c);
    }

    public HoriRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public float a() {
        return this.b.b();
    }

    public void a(int i) {
        this.b.a(i);
    }

    public void a(int i, int i2, int i3, String str) {
        this.f = i;
        this.g = i2;
        this.e = str;
        while (i < i2) {
            View inflate = this.d.inflate(R.layout.ruler_item, null);
            ((TextView) inflate.findViewById(R.id.ruler_txt)).setText(a.f + i);
            addView(inflate);
            i += i3;
        }
        C0596r.e(a, "initRuler");
        this.b.a(this.f, this.g, str);
    }

    public void addView(View view) {
        this.b.addView(view);
    }

    public int b() {
        return this.b.a();
    }
}
