package cn.com.smartdevices.bracelet.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.com.smartdevices.bracelet.Utils;

class o extends ClickableSpan {
    final /* synthetic */ LoginActivity a;

    o(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void onClick(View view) {
        Utils.r(this.a.p);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(-1);
        textPaint.setUnderlineText(true);
    }
}
