package android.support.v4.widget;

class C0239h implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar a;

    C0239h(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.a = contentLoadingProgressBar;
    }

    public void run() {
        this.a.d = false;
        this.a.c = -1;
        this.a.setVisibility(8);
    }
}
