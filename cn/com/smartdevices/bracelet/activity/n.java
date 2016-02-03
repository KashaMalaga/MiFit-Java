package cn.com.smartdevices.bracelet.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.f.d;
import com.xiaomi.hm.health.R;

class n extends ClickableSpan {
    final /* synthetic */ LoginActivity a;

    n(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void onClick(View view) {
        d.a(this.a.p, false);
        C0401a.a(this.a.getApplicationContext(), C0401a.be, C0401a.cc);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.a.getResources().getColor(R.color.content_color));
        textPaint.setUnderlineText(true);
    }
}
