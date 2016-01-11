package cn.com.smartdevices.bracelet.gps.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0151az;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.h.j;
import java.io.File;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

@SuppressLint({"NewApi"})
public class WatermarkBar extends HorizontalScrollView {
    private LinearLayout a;
    private Typeface b;
    private Context c;
    private bs d;
    private int e;
    private int f;
    private final OnClickListener g = new br(this);

    public class Watermark implements Parcelable {
        public static final Creator<Watermark> CREATOR = new bt();
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        public static final int i = 9;
        public static final int j = 10;
        public String k;
        public String l;
        public String m;
        public String n;
        public int o;
        public int p;
        public String q;
        public int r;
        public double s;
        public int t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeString(this.m);
            parcel.writeString(this.n);
            parcel.writeInt(this.o);
            parcel.writeInt(this.p);
            parcel.writeString(this.q);
            parcel.writeInt(this.r);
            parcel.writeDouble(this.s);
            parcel.writeInt(this.t);
            parcel.writeString(this.u);
            parcel.writeString(this.v);
            parcel.writeString(this.w);
            parcel.writeString(this.x);
            parcel.writeString(this.y);
        }
    }

    public WatermarkBar(Context context) {
        super(context);
        b();
    }

    public WatermarkBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public WatermarkBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void a(String str, String str2, int i) {
        View linearLayout = new LinearLayout(this.c);
        linearLayout.setTag(Integer.valueOf(i));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#262626"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(j.a(this.c, 1.0f), 0, j.a(this.c, 1.0f), 0);
        linearLayout.setLayoutParams(layoutParams);
        View imageView = new ImageView(this.c);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setImageURI(Uri.fromFile(new File(str2)));
        View textView = new TextView(this.c);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setText(str);
        View textView2 = new TextView(this.c);
        textView2.setId(100);
        textView2.setBackgroundColor(0);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(j.a(this.c, 80.0f), j.a(this.c, 80.0f));
        layoutParams2.gravity = 17;
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, j.a(this.c, 3.0f), 0, j.a(this.c, 3.0f));
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, j.a(this.c, 6.0f));
        linearLayout.addView(imageView, layoutParams2);
        linearLayout.addView(textView, layoutParams3);
        linearLayout.addView(textView2, layoutParams4);
        linearLayout.setOnClickListener(this.g);
        this.a.addView(linearLayout);
    }

    private void b() {
        this.c = getContext();
        setHorizontalScrollBarEnabled(false);
        this.a = new LinearLayout(this.c);
        this.a.setBackgroundColor(C0151az.s);
        addView(this.a, new FrameLayout.LayoutParams(-1, -2));
        this.b = Typeface.createFromAsset(this.c.getAssets(), "fonts/watermark_data_view_bold.otf");
    }

    private void b(String str, String str2, int i) {
        View linearLayout = new LinearLayout(this.c);
        linearLayout.setTag(Integer.valueOf(i));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#262626"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(j.a(this.c, 1.0f), 0, j.a(this.c, 1.0f), 0);
        linearLayout.setLayoutParams(layoutParams);
        View textView = new TextView(this.c);
        textView.setTextColor(-1);
        textView.setTextSize(32.0f);
        textView.setSingleLine();
        textView.setTypeface(this.b);
        textView.setGravity(17);
        textView.setText(str2);
        View textView2 = new TextView(this.c);
        textView2.setGravity(17);
        textView2.setTextColor(-1);
        textView2.setText(str);
        View textView3 = new TextView(this.c);
        textView3.setId(100);
        textView3.setBackgroundColor(0);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(j.a(this.c, 80.0f), j.a(this.c, 80.0f));
        layoutParams2.gravity = 17;
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, j.a(this.c, 3.0f), 0, j.a(this.c, 3.0f));
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, j.a(this.c, 6.0f));
        linearLayout.addView(textView, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        linearLayout.addView(textView3, layoutParams4);
        linearLayout.setOnClickListener(this.g);
        this.a.addView(linearLayout);
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
        LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(this.f);
        linearLayout.setBackgroundColor(Color.parseColor("#262626"));
        ((TextView) linearLayout.findViewById(100)).setBackgroundColor(0);
        linearLayout = (LinearLayout) this.a.getChildAt(i);
        linearLayout.setBackgroundColor(Color.parseColor("#181818"));
        ((TextView) linearLayout.findViewById(100)).setBackgroundColor(Color.parseColor("#00C300"));
        this.f = i;
        if (this.e >= 1) {
            scrollTo(j.a(this.c, (float) ((this.e - 1) * 82)), 0);
        }
    }

    public void a(bs bsVar) {
        this.d = bsVar;
    }

    public void a(List<Watermark> list) {
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                setVisibility(0);
                for (int i = 0; i < size; i++) {
                    Watermark watermark = (Watermark) list.get(i);
                    watermark.p = i;
                    String str = watermark.k;
                    int i2 = watermark.p;
                    switch (watermark.o) {
                        case l.a /*1*/:
                            a(str, watermark.l, i2);
                            break;
                        case a.k /*2*/:
                            a(str, watermark.m, i2);
                            break;
                        case a.l /*3*/:
                            b(str, watermark.w, i2);
                            break;
                        case a.aQ /*4*/:
                            b(str, "06:18", i2);
                            break;
                        case a.X /*5*/:
                            b(str, "06:18", i2);
                            break;
                        case a.bt /*6*/:
                            b(str, "06:18", i2);
                            break;
                        case a.bc /*7*/:
                            b(str, "06:18", i2);
                            break;
                        case a.ba /*8*/:
                            b(str, "06:18", i2);
                            break;
                        case a.bo /*9*/:
                            b(str, "06:18", i2);
                            break;
                        case a.bd /*10*/:
                            b(str, "06:18", i2);
                            break;
                        default:
                            break;
                    }
                }
                a(this.e);
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }
}
