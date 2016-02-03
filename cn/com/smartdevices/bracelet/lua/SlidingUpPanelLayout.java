package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.C0151az;
import android.support.v4.widget.bf;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayoutSavedState.SlideState;
import com.e.c.a.a;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.l;

public class SlidingUpPanelLayout extends ViewGroup {
    private static final int[] DEFAULT_ATTRS = new int[]{16842927};
    private static final int DEFAULT_FADE_COLOR = -1728053248;
    private static final int DEFAULT_MIN_FLING_VELOCITY = 400;
    private static final boolean DEFAULT_OVERLAY_FLAG = false;
    private static final int DEFAULT_PANEL_HEIGHT = 68;
    private static final int DEFAULT_PARALAX_OFFSET = 0;
    private static final int DEFAULT_SHADOW_HEIGHT = 4;
    private static final int ONE_PAGE_ITEMS = 8;
    private static final String TAG = "SlidingUpPanelLayout";
    private Boolean isPressed;
    private BaseAdapter listAdapter;
    private float mAnchorPoint;
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private final Paint mCoveredFadePaint;
    private final bf mDragHelper;
    private View mDragView;
    private int mDragViewResId;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsPullDownEnabled;
    private boolean mIsSlidingEnabled;
    private boolean mIsSlidingUp;
    private boolean mIsUnableToDrag;
    private boolean mIsUsingDragViewTouchEvents;
    private View mMainView;
    private int mMinFlingVelocity;
    private boolean mOverlayContent;
    private int mPanelHeight;
    private PanelSlideListener mPanelSlideListener;
    private int mParalaxOffset;
    private final int mScrollTouchSlop;
    private final Drawable mShadowDrawable;
    private int mShadowHeight;
    private float mSlideOffset;
    private int mSlideRange;
    private SlideState mSlideState;
    private View mSlideableView;
    private final Rect mTmpRect;

    public interface PanelSlideListener {
        int onGetPullDownDistance();

        Boolean onGetPullDownDockEnable();

        float onGetThreshhold();

        float onGetThreshhold2();

        void onLastSlideOffset(View view, float f);

        void onPanelAnchored(View view);

        void onPanelCollapsed(View view);

        void onPanelExpanded(View view);

        void onPanelSlide(View view, Boolean bool, float f);
    }

