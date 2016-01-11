package com.huami.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class SquareView extends View {
    public SquareView(Context context) {
        super(context);
    }

    public SquareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= measuredHeight) {
            measuredHeight = measuredWidth;
        }
        measuredHeight = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        super.onMeasure(measuredHeight, measuredHeight);
    }
}
