package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.t;

public class WeightView extends LinearLayout {
    private WeightProgressBar a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;

    public WeightView(Context context) {
        this(context, null);
    }

    public WeightView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        LayoutInflater.from(context).inflate(n.view_weight_std, this);
        this.a = (WeightProgressBar) findViewById(l.weight_pb);
        this.b = (TextView) findViewById(l.weight_value_tv);
        this.c = (TextView) findViewById(l.weight_unit_tv);
        this.d = (TextView) findViewById(l.weight_bmi_tv);
        this.e = (TextView) findViewById(l.weight_tips_tv);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.WeightView);
        b(obtainStyledAttributes.getDimension(0, 20.0f));
        e(obtainStyledAttributes.getDimension(7, 40.0f));
        f(obtainStyledAttributes.getDimension(10, 12.0f));
        g(obtainStyledAttributes.getDimension(13, 12.0f));
        h(obtainStyledAttributes.getDimension(16, 13.0f));
        a(obtainStyledAttributes.getColor(1, -10919831));
        c(obtainStyledAttributes.getColor(2, -1));
        d(0);
        b(obtainStyledAttributes.getColor(3, -8476672));
        e(obtainStyledAttributes.getColor(6, -1));
        f(obtainStyledAttributes.getColor(9, -4078651));
        g(obtainStyledAttributes.getColor(12, -6446940));
        h(obtainStyledAttributes.getColor(15, -1973533));
        a(obtainStyledAttributes.getFloat(4, CropOverlayView.a));
        c(obtainStyledAttributes.getFloat(5, 0.0f));
        String string = obtainStyledAttributes.getString(8);
        if (string != null) {
            a(string);
        }
        string = obtainStyledAttributes.getString(11);
        if (string != null) {
            b(string);
        }
        string = obtainStyledAttributes.getString(14);
        if (string != null) {
            c(string);
        }
        obtainStyledAttributes.recycle();
    }

    public void a(float f) {
        this.a.c(f);
    }

    public void a(int i) {
        this.a.b(i);
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void b(float f) {
        this.a.d(f);
    }

    public void b(int i) {
        this.a.a(i);
    }

    public void b(String str) {
        this.d.setText(str);
    }

    public void c(float f) {
        this.a.a(f);
        this.b.setText(a.f + f);
    }

    public void c(int i) {
        this.a.c(i);
    }

    public void c(String str) {
        this.e.setText(str);
    }

    public void d(float f) {
        this.a.b(f);
    }

    public void d(int i) {
        this.a.d(i);
    }

    public void e(float f) {
        this.b.setTextSize(f);
    }

    public void e(int i) {
        this.b.setTextColor(i);
    }

    public void f(float f) {
        this.c.setTextSize(f);
    }

    public void f(int i) {
        this.c.setTextColor(i);
    }

    public void g(float f) {
        this.d.setTextSize(f);
    }

    public void g(int i) {
        this.d.setTextColor(i);
    }

    public void h(float f) {
        this.e.setTextSize(f);
    }

    public void h(int i) {
        this.e.setTextColor(i);
    }
}