    public class LayoutParams extends MarginLayoutParams {
        private static final int[] ATTRS = new int[]{16843137};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context.obtainStyledAttributes(attributeSet, ATTRS).recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class SimplePanelSlideListener implements PanelSlideListener {
        public int onGetPullDownDistance() {
            return SlidingUpPanelLayout.DEFAULT_PARALAX_OFFSET;
        }

        public Boolean onGetPullDownDockEnable() {
            return Boolean.valueOf(true);
        }

        public float onGetThreshhold() {
            return 0.0f;
        }

        public float onGetThreshhold2() {
            return 0.0f;
        }

        public void onLastSlideOffset(View view, float f) {
        }

        public void onPanelAnchored(View view) {
        }

        public void onPanelCollapsed(View view) {
        }

        public void onPanelExpanded(View view) {
        }

        public void onPanelSlide(View view, Boolean bool, float f) {
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, DEFAULT_PARALAX_OFFSET);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMinFlingVelocity = DEFAULT_MIN_FLING_VELOCITY;
        this.mCoveredFadeColor = DEFAULT_FADE_COLOR;
        this.mCoveredFadePaint = new Paint();
        this.mPanelHeight = -1;
        this.mShadowHeight = -1;
        this.mParalaxOffset = -1;
        this.mOverlayContent = DEFAULT_OVERLAY_FLAG;
        this.mDragViewResId = -1;
        this.mSlideState = SlideState.COLLAPSED;
        this.mAnchorPoint = 0.0f;
        this.mIsPullDownEnabled = true;
        this.isPressed = Boolean.valueOf(DEFAULT_OVERLAY_FLAG);
        this.listAdapter = null;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        if (isInEditMode()) {
            this.mShadowDrawable = null;
            this.mScrollTouchSlop = DEFAULT_PARALAX_OFFSET;
            this.mDragHelper = null;
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DEFAULT_ATTRS);
            if (obtainStyledAttributes != null) {
                int i2 = obtainStyledAttributes.getInt(DEFAULT_PARALAX_OFFSET, DEFAULT_PARALAX_OFFSET);
                if (i2 == 48 || i2 == 80) {
                    this.mIsSlidingUp = i2 == 80 ? true : DEFAULT_OVERLAY_FLAG;
                } else {
                    throw new IllegalArgumentException("gravity must be set to either top or bottom");
                }
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, t.SlidingUpPanelLayout);
            if (obtainStyledAttributes2 != null) {
                this.mPanelHeight = obtainStyledAttributes2.getDimensionPixelSize(DEFAULT_PARALAX_OFFSET, -1);
                this.mShadowHeight = obtainStyledAttributes2.getDimensionPixelSize(1, -1);
                this.mParalaxOffset = obtainStyledAttributes2.getDimensionPixelSize(2, -1);
                this.mMinFlingVelocity = obtainStyledAttributes2.getInt(DEFAULT_SHADOW_HEIGHT, DEFAULT_MIN_FLING_VELOCITY);
                this.mCoveredFadeColor = obtainStyledAttributes2.getColor(3, DEFAULT_FADE_COLOR);
                this.mDragViewResId = obtainStyledAttributes2.getResourceId(5, -1);
                this.mOverlayContent = obtainStyledAttributes2.getBoolean(6, DEFAULT_OVERLAY_FLAG);
                this.mIsUsingDragViewTouchEvents = obtainStyledAttributes2.getBoolean(7, true);
            }
            obtainStyledAttributes2.recycle();
        }
        float f = context.getResources().getDisplayMetrics().density;
        if (this.mPanelHeight == -1) {
            this.mPanelHeight = (int) ((68.0f * f) + 0.5f);
        }
        if (this.mShadowHeight == -1) {
            this.mShadowHeight = (int) ((4.0f * f) + 0.5f);
        }
        if (this.mParalaxOffset == -1) {
            this.mParalaxOffset = (int) (0.0f * f);
        }
        if (this.mShadowHeight <= 0) {
            this.mShadowDrawable = null;
        } else if (this.mIsSlidingUp) {
            this.mShadowDrawable = getResources().getDrawable(R.drawable.above_shadow);
        } else {
            this.mShadowDrawable = getResources().getDrawable(R.drawable.below_shadow);
        }
        setWillNotDraw(DEFAULT_OVERLAY_FLAG);
        this.mDragHelper = bf.a((ViewGroup) this, 0.5f, new m());
        this.mDragHelper.a(f * ((float) this.mMinFlingVelocity));
        this.mCanSlide = true;
        this.mIsSlidingEnabled = true;
        this.mScrollTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean collapsePane(View view, int i) {
        return (this.mFirstLayout || smoothSlideTo(1.0f, i)) ? true : DEFAULT_OVERLAY_FLAG;
    }

    private boolean expandPane(View view, int i, float f) {
        return (this.mFirstLayout || smoothSlideTo(f, i)) ? true : DEFAULT_OVERLAY_FLAG;
    }

    private int getSlidingTop() {
        return this.mSlideableView != null ? this.mIsSlidingUp ? (getMeasuredHeight() - getPaddingBottom()) - this.mSlideableView.getMeasuredHeight() : getPaddingTop() : getMeasuredHeight() - getPaddingBottom();
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        return (background == null || background.getOpacity() != -1) ? DEFAULT_OVERLAY_FLAG : true;
    }

