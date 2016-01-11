package cn.com.smartdevices.bracelet.lua;

import android.support.v4.widget.bi;
import android.view.View;
import cn.com.smartdevices.bracelet.lua.ScrollSlidingUpPanelLayout.LayoutParams;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayoutSavedState.SlideState;

class k extends bi {
    final /* synthetic */ ScrollSlidingUpPanelLayout a;

    private k(ScrollSlidingUpPanelLayout scrollSlidingUpPanelLayout) {
        this.a = scrollSlidingUpPanelLayout;
    }

    public void a(int i) {
        int access$200 = (int) (this.a.mAnchorPoint * ((float) this.a.mSlideRange));
        if (this.a.mDragHelper.b() != 0) {
            return;
        }
        if (this.a.mSlideOffset == 0.0f) {
            if (this.a.mSlideState != SlideState.EXPANDED) {
                this.a.updateObscuredViewVisibility();
                this.a.dispatchOnPanelExpanded(this.a.mSlideableView);
                this.a.mSlideState = SlideState.EXPANDED;
            }
        } else if (this.a.mSlideOffset == ((float) access$200) / ((float) this.a.mSlideRange)) {
            if (this.a.mSlideState != SlideState.ANCHORED) {
                this.a.updateObscuredViewVisibility();
                this.a.dispatchOnPanelAnchored(this.a.mSlideableView);
                this.a.mSlideState = SlideState.ANCHORED;
            }
        } else if (this.a.mSlideState != SlideState.COLLAPSED) {
            this.a.dispatchOnPanelCollapsed(this.a.mSlideableView);
            this.a.mSlideState = SlideState.COLLAPSED;
        }
    }

    public void a(View view, float f, float f2) {
        this.a.isPressed = Boolean.valueOf(false);
        int access$1100 = this.a.mIsSlidingUp ? this.a.getSlidingTop() : this.a.getSlidingTop() - this.a.mSlideRange;
        if (this.a.mAnchorPoint != 0.0f) {
            float access$200 = this.a.mIsSlidingUp ? ((float) ((int) (this.a.mAnchorPoint * ((float) this.a.mSlideRange)))) / ((float) this.a.mSlideRange) : ((float) (this.a.mPanelHeight - (this.a.mPanelHeight - ((int) (this.a.mAnchorPoint * ((float) this.a.mSlideRange)))))) / ((float) this.a.mSlideRange);
            if (f2 > 0.0f || (f2 == 0.0f && this.a.mSlideOffset >= (1.0f + access$200) / 2.0f)) {
                access$1100 += this.a.mSlideRange;
            } else if (f2 == 0.0f && this.a.mSlideOffset < (1.0f + access$200) / 2.0f && this.a.mSlideOffset >= access$200 / 2.0f) {
                access$1100 = (int) (((float) access$1100) + (((float) this.a.mSlideRange) * this.a.mAnchorPoint));
            }
        } else if (f2 > 0.0f || (f2 == 0.0f && this.a.mSlideOffset > 0.5f)) {
            access$1100 += this.a.mSlideRange;
        }
        if (this.a.getPullDownDockEnable().booleanValue()) {
            access$200 = this.a.getSlideThreshhold();
            float slideThreshhold2 = this.a.getSlideThreshhold2();
            if (0.0f == access$200 || this.a.mSlideOffset <= access$200) {
                this.a.mDragHelper.a(view.getLeft(), access$1100);
            } else {
                this.a.mDragHelper.a(view.getLeft(), (int) (((float) (access$1100 - this.a.mSlideRange)) + (slideThreshhold2 * ((float) this.a.mSlideRange))));
            }
            this.a.invalidate();
            return;
        }
        this.a.mDragHelper.a(view.getLeft(), access$1100);
        this.a.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.a.onPanelDragged(i2);
        this.a.invalidate();
    }

    public boolean a(View view, int i) {
        return this.a.mIsUnableToDrag ? false : ((LayoutParams) view.getLayoutParams()).slideable;
    }

    public int b(View view) {
        return this.a.mSlideRange;
    }

    public int b(View view, int i, int i2) {
        int access$1100;
        int access$300;
        if (this.a.mIsSlidingUp) {
            access$1100 = this.a.getSlidingTop();
            access$300 = this.a.mSlideRange + access$1100;
        } else {
            access$300 = this.a.getPaddingTop();
            access$1100 = access$300 - this.a.mSlideRange;
        }
        return (i <= access$300 || this.a.mIsPullDownEnabled) ? Math.min(Math.max(i, access$1100), access$300 + this.a.getPullDownDistance()) : access$300;
    }

    public void b(View view, int i) {
        this.a.setAllChildrenVisible();
        this.a.isPressed = Boolean.valueOf(true);
    }
}
