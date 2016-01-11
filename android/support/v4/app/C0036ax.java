package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class C0036ax implements OnItemClickListener {
    final /* synthetic */ C0034av a;

    C0036ax(C0034av c0034av) {
        this.a = c0034av;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.a((ListView) adapterView, view, i, j);
    }
}
