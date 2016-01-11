package cn.com.smartdevices.bracelet.chart.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypefaceTextView extends TextView {
    public TypefaceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c.a().a(this, context, attributeSet);
    }

    public void a(d dVar) {
        c.a().a((TextView) this, dVar);
    }
}
