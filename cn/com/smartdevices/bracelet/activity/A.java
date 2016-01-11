package cn.com.smartdevices.bracelet.activity;

class A implements Runnable {
    final /* synthetic */ WebActivity a;

    A(WebActivity webActivity) {
        this.a = webActivity;
    }

    public void run() {
        if (!this.a.mPageLoaded && this.a.mWebView != null) {
            this.a.mWebView.reload();
        }
    }
}
