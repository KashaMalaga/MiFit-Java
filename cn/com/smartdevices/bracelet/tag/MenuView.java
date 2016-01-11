package cn.com.smartdevices.bracelet.tag;

import android.content.Context;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class MenuView extends GridView {
    public MenuView(Context context) {
        super(context);
    }

    public MenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE, af.a));
    }
}
