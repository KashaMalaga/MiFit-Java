package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.R;

public class RotateLoadingLayout extends LoadingLayout {
    private Animation mAnimationDown;
    private Animation mAnimationUp;
    private final Drawable mDownArrow;
    AnimationListener mFooterToDownListener;
    AnimationListener mFooterToUpListener;
    AnimationListener mHeaderToDownListener;
    AnimationListener mHeaderToUpListener;
    private final Drawable mUpArrow;

    public RotateLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.mAnimationUp = null;
        this.mAnimationDown = null;
        this.mHeaderToUpListener = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                RotateLoadingLayout.this.mHeaderImage.setImageDrawable(RotateLoadingLayout.this.mUpArrow);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.mHeaderToDownListener = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                RotateLoadingLayout.this.mHeaderImage.setImageDrawable(RotateLoadingLayout.this.mDownArrow);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.mFooterToDownListener = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                RotateLoadingLayout.this.mHeaderImage.setImageDrawable(RotateLoadingLayout.this.mDownArrow);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.mFooterToUpListener = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                RotateLoadingLayout.this.mHeaderImage.setImageDrawable(RotateLoadingLayout.this.mUpArrow);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.mAnimationUp = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_up);
        this.mAnimationUp.setFillAfter(true);
        this.mAnimationUp.setFillBefore(false);
        this.mAnimationDown = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_down);
        this.mAnimationDown.setFillAfter(true);
        this.mAnimationDown.setFillBefore(false);
        this.mUpArrow = getResources().getDrawable(R.drawable.pullup);
        this.mDownArrow = getResources().getDrawable(R.drawable.pulldown);
    }

    protected int getDefaultDrawableResId(Mode mode) {
        return mode == Mode.PULL_FROM_START ? R.drawable.pulldown : R.drawable.pullup;
    }

    public void onLoadingDrawableSet(Drawable drawable) {
    }

    protected void onPullImpl(float f) {
    }

    protected void pullToRefreshImpl() {
        if (this.mMode == Mode.PULL_FROM_END) {
            this.mAnimationUp.setAnimationListener(this.mFooterToUpListener);
            this.mHeaderImage.startAnimation(this.mAnimationUp);
        } else if (this.mMode == Mode.PULL_FROM_START) {
            this.mAnimationDown.setAnimationListener(this.mHeaderToDownListener);
            this.mHeaderImage.startAnimation(this.mAnimationDown);
        }
    }

    protected void refreshingImpl() {
        this.mHeaderImage.setVisibility(8);
        this.mHeaderProgress.setVisibility(0);
    }

    protected void releaseToRefreshImpl() {
        if (this.mMode == Mode.PULL_FROM_END) {
            this.mAnimationDown.setAnimationListener(this.mFooterToDownListener);
            this.mHeaderImage.startAnimation(this.mAnimationDown);
        } else if (this.mMode == Mode.PULL_FROM_START) {
            this.mAnimationUp.setAnimationListener(this.mHeaderToUpListener);
            this.mHeaderImage.startAnimation(this.mAnimationUp);
        }
    }

    protected void resetImpl() {
        this.mHeaderImage.setVisibility(0);
        this.mHeaderProgress.setVisibility(8);
        this.mHeaderImage.clearAnimation();
    }
}