    private boolean innerListViewNeedSlide(float f) {
        return (this.mInitialMotionY - f <= ((float) this.mScrollTouchSlop) || this.listAdapter.getCount() < ONE_PAGE_ITEMS) ? DEFAULT_OVERLAY_FLAG : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isDragViewUnder(int r9, int r10) {
        /*
        r8 = this;
        r4 = 2;
        r0 = 1;
        r1 = 0;
        r2 = r8.mDragView;
        if (r2 == 0) goto L_0x000c;
    L_0x0007:
        r2 = r8.mDragView;
    L_0x0009:
        if (r2 != 0) goto L_0x000f;
    L_0x000b:
        return r1;
    L_0x000c:
        r2 = r8.mSlideableView;
        goto L_0x0009;
    L_0x000f:
        r3 = new int[r4];
        r2.getLocationOnScreen(r3);
        r4 = new int[r4];
        r8.getLocationOnScreen(r4);
        r5 = r4[r1];
        r5 = r5 + r9;
        r4 = r4[r0];
        r4 = r4 + r10;
        r6 = r3[r1];
        if (r5 < r6) goto L_0x003b;
    L_0x0023:
        r6 = r3[r1];
        r7 = r2.getWidth();
        r6 = r6 + r7;
        if (r5 >= r6) goto L_0x003b;
    L_0x002c:
        r5 = r3[r0];
        if (r4 < r5) goto L_0x003b;
    L_0x0030:
        r3 = r3[r0];
        r2 = r2.getHeight();
        r2 = r2 + r3;
        if (r4 >= r2) goto L_0x003b;
    L_0x0039:
        r1 = r0;
        goto L_0x000b;
    L_0x003b:
        r0 = r1;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.isDragViewUnder(int, int):boolean");
    }

    private void onPanelDragged(int i) {
        int slidingTop = getSlidingTop();
        this.mSlideOffset = this.mIsSlidingUp ? ((float) (i - slidingTop)) / ((float) this.mSlideRange) : ((float) (slidingTop - i)) / ((float) this.mSlideRange);
        if (this.mSlideOffset <= 1.0f || this.mIsPullDownEnabled) {
            dispatchOnPanelSlide(this.mSlideableView);
            if (this.mParalaxOffset > 0) {
                slidingTop = getCurrentParalaxOffset();
                if (VERSION.SDK_INT >= 11) {
                    this.mMainView.setTranslationY((float) slidingTop);
                    return;
                } else {
                    a.a(this.mMainView).j((float) slidingTop);
                    return;
                }
            }
            return;
        }
        this.mSlideOffset = 1.0f;
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return (z && C0151az.a(view, -i)) ? true : DEFAULT_OVERLAY_FLAG;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) ? true : DEFAULT_OVERLAY_FLAG;
    }

    public boolean collapsePane() {
        return collapsePane(this.mSlideableView, DEFAULT_PARALAX_OFFSET);
    }

    public void computeScroll() {
        if (this.mDragHelper == null || !this.mDragHelper.a(true)) {
            return;
        }
        if (this.mCanSlide) {
            C0151az.d(this);
        } else {
            this.mDragHelper.h();
        }
    }

    void dispatchOnPanelAnchored(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelAnchored(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelCollapsed(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelCollapsed(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelExpanded(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelExpanded(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelLastOffset(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onLastSlideOffset(view, this.mSlideOffset);
        }
    }

    void dispatchOnPanelSlide(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(view, this.isPressed, this.mSlideOffset);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mSlideableView != null) {
            int top;
            int top2;
            int right = this.mSlideableView.getRight();
            if (this.mIsSlidingUp) {
                top = this.mSlideableView.getTop() - this.mShadowHeight;
                top2 = this.mSlideableView.getTop();
            } else {
                top = this.mSlideableView.getBottom();
                top2 = this.mSlideableView.getBottom() + this.mShadowHeight;
            }
            int left = this.mSlideableView.getLeft();
            if (this.mShadowDrawable != null) {
                this.mShadowDrawable.setBounds(left, top, right, top2);
                this.mShadowDrawable.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj;
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.mCanSlide || layoutParams.slideable || this.mSlideableView == null)) {
            if (!this.mOverlayContent) {
                canvas.getClipBounds(this.mTmpRect);
                if (this.mIsSlidingUp) {
                    this.mTmpRect.bottom = Math.min(this.mTmpRect.bottom, this.mSlideableView.getTop());
                } else {
                    this.mTmpRect.top = Math.max(this.mTmpRect.top, this.mSlideableView.getBottom());
                }
                canvas.clipRect(this.mTmpRect);
            }
            if (this.mSlideOffset < 1.0f) {
                obj = 1;
                drawChild = super.drawChild(canvas, view, j);
                canvas.restoreToCount(save);
                if (obj != null) {
                    this.mCoveredFadePaint.setColor((((int) (((float) ((this.mCoveredFadeColor & C0151az.s) >>> 24)) * (1.0f - this.mSlideOffset))) << 24) | (this.mCoveredFadeColor & C0151az.r));
                    canvas.drawRect(this.mTmpRect, this.mCoveredFadePaint);
                }
                return drawChild;
            }
        }
        obj = DEFAULT_PARALAX_OFFSET;
        drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (obj != null) {
            this.mCoveredFadePaint.setColor((((int) (((float) ((this.mCoveredFadeColor & C0151az.s) >>> 24)) * (1.0f - this.mSlideOffset))) << 24) | (this.mCoveredFadeColor & C0151az.r));
            canvas.drawRect(this.mTmpRect, this.mCoveredFadePaint);
        }
        return drawChild;
    }

    public boolean expandPane() {
        return expandPane(0.0f);
    }

    public boolean expandPane(float f) {
        if (!isPaneVisible()) {
            showPane();
        }
        return expandPane(this.mSlideableView, DEFAULT_PARALAX_OFFSET, f);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getCurrentParalaxOffset() {
        int i = (int) (((float) this.mParalaxOffset) * (1.0f - this.mSlideOffset));
        return this.mIsSlidingUp ? -i : i;
    }

    public int getPanelHeight() {
        return this.mPanelHeight;
    }

    int getPullDownDistance() {
        return this.mPanelSlideListener != null ? this.mPanelSlideListener.onGetPullDownDistance() : DEFAULT_PARALAX_OFFSET;
    }

    Boolean getPullDownDockEnable() {
        return this.mPanelSlideListener != null ? this.mPanelSlideListener.onGetPullDownDockEnable() : Boolean.valueOf(true);
    }

    float getSlideThreshhold() {
        return this.mPanelSlideListener != null ? this.mPanelSlideListener.onGetThreshhold() : 0.0f;
    }

    float getSlideThreshhold2() {
        return this.mPanelSlideListener != null ? this.mPanelSlideListener.onGetThreshhold2() : 0.0f;
    }

    public Boolean getSlidingEnable() {
        return Boolean.valueOf(this.mIsSlidingEnabled);
    }

    public void hidePane() {
        if (this.mSlideableView != null) {
            this.mSlideableView.setVisibility(ONE_PAGE_ITEMS);
            requestLayout();
        }
    }

    public boolean isAnchored() {
        return this.mSlideState == SlideState.ANCHORED ? true : DEFAULT_OVERLAY_FLAG;
    }

    public boolean isCollapsed() {
        return this.mSlideState == SlideState.COLLAPSED ? true : DEFAULT_OVERLAY_FLAG;
    }

    public boolean isExpanded() {
        return this.mSlideState == SlideState.EXPANDED ? true : DEFAULT_OVERLAY_FLAG;
    }

    public boolean isOverlayed() {
        return this.mOverlayContent;
    }

    public boolean isPaneVisible() {
        boolean z = true;
        if (getChildCount() < 2) {
            return DEFAULT_OVERLAY_FLAG;
        }
        if (getChildAt(1).getVisibility() != 0) {
            z = DEFAULT_PARALAX_OFFSET;
        }
        return z;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.mDragViewResId != -1) {
            this.mDragView = findViewById(this.mDragViewResId);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r3 = r10.getX();
        r4 = r10.getY();
        r0 = android.support.v4.view.Y.a(r10);
        r5 = r9.mCanSlide;
        if (r5 == 0) goto L_0x001c;
    L_0x0012:
        r5 = r9.mIsSlidingEnabled;
        if (r5 == 0) goto L_0x001c;
    L_0x0016:
        r5 = r9.mIsUnableToDrag;
        if (r5 == 0) goto L_0x0026;
    L_0x001a:
        if (r0 == 0) goto L_0x0026;
    L_0x001c:
        r0 = r9.mDragHelper;
        r0.g();
        r2 = super.onInterceptTouchEvent(r10);
    L_0x0025:
        return r2;
    L_0x0026:
        r5 = 3;
        if (r0 == r5) goto L_0x002b;
    L_0x0029:
        if (r0 != r1) goto L_0x0031;
    L_0x002b:
        r0 = r9.mDragHelper;
        r0.g();
        goto L_0x0025;
    L_0x0031:
        switch(r0) {
            case 0: goto L_0x0041;
            case 1: goto L_0x0034;
            case 2: goto L_0x0055;
            default: goto L_0x0034;
        };
    L_0x0034:
        r0 = r2;
    L_0x0035:
        r3 = r9.mDragHelper;
        r3 = r3.a(r10);
        if (r3 != 0) goto L_0x003f;
    L_0x003d:
        if (r0 == 0) goto L_0x0025;
    L_0x003f:
        r2 = r1;
        goto L_0x0025;
    L_0x0041:
        r9.mIsUnableToDrag = r2;
        r9.mInitialMotionX = r3;
        r9.mInitialMotionY = r4;
        r0 = (int) r3;
        r3 = (int) r4;
        r0 = r9.isDragViewUnder(r0, r3);
        if (r0 == 0) goto L_0x0034;
    L_0x004f:
        r0 = r9.mIsUsingDragViewTouchEvents;
        if (r0 != 0) goto L_0x0034;
    L_0x0053:
        r0 = r1;
        goto L_0x0035;
    L_0x0055:
        r0 = r9.mInitialMotionX;
        r0 = r3 - r0;
        r5 = java.lang.Math.abs(r0);
        r0 = r9.mInitialMotionY;
        r0 = r4 - r0;
        r6 = java.lang.Math.abs(r0);
        r0 = r9.mDragHelper;
        r7 = r0.f();
        r0 = r9.isExpanded();
        if (r0 == 0) goto L_0x007f;
    L_0x0071:
        r0 = r9.listAdapter;
        if (r0 == 0) goto L_0x007f;
    L_0x0075:
        r0 = r9.innerListViewNeedSlide(r4);
        if (r0 == 0) goto L_0x007f;
    L_0x007b:
        r9.setSlidingEnabled(r2);
        goto L_0x0025;
    L_0x007f:
        r0 = r9.mIsUsingDragViewTouchEvents;
        if (r0 == 0) goto L_0x00bd;
    L_0x0083:
        r0 = r9.mScrollTouchSlop;
        r0 = (float) r0;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0096;
    L_0x008a:
        r0 = r9.mScrollTouchSlop;
        r0 = (float) r0;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0096;
    L_0x0091:
        r2 = super.onInterceptTouchEvent(r10);
        goto L_0x0025;
    L_0x0096:
        r0 = r9.mScrollTouchSlop;
        r0 = (float) r0;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00bd;
    L_0x009d:
        r0 = (int) r3;
        r8 = (int) r4;
        r0 = r9.isDragViewUnder(r0, r8);
    L_0x00a3:
        r7 = (float) r7;
        r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r7 <= 0) goto L_0x00ac;
    L_0x00a8:
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 > 0) goto L_0x00b4;
    L_0x00ac:
        r3 = (int) r3;
        r4 = (int) r4;
        r3 = r9.isDragViewUnder(r3, r4);
        if (r3 != 0) goto L_0x0035;
    L_0x00b4:
        r0 = r9.mDragHelper;
        r0.g();
        r9.mIsUnableToDrag = r1;
        goto L_0x0025;
    L_0x00bd:
        r0 = r2;
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int slidingTop = getSlidingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            switch (l.a[this.mSlideState.ordinal()]) {
                case l.a /*1*/:
                    this.mSlideOffset = this.mCanSlide ? 0.0f : 1.0f;
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    this.mSlideOffset = this.mCanSlide ? this.mAnchorPoint : 1.0f;
                    break;
                default:
                    this.mSlideOffset = 1.0f;
                    break;
            }
        }
        for (int i5 = DEFAULT_PARALAX_OFFSET; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != ONE_PAGE_ITEMS) {
                int i6;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                if (layoutParams.slideable) {
                    this.mSlideRange = measuredHeight - this.mPanelHeight;
                }
                if (this.mIsSlidingUp) {
                    i6 = layoutParams.slideable ? ((int) (((float) this.mSlideRange) * this.mSlideOffset)) + slidingTop : paddingTop;
                } else {
                    i6 = layoutParams.slideable ? slidingTop - ((int) (((float) this.mSlideRange) * this.mSlideOffset)) : paddingTop;
                    if (!(layoutParams.slideable || this.mOverlayContent)) {
                        i6 += this.mPanelHeight;
                    }
                }
                childAt.layout(paddingLeft, i6, childAt.getMeasuredWidth() + paddingLeft, i6 + measuredHeight);
            }
        }
        if (this.mFirstLayout) {
            updateObscuredViewVisibility();
        }
        this.mFirstLayout = DEFAULT_OVERLAY_FLAG;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 != 1073741824) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        } else {
            int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            mode = this.mPanelHeight;
            int childCount = getChildCount();
            if (childCount > 2) {
                C0596r.a(TAG, "onMeasure: More than two child views are not supported.");
                mode2 = mode;
            } else {
                mode2 = getChildAt(1).getVisibility() == ONE_PAGE_ITEMS ? DEFAULT_PARALAX_OFFSET : mode;
            }
            this.mSlideableView = null;
            this.mCanSlide = DEFAULT_OVERLAY_FLAG;
            for (int i3 = DEFAULT_PARALAX_OFFSET; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() == ONE_PAGE_ITEMS) {
                    layoutParams.dimWhenOffset = DEFAULT_OVERLAY_FLAG;
                } else {
                    int i4;
                    if (i3 == 1) {
                        layoutParams.slideable = true;
                        layoutParams.dimWhenOffset = true;
                        this.mSlideableView = childAt;
                        this.mCanSlide = true;
                        i4 = paddingTop;
                    } else {
                        i4 = !this.mOverlayContent ? paddingTop - mode2 : paddingTop;
                        this.mMainView = childAt;
                    }
                    int makeMeasureSpec = layoutParams.width == -2 ? MeasureSpec.makeMeasureSpec(size, af.a) : layoutParams.width == -1 ? MeasureSpec.makeMeasureSpec(size, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    mode = layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(i4, af.a) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(i4, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    childAt.measure(makeMeasureSpec, mode);
                }
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SlidingUpPanelLayoutSavedState slidingUpPanelLayoutSavedState = (SlidingUpPanelLayoutSavedState) parcelable;
        super.onRestoreInstanceState(slidingUpPanelLayoutSavedState.getSuperState());
        this.mSlideState = slidingUpPanelLayoutSavedState.mSlideState;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable slidingUpPanelLayoutSavedState = new SlidingUpPanelLayoutSavedState(super.onSaveInstanceState());
        slidingUpPanelLayoutSavedState.mSlideState = this.mSlideState;
        return slidingUpPanelLayoutSavedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide || !this.mIsSlidingEnabled || this.mDragHelper == null) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.b(motionEvent);
        float y;
        switch (motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE) {
            case DEFAULT_PARALAX_OFFSET /*0*/:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                return true;
            case l.a /*1*/:
                dispatchOnPanelLastOffset(this.mSlideableView);
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = y - this.mInitialMotionX;
                float f2 = y2 - this.mInitialMotionY;
                int f3 = this.mDragHelper.f();
                View view = this.mDragView != null ? this.mDragView : this.mSlideableView;
                if ((f * f) + (f2 * f2) >= ((float) (f3 * f3)) || !isDragViewUnder((int) y, (int) y2)) {
                    return true;
                }
                view.playSoundEffect(DEFAULT_PARALAX_OFFSET);
                if (isExpanded() || isAnchored()) {
                    collapsePane();
                    return true;
                }
                expandPane(this.mAnchorPoint);
                return true;
            default:
                return true;
        }
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = DEFAULT_PARALAX_OFFSET; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == DEFAULT_SHADOW_HEIGHT) {
                childAt.setVisibility(DEFAULT_PARALAX_OFFSET);
            }
        }
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.mAnchorPoint = f;
        }
    }

    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
        invalidate();
    }

    public void setDragView(View view) {
        this.mDragView = view;
    }

    public void setEnableDragViewTouchEvents(boolean z) {
        this.mIsUsingDragViewTouchEvents = z;
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        this.listAdapter = baseAdapter;
    }

    public void setOverlayed(boolean z) {
        this.mOverlayContent = z;
    }

    public void setPanelHeight(int i) {
        this.mPanelHeight = i;
        requestLayout();
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setPullDownEnabled(boolean z) {
        this.mIsPullDownEnabled = z;
    }

    public void setSlidingEnabled(boolean z) {
        C0596r.e(TAG, "setSlidingEnabled  = " + z);
        this.mIsSlidingEnabled = z;
    }

    public void showPane() {
        if (getChildCount() >= 2) {
            getChildAt(1).setVisibility(DEFAULT_PARALAX_OFFSET);
            requestLayout();
        }
    }

    public boolean smoothSlideTo(float f, int i) {
        if (!this.mCanSlide || this.mDragHelper == null || this.mSlideableView == null) {
            return DEFAULT_OVERLAY_FLAG;
        }
        int slidingTop = getSlidingTop();
        if (!this.mDragHelper.a(this.mSlideableView, this.mSlideableView.getLeft(), this.mIsSlidingUp ? (int) (((float) slidingTop) + (((float) this.mSlideRange) * f)) : (int) (((float) slidingTop) - (((float) this.mSlideRange) * f)))) {
            return DEFAULT_OVERLAY_FLAG;
        }
        setAllChildrenVisible();
        C0151az.d(this);
        return true;
    }

    void updateObscuredViewVisibility() {
        int i = DEFAULT_PARALAX_OFFSET;
        if (getChildCount() != 0) {
            int i2;
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int i3;
            int i4;
            int i5;
            if (this.mSlideableView == null || !hasOpaqueBackground(this.mSlideableView)) {
                i3 = DEFAULT_PARALAX_OFFSET;
                i4 = DEFAULT_PARALAX_OFFSET;
                i5 = DEFAULT_PARALAX_OFFSET;
                i2 = DEFAULT_PARALAX_OFFSET;
            } else {
                i2 = this.mSlideableView.getLeft();
                i5 = this.mSlideableView.getRight();
                i4 = this.mSlideableView.getTop();
                i3 = this.mSlideableView.getBottom();
            }
            View childAt = getChildAt(DEFAULT_PARALAX_OFFSET);
            paddingLeft = Math.max(paddingLeft, childAt.getLeft());
            paddingTop = Math.max(paddingTop, childAt.getTop());
            width = Math.min(width, childAt.getRight());
            height = Math.min(height, childAt.getBottom());
            if (paddingLeft >= i2 && paddingTop >= r2 && width <= r3 && height <= r0) {
                i = DEFAULT_SHADOW_HEIGHT;
            }
            childAt.setVisibility(i);
        }
    }
}
