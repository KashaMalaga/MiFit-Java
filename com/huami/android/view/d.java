package com.huami.android.view;

import android.view.View;
import android.view.View.OnClickListener;

class d implements OnClickListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void onClick(View view) {
        this.a.onEmptyAreaClicked();
    }
}
