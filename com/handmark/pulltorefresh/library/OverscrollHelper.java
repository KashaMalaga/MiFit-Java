package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import kankan.wheel.widget.l;

@TargetApi(9)
public final class OverscrollHelper {
    static final float DEFAULT_OVERSCROLL_SCALE = 1.0f;
    static final String LOG_TAG = "OverscrollHelper";

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation = new int[Orientation.values().length];

        static {
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static boolean isAndroidOverScrollEnabled(View view) {
        return view.getOverScrollMode() != 2;
    }

    public static void overScrollBy(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z) {
        int scrollX;
        int i7;
        int i8;
        switch (AnonymousClass1.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                scrollX = pullToRefreshBase.getScrollX();
                i7 = i;
                i8 = i2;
                break;
            default:
                scrollX = pullToRefreshBase.getScrollY();
                i7 = i3;
                i8 = i4;
                break;
        }
        if (pullToRefreshBase.isPullToRefreshOverScrollEnabled() && !pullToRefreshBase.isRefreshing()) {
            Mode mode = pullToRefreshBase.getMode();
            if (mode.permitsPullToRefresh() && !z && i7 != 0) {
                i8 += i7;
                Log.d(LOG_TAG, "OverScroll. DeltaX: " + i + ", ScrollX: " + i2 + ", DeltaY: " + i3 + ", ScrollY: " + i4 + ", NewY: " + i8 + ", ScrollRange: " + i5 + ", CurrentScroll: " + scrollX);
                if (i8 < 0 - i6) {
                    if (mode.showHeaderLoadingLayout()) {
                        if (scrollX == 0) {
                            pullToRefreshBase.setState(State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (((float) (i8 + scrollX)) * f));
                    }
                } else if (i8 > i5 + i6) {
                    if (mode.showFooterLoadingLayout()) {
                        if (scrollX == 0) {
                            pullToRefreshBase.setState(State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (((float) ((i8 + scrollX) - i5)) * f));
                    }
                } else if (Math.abs(i8) <= i6 || Math.abs(i8 - i5) <= i6) {
                    pullToRefreshBase.setState(State.RESET, new boolean[0]);
                }
            } else if (z && State.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.setState(State.RESET, new boolean[0]);
            }
        }
    }

    public static void overScrollBy(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        overScrollBy(pullToRefreshBase, i, i2, i3, i4, i5, 0, DEFAULT_OVERSCROLL_SCALE, z);
    }

    public static void overScrollBy(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        overScrollBy(pullToRefreshBase, i, i2, i3, i4, 0, z);
    }
}
