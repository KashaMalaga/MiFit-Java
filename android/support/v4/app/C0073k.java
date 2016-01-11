package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class C0073k {
    public Method a;
    public Method b;
    public ImageView c;

    C0073k(Activity activity) {
        try {
            this.a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
            this.b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            View findViewById = activity.findViewById(16908332);
            if (findViewById != null) {
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() == 2) {
                    View childAt = viewGroup.getChildAt(0);
                    findViewById = viewGroup.getChildAt(1);
                    if (childAt.getId() != 16908332) {
                        findViewById = childAt;
                    }
                    if (findViewById instanceof ImageView) {
                        this.c = (ImageView) findViewById;
                    }
                }
            }
        }
    }
}
