package cn.com.smartdevices.bracelet.gps.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.h.m;
import cn.com.smartdevices.bracelet.gps.services.aa;
import cn.com.smartdevices.bracelet.gps.ui.WatermarkBar.Watermark;
import com.xiaomi.hm.health.b.a.g;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.n;
import kankan.wheel.widget.a;

@SuppressLint({"NewApi"})
public class WatermarkFragment extends Fragment {
    private static final String a = "WatermarkFragment";
    private static final String b = "key_watermark";
    private WatermarkActivity A;
    private Resources B;
    private boolean C = false;
    private final String D = m.a;
    private int E;
    private int F;
    private String G;
    private TextView H;
    private final OnTouchListener I = new bz(this);
    private Watermark c;
    private Context d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private TextView j;
    private ImageView k;
    private RelativeLayout l;
    private RelativeLayout m = null;
    private LayoutParams n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public class WatermarkTag extends RelativeLayout implements OnClickListener {
        public static final int a = 2000;
        public static final int b = 2001;
        public static final int c = 2002;
        private static final String e = "WatermarkTag";
        public final OnTouchListener d = new bD(this);
        private RelativeLayout f;
        private int g;
        private int h;
        private int i;
        private int j;
        private final bC k = new bC();

        public WatermarkTag(Context context) {
            super(context);
        }

        public WatermarkTag(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public WatermarkTag(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public WatermarkTag a(String str) {
            bC bCVar = new bC();
            this.f = new RelativeLayout(getContext());
            View textView = new TextView(getContext());
            textView.setId(a);
            textView.setBackgroundColor(Color.parseColor("#70000000"));
            textView.setText(str);
            this.f.setClickable(true);
            this.f.setOnTouchListener(this.d);
            this.f.setOnClickListener(this);
            this.f.addView(textView);
            this.f.setTag(bCVar);
            addView(this.f);
            return this;
        }

        public void a(bC bCVar) {
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case a /*2000*/:
                    Log.i(e, "TEXT CLICK");
                    return;
                default:
                    return;
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag == null) {
                        super.onLayout(z, i, childCount, i3, i4);
                    } else if (tag instanceof bC) {
                        bC bCVar = (bC) tag;
                        childAt.layout(bCVar.a, bCVar.b, bCVar.c, bCVar.d);
                    } else {
                        super.onLayout(z, i, childCount, i3, i4);
                    }
                }
            }
        }
    }

    public static WatermarkFragment a(Watermark watermark) {
        WatermarkFragment watermarkFragment = new WatermarkFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(b, watermark);
        watermarkFragment.setArguments(bundle);
        return watermarkFragment;
    }

    private void d() {
        if (this.C) {
            this.u = this.B.getDimensionPixelSize(g.watermark_guide_tips_w);
            this.v = this.B.getDimensionPixelSize(g.watermark_guide_tips_h);
            this.w = this.B.getDimensionPixelSize(g.watermark_guide_tips_margin_bottom);
            this.x = (this.s - this.w) - this.v;
            this.y = (this.o / 2) - (this.u / 2);
            this.m.setBackgroundColor(Color.parseColor("#50000000"));
            this.H = new TextView(getActivity());
            this.H.setTextSize(2, 11.0f);
            this.H.setTextColor(Color.parseColor("#FFFFFF"));
            this.H.setBackgroundResource(h.running_click_btn_bg_dark_corners);
            this.H.setText(n.running_watermark_guide_tips);
            this.H.setGravity(17);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(this.u, this.v);
            layoutParams.topMargin = this.x;
            layoutParams.leftMargin = this.y;
            this.m.addView(this.H, layoutParams);
            this.l.setBackgroundResource(h.watermark_dotted_line);
        }
    }

    private void e() {
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        layoutParams.addRule(14);
        this.l.setLayoutParams(layoutParams);
        int measuredWidth = (this.j.getMeasuredWidth() + this.f.getMeasuredWidth()) + this.E;
        int width = (this.k.getWidth() + this.g.getMeasuredWidth()) + this.F;
        if (measuredWidth >= width) {
            this.z = measuredWidth;
        } else {
            this.z = width;
        }
        ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
        layoutParams2.width = this.z;
        this.h.setLayoutParams(layoutParams2);
        layoutParams2 = this.i.getLayoutParams();
        layoutParams2.width = this.z;
        this.i.setLayoutParams(layoutParams2);
    }

    private void f() {
        if (this.g != null) {
            this.g.setText(TextUtils.isEmpty(this.G) ? getString(n.running_share_to_title) : this.G);
            e();
        }
    }

    public void a() {
        if (this.C) {
            this.m.setBackgroundColor(Color.parseColor("#00000000"));
            this.H.setVisibility(8);
            this.l.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    void a(String str) {
        this.G = str;
        if (!TextUtils.isEmpty(this.G)) {
            f();
        }
    }

    public boolean a(aa aaVar) {
        if (aaVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.G)) {
            aaVar.a(getActivity(), new bA(this), false);
            return false;
        }
        a(this.G);
        return true;
    }

    public void b() {
        if (this.l != null) {
            LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
            layoutParams.topMargin = this.s;
            layoutParams.leftMargin = this.t;
            this.l.setLayoutParams(layoutParams);
        }
    }

    void c() {
        if (TextUtils.isEmpty(this.G) && this.g != null) {
            this.g.setText(getString(n.running_share_to_title));
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.A = (WatermarkActivity) activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = (Watermark) arguments.getParcelable(b);
        }
        this.d = getActivity();
        this.C = m.a(this.d, m.a);
        this.B = getResources();
        a(this.A.c());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        switch (this.c.o) {
            case a.k /*2*/:
                this.m = (RelativeLayout) layoutInflater.inflate(j.fragment_watermark_camera_line, null);
                this.o = this.A.b();
                this.p = this.A.i_();
                this.E = this.B.getDimensionPixelSize(g.watermark_line_km_margin_r);
                this.F = this.B.getDimensionPixelSize(g.watermark_line_locogo_pr);
                this.l = (RelativeLayout) this.m.findViewById(i.rl_drag_line);
                this.e = (ImageView) this.m.findViewById(i.watermark_line_icon);
                this.f = (TextView) this.m.findViewById(i.tv_km_value);
                this.j = (TextView) this.m.findViewById(i.tv_km_unit);
                this.k = (ImageView) this.m.findViewById(i.iv_watermark_local);
                this.g = (TextView) this.m.findViewById(i.tv_location);
                this.h = this.m.findViewById(i.line1);
                this.i = this.m.findViewById(i.line2);
                this.e.setImageURI(Uri.parse(this.c.m));
                this.f.setText(this.c.v);
                this.l.getViewTreeObserver().addOnGlobalLayoutListener(new bB(this));
                break;
        }
        return this.m;
    }

    public void onResume() {
        super.onResume();
    }
}
