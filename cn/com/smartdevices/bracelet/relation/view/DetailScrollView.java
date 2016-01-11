package cn.com.smartdevices.bracelet.relation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import kankan.wheel.widget.a;

public class DetailScrollView extends ScrollView {
    private float a;
    private float b;

    public DetailScrollView(Context context) {
        super(context);
    }

    public DetailScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DetailScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                break;
            case a.k /*2*/:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float abs = Math.abs(x - this.a);
                float abs2 = Math.abs(y - this.b);
                this.a = x;
                this.b = y;
                return abs2 > abs && abs2 > 10.0f;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
