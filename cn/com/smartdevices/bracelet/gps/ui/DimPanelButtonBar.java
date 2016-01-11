package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.b.a.f;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.b.a.i;
import com.xiaomi.hm.health.b.a.j;
import com.xiaomi.hm.health.b.a.p;

public class DimPanelButtonBar extends FrameLayout {
    private static final String a = "dark";
    private final TextView b;
    private final TextView c;

    public DimPanelButtonBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DimPanelButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(j.dialog_button_bar, this);
        this.c = (TextView) findViewById(i.left_button);
        this.b = (TextView) findViewById(i.right_button);
        View findViewById = findViewById(i.bottom_bar_frame);
        View findViewById2 = findViewById(i.bottom_bar_frame_split);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.DimPanelFragmentBottomBar);
        CharSequence string = obtainStyledAttributes.getString(p.DimPanelFragmentBottomBar_left_text);
        CharSequence string2 = obtainStyledAttributes.getString(p.DimPanelFragmentBottomBar_right_text);
        int color = obtainStyledAttributes.getColor(p.DimPanelFragmentBottomBar_left_text_color, getResources().getColor(f.main_ui_title_color));
        int color2 = obtainStyledAttributes.getColor(p.DimPanelFragmentBottomBar_right_text_color, getResources().getColor(f.main_ui_title_color));
        String string3 = obtainStyledAttributes.getString(p.DimPanelFragmentBottomBar_show_style);
        C0596r.e(getClass().getName(), "left:" + string + ", right:" + string2);
        int i2 = h.click_btn_bg_3;
        int i3 = h.click_btn_bg_3_left_round;
        int i4 = h.click_btn_bg_3_right_round;
        if (a.equals(string3)) {
            i2 = h.click_btn_bg;
            i3 = h.click_btn_bg_left_round;
            i4 = h.click_btn_bg_right_round;
            findViewById2.setBackgroundResource(f.content_color);
        }
        if (TextUtils.isEmpty(string)) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(string);
            this.c.setVisibility(0);
            this.c.setBackgroundResource(i2);
        }
        if (TextUtils.isEmpty(string2)) {
            this.b.setVisibility(8);
        } else {
            this.b.setText(string2);
            this.b.setVisibility(0);
            this.b.setBackgroundResource(i2);
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            findViewById2.setVisibility(8);
            findViewById.setBackgroundResource(f.trans);
        } else {
            findViewById2.setVisibility(0);
            findViewById.setBackgroundResource(i2);
            this.b.setBackgroundResource(i4);
            this.c.setBackgroundResource(i3);
        }
        this.c.setTextColor(color);
        this.b.setTextColor(color2);
        obtainStyledAttributes.recycle();
    }

    public void a(int i) {
        this.c.setTextColor(i);
    }

    public void b(int i) {
        this.b.setTextColor(i);
    }
}
