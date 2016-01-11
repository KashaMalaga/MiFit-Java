package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView.ScaleType;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.R;
import kankan.wheel.widget.l;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout extends LoadingLayout {
    static final int FLIP_ANIMATION_DURATION = 150;
    private final Animation mResetRotateAnimation;
    private final Animation mRotateAnimation;

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[Mode.values().length];

        static {
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public FlipLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i = mode == Mode.PULL_FROM_START ? -180 : a.i;
        this.mRotateAnimation = new RotateAnimation(0.0f, (float) i, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(150);
        this.mRotateAnimation.setFillAfter(true);
        this.mResetRotateAnimation = new RotateAnimation((float) i, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mResetRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mResetRotateAnimation.setDuration(150);
        this.mResetRotateAnimation.setFillAfter(true);
    }

    private float getDrawableRotationAngle() {
        switch (AnonymousClass1.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mMode.ordinal()]) {
            case l.a /*1*/:
                return this.mScrollDirection == Orientation.HORIZONTAL ? 90.0f : BitmapDescriptorFactory.HUE_CYAN;
            case kankan.wheel.widget.a.k /*2*/:
                return this.mScrollDirection == Orientation.HORIZONTAL ? BitmapDescriptorFactory.HUE_VIOLET : 0.0f;
            default:
                return 0.0f;
        }
    }

    protected int getDefaultDrawableResId(Mode mode) {
        return R.drawable.default_ptr_flip;
    }

    protected void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            LayoutParams layoutParams = this.mHeaderImage.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.mHeaderImage.requestLayout();
            this.mHeaderImage.setScaleType(ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(((float) (layoutParams.width - intrinsicWidth)) / 2.0f, ((float) (layoutParams.height - intrinsicHeight)) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), ((float) layoutParams.width) / 2.0f, ((float) layoutParams.height) / 2.0f);
            this.mHeaderImage.setImageMatrix(matrix);
        }
    }

    protected void onPullImpl(float f) {
    }

    protected void pullToRefreshImpl() {
        if (this.mRotateAnimation == this.mHeaderImage.getAnimation()) {
            this.mHeaderImage.startAnimation(this.mResetRotateAnimation);
        }
    }

    protected void refreshingImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderImage.setVisibility(4);
        this.mHeaderProgress.setVisibility(0);
    }

    protected void releaseToRefreshImpl() {
        this.mHeaderImage.startAnimation(this.mRotateAnimation);
    }

    protected void resetImpl() {
        this.mHeaderImage.clearAnimation();
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.setVisibility(0);
    }
}
