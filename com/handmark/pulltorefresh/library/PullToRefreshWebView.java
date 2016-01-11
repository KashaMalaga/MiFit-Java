package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static final OnRefreshListener<WebView> defaultOnRefreshListener = new OnRefreshListener<WebView>() {
        public void onRefresh(PullToRefreshBase<WebView> pullToRefreshBase) {
            ((WebView) pullToRefreshBase.getRefreshableView()).reload();
        }
    };
    private final WebChromeClient defaultWebChromeClient = new WebChromeClient() {
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                PullToRefreshWebView.this.onRefreshComplete();
            }
        }
    };

    @TargetApi(9)
    final class InternalWebViewSDK9 extends WebView {
        static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
        static final float OVERSCROLL_SCALE_FACTOR = 1.5f;

        public InternalWebViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            return (int) Math.max(0.0f, FloatMath.floor(((WebView) PullToRefreshWebView.this.mRefreshableView).getScale() * ((float) ((WebView) PullToRefreshWebView.this.mRefreshableView).getContentHeight())) - ((float) ((getHeight() - getPaddingBottom()) - getPaddingTop())));
        }

        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.overScrollBy(PullToRefreshWebView.this, i, i3, i2, i4, getScrollRange(), OVERSCROLL_FUZZY_THRESHOLD, OVERSCROLL_SCALE_FACTOR, z);
            return overScrollBy;
        }
    }

    public PullToRefreshWebView(Context context) {
        super(context);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public PullToRefreshWebView(Context context, Mode mode) {
        super(context, mode);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public PullToRefreshWebView(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    protected WebView createRefreshableView(Context context, AttributeSet attributeSet) {
        WebView internalWebViewSDK9 = VERSION.SDK_INT >= 9 ? new InternalWebViewSDK9(context, attributeSet) : new WebView(context, attributeSet);
        internalWebViewSDK9.setId(R.id.webview);
        return internalWebViewSDK9;
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected boolean isReadyForPullEnd() {
        return ((float) ((WebView) this.mRefreshableView).getScrollY()) >= FloatMath.floor(((WebView) this.mRefreshableView).getScale() * ((float) ((WebView) this.mRefreshableView).getContentHeight())) - ((float) ((WebView) this.mRefreshableView).getHeight());
    }

    protected boolean isReadyForPullStart() {
        return ((WebView) this.mRefreshableView).getScrollY() == 0;
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
        super.onPtrRestoreInstanceState(bundle);
        ((WebView) this.mRefreshableView).restoreState(bundle);
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
        super.onPtrSaveInstanceState(bundle);
        ((WebView) this.mRefreshableView).saveState(bundle);
    }
}
