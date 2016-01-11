package android.support.v4.widget;

import android.widget.SearchView.OnQueryTextListener;

final class aD implements OnQueryTextListener {
    final /* synthetic */ aG a;

    aD(aG aGVar) {
        this.a = aGVar;
    }

    public boolean onQueryTextChange(String str) {
        return this.a.b(str);
    }

    public boolean onQueryTextSubmit(String str) {
        return this.a.a(str);
    }
}
