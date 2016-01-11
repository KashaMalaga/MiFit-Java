package cn.com.smartdevices.bracelet.activity;

class D implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ WebActivity b;

    D(WebActivity webActivity, String str) {
        this.b = webActivity;
        this.a = str;
    }

    public void run() {
        this.b.mWebView.post(new E(this, this.b.processExtras(this.a)));
    }
}
