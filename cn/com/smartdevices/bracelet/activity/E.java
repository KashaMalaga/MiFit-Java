package cn.com.smartdevices.bracelet.activity;

class E implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ D b;

    E(D d, String str) {
        this.b = d;
        this.a = str;
    }

    public void run() {
        this.b.b.mWebView.loadUrl(this.a);
    }
}
