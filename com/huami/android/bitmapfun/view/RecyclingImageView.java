package com.huami.android.bitmapfun.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huami.android.bitmapfun.D;

public class RecyclingImageView extends ImageView {
    public RecyclingImageView(Context context) {
        super(context);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void a(Drawable drawable, boolean z) {
        if (drawable instanceof D) {
            ((D) drawable).a(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                a(layerDrawable.getDrawable(i), z);
            }
        }
    }

    protected void onDetachedFromWindow() {
        setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        a(drawable, true);
        a(drawable2, false);
    }
}
