package android.support.v4.h;

import android.os.CancellationSignal.OnCancelListener;

class m implements OnCancelListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void onCancel() {
        this.a.e.a();
        this.a.cancel(false);
    }
}
