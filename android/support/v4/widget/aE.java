package android.support.v4.widget;

import android.widget.SearchView.OnCloseListener;

final class aE implements OnCloseListener {
    final /* synthetic */ aF a;

    aE(aF aFVar) {
        this.a = aFVar;
    }

    public boolean onClose() {
        return this.a.a();
    }
}
