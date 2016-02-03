package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.xiaomi.hm.health.R;

class fp implements OnCheckedChangeListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ fn b;

    fp(fn fnVar, TextView textView) {
        this.b = fnVar;
        this.a = textView;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.b.c = true;
            this.a.setTextColor(this.b.getResources().getColor(R.color.main_ui_title_color));
            return;
        }
        this.b.c = false;
        this.a.setTextColor(this.b.getResources().getColor(R.color.main_ui_content_color));
    }
}
