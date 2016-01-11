package android.support.v4.widget;

class C0240i implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar a;

    C0240i(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.a = contentLoadingProgressBar;
    }

    public void run() {
        this.a.e = false;
        if (!this.a.f) {
            this.a.c = System.currentTimeMillis();
            this.a.setVisibility(0);
        }
    }
}
