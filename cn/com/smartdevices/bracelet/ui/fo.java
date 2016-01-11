package cn.com.smartdevices.bracelet.ui;

import android.support.v4.view.C0151az;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.com.smartdevices.bracelet.Utils;

class fo extends ClickableSpan {
    final /* synthetic */ fn a;

    fo(fn fnVar) {
        this.a = fnVar;
    }

    public void onClick(View view) {
        Utils.r(this.a.getActivity());
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(C0151az.s);
        textPaint.setUnderlineText(true);
    }
}
