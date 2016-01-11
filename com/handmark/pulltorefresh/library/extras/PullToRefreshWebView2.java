package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PullToRefreshWebView2 extends PullToRefreshWebView {
    static final String DEF_JS_READY_PULL_DOWN_CALL = "javascript:isReadyForPullDown();";
    static final String DEF_JS_READY_PULL_UP_CALL = "javascript:isReadyForPullUp();";
    static final String JS_INTERFACE_PKG = "ptr";
    private final AtomicBoolean mIsReadyForPullDown = new AtomicBoolean(false);
    private final AtomicBoolean mIsReadyForPullUp = new AtomicBoolean(false);
    private JsValueCallback mJsCallback;

    final class JsValueCallback {
        JsValueCallback() {
        }

        public void isReadyForPullDownResponse(boolean z) {
            PullToRefreshWebView2.this.mIsReadyForPullDown.set(z);
        }

        public void isReadyForPullUpResponse(boolean z) {
            PullToRefreshWebView2.this.mIsReadyForPullUp.set(z);
        }
    }

    public PullToRefreshWebView2(Context context) {
        super(context);
    }

    public PullToRefreshWebView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshWebView2(Context context, Mode mode) {
        super(context, mode);
    }

    protected WebView createRefreshableView(Context context, AttributeSet attributeSet) {
        WebView createRefreshableView = super.createRefreshableView(context, attributeSet);
        this.mJsCallback = new JsValueCallback();
        createRefreshableView.addJavascriptInterface(this.mJsCallback, JS_INTERFACE_PKG);
        return createRefreshableView;
    }

    protected boolean isReadyForPullEnd() {
        ((WebView) getRefreshableView()).loadUrl(DEF_JS_READY_PULL_UP_CALL);
        return this.mIsReadyForPullUp.get();
    }

    protected boolean isReadyForPullStart() {
        ((WebView) getRefreshableView()).loadUrl(DEF_JS_READY_PULL_DOWN_CALL);
        return this.mIsReadyForPullDown.get();
    }
}
